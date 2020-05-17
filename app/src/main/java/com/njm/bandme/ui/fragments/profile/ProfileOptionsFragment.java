package com.njm.bandme.ui.fragments.profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.card.MaterialCardView;
import com.njm.bandme.R;
import com.njm.bandme.ui.activities.profile.FriendsActivity;
import com.njm.bandme.utils.BaseApplication;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileOptionsFragment extends Fragment{

    @BindView(R.id.cardMyProfile) MaterialCardView materialCardViewFriends;
    @BindView(R.id.cardFriends) MaterialCardView materialCardMyProfile;
    private View view;
    private FriendsFragment friendsFragment;
    private ProfileFragment profileFragment;

    public ProfileOptionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_profile_options, container, false);

        ButterKnife.bind(this, view);


        return view;
    }

    @OnClick({R.id.cardMyProfile, R.id.cardFriends})
    public void onClickAction(View v) {
        FragmentManager fragmentManager = getFragmentManager(); //abstraer!
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();//abstraer!
        switch (v.getId()){
            case R.id.cardFriends:
                Intent intent = new Intent(BaseApplication.getContext(), FriendsActivity.class);
                startActivity(intent);
                break;
            case R.id.cardMyProfile:
                profileFragment = new ProfileFragment();
                fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                fragmentTransaction.replace(R.id.fragment_login_container, profileFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
        }
    }
}
