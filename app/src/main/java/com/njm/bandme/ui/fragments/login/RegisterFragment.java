package com.njm.bandme.ui.fragments.login;

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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterFragment extends Fragment {

    @BindView(R.id.tvReturnLogin) MaterialTextView tvReturnLogin;
    @BindView(R.id.tvInputUsername) TextInputEditText tvInputUsername;
    @BindView(R.id.tvInputEmail) TextInputEditText tvInputEmail;
    @BindView(R.id.tvInputPassword) TextInputEditText tvInputPassword;
    @BindView(R.id.tvInputConfirmPassword) TextInputEditText tvInputConfirmPassword;
    @BindView(R.id.btnRegister) MaterialButton btnRegister;
    private View view;
    private LoginFragment loginFragment;

    public RegisterFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.tvReturnLogin})
    public void onClickLogin(View v) {
        switch (v.getId()){
            case R.id.tvReturnLogin:
                loginFragment = new LoginFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                fragmentTransaction.replace(R.id.fragment_login_container, loginFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

        }
    }
}
