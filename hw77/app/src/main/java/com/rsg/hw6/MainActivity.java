package com.rsg.hw6;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<String> {

    private final static String TAG = "MAIN_ACTIVITY";
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager conManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = conManager.getActiveNetworkInfo();

        if (info != null && info.isConnected()) {

            Bundle bundle = new Bundle();
            getSupportLoaderManager().restartLoader(0, bundle, this);


        } else {
            Toast toast = Toast.makeText(
                    this,
                    "internet not connection.",
                    Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new AsyncTaskLoaderDOT(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String s) {

        try {

            JSONObject rootObject = new JSONObject(s);
            JSONArray features = rootObject.getJSONArray("Features");
            Cam[] cameras = new Cam[features.length()];

            for (int i = 0; i < features.length(); i++) {
                JSONObject newCameraObject = features.getJSONObject(i);
                JSONArray camera = newCameraObject.getJSONArray("Cameras");
                for (int j = 0; j < camera.length(); j++) {
                    JSONObject currentCameraObject = camera.getJSONObject(j);
                    String description = currentCameraObject.getString("Description");
                    String url = currentCameraObject.getString("ImageUrl");
                    String type = currentCameraObject.getString("Type");

                    Cam cam = new Cam(description, url, type);
                    cameras[i] = cam;

                }
            }

            RecyclerView recyclerView = findViewById(R.id.recycler_view);
            recyclerView.setHasFixedSize(true);

            LinearLayoutManager manager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(manager);
            adapter = new RecyclerViewAdapter(cameras);
            recyclerView.setAdapter(adapter);





        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}