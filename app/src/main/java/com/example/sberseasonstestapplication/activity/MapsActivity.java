package com.example.sberseasonstestapplication.activity;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.sberseasonstestapplication.R;
import com.example.sberseasonstestapplication.api.model.BankAutomat;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public static final String BANK_AUTOMATS_LIST = "BANK_AUTOMATS";
    private ArrayList<BankAutomat> bankAutomats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng latLng;
        bankAutomats = (ArrayList<BankAutomat>) getIntent().getSerializableExtra(BANK_AUTOMATS_LIST);
        // Add a marker on map
        try {
            for (int i = 0; i < bankAutomats.size(); i++) {
                latLng = new LatLng(bankAutomats.get(i).getLat(), bankAutomats.get(i).getLng());
                mMap.addMarker(new MarkerOptions().position(latLng));
            }
        }catch (NullPointerException e) {
            e.printStackTrace();
        }

        // Move the camera on Moscow marker
        LatLng moscow = new LatLng(55.7525897, 37.6228476);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(moscow));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(moscow, 9.0f));
    }
}
