package br.com.lzacheu.appflix.data.network;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by luiszacheu on 03/07/18.
 */
public abstract class RemoteCallback<T> implements Callback<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        switch (response.code()) {
            case HttpURLConnection.HTTP_OK:
            case HttpURLConnection.HTTP_CREATED:
            case HttpURLConnection.HTTP_ACCEPTED:
            case HttpURLConnection.HTTP_NOT_AUTHORITATIVE:
                if (response.body() != null){
                    onSuccess(response.body());
                }
                break;
            case HttpURLConnection.HTTP_UNAUTHORIZED:
                onUnauthorized();

            default:
                onFailure(new Throwable("Default " + response.code() + " " + response.message() ));
        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }

    public abstract void onSuccess(T response);

    public abstract void onFailure(Throwable throwable);

    public abstract void onUnauthorized();
}
