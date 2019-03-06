package com.example.audio_1_mubs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuranFragment extends Fragment {
    RecyclerView rvQuran;
    private QuranAdapter quranAdapter;

    public QuranFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vi = inflater.inflate( R.layout.fragment_quran, null );
        rvQuran = vi.findViewById( R.id.quran_list );
        quranAdapter = new QuranAdapter( getActivity() );
        rvQuran.setAdapter( quranAdapter );
        rvQuran.setLayoutManager( new LinearLayoutManager( getActivity(), LinearLayoutManager.VERTICAL, false ) );

        return vi;
    }

}
