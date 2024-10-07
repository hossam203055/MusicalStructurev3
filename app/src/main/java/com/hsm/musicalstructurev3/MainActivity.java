package com.hsm.musicalstructurev3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Song> Songs;
    ListView songsListView;
    SongAdapter songAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Songs = new ArrayList<>();
        Songs.add(new Song("Blue (Da Ba Dee)", "Eiffel 65", "Europop", R.raw.eiffel65_blue_da_ba_dee, R.drawable.eiffel65));
        Songs.add(new Song("Scary Monsters and Nice Sprites (Hellsing Ultimate AMV)", "Skrillex", "More Monsters and Sprites EP", R.raw.hellsing_ultimate_amv_skrillex_scary_monsters_and_nice_sprites, R.drawable.skrillex_album));
        Songs.add(new Song("Scary Monsters And Nice Sprites (The Juggernaut Remix)", "Skrillex", "More Monsters and Sprites EP", R.raw.skrillex_scary_monsters_and_nice_sprites_the_juggernaut_remix, R.drawable.skrillex_album));
        Songs.add(new Song("Burning", "Mia Martina", "Devotion", R.raw.mia_martina_burning, R.drawable.mia_martina_burning));
        Songs.add(new Song("Macintosh Plus", "Vektroid", "Floral Shoppe", R.raw.macintosh_plus, R.drawable.macintosh_plus));
        Songs.add(new Song("Shooting Stars", "Bag Raiders", "Bag Raiders", R.raw.bag_raiders_shooting_stars, R.drawable.shooting_stars));
        Songs.add(new Song("What Is Love", "Haddaway", "The Album", R.raw.haddaway_what_is_love, R.drawable.haddaway_what_is_love_maxi_cd_cover));

        songAdapter = new SongAdapter(this, Songs);
        songsListView = (ListView) findViewById(R.id.songsListView);
        songsListView.setAdapter(songAdapter);
        songsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent switchIntoSongIntent = new Intent(MainActivity.this, PlayingSong.class);
                Bundle putItemsIntoSongIntentBundle = new Bundle();

                putItemsIntoSongIntentBundle.putString("song", Songs.get(i).getSong());
                putItemsIntoSongIntentBundle.putString("artist", Songs.get(i).getArtist());
                putItemsIntoSongIntentBundle.putString("album", Songs.get(i).getAlbum());
                putItemsIntoSongIntentBundle.putInt("songId", Songs.get(i).getSongId());
                putItemsIntoSongIntentBundle.putInt("image", Songs.get(i).getSongImage());

                switchIntoSongIntent.putExtras(putItemsIntoSongIntentBundle);
                startActivity(switchIntoSongIntent);
            }
        });
    }
}
