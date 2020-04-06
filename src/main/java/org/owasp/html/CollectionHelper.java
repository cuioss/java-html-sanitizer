package org.owasp.html;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Replacement for guavas collection methods.
 * 
 * @author Oliver Wolff
 *
 */
final class CollectionHelper {

    /**
     * Creates a <i>mutable</i> {@code List} instance containing the given elements.
     *
     * @param elements to be added
     * @return the <i>mutable</i> {@link List} with the given elements
     */
    @SafeVarargs
    static <E> List<E> mutableList(E... elements) {
        if (isEmpty(elements)) {
            return new ArrayList<>();
        }
        return new ArrayList<>(Arrays.asList(elements));
    }

    /**
     * Creates a <i>mutable</i> {@code List} instance containing the given elements.
     *
     * @param elements to be added. If it is null and empty <i>mutable</i> list will be returned
     * @return the <i>mutable</i> {@link List} with the given elements
     */
    static <E> List<E> mutableList(Iterable<? extends E> elements) {
        ArrayList<E> list = new ArrayList<>();
        if (isEmpty(elements)) {
            return list;
        }
        elements.forEach(list::add);
        return list;
    }

    /**
     * Creates a <i>mutable</i> {@code List} instance containing the given elements.
     *
     * @param elements to be added. If it is null and empty <i>mutable</i> list will be returned
     * @return the <i>mutable</i> {@link List} with the given elements
     */
    static <E> List<E> mutableList(Collection<? extends E> elements) {
        if (isEmpty(elements)) {
            return new ArrayList<>();
        }
        return new ArrayList<>(elements);
    }

    /**
     * Creates an <i>immutable</i> {@code List} instance. Convenience method for
     * {@link Collections#emptyList()}
     *
     * @return the <i>immutable</i> {@link List} without any element
     */
    static <E> List<E> immutableList() {
        return Collections.emptyList();
    }

    /**
     * Creates an <i>immutable</i> {@code List} instance containing the given elements.
     *
     * @param elements to be wrapped, must not be null
     * @return the <i>immutable</i> {@link List} with the given elements
     */
    @SafeVarargs
    static <E> List<E> immutableList(E... elements) {
        if (isEmpty(elements)) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(mutableList(elements));
    }

    /**
     * Creates an <i>immutable</i> {@code List} instance containing the given element.
     *
     * @param element to be wrapped, must not be null
     * @return the <i>immutable</i> {@link List} with the given elements
     */
    static <E> List<E> immutableList(E element) {
        if (null == element) {
            return Collections.emptyList();
        }
        return Collections.singletonList(element);
    }

    /**
     * Creates an <i>immutable</i> {@code List} instance containing the given elements.
     *
     * @param elements to be wrapped, must not be null
     * @return the <i>immutable</i> {@link List} with the given elements
     */
    static <E> List<E> immutableList(Iterable<? extends E> elements) {
        if (isEmpty(elements)) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(mutableList(elements));
    }

    /**
     * Creates an <i>immutable</i> {@code List} instance containing the given elements.
     *
     * @param elements to be wrapped, must not be null
     * @return the <i>immutable</i> {@link List} with the given elements. It implicitly creates a
     *         copy
     */
    static <E> List<E> immutableList(Collection<? extends E> elements) {
        if (isEmpty(elements)) {
            return Collections.emptyList();
        }

        return Collections.unmodifiableList(mutableList(elements));
    }

    /**
     * @return a newly created empty {@link HashSet}
     */
    static <E> Set<E> mutableSet() {
        return new HashSet<>();
    }

    /**
     * @param elements to be added
     * @return a newly created empty {@link HashSet} with the given elements
     */
    @SafeVarargs
    static <E> Set<E> mutableSet(E... elements) {
        if (isEmpty(elements)) {
            return new HashSet<>();
        }
        return new HashSet<>(Arrays.asList(elements));
    }

    /**
     * Creates a <i>mutable</i> {@code Set} instance containing the given elements.
     *
     * @param elements to be added. If it is null and empty <i>mutable</i> list will be returned
     * @return the <i>mutable</i> {@link Set} with the given elements
     */
    static <E> Set<E> mutableSet(Iterable<? extends E> elements) {
        Set<E> set = new HashSet<>();
        if (isEmpty(elements)) {
            return set;
        }
        elements.forEach(set::add);
        return set;

    }

    /**
     * @return a newly created empty {@link HashSet} Convenience method for
     *         {@link Collections#emptySet()}
     */
    static <E> Set<E> immutableSet() {
        return Collections.emptySet();
    }

    /**
     * Creates an <i>immutable</i> {@code Set} instance containing the given elements.
     *
     * @param element to be wrapped, must not be null
     * @return the <i>immutable</i> {@link Set} with the given elements
     */
    static <E> Set<E> immutableSet(E element) {
        if (null == element) {
            return Collections.emptySet();
        }
        return Collections.singleton(element);
    }

    /**
     * Creates an <i>immutable</i> {@code Set} instance containing the given elements.
     *
     * @param elements to be wrapped, must not be null
     * @return the <i>immutable</i> {@link Set} with the given elements
     */
    @SafeVarargs
    static <E> Set<E> immutableSet(E... elements) {
        if (isEmpty(elements)) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(mutableSet(elements));
    }

    /**
     * Creates an <i>immutable</i> {@code Set} instance containing the given elements.
     *
     * @param elements to be wrapped
     * @return the <i>immutable</i> {@link Set} with the given elements
     */
    static <E> Set<E> immutableSet(Iterable<? extends E> elements) {
        if (isEmpty(elements)) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(mutableSet(elements));
    }
    
    // Map Operations
    /**
     * @return an empty <i>mutable</i> Map
     */
    static <K, V> Map<K, V> mutableMap() {
        return new HashMap<>();
    }

    /**
     * Convenience method for the inline creation of a map with values
     *
     * @param k key to be added
     * @param v value to be added
     * @return a <i>mutable</i> Map with the given elements
     */
    static <K, V> Map<K, V> mutableMap(K k, V v) {
        Map<K, V> map = new HashMap<>();
        map.put(k, v);
        return map;
    }

    /**
     * Convenience method for the inline creation of a map with values
     *
     * @param k1 key to be added
     * @param v1 value to be added
     * @param k2 key to be added
     * @param v2 value to be added
     * @return a <i>mutable</i> Map with the given elements
     */
    static <K, V> Map<K, V> mutableMap(K k1, V v1, K k2, V v2) {
        Map<K, V> map = new HashMap<>();
        map.put(k1, v1);
        map.put(k2, v2);
        return map;
    }

    /**
     * Convenience method for the inline creation of a map with values
     *
     * @param k1 key to be added
     * @param v1 value to be added
     * @param k2 key to be added
     * @param v2 value to be added
     * @param k3 key to be added
     * @param v3 value to be added
     * @return a <i>mutable</i> Map with the given elements
     */
    static <K, V> Map<K, V> mutableMap(K k1, V v1, K k2, V v2, K k3, V v3) {
        Map<K, V> map = new HashMap<>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        return map;
    }

    /**
     * Convenience method for the inline creation of a map with values
     *
     * @param k1 key to be added
     * @param v1 value to be added
     * @param k2 key to be added
     * @param v2 value to be added
     * @param k3 key to be added
     * @param v3 value to be added
     * @param k4 key to be added
     * @param v4 value to be added
     * @return a <i>mutable</i> Map with the given elements
     */
    @SuppressWarnings("squid:S00107") // owolff: Number of parameters match to the use-case
    static <K, V> Map<K, V> mutableMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        Map<K, V> map = new HashMap<>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        return map;
    }

    /**
     * @return an empty <i>mutable</i> Map
     */
    static <K, V> Map<K, V> immutableMap() {
        return Collections.emptyMap();
    }

    /**
     * Shorthand to {@link Collections#unmodifiableMap(Map)}
     *
     * @param source
     * @return an <i>immutable</i> Map with the given elements
     */
    static <K, V> Map<K, V> immutableMap(Map<K, V> source) {
        return Collections.unmodifiableMap(source);
    }

    /**
     * Convenience method for the inline creation of a map with values
     *
     * @param k key to be added
     * @param v value to be added
     * @return an <i>immutable</i> Map with the given elements
     */
    static <K, V> Map<K, V> immutableMap(K k, V v) {
        Map<K, V> map = mutableMap();
        map.put(k, v);
        return Collections.unmodifiableMap(map);
    }

    /**
     * Convenience method for the inline creation of a map with values
     *
     * @param k1 key to be added
     * @param v1 value to be added
     * @param k2 key to be added
     * @param v2 value to be added
     * @return an <i>immutable</i> Map with the given elements
     */
    static <K, V> Map<K, V> immutableMap(K k1, V v1, K k2, V v2) {
        Map<K, V> map = mutableMap();
        map.put(k1, v1);
        map.put(k2, v2);
        return Collections.unmodifiableMap(map);
    }
    
    /**
     * Convenience method for the inline creation of a map with values
     *
     * @param k1 key to be added
     * @param v1 value to be added
     * @param k2 key to be added
     * @param v2 value to be added
     * @param k3 key to be added
     * @param v3 value to be added
     * @param k4 key to be added
     * @param v4 value to be added
     * @return an <i>immutable</i> Map with the given elements
     */
    @SuppressWarnings("squid:S00107") // owolff: Number of parameters match to the use-case
    static <K, V> Map<K, V> immutableMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Map<K, V> map = mutableMap();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        map.put(k4, v4);
        map.put(k5, v5);
        return Collections.unmodifiableMap(map);
    }
    
    // Checks for emptiness
    /**
     * Simple check method for a {@code null} safe check of the emptiness of the given
     * varags-parameter.
     *
     * @param elements to be checked, may be null
     * @return {@code true} is the given elements are {@code null} of {@code empty}
     */
     static boolean isEmpty(Object... elements) {
        return null == elements || 0 == elements.length;
    }

    /**
     * Simple check method for a {@code null} safe check of the emptiness of the given parameter.
     *
     * @param elements to be checked, may be null
     * @return {@code true} is the given elements are {@code null} or {@code empty}
     */
    static boolean isEmpty(Iterable<?> elements) {
        return null == elements || isEmpty(elements.iterator());
    }

    /**
     * Simple check method for a {@code null} safe check of the emptiness of the given parameter.
     *
     * @param elements to be checked, may be null
     * @return {@code true} is the given elements are {@code null} or {@code empty}
     */
    static boolean isEmpty(Collection<?> elements) {
        return null == elements || elements.isEmpty();
    }

    /**
     * Simple check method for a {@code null} safe check of the emptiness of the given parameter.
     *
     * @param elements to be checked, may be null
     * @return {@code true} is the given elements are {@code null} or {@code empty}
     */
    static boolean isEmpty(Iterator<?> elements) {
        return null == elements || !elements.hasNext();
    }

    private CollectionHelper() {
        // Utility Class
    }
}
