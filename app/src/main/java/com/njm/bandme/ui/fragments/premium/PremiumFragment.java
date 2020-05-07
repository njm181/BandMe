package com.njm.bandme.ui.fragments.premium;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.njm.bandme.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PremiumFragment extends Fragment {

    @BindView(R.id.btnAcceptPremium) MaterialButton btnAcceptPremium;
    private View view;

    public PremiumFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_premium, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.btnAcceptPremium})
    private void onClickAcceptPremiun(){
        //redirect to page
    }
}
