package com.njm.bandme.domain.di.component;

import com.njm.bandme.domain.di.module.SharedPreferencesModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = SharedPreferencesModule.class)
public interface SharedPreferencesComponent {
}
