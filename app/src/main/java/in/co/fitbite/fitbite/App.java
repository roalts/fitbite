package in.co.fitbite.fitbite;

import android.app.Application;

import in.co.fitbite.fitbite.Api.Api;
import retrofit.RestAdapter;

/**
 * Created by raghav on 17/10/15.
 */
public class App extends Application {
    private Api apiHandler;
    private RestAdapter restAdapter;

    public Api getApiHandler() {
        //Make sure we just have one instance
        if (apiHandler == null) {
            restAdapter = new RestAdapter.Builder()
                    .setEndpoint(Api.BASE_URL)
                    .build();
            apiHandler = restAdapter.create(Api.class);
        }
        return apiHandler;
    }
}
