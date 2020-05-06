package com.njm.bandme.domain.di.component;

import com.njm.bandme.domain.di.module.RetrofitModule;
import com.njm.bandme.ui.fragments.login.LoginFragment;
import com.njm.bandme.ui.fragments.login.RegisterFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = RetrofitModule.class)
public interface RetrofitComponent {

    void inject(LoginFragment loginFragment);
    void inject(RegisterFragment registerFragment);
}
