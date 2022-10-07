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
        musics.add(new Music ("Miyagi", "Marmalade", R.drawable.marmalade, R.raw.marmalade));
        musics.add(new Music ("Anna Asti", "По барам", R.drawable.bar, R.raw.bar));
        musics.add(new Music ("Mikhail Shufutinskiy", "3-е сентября", R.drawable.sept, R.raw.sent));
        musics.add(new Music ("Anna Asti", "Танец", R.drawable.tenec, R.raw.tanec));
        musics.add(new Music ("Jony", "Никак", R.drawable.nikak, R.raw.nikak));
    }


}