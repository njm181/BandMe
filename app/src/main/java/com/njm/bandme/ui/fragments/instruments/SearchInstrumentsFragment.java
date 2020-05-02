package com.njm.bandme.ui.fragments.instruments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.njm.bandme.R;
import com.njm.bandme.premium.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchInstrumentsFragment extends Fragment {

    public SearchInstrumentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_instruments, container, false);
    }
}
