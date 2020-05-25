package com.njm.bandme.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.njm.bandme.R;
import com.njm.bandme.domain.entities.Instrument;
import com.njm.bandme.domain.entities.User;
import com.njm.bandme.ui.fragments.home.HomeFragment;
import com.njm.bandme.ui.fragments.instruments.instrumentListFragment;
import com.njm.bandme.ui.fragments.login.LoginFragment;
import com.njm.bandme.ui.fragments.login.RegisterFragment;
import com.njm.bandme.ui.fragments.profile.FriendsFragment;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements FriendsFragment.OnListFragmentInteractionListener,
        instrumentListFragment.OnListFragmentInteractionListener {


    private static final int RC_SIGN_IN = 0;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private LoginFragment loginFragment;


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

    @Override
    public void onListFragmentInteraction(User item) {

    }

    @Override
    public void onListFragmentInteraction(Instrument item) {

    }


}
