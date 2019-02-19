package com.striim.restsample;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author subhash
 */
public class AuthTest {

    /**
     * Test of getAuthToken method, of class Auth.
     */
    @Test
    public void testGetAuthToken() throws Exception {
        System.out.println("getAuthToken");
        String url = "http://localhost:9080";
        String uname = "admin";
        String pwd = "admin";
        int expResultSize = 36;
        String result = Auth.getAuthToken(url, uname, pwd);
        System.out.println("Token: " + result);
        assertEquals(expResultSize, result.length());
    }
    
}
