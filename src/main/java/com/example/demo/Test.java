package com.example.demo;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author denakira
 * @date 2019/12/25 10:29 上午
 */
public class Test {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(null, new byte[0]);
        Request request = new Request.Builder()
                .url("http://localhost:8080/download")
                .get()
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
