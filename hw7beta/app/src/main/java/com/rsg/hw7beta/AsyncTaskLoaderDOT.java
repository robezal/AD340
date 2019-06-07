package com.rsg.hw7beta;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

public class AsyncTaskLoaderDOT extends AsyncTaskLoader<String> {

    public AsyncTaskLoaderDOT(Context context) {
        super(context);

    }

    @Nullable
    @Override
    public String loadInBackground() {

        String url = "https://web6.seattle.gov/Travelers/api/Map/Data?zoomId=13&type=2";

        return NetWorkConnection.getData(url);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
