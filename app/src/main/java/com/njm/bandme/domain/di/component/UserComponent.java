package com.njm.bandme.domain.di.component;

import com.njm.bandme.domain.di.module.UserModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = UserModule.class)
public interface UserComponent {
}
