package org.example;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class App {


    public static void main(String[] args) throws Exception {
        requestPut();
    }

    public static void requestGet() throws Exception{
        final Content getResult = Request.Get("http://localhost:9200/puttest/_doc/1")
                .execute().returnContent();
        System.out.println(getResult.asString());
    }

    public static void requestPut() throws IOException {

        final Collection<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("title", "foo"));
        params.add(new BasicNameValuePair("body", "bar"));
        params.add(new BasicNameValuePair("userId", "1"));

        final Content postResult = Request.Put("http://localhost:9200/puttest/_doc/1")
                .bodyString("{\"title\": \"foo\",\"body\":\"bar\",\"userId\": 1}", ContentType.APPLICATION_JSON)
                .execute().returnContent();
        System.out.println(postResult.asString());
    }

}

