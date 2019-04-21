package com.example.sberseasonstestapplication.api.service;

import com.example.sberseasonstestapplication.api.model.BankAutomatList;

import retrofit2.Call;
import retrofit2.http.GET;


public interface BankAutomatService {
    @GET("/GetBankAutomats")
    Call<BankAutomatList> getBankAutomatList();
}
