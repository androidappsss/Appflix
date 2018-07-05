package br.com.lzacheu.appflix.movies;

import android.content.Context;
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
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.lzacheu.appflix.R;
import br.com.lzacheu.appflix.model.Movie;
import br.com.lzacheu.appflix.utils.Constants;

/**
 * Created by luiszacheu on 22/06/18.
 */
public class MoviesFragment extends Fragment implements MoviesContract.View {

    private static final int NUMBER_COLUMN = 2;
    private MoviesAdapter moviesAdapter;

    private MoviesContract.Presenter moviesPresenter;

    private ProgressBar progressBar;

    private RecyclerView recyclerView;

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
        recyclerView = rootView.findViewById(R.id.recycler_view);
        progressBar = rootView.findViewById(R.id.progressBar);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), NUMBER_COLUMN);
        recyclerView.setLayoutManager(layoutManager);

        moviesAdapter = new MoviesAdapter(getContext(), new ArrayList<Movie>(Collections.EMPTY_LIST));
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
        runLayoutAnimation(recyclerView);
    }

    @Override
    public void showEmptyView(boolean active) {

    }

    @Override
    public void setPresenter(MoviesContract.Presenter presenter) {
        moviesPresenter = presenter;
    }

    private void runLayoutAnimation(final RecyclerView recyclerView){
        final Context context = recyclerView.getContext();
        final LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(context,
                R.anim.layout_animation_fall_down);

        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();

    }
}
