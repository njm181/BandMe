package com.njm.bandme.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.njm.bandme.domain.di.component.BandComponent;
import com.njm.bandme.domain.di.component.DaggerBandComponent;
import com.njm.bandme.domain.di.component.DaggerPlacesComponent;
import com.njm.bandme.domain.di.component.DaggerRetrofitComponent;
import com.njm.bandme.domain.di.component.DaggerSharedPreferencesComponent;
import com.njm.bandme.domain.di.component.DaggerUserComponent;
import com.njm.bandme.domain.di.component.PlacesComponent;
import com.njm.bandme.domain.di.component.RetrofitComponent;
import com.njm.bandme.domain.di.component.SharedPreferencesComponent;
import com.njm.bandme.domain.di.component.UserComponent;
import com.njm.bandme.domain.di.module.BandModule;
import com.njm.bandme.domain.di.module.PlacesModule;
import com.njm.bandme.domain.di.module.RetrofitModule;
import com.njm.bandme.domain.di.module.SharedPreferencesModule;
import com.njm.bandme.domain.di.module.UserModule;

public class BaseApplication extends Application {

    private static BaseApplication instance;
    private RetrofitComponent retrofitComponent;;
    private BandComponent bandComponent;
    private PlacesComponent placesComponent;
    private SharedPreferencesComponent sharedPreferencesComponent;
    private UserComponent userComponent;

    //vinculado con el manifest
    public static BaseApplication getInstance(){
        return instance;
    }

    public static Context getContext(){
        return instance;
    }

    @Override
    public void onCreate() {
        //se inicializa cuando se ejecuta la app
        instance = this;
        super.onCreate();

        //componentes de Dagger
        retrofitComponent = DaggerRetrofitComponent
                .builder()
                .retrofitModule(new RetrofitModule())
                .build();

        bandComponent = DaggerBandComponent
                .builder()
                .bandModule(new BandModule())
                .build();

        placesComponent = DaggerPlacesComponent
                .builder()
                .placesModule(new PlacesModule())
                .build();

        sharedPreferencesComponent = DaggerSharedPreferencesComponent
                .builder()
                .sharedPreferencesModule(new SharedPreferencesModule())
                .build();

        userComponent = DaggerUserComponent
                .builder()
                .userModule(new UserModule())
                .build();
    }

    public RetrofitComponent getRetrofitComponent(){
        return retrofitComponent;
    }

    public BandComponent getBandComponent(){
        return bandComponent;
    }

    public PlacesComponent getPlacesComponent(){
        return placesComponent;
    }

    public SharedPreferencesComponent getSharedPreferencesComponent(){
        return sharedPreferencesComponent;
    }

    public UserComponent getUserComponent(){
        return userComponent;
    }
}
