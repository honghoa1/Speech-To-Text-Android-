package com.example.vietha1.Service;

public class APIService {
    private static final String base_url = "http://192.168.1.5/server/";
    public static Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}
