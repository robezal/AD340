package com.rsg.hw6;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Listener listener;

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    interface Listener {
        void onClick(int position);
    }

    private Cam[] cams;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout layout;

        public ViewHolder(View v) {
            super(v);
            layout = v.findViewById(R.id.layout_camera);
        }
    }

    public RecyclerViewAdapter(Cam[] cams) {
        this.cams = cams;
    }

    @Override
    public int getItemCount() {
        return cams.length;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_camera, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        View view = holder.layout;
        TextView title = view.findViewById(R.id.location);
        ImageView pic = view.findViewById(R.id.image);

        Cam cam = cams[position];
        title.setText(cam.getLocation());

        Picasso.get().load(cams[position].getUrl()).into(pic);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }
}