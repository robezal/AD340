package com.rsg.hw7beta;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback{
    private final static String TAG = "MAPS_ACTIVITY";
    private double myLatitude;
    private double myLongitude;
    private double camLatitude;
    private double camLongitude;
    private boolean mLocationPermissionGranted = false;
    private GoogleMap mMap;
    private FusedLocationProviderClient mLocationClient;


    @Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_maps);

    Intent mapsIntent = getIntent();
    double[] array = (mapsIntent).getDoubleArrayExtra("array");
    Log.i(TAG, Double.toString(array[0]));
    camLatitude = array[0];
    camLongitude = array[1];
    mLocationClient = LocationServices.getFusedLocationProviderClient(this);
    SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        getLocationPermission();
        getLocation();
    }

    @SuppressLint("MissingLocation")
    private void getLocation() {
        if(mLocationPermissionGranted) {


            Task location = mLocationClient.getLastLocation();


            location.addOnCompleteListener(new OnCompleteListener<Location>() {
                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    Location myLocation = task.getResult();
                    //Log.i(TAG, "LOOK FOR THIS");
                    LatLng camLocation = new LatLng(camLatitude, camLongitude);

                    MarkerOptions cameraOptions = new MarkerOptions();
                    cameraOptions.position(camLocation);

                    Marker camMarker = mMap.addMarker(cameraOptions);
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(camLocation,10));

//                    if (myLocation != null){
//                        LatLng newLocation = new LatLng(myLocation.getLatitude(),myLocation.getLongitude());
//                        Log.i(TAG, newLocation.toString());
//                        MarkerOptions myOptions = new MarkerOptions();
//                        myOptions.position(newLocation);
//                        mMap.addMarker(myOptions);
//                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(newLocation,10));
//                    }


                }
            });
            location.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.e(TAG, e.getLocalizedMessage());
                }
            });
        }
    }



    private void getLocationPermission () {

        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
            Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED){
            mLocationPermissionGranted = true;

        } else{
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }


    }

    @Override
    public void onRequestPermissionsResult ( int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        mLocationPermissionGranted = false;
        switch (requestCode) {
            case 1: {


                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mLocationPermissionGranted = true;
                    getLocation();
                }
            }
        }
    }
}



