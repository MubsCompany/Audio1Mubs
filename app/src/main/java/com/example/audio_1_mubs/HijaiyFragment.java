package com.example.audio_1_mubs;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class HijaiyFragment extends Fragment {
    RecyclerView rvHijaiy;
HijaiyAdapter hijaiyAdapter;

    public HijaiyFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate( R.layout.fragment_hijaiy, container, false );

        rvHijaiy = v.findViewById( R.id.rv_hijaiy );
        hijaiyAdapter = new HijaiyAdapter( getContext() );
        rvHijaiy.setAdapter( hijaiyAdapter );
        rvHijaiy.setLayoutManager( new GridLayoutManager(getContext(),2 ) );

        return v;
    }

}
