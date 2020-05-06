package com.njm.bandme.domain.di.component;

import com.njm.bandme.domain.di.module.PlacesModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = PlacesModule.class)
public interface PlacesComponent {
}
