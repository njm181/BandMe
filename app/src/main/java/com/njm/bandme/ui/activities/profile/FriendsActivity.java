package com.njm.bandme.ui.activities.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.njm.bandme.R;
import com.njm.bandme.domain.entities.User;
import com.njm.bandme.ui.fragments.profile.FriendsFragment;
public class FriendsActivity extends AppCompatActivity implements FriendsFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_friends);
    }

    @Override
    public void onListFragmentInteraction(User item) {

    }
}
