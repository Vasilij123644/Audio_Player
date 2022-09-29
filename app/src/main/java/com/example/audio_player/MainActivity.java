package com.example.audio_player;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    String IspolName, songName;
    int AlbomName;

    private void next() {
        Intent intent = new Intent(this, MusicPlayer.class);
        startActivity(intent);

        intent.putExtra("isolnit", IspolName);
        intent.putExtra("song", songName);

    }

    ArrayList<Music> musics = new ArrayList<Music>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);

        MusicList.OnStateClickListener stateClickListener = new MusicList.OnStateClickListener() {
            @Override
            public void onStateClick(Music state, int position) {
                Intent intent = new Intent(getApplicationContext(), MusicPlayer.class);
                intent.putExtra("isolnit", musics.get(position).getIsop());
                intent.putExtra("song", musics.get(position).getName());
                Integer SS= 21;
                intent.putExtra("isolnit2", ""+musics.get(position).getAlbom() );
                intent.putExtra("isolnit3", ""+musics.get(position).getMusic() );
                startActivity(intent);
            }
        };
        MusicList adapter = new MusicList(this, musics, stateClickListener);
        recyclerView.setAdapter(adapter);
    }
    public void setInitialData(){

        musics.add(new Music ("MUPP X wSadfriendd", "Vendetta", R.drawable.vendetta, R.raw.vendetta));
        musics.add(new Music ("soviss", "Kitty Phonk", R.drawable.kittyphonk, R.raw.kitty_phonk));
        musics.add(new Music ("SHADXWBXRN", "KNIGHT", R.drawable.knight, R.raw.knight));
        musics.add(new Music ("Ghostface Playa, fkbambam", "KILLKA", R.drawable.killka, R.raw.killka));
        musics.add(new Music ("KORDHELL", "Live Another Day", R.drawable.liveanotherday, R.raw.liveanotherday));
    }


}