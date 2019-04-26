package com.rsg.hw3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    private Context context;
    private static final String MOVIE = "movie";
    private static final String YEAR = "year";

    private static final String DIRECTOR = "director";
    private static final String URL = "url";
    private static final String DESCRIPTION = "description";




    String[][] movies;


    public RecyclerViewAdapter(Context context, String[][] movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_year, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final int n=i;
        viewHolder.movie.setText(movies[i][0]);
        viewHolder.year.setText(movies[i][1]);
        viewHolder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ThirdActivity.class);
                intent.putExtra(MOVIE,movies[n][0]);
                intent.putExtra(YEAR,movies[n][1]);
                intent.putExtra(DIRECTOR,movies[n][2]);
                intent.putExtra(URL,movies[n][3]);
                intent.putExtra(DESCRIPTION,movies[n][4]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView movie, year;
        LinearLayout parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            movie = itemView.findViewById(R.id.movie);
            year = itemView.findViewById(R.id.year);
            parent = itemView.findViewById(R.id.LinearLayoutId);
        }

    }
}
