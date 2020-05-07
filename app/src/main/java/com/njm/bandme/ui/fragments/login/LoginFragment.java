package com.njm.bandme.ui.fragments.login;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;
import com.njm.bandme.R;
import com.njm.bandme.domain.entities.User;
import com.njm.bandme.ui.fragments.home.HomeFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends Fragment {

    private User user;

    @BindView(R.id.tvRegister) MaterialTextView tvRegister;
    @BindView(R.id.btnLogin) MaterialButton btnLogin;
    @BindView(R.id.tvInputUsername) TextInputEditText tvInputUsername;
    @BindView(R.id.tvInputPassword) TextInputEditText tvInputPassword;
    @BindView(R.id.tvInputUsername) TextInputEditText tvForgotPassword;
    private View view;
    private RegisterFragment registerFragment;
    private HomeFragment homeFragment;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);


        //tvRegister.setOnClickListener(this);
        //btnLogin.setOnClickListener(this);

        return view;
    }


    @OnClick({R.id.btnLogin, R.id.tvRegister})
    public void onClickListener(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (v.getId()){
            case R.id.tvRegister:
                registerFragment = new RegisterFragment();
                fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                fragmentTransaction.replace(R.id.fragment_login_container, registerFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.btnLogin:
                homeFragment = new HomeFragment();
                fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                fragmentTransaction.replace(R.id.fragment_login_container, homeFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;

        }
    }
}

