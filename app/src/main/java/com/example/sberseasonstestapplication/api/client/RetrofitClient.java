package com.example.sberseasonstestapplication.api.client;

import com.example.sberseasonstestapplication.api.service.BankAutomatService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {

    private static final String BASE_URL = "http://10.0.2.2:8080";


    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static BankAutomatService getBankAutomatService() {
        return getRetrofitInstance().create(BankAutomatService.class);
    }
}
