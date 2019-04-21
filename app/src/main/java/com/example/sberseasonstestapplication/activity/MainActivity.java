package com.example.sberseasonstestapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sberseasonstestapplication.R;
import com.example.sberseasonstestapplication.api.model.BankAutomat;
import com.example.sberseasonstestapplication.api.model.BankAutomatList;
import com.example.sberseasonstestapplication.api.service.BankAutomatService;
import com.example.sberseasonstestapplication.api.client.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button button;
    Intent mapActivityIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.search_bank_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataLoader();
                mapActivityIntent = new Intent(v.getContext(), MapsActivity.class);
            }
        });


    }

    private ArrayList<BankAutomat> dataLoader(){
        final BankAutomatService bankAutomatService = RetrofitClient.getBankAutomatService();

        Call<BankAutomatList> call = bankAutomatService.getBankAutomatList();

        call.enqueue(new Callback<BankAutomatList>() {
            @Override
            public void onResponse(Call<BankAutomatList> call, Response<BankAutomatList> response) {
                if (response.isSuccessful()){
                    Log.d("MainActivity", ":   " + response.code());
                    mapActivityIntent.putExtra(MapsActivity.BANK_AUTOMATS_LIST, response.body().getBankAutomats());
                    startActivity(mapActivityIntent);
                }
            }

            @Override
            public void onFailure(Call<BankAutomatList> call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(), "Network error", Toast.LENGTH_LONG);
                toast.show();
                t.printStackTrace();
            }
        });

        return null;
    }
}
