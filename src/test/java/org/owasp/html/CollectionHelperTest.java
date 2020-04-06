package org.owasp.html;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.owasp.html.CollectionHelper.immutableList;
import static org.owasp.html.CollectionHelper.immutableMap;
import static org.owasp.html.CollectionHelper.immutableSet;
import static org.owasp.html.CollectionHelper.isEmpty;
import static org.owasp.html.CollectionHelper.mutableList;
import static org.owasp.html.CollectionHelper.mutableMap;
import static org.owasp.html.CollectionHelper.mutableSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.Test;

class CollectionHelperTest {

    @Test
    void shouldDetermineEmptinessForVarags() {
        assertFalse(isEmpty("1"));
        assertFalse(isEmpty("1", "2"));
        assertTrue(isEmpty(Collections.emptyList().toArray()));
        assertTrue(isEmpty((Object[]) null));

    }

    @Test
    void shouldDetermineEmptinessForIterable() {
        assertFalse(isEmpty((Iterable<?>) mutableList("1")));
        assertFalse(isEmpty((Iterable<?>) mutableList("1", "2")));
        assertTrue(isEmpty((Iterable<?>) Collections.emptyList()));
        assertTrue(isEmpty((Iterable<?>) null));

    }

    @Test
    void shouldDetermineEmptinessForCollection() {
        assertFalse(isEmpty(mutableList("1")));
        assertFalse(isEmpty(mutableList("1", "2")));
        assertTrue(isEmpty(Collections.emptyList()));
        assertTrue(isEmpty((Collection<?>) null));

    }

    @Test
    void shouldDetermineEmptinessForIterator() {
        assertFalse(isEmpty(mutableList("1").iterator()));
        assertFalse(isEmpty(mutableList("1", "2").iterator()));
        assertTrue(isEmpty(Collections.emptyList().iterator()));
        assertTrue(isEmpty((Iterator<?>) null));

    }

    @Test
    void shouldDetermineEmptinessForStream() {
        assertFalse(isEmpty(mutableList("1").stream()));
        assertFalse(isEmpty(Collections.emptyList().stream()));
        assertTrue(isEmpty((Stream<?>) null));

    }
    
    @Test
    void shouldHandleMutableList() {
        assertMutable(mutableList());
        assertMutable(mutableList((String[]) null));
        assertMutable(mutableList((String) null));
        assertMutable(mutableList("1"));
        assertMutable(mutableList("1", "2"));
        assertMutable(mutableList("1", "2"));
        assertMutable(mutableList(new ArrayList<>()));
        assertMutable(mutableList(Arrays.asList("1", "2")));
        assertMutable(mutableList((Iterable<String>) null));
        assertMutable(mutableList((Iterable<String>) Arrays.asList("1", "2")));
    }

    @Test
    void shouldHandleImmutableList() {
        assertImmutable(immutableList());
        assertImmutable(immutableList((String[]) null));
        assertImmutable(immutableList((String) null));
        assertImmutable(immutableList("1"));
        assertImmutable(immutableList("1", "2"));
        assertImmutable(immutableList(new ArrayList<>()));
        assertImmutable(immutableList((Iterable<String>) null));
        assertImmutable(immutableList(Arrays.asList("1", "2")));
        assertImmutable(immutableList(mutableSet("1", "2")));
        assertImmutable(immutableList((Iterable<String>) Arrays.asList("1", "2")));
    }

    @Test
    void shouldHandleMutableSet() {
        assertMutable(mutableSet());
        assertMutable(mutableSet((String[]) null));
        assertMutable(mutableSet((String) null));
        assertMutable(mutableSet("1"));
        assertMutable(mutableSet("1", "2"));
        assertMutable(mutableSet(new ArrayList<>()));
        assertMutable(mutableSet(Arrays.asList("1", "2")));
        assertMutable(mutableSet((Iterable<String>) null));
        assertMutable(mutableSet((Iterable<String>) Arrays.asList("1", "2")));
    }

    @Test
    void shouldHandleImmutableSet() {
        assertImmutable(immutableSet());
        assertImmutable(immutableSet((String[]) null));
        assertImmutable(immutableSet((String) null));
        assertImmutable(immutableSet("1"));
        assertImmutable(immutableSet("1", "2"));
        assertImmutable(immutableSet(Arrays.asList("1", "2")));
        assertImmutable(immutableSet((Iterable<String>) null));
        assertImmutable(immutableSet((Iterable<String>) Arrays.asList("1", "2")));

    }

    @Test
    void shouldHandleMutableMap() {
        assertMutable(mutableMap());
        assertMutable(mutableMap("1", "1-1"));
        assertMutable(mutableMap("1", "1-1", "2", "2-2"));
        assertMutable(mutableMap("1", "1-1", "2", "2-2", "3", "3-3"));
        assertMutable(mutableMap("1", "1-1", "2", "2-2", "3", "3-3", "4", "4-4"));
    }

    @Test
    void shouldHandleImmutableMap() {
        assertImmutable(immutableMap());
        assertImmutable(immutableMap(mutableMap("1", "2")));
        assertImmutable(immutableMap("1", "2"));
        assertImmutable(immutableMap("1", "1-1", "2", "2-2"));
    }

    static final void assertMutable(Collection<String> collection) {
        assertNotNull(collection);
        collection.add("I am mutable");
    }

    static final void assertImmutable(Collection<String> collection) {
        assertNotNull(collection);
        assertThrows(UnsupportedOperationException.class, () -> {
            collection.add("i am not mutable");
        });
    }

    static final void assertMutable(Map<String, String> map) {
        assertNotNull(map);
        map.put("I am", "mutable");

    }

    static final void assertImmutable(Map<String, String> map) {
        assertNotNull(map);
        assertThrows(UnsupportedOperationException.class, () -> {
            map.put("i am", "not mutable");
        });
    }

}
