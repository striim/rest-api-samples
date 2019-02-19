package com.striim.restsample;

import org.junit.Test;
import static org.junit.Assert.*;

public class AuthTest {
    @Test public void testGetToken() throws Exception {
        String computed = Auth.getToken("http://localhost:9080", "admin", "admin");
        assertEquals(36, computed.length());
    }
}
