package com.striim.restsample;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class Auth {
    
    private static final String URL_PATH = "/security/authenticate";
    
    public static String getAuthToken(String url,
            String uname, String pwd) throws IOException {
        try(CloseableHttpClient httpclient = HttpClients.createDefault()) {
            List<NameValuePair> form = new ArrayList<>();
            form.add(new BasicNameValuePair("username", uname));
            form.add(new BasicNameValuePair("password", pwd));
            
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(
                    form, Consts.UTF_8);
            
            HttpPost httpPost = new HttpPost(url + URL_PATH);
            httpPost.setEntity(entity);
            
            try(CloseableHttpResponse res = httpclient.execute(httpPost)) {
                final int status = res.getStatusLine().getStatusCode();
                if(status != 200) {
                    throw new LoginException(
                            String.format("Response status %s", status));
                }
                try(
                        InputStream is = res.getEntity().getContent();
                        JsonReader reader = Json.createReader(is);
                        ) {
                    JsonObject obj = reader.readObject();
                    final String token = obj.getString("token");
                    return token;
                }
            }
        }
    }
}