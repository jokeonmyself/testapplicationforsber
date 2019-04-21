package com.example.sberseasonstestapplication.api.model;

import com.example.sberseasonstestapplication.api.model.BankAutomat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BankAutomatList {

    @SerializedName("bankAutomats")
    @Expose
    private ArrayList<BankAutomat> bankAutomatList = new ArrayList<>();

    public ArrayList<BankAutomat> getBankAutomats () {
        return bankAutomatList;
    }

    public void setBankAutomats(ArrayList<BankAutomat> bankAutomats){
        this.bankAutomatList = bankAutomats;
    }
}
