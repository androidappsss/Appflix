package br.com.lzacheu.appflix.movies;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.lzacheu.appflix.R;
import br.com.lzacheu.appflix.model.Movie;

/**
 * Created by luiszacheu on 22/06/18.
 */
public class MoviesFragment extends Fragment implements MoviesContract.View {

    private static final int NUMBER_COLUMN = 2;
    private MoviesAdapter moviesAdapter;

    private MoviesContract.Presenter moviesPresenter;

    private ProgressBar progressBar;


    public MoviesFragment() {

    }

    public static MoviesFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MoviesFragment fragment = new MoviesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.movies_fragment, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
        progressBar = rootView.findViewById(R.id.progressBar);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), NUMBER_COLUMN);
        recyclerView.setLayoutManager(layoutManager);

        moviesAdapter = new MoviesAdapter(new ArrayList<Movie>(Collections.EMPTY_LIST));
        recyclerView.setAdapter(moviesAdapter);

        moviesPresenter = new MoviesPresenter(this);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        moviesPresenter.start();
        moviesPresenter.loadMovies();
    }

    @Override
    public void showLoading(boolean active) {
        if (active){
            progressBar.setVisibility(View.VISIBLE);
        }else{
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showMovies(List<Movie> movies) {
        moviesAdapter.addMovies(movies);
    }

    @Override
    public void showEmptyView(boolean active) {

    }

    @Override
    public void setPresenter(MoviesContract.Presenter presenter) {
        moviesPresenter = presenter;
    }
}
