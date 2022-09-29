package com.example.audio_player;

public class Music {

    private String isop;
    private String name;
    private int albom;
    private int music;

    public Music(String isop, String name, int albom, int music){

        this.isop=isop;
        this.name=name;
        this.albom=albom;
        this.music=music;
    }

    public String getIsop() {
        return this.isop;
    }

    public void setIsop(String isop) {
        this.isop = isop;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlbom() {
        return this.albom;
    }

    public void setAlbom(int albom) {
        this.albom = albom;
    }

    public int getMusic() {
        return this.music;
    }

    public void setMusic(int music) {
        this.music = music;
    }
}
