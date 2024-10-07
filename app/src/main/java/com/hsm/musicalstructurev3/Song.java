package com.hsm.musicalstructurev3;

/**
 * Created by HSM on 16/2/2018.
 */

public class Song {

    private String song;
    private String artist;
    private String album;
    private int songId;
    private int songImage;

    public Song(String song, String artist, String album, int songId, int songImage) {
        this.song = song;
        this.artist = artist;
        this.album = album;
        this.songId = songId;
        this.songImage = songImage;
    }


    public int getSongImage() {
        return songImage;
    }

    public int getSongId() {
        return songId;
    }

    public String getSong() {

        return song;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }
}
