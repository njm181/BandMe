package com.njm.bandme.domain.di.module;

import com.njm.bandme.utils.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPreferencesModule {

    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences(){
        return new SharedPreferences();
    }
}
