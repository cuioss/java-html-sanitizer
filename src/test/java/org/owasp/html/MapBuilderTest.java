package org.owasp.html;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.owasp.html.CollectionHelper.immutableMap;
import static org.owasp.html.CollectionHelperTest.assertImmutable;
import static org.owasp.html.CollectionHelperTest.assertMutable;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class MapBuilderTest {

    @Test
    public void shouldHandleEmptyMap() {
        MapBuilder<String, String> builder = new MapBuilder<>();
        assertMutable(builder.toMutableMap());
        assertImmutable(builder.toImmutableMap());
    }

    @Test
    public void shouldHandleHappyCase() {
        MapBuilder<String, String> builder = new MapBuilder<>();
        builder.put("key1", "value1").put("key2", "value2");
        assertEquals(2, builder.size());
        assertMutable(builder.toMutableMap());
        assertImmutable(builder.toImmutableMap());
    }

    @Test
    public void shouldHandleRemove() {
        MapBuilder<String, String> builder = new MapBuilder<>();
        builder.put("key1", "value1").remove("key1");
        assertTrue(builder.isEmpty());
        assertEquals(0, builder.size());
        assertMutable(builder.toMutableMap());
        assertImmutable(builder.toImmutableMap());
    }

    @Test
    public void shouldHandleClear() {
        MapBuilder<String, String> builder = new MapBuilder<>();
        assertTrue(builder.isEmpty());
        assertTrue(builder.clear().isEmpty());
        builder.put("key1", "value1");
        assertFalse(builder.isEmpty());
        assertTrue(builder.clear().isEmpty());
    }

    @Test
    public void shouldHandlePutAll() {
        MapBuilder<String, String> builder = new MapBuilder<>();
        builder.putAll(new MapBuilder<String, String>().put("key1", "value1").toImmutableMap());
        assertFalse(builder.isEmpty());
    }

    @Test
    public void shouldHandlePutEntry() {
        MapBuilder<String, String> builder = new MapBuilder<>();
        builder.put(
                new MapBuilder<String, String>().put("key1", "value1").toImmutableMap().entrySet().iterator().next());
        assertFalse(builder.isEmpty());
    }

    @Test
    public void shouldHandleContainsKeyValue() {
        MapBuilder<String, String> builder = new MapBuilder<>();
        assertFalse(builder.containsKey("key1"));
        assertFalse(builder.containsValue("value1"));
        builder.put("key1", "value1");
        assertTrue(builder.containsKey("key1"));
        assertTrue(builder.containsValue("value1"));
    }

    @Test
    public void shouldHandleCopyFromMap() {
        MapBuilder<String, String> builder = MapBuilder.copyFrom(immutableMap("key2", "value2"));
        builder.put("key1", "value1");
        assertFalse(builder.isEmpty());
        assertEquals(2, builder.size());
    }

    @Test
    public void shouldHandleLiteralCopy() {
        assertEquals(1, MapBuilder.from("key1", 1).size());
        assertEquals(2, MapBuilder.from("key1", 1, "key2", 2).size());
        assertEquals(3, MapBuilder.from("key1", 1, "key2", 2, "key3", 3).size());
        assertEquals(4, MapBuilder.from("key1", 1, "key2", 2, "key3", 3, "key4", 4).size());
    }

}
