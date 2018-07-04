package br.com.lzacheu.appflix.data.network;


import java.util.concurrent.TimeUnit;

import br.com.lzacheu.appflix.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by luiszacheu on 03/07/18.
 */
public class NetworkFactory {

    private static final String BASE_URL = "https://api.themoviedb.org/";

    public static final String API_KEY = "8afa32c4aa6ec9c873b3342d0bd26a9c";

    public static final String LANGUAGE_DEFAULT = "pt-BR";

    private static int HTTP_READ_TIMEOUT = 10000;

    private static int HTTP_CONNECT_TIMEOUT = 6000;

    public static <T> T getApiService(Class<T> clazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(makeOkHttpClient())
                .build();

        return retrofit.create(clazz);
    }

    private static OkHttpClient makeOkHttpClient() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient().newBuilder();
        httpClientBuilder.connectTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(HTTP_READ_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.addInterceptor(makeLoggingInterceptor());

        return httpClientBuilder.build();
    }

    private static HttpLoggingInterceptor makeLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        return loggingInterceptor;
    }
}
