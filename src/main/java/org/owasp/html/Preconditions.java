package org.owasp.html;

/**
 * Inspired by com.google.common.base.Preconditions. Defines a subset of the corresponding
 * Preconditions
 *
 * @author Oliver Wolff
 *
 */
final class Preconditions {

    /**
     * Ensures the truth of an expression involving one or more parameters to the calling method.
     *
     * @author com.google.common.base.Preconditions
     * @param expression a boolean expression
     * @throws IllegalArgumentException if {@code expression} is false
     */
    static void checkArgument(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Ensures the truth of an expression involving one or more parameters to the calling method.
     *
     * @author com.google.common.base.Preconditions
     * @param expression a boolean expression
     * @param message to be put into the create {@link IllegalArgumentException}
     * @throws IllegalArgumentException if {@code expression} is false
     */
    static void checkArgument(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Ensures the truth of an expression involving the state of the calling instance, but not
     * involving any parameters to the calling method.
     *
     * @author com.google.common.base.Preconditions
     * @param expression a boolean expression
     * @throws IllegalStateException if {@code expression} is false
     */
    static void checkState(boolean expression) {
        if (!expression) {
            throw new IllegalStateException();
        }
    }

    /**
     * @param a
     * @param matrixLength
     * @return 
     */
    static int checkElementIndex(int index, int size) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index " + index + "not in " + size);
          }
          return index;
        
    }

}
