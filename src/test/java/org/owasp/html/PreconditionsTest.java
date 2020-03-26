package org.owasp.html;

import static org.owasp.html.Preconditions.checkArgument;
import static org.owasp.html.Preconditions.checkState;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class PreconditionsTest {

    private static final String MESSAGE = "message";

    private static final String MESSAGE_TEMPLATE = "message %s";

    private static final String MESSAGE_PARAMETER = "parameter";

    private static final String MESSAGE_TEMPLATE_RESULT = "message parameter";

    @Test
    void shouldHandleCheckArgument() {
        checkArgument(true);
        assertThrows(IllegalArgumentException.class, () -> checkArgument(false));

        checkArgument(true, MESSAGE);

        try {
            checkArgument(false, MESSAGE);
            fail("Should have thrown exception");
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertEquals(MESSAGE, e.getMessage());
        }
    }


    @Test
    void shouldHandleCheckState() {
        checkState(true);
        assertThrows(IllegalStateException.class, () -> checkState(false));

        checkState(true, MESSAGE);

        try {
            checkState(false, MESSAGE);
            fail("Should have thrown exception");
        } catch (Exception e) {
            assertTrue(e instanceof IllegalStateException);
            assertEquals(MESSAGE, e.getMessage());
        }
    }

}
