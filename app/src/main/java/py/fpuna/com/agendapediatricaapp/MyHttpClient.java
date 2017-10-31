package py.fpuna.com.agendapediatricaapp;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONObject;
import java.util.HashMap;



import java.io.IOException;

/**
 * Created by marceloe on 08/10/17.
 */

public class MyHttpClient {

    private static final String PATH = "http://localhost:8080/AgendaPediatrica/webresources/";

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    private OkHttpClient client = new OkHttpClient();

    public OkHttpClient getClient() {
        return client;
    }

    public void setClient(OkHttpClient client) {
        this.client = client;
    }

    public String doGetRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .url(PATH + url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String doPostRequest2(String url, String json) throws IOException {
        //RequestBody body = RequestBody.create(JSON, json);
        RequestBody formBody = new FormBody.Builder()
                .add("correo", json)
                .build();



        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(this)
                .build();
        Request request = new Request.Builder()
                .url(loginUrl)
                .post(formBody)
                .build();

       Request request = new Request.Builder()
                .header("X-Client-Type", "Android")
                .url(PATH + url)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();

        return response.body().string();

    }
}
