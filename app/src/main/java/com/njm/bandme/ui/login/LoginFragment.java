package com.njm.bandme.ui.login;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
public class LoginFragment extends Fragment implements View.OnClickListener {

    private MaterialTextView tvRegister;
    private View view;
    private RegisterFragment registerFragment;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_login, container, false);

        setVisualResources(view);

        tvRegister.setOnClickListener(this);

        return view;
    }


    private void setVisualResources(View view) {
        tvRegister = view.findViewById(R.id.tvRegister);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvRegister:
                registerFragment = new RegisterFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                fragmentTransaction.replace(R.id.fragment_login_container, registerFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

        }
    }
}

