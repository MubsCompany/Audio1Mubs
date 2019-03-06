package com.example.audio_1_mubs;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {
    MediaPlayer player;
    Context context;

    String[] arrayAnimalName = {"Ayam", "Bebek", "Nyamuk", "Kera", "Burung Hantu", "Kambing"};
    int[] arrayAnimalImage = {R.drawable.ayam, R.drawable.bebek, R.drawable.nyamuk, R.drawable.monyet, R.drawable.burunghantu, R.drawable.kambing};
    int[] arrayAnimalSound = {R.raw.ayam, R.raw.bebek, R.raw.nyamuk, R.raw.kera, R.raw.burunghantu, R.raw.kambing};

    public AnimalAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from( context ).inflate( R.layout.animal_layout, viewGroup, false );
        return new AnimalViewHolder( v );
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder animalViewHolder, final int i) {
        animalViewHolder.imgAnimal.setImageResource( arrayAnimalImage[i] );
        animalViewHolder.tvAnimal.setText( arrayAnimalName[i] );
        animalViewHolder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse( "android.resource://" + context.getPackageName() + "/" + arrayAnimalSound[i] );

                player = new MediaPlayer();
                player.setAudioStreamType( AudioManager.STREAM_MUSIC );

                try {
                    player.setDataSource( context, uri );
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }

                try {
                    player.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                player.start();
            }
        } );
    }

    @Override
    public int getItemCount() {
        return arrayAnimalImage.length;
    }

    public class AnimalViewHolder extends RecyclerView.ViewHolder {
        TextView tvAnimal;
        ImageView imgAnimal;

        public AnimalViewHolder(@NonNull View itemView) {
            super( itemView );

            tvAnimal = itemView.findViewById( R.id.tv_animal );
            imgAnimal = itemView.findViewById( R.id.img_animal );
        }
    }
}
