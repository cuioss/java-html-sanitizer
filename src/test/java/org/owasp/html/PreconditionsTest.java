package org.owasp.html;

import static org.junit.Assert.*;
import static org.owasp.html.Preconditions.checkArgument;
import static org.owasp.html.Preconditions.checkState;

import org.junit.Test;


public class PreconditionsTest {

    private static final String MESSAGE = "message";

    @Test
    public void shouldHandleCheckArgument() {
        checkArgument(true);
        
        try {
            checkArgument(false);
            fail("Should have thrown exception");
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }

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
    public void shouldHandleCheckState() {
        checkState(true);
        
        try {
            checkState(false);
            fail("Should have thrown exception");
        } catch (Exception e) {
            assertTrue(e instanceof IllegalStateException);
        }

    }

}
