package com.njm.bandme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.njm.bandme.ui.login.LoginFragment;
import com.njm.bandme.ui.login.RegisterFragment;

public class MainActivity extends AppCompatActivity {


    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private LoginFragment loginFragment;
    private RegisterFragment registerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setLoginFragment();


    }
    //se cargaran algunos fragmentos a esta actividad y luego se hara el intent a otra actividad Home a la cual se le pasaran los fragments
    //cargar fragmentos
    private void setLoginFragment(){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        loginFragment = new LoginFragment();
        fragmentTransaction.add(R.id.fragment_login_container, loginFragment);
        fragmentTransaction.commit();
    }
}
