package com.njm.bandme.ui.fragments.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.card.MaterialCardView;
import com.njm.bandme.R;
import com.njm.bandme.ui.fragments.instruments.SearchInstrumentsFragment;
import com.njm.bandme.ui.fragments.premium.PremiumFragment;
import com.njm.bandme.ui.fragments.profile.ProfileOptionsFragment;
import com.njm.bandme.ui.fragments.searchUsers.SearchUserFragment;
import com.njm.bandme.utils.BaseApplication;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.cardUserProfile) MaterialCardView cardViewProfile;
    @BindView(R.id.cardSearchUsers) MaterialCardView cardSearchUsers;
    @BindView(R.id.cardInstruments) MaterialCardView cardInstruments;
    @BindView(R.id.cardPremium) MaterialCardView cardPremium;
    private View view;
    private ProfileOptionsFragment profileOptionsFragment;
    private BaseApplication baseApplication;
    private SearchUserFragment searchUserFragment;
    private SearchInstrumentsFragment searchInstrumentsFragment;
    private PremiumFragment premiumFragment;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);

        ButterKnife.bind(this, view);



        return view;
    }

    @OnClick({R.id.cardUserProfile, R.id.cardSearchUsers, R.id.cardPremium, R.id.cardInstruments})
    public void onClickAction(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        baseApplication = new BaseApplication();
        switch (v.getId()){
            case R.id.cardUserProfile:
                profileOptionsFragment = new ProfileOptionsFragment();
                fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                fragmentTransaction.replace(R.id.fragment_login_container, profileOptionsFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.cardSearchUsers:
                searchUserFragment = new SearchUserFragment();
                fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                fragmentTransaction.replace(R.id.fragment_login_container, searchUserFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.cardInstruments:
                searchInstrumentsFragment = new SearchInstrumentsFragment();
                fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                fragmentTransaction.replace(R.id.fragment_login_container, searchInstrumentsFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.cardPremium:
                premiumFragment = new PremiumFragment();
                fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                fragmentTransaction.replace(R.id.fragment_login_container, premiumFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;

        }
    }
}
