package com.njm.bandme.ui.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.textview.MaterialTextView;
import com.njm.bandme.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener {

    private MaterialTextView tvReturnLogin;
    private View view;
    private LoginFragment loginFragment;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_register, container, false);

        setVisualResources(view);

        tvReturnLogin.setOnClickListener(this);

        return view;
    }


    private void setVisualResources(View view) {
        tvReturnLogin = view.findViewById(R.id.tvReturnLogin);
    }


    @Override
    public void onClick(View v) {
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
