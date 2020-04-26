package com.njm.bandme.ui.activities.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.njm.bandme.R;
import com.njm.bandme.ui.fragments.profile.FriendsFragment;
import com.njm.bandme.ui.fragments.profile.dummy.DummyContent;

public class FriendsActivity extends AppCompatActivity implements FriendsFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_friends);
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
