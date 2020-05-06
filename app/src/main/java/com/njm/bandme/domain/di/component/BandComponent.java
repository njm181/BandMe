package com.njm.bandme.domain.di.component;

import com.njm.bandme.domain.di.module.BandModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = BandModule.class)
public interface BandComponent {
}
