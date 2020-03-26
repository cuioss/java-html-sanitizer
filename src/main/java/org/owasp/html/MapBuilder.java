package org.owasp.html;

import static org.owasp.html.CollectionHelper.*;
import static java.util.Objects.requireNonNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


/**
 * Builder for creating {@link Map}s providing some convenience methods. The class writes
 * everything through into the contained collector. Using the default constructor a newly created
 * {@link HashMap} will be used as collector, but you can pass you own collector as
 * constructor-argument.
 *
 * @author Oliver Wolff
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 *
 */
final class MapBuilder<K, V> {

    private final Map<K, V> collector;

    /**
     * Default Constructor initializing the collector with an {@link HashMap}
     *
     */
    MapBuilder() {
        this(new HashMap<>());
    }

    /**
     * @param collector to be used for storage. Must not be null
     */
    MapBuilder(Map<K, V> collector) {
        this.collector = requireNonNull(collector);
    }

    /**
     * @return the number of key-value mappings in this map
     * @see Map#size()
     */
    int size() {
        return collector.size();
    }

    /**
     * @return true if this map contains no key-value mappings
     * @see Map#isEmpty()
     */
    boolean isEmpty() {
        return collector.isEmpty();
    }

    /**
     * Returns <tt>true</tt> if this map contains a mapping for the specified
     * key. More formally, returns <tt>true</tt> if and only if
     * this map contains a mapping for a key <tt>k</tt> such that
     * <tt>(key==null ? k==null : key.equals(k))</tt>. (There can be
     * at most one such mapping.)
     *
     * @param key key whose presence in this map is to be tested
     * @return <tt>true</tt> if this map contains a mapping for the specified
     *         key
     * @see Map#containsKey(Object)
     */
    boolean containsKey(Object key) {
        return collector.containsKey(key);
    }

    /**
     * Returns <tt>true</tt> if this map maps one or more keys to the
     * specified value. More formally, returns <tt>true</tt> if and only if
     * this map contains at least one mapping to a value <tt>v</tt> such that
     * <tt>(value==null ? v==null : value.equals(v))</tt>. This operation
     * will probably require time linear in the map size for most
     * implementations of the <tt>Map</tt> interface.
     *
     * @param value value whose presence in this map is to be tested
     * @return <tt>true</tt> if this map maps one or more keys to the
     *         specified value
     * @see Map#containsValue(Object)
     */
    boolean containsValue(Object value) {
        return collector.containsValue(value);
    }

    /**
     * @param key to be put as key, must not be empty
     * @param value to be put as value, must not e empty
     * @return the instance itself in order to use it in a fluent way.
     */
    MapBuilder<K, V> put(K key, V value) {
        collector.put(key, value);
        return this;
    }

    /**
     * @param entry to be put, must not {@code null}
     * @return the instance itself in order to use it in a fluent way.
     */
    MapBuilder<K, V> put(Entry<? extends K, ? extends V> entry) {
        collector.put(entry.getKey(), entry.getValue());
        return this;
    }

    /**
     * @param key to be removed
     * @return the instance itself in order to use it in a fluent way.
     */
    MapBuilder<K, V> remove(Object key) {
        collector.remove(key);
        return this;
    }

    /**
     * @param map to be put
     * @return the instance itself in order to use it in a fluent way.
     */
    MapBuilder<K, V> putAll(Map<? extends K, ? extends V> map) {
        collector.putAll(map);
        return this;
    }

    /**
     * Clears the contained collector
     *
     * @return the instance itself in order to use it in a fluent way.
     */
    MapBuilder<K, V> clear() {
        collector.clear();
        return this;
    }

    /**
     * @return a mutable {@link Map} representation of the builders content, the actual
     *         implementation is a {@link HashMap}
     */
    Map<K, V> toMutableMap() {
        return new HashMap<>(collector);
    }

    /**
     * @return an immutable {@link Map} representation of the builders content, the actual
     *         implementation does not create a copy but provides an unmodifiable view using
     *         {@link Collections#unmodifiableMap(Map)}
     */
    Map<K, V> toImmutableMap() {
        return Collections.unmodifiableMap(collector);
    }

    /**
     * @param <K> the type of keys maintained by this map
     * @param <V> the type of mapped values
     * @param original map used to initialize the contained collector
     * @return an instance of MapBuilder initialized with a copy of the given Map.
     */
    static <K, V> MapBuilder<K, V> copyFrom(Map<K, V> original) {
        return new MapBuilder<>(new HashMap<>(original));
    }

    /**
     * Shorthand for creating a MapBuilder from a given key/value pair
     *
     * @param <K> the type of keys maintained by this map
     * @param <V> the type of mapped values
     * @param k1 key to be added
     * @param v1 value to be added
     * @return an instance of MapBuilder initialized with the given key/value pair.
     */
    static <K, V> MapBuilder<K, V> from(K k1, V v1) {
        return new MapBuilder<>(mutableMap(k1, v1));
    }

    /**
     * Shorthand for creating a MapBuilder from given key/value pairs
     *
     * @param <K> the type of keys maintained by this map
     * @param <V> the type of mapped values
     * @param k1 key to be added
     * @param v1 value to be added
     * @param k2 key to be added
     * @param v2 value to be added
     * @return an instance of MapBuilder initialized with the given key/value pairs.
     */
    static <K, V> MapBuilder<K, V> from(K k1, V v1, K k2, V v2) {
        return new MapBuilder<>(mutableMap(k1, v1, k2, v2));
    }

    /**
     * Shorthand for creating a MapBuilder from given key/value pairs
     *
     * @param <K> the type of keys maintained by this map
     * @param <V> the type of mapped values
     * @param k1 key to be added
     * @param v1 value to be added
     * @param k2 key to be added
     * @param v2 value to be added
     * @param k3 key to be added
     * @param v3 value to be added
     * @return an instance of MapBuilder initialized with the given key/value pairs.
     */
    static <K, V> MapBuilder<K, V> from(K k1, V v1, K k2, V v2, K k3, V v3) {
        return new MapBuilder<>(mutableMap(k1, v1, k2, v2, k3, v3));
    }

    /**
     * Shorthand for creating a MapBuilder from given key/value pairs
     *
     * @param <K> the type of keys maintained by this map
     * @param <V> the type of mapped values
     * @param k1 key to be added
     * @param v1 value to be added
     * @param k2 key to be added
     * @param v2 value to be added
     * @param k3 key to be added
     * @param v3 value to be added
     * @param k4 key to be added
     * @param v4 value to be added
     * @return an instance of MapBuilder initialized with the given key/value pairs.
     */
    @SuppressWarnings("squid:S00107") // owolff: Number of parameters match to the use-case
    static <K, V> MapBuilder<K, V> from(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        return new MapBuilder<>(mutableMap(k1, v1, k2, v2, k3, v3, k4, v4));
    }
}
