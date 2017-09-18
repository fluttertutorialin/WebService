package com.jdkgroup.retrofitmvp3;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.androidnetworking.AndroidNetworking;
import com.google.gson.Gson;
import com.jdkgroup.retrofitmvp3.baseclasses.SimpleMVPActivity;
import com.jdkgroup.retrofitmvp3.models.Login;
import com.jdkgroup.retrofitmvp3.presenter.RegistrationPresenter;
import com.jdkgroup.retrofitmvp3.utils.AppUtils;
import com.jdkgroup.retrofitmvp3.view.RegistrationView;
import com.jdkgroup.webservice.R;

import java.util.HashMap;

import butterknife.ButterKnife;

public class ActivityRegister extends SimpleMVPActivity<RegistrationPresenter, RegistrationView> implements RegistrationView {
    HashMap<String, String> params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideSoftKeyboard();
        setContentView(R.layout.activity_retrofit_mvp_3);
        //getWindow().setBackgroundDrawableResource(R.drawable.bg);
        ButterKnife.bind(this);
        init();

        params = getDefaultParameter();
        getPresenter().callRegisterAPI(params);

        params = new HashMap<>();
        getPresenter().callCityApi(this, params);
    }

    public void init() {
        AndroidNetworking.initialize(getApplicationContext());
    }

    @NonNull
    @Override
    public RegistrationPresenter createPresenter() {
        return new RegistrationPresenter();
    }

    @NonNull
    @Override
    public RegistrationView attachView() {
        return this;
    }

    @Override
    public void onSuccess(Login response) {
        System.out.println("Tag" + "call");
        Gson gson = new Gson();
        AppUtils.showToast(this, gson.toJson(response));
    }

    @Override
    public void onFailure(String message) {
        AppUtils.showToast(this, message);
    }

    @Override
    public void responseCity(Login response) {
        System.out.println("Tag" + "call");
        Gson gson = new Gson();
        AppUtils.showToast(this, gson.toJson(response));
    }
}
