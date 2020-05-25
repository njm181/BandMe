package com.njm.bandme.ui.fragments.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;
import com.njm.bandme.R;
import com.njm.bandme.domain.entities.User;
import com.njm.bandme.ui.fragments.home.HomeFragment;

import java.util.concurrent.Executor;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends Fragment {

    private static final int RC_SIGN_IN = 100;
    private User user;

    @BindView(R.id.tvRegister) MaterialTextView tvRegister;
    @BindView(R.id.btnLogin) MaterialButton btnLogin;
    @BindView(R.id.tvInputUsername) TextInputEditText tvInputUsername;
    @BindView(R.id.tvInputPassword) TextInputEditText tvInputPassword;

    @BindView(R.id.btnGoogle)
    SignInButton btnGoogle;
    @BindView(R.id.btnCerrar)
    Button btnCerrar;

    GoogleSignInOptions gso;
    private GoogleSignInClient mGoogleSignInClient;
    private GoogleApiClient googleApiClient;

    private View view;
    private RegisterFragment registerFragment;
    private HomeFragment homeFragment;



    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();;


        mGoogleSignInClient = GoogleSignIn.getClient (getContext(), gso);
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


    @OnClick({R.id.btnGoogle})
    public void onClickGoogle(View v) {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    @OnClick({R.id.btnCerrar})
    public void cerrarSesion(View v) {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener((Activity) getContext(), new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getContext(), "Sesion cerrada", Toast.LENGTH_SHORT).show();
                    }
                });
        mGoogleSignInClient.revokeAccess()
                .addOnCompleteListener((Activity) getContext(), new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getContext(), "Sesion revocada", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RC_SIGN_IN){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if(result.isSuccess()){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Toast.makeText(getContext(), "sesion iniciada "+ result.getSignInAccount().getEmail()+" / "
                    +result.getSignInAccount().getDisplayName()+" / "+ result.getSignInAccount().getId(), Toast.LENGTH_LONG).show();
            homeFragment = new HomeFragment();
            fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
            fragmentTransaction.replace(R.id.fragment_login_container, homeFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }else{
            Toast.makeText(getContext(), "no te logueaste", Toast.LENGTH_SHORT).show();
        }
    }
}

