package com.example.WeatherApp.service;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.stereotype.Service;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
@Service
public class JsonParsingService{
    private OkHttpClient client;
    private Response response;
    private static final String API_KEY = "652db73004b0a32ebf17323379356f46";

    public JSONObject getWeather(){
        client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.openweathermap.org/data/2.5/weather?q=Moscow&appid="+API_KEY)
                .build();
        try {
            response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        }catch (IOException | JSONException e){
            e.printStackTrace();
        }
        return null;
    }
}
