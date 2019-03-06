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
import android.widget.TextView;

import java.io.IOException;

class QuranAdapter extends RecyclerView.Adapter<QuranAdapter.QuranViewHolder> {
    Context context;
    MediaPlayer player;

    String[] arraySurah = {"القارعة", "التكاثر", "العصر", "الهُمَزة", "الْفِيلِ", "قُرَيْشٍ", "الْمَاعُونَ", "الكوثر", "الْكَافِرُونَ", "النصر", "المسد", "الإخلاص", "الْفَلَقِ", "النَّاسِ"};
    int[] audioQuran = { R.raw.alqariah,R.raw.attakatsur, R.raw.alasr, R.raw.alhumazah, R.raw.alfiil, R.raw.alqurays, R.raw.almaun, R.raw.alkawtsar, R.raw.alkafirun, R.raw.annasr, R.raw.almasad, R.raw.alikhlas, R.raw.alfalaq,R.raw.annas};

    public QuranAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public QuranViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from( context ).inflate( R.layout.quran_layout, viewGroup, false );
        return new QuranViewHolder( inflate );
    }

    @Override
    public void onBindViewHolder(@NonNull QuranViewHolder quranViewHolder, final int i) {
        quranViewHolder.tvQuran.setText( arraySurah[i] );
        quranViewHolder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse( "android.resource://" + context.getPackageName() + "/" + audioQuran[i] );

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
        return arraySurah.length;
    }

    public class QuranViewHolder extends RecyclerView.ViewHolder {
        TextView tvQuran;

        public QuranViewHolder(@NonNull View itemView) {
            super( itemView );

            tvQuran = itemView.findViewById( R.id.tv_quran );
        }
    }
}
