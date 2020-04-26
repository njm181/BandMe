package com.njm.bandme.ui.fragments.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.card.MaterialCardView;
import com.njm.bandme.R;
import com.njm.bandme.ui.activities.search.SearchActivity;
import com.njm.bandme.ui.fragments.profile.ProfileFragment;
import com.njm.bandme.ui.fragments.profile.ProfileOptionsFragment;
import com.njm.bandme.utils.BaseApplication;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private MaterialCardView materialCardViewProfile, MaterialCardSearchUsers;
    private View view;
    private ProfileOptionsFragment profileOptionsFragment;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);

        //abstraer!
        materialCardViewProfile = view.findViewById(R.id.cardUserProfile);
        MaterialCardSearchUsers = view.findViewById(R.id.cardSearchUsers);
        //abstraer!
        MaterialCardSearchUsers.setOnClickListener(this);
        materialCardViewProfile.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (v.getId()){
            case R.id.cardUserProfile:
                profileOptionsFragment = new ProfileOptionsFragment();
                fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                fragmentTransaction.replace(R.id.fragment_login_container, profileOptionsFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.cardSearchUsers:
                /*profileOptionsFragment = new ProfileOptionsFragment();
                fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                fragmentTransaction.replace(R.id.fragment_login_container, profileOptionsFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();*/
                Intent intent = new Intent(BaseApplication.getContext(), SearchActivity.class);
                startActivity(intent);
                break;

        }
    }
}
