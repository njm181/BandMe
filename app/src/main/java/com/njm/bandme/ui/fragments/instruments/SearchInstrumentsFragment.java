package com.njm.bandme.ui.fragments.instruments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.njm.bandme.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchInstrumentsFragment extends Fragment {

    @BindView(R.id.tvInputSearchInstruments) TextInputEditText tvInputSearchInstruments;
    @BindView(R.id.btnSearchInstruments) MaterialButton btnSearchInstruments;
    private View view;


    public SearchInstrumentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search_instruments, container, false);
        ButterKnife.bind(this,view);
        return view;
    }
}
