package com.jdkgroup.retrofit2mvp.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jdkgroup.retrofit2mvp.retrofit.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kamlesh on 12/17/2016.
 */

public class RetrofitClient {
    private final String ROOT_URL = "http://services.groupkt.com/";

    private Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create();

    private Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }
}
