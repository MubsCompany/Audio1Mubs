package com.example.audio_1_mubs;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

class HijaiyAdapter extends RecyclerView.Adapter<HijaiyAdapter.HijaiyViewHolder> {
    MediaPlayer player;
    Context context;

    int[] arrayHijaiyImage = {R.drawable.alif,R.drawable.ba,R.drawable.ta,R.drawable.tsa,R.drawable.jim,R.drawable.cha,R.drawable.kha,R.drawable.dal,R.drawable.dzal,R.drawable.ro,R.drawable.zain,R.drawable.sin,R.drawable.syin,R.drawable.shod};
    String[] arrayHijaiyName = {"Alif","Ba","Ta","Tsa","Jim","Cha","Kha","Dal","Dzal","Ro","Zain","Sin","syin","Shod"};
    int[] audioHijaiy = {R.raw.fatah_a,R.raw.fatah_ba,R.raw.fatah_ta,R.raw.fatah_tsa,R.raw.fatah_ja,R.raw.fatah_ha,R.raw.fatah_kho,R.raw.fatah_da,R.raw.fatah_dza,R.raw.fatah_ro,R.raw.fatah_za,R.raw.fatah_sa,R.raw.fatah_sya,R.raw.fatah_sho};


    public HijaiyAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public HijaiyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
View v = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.hijaiy_layout,viewGroup,false );
        return new HijaiyViewHolder( v );
    }

    @Override
    public void onBindViewHolder(@NonNull HijaiyViewHolder hijaiyViewHolder, final int i) {
hijaiyViewHolder.imgHijaiy.setImageResource( arrayHijaiyImage[i] );
hijaiyViewHolder.tvHijaiy.setText( arrayHijaiyName[i] );
hijaiyViewHolder.itemView.setOnClickListener( new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Uri uri = Uri.parse( "android.resource://" + context.getPackageName() + "/" + audioHijaiy[i] );

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
        return arrayHijaiyImage.length;
    }

    public class HijaiyViewHolder extends RecyclerView.ViewHolder {
        TextView tvHijaiy;
        ImageView imgHijaiy;

        public HijaiyViewHolder(@NonNull View itemView) {
            super( itemView );

            tvHijaiy = itemView.findViewById( R.id.tv_hijaiy );
            imgHijaiy = itemView.findViewById( R.id.img_hijaiy );
        }
    }
}
