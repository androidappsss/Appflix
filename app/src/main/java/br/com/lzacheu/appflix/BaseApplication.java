package br.com.lzacheu.appflix;

import android.app.Application;
import android.util.Log;

import br.com.lzacheu.appflix.data.DataManager;
import br.com.lzacheu.appflix.data.network.RemoteCallback;
import br.com.lzacheu.appflix.model.ConfigurationTmdb;

/**
 * Created by luiszacheu on 04/07/18.
 */
public class BaseApplication extends Application {

    private static final String TAG = BaseApplication.class.getSimpleName();
    private DataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate();
        dataManager = DataManager.getInstance();
        dataManager.getConfiguration(new RemoteCallback<ConfigurationTmdb>() {
            @Override
            public void onSuccess(ConfigurationTmdb response) {
                Log.e(TAG, "onSuccess: -> " + response.toString() );
            }

            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onUnauthorized() {

            }
        });
    }
}
