package br.com.lzacheu.appflix.movies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import br.com.lzacheu.appflix.R;

/**
 * Created by luiszacheu on 22/06/18.
 */
public class MoviesActivity extends AppCompatActivity  {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies_activity);

        MoviesFragment moviesFragment = (MoviesFragment) getSupportFragmentManager().findFragmentById(R.id.content);
        if (moviesFragment == null){
            moviesFragment = MoviesFragment.newInstance();
        }

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.content, moviesFragment);
        fragmentTransaction.commit();

        new MoviesPresenter(moviesFragment);
    }
}
