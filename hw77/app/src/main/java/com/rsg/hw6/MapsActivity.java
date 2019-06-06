package com.rsg.hw6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MapsActivity extends AppCompatActivity
    implements View.OnClickListener, OnMapReadyCallback {
    private final static String TAG = "MapsActivity";

    private FusedLocatoinProviderClient mLocationClient;
    private boolean mLocationPermissionGranted = false;
    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }

    @Override
    public void onClick(View view) {
        getLocationPermission();
        getLocation();
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {
        if (mLocationClientPermissionGranted)
            Task location = mLocationClient.getLastLocation();

        location.addOnCompleteListener(new onCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location actualLocation = task.getResult();
                if (actualLocation != null) {
                    String latLong = String.format("Lat: %f, Long: %f",
                            actualLocation.getLatitude(),
                            actualLocation.getLongitute());

                    mMap.setMyLocationEnabled(true);
                    



                } else {
                    Log.e(TAG, "Location is null ...");
                }
            }

        });
        adapter.setListener(new RecyclerAdapter.Listener() {
        });

        private void getLocationPermission () {
            if (ContextCompat.checkSelfPermission(this.getAppContext(),
                    Manifest.Permission.ACCESS_COARSE_LOCATION)
                    == PackageManager.class PERMISSION_GRANTED){
                mLocationPermissionGranted = true;

            } else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.Permission.ACCESS_COURSE_LOCATION}, 1)

            }
        }

        @Override
        public void onRequestPermissionResult ( int requestCode, @NonNull String[] permissions,
        @NonNull int[] grantResults){
            mLocationPermissionGranted = false;
            switch (requestCode) {


                //request code is our id for our request
                case 1: {


                    if (grantResults.length > 0 && grantResult[0] == PackageManager.PERMISSION_GRANTED) {
                        mLocationPermissionGranted = true;
                        getLocation();
                    }


                }
            }
        }

        @Override
        public void onMapReady (GoogleMap googleMap){
            mMap = googleMap;
            getLocation();
        }
    }
}
























