package com.hsm.musicalstructurev3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HSM on 25/2/2018.
 */

public class SongAdapter extends ArrayAdapter<Song> {
    Context context;
    ArrayList<Song> songArrayList = new ArrayList<>();

    public SongAdapter(@NonNull Context context, @NonNull ArrayList<Song> objects) {
        super(context, R.layout.activity_song_list_item, objects);
        this.context = context;
        this.songArrayList = objects;
    }

    @Override
    public int getCount() {
        return songArrayList.size();
    }

    @Override
    public Song getItem(int i) {
        return songArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View tempView = view;
        if(tempView == null) {
            tempView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_song_list_item, viewGroup, false);
        }
        ImageView songImage = (ImageView) tempView.findViewById(R.id.songImageViewPattern);
        TextView songTextView = (TextView) tempView.findViewById(R.id.songTextViewPattern);
        TextView artistTextView = (TextView) tempView.findViewById(R.id.artistTextViewPattern);
        TextView albumTextView = (TextView) tempView.findViewById(R.id.albumTextViewPattern);

        Song song = getItem(i);
        songImage.setImageResource(song.getSongImage());
        songTextView.setText(song.getSong());
        artistTextView.setText(song.getArtist());
        albumTextView.setText(song.getAlbum());
        return tempView;
    }
}
