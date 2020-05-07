package com.njm.bandme.ui.fragments.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.njm.bandme.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProfileFragment extends Fragment {

    @BindView(R.id.tvOffice) TextView tvOffice;
    @BindView(R.id.tvUsernamLastName) TextView tvUsernamLastName;
    @BindView(R.id.tvEdadUser) TextView tvEdadUser;
    @BindView(R.id.tvCiudad) TextView tvCiudad;
    @BindView(R.id.ratingBar) RatingBar ratingBar;
    @BindView(R.id.ivSpotify) ImageView ivSpotify;
    @BindView(R.id.ivYoutube) ImageView ivYoutube;
    @BindView(R.id.ivInstagram) ImageView ivInstagram;
    @BindView(R.id.tvContentUser) TextView tvContentUser;
    @BindView(R.id.btnPhone) FloatingActionButton btnPhone;
    @BindView(R.id.btnEmail) FloatingActionButton btnEmail;
    @BindView(R.id.btnEdit) FloatingActionButton btnEdit;
    private View view;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
