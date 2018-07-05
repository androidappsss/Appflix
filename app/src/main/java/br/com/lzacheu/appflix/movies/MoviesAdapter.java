package br.com.lzacheu.appflix.movies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.lzacheu.appflix.R;
import br.com.lzacheu.appflix.model.Movie;
import br.com.lzacheu.appflix.utils.Constants;

/**
 * Created by luiszacheu on 03/07/18.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private List<Movie> movieList;

    private Context context;

    public MoviesAdapter(Context context, List<Movie> movieList) {
        this.movieList = movieList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_adapter, parent, false);

        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.title.setText(movieList.get(position).getTitle());
        Picasso.get()
                .load(Constants.IMAGE_BASE_URL + movieList.get(position).getPosterPath())
                .into(holder.poster);

        holder.parentView.setOnClickListener((view) -> {
            Toast.makeText(context, movieList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void addMovies(List<Movie> movies) {
        movieList.addAll(movies);
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView poster;
        public CardView parentView;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            poster = itemView.findViewById(R.id.poster);
            parentView = itemView.findViewById(R.id.card_content);

        }
    }

}
