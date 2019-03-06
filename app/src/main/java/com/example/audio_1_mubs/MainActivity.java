package com.example.audio_1_mubs;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    FragmentManager fm;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        loadFragment( new HijaiyFragment() );

        fm = getSupportFragmentManager();
        fm.beginTransaction().add( R.id.container, new HijaiyFragment() ).addToBackStack( "any" ).commit();

        bottomNavigationView = findViewById( R.id.nv_view );
        bottomNavigationView.setOnNavigationItemSelectedListener( this );
    }

    private boolean loadFragment(HijaiyFragment hijaiyFragment) {
        if (hijaiyFragment != null) {
            getSupportFragmentManager().beginTransaction().replace( R.id.container, new HijaiyFragment() ).commit();
        }

        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment destinationFragment = null;
        fm = getSupportFragmentManager();

        switch (menuItem.getItemId()) {
            case R.id.ic_hijaiy:
                destinationFragment = new HijaiyFragment();
                break;
            case R.id.ic_quran:
                destinationFragment = new QuranFragment();
                break;
            case R.id.ic_favorite:
                destinationFragment = new AnimalFragment();
                break;

        }
        assert destinationFragment != null;
        fm.beginTransaction().replace( R.id.container, destinationFragment ).addToBackStack( "any" ).commit();

        return super.onOptionsItemSelected( menuItem );
    }







    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder( MainActivity.this );

        builder.setTitle( "Exit" )
                .setMessage( "Want to leave?" )
                .setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                } )
                .setNegativeButton( "Cancel",null );

        AlertDialog alert = builder.create();
        alert.show();
    }



}