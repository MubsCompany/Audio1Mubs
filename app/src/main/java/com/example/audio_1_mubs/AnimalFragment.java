package com.example.audio_1_mubs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalFragment extends Fragment {
RecyclerView rvAnimal;
AnimalAdapter animalAdapter;

    public AnimalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate( R.layout.fragment_animal, container, false );
        rvAnimal = v.findViewById( R.id.animal_list );
        animalAdapter = new AnimalAdapter(getActivity());
        rvAnimal.setAdapter( animalAdapter );
        rvAnimal.setLayoutManager( new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false ) );

        return v;
    }

}
