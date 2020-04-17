package com.njm.bandme.utils;

import android.app.Application;
import android.content.Context;

public class BaseApplication extends Application {

    private static BaseApplication instance;

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
    }
}
