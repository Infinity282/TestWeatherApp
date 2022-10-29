package com.example.WeatherApp.service;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.stereotype.Service;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
@Service
public class JsonParsingService{
    private OkHttpClient client;
    private Response response;
    private String unit;
    private static final String API_KEY = "ba61e79a0119a86f77cc471643451b24";

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