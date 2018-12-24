package com.striim.restsample;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

public class Auth {
    
    private static final String URL_PATH = "/security/authenticate";
    
    public static String getToken(String url, String uname, String pwd) throws IOException {
        Form form = new Form()
                .param("username", uname)
                .param("password", pwd);
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url + URL_PATH);
        Future<ResponseBean> res = target
                .request(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON)
                .buildPost(Entity.form(form))
                .submit(ResponseBean.class);
        try {
            String token = res.get().getToken();
            return token;
        } catch(InterruptedException | ExecutionException ex) {
            throw new RuntimeException(ex);
        }
    }
}
