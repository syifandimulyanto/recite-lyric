package service;

import entity.Lyric;

import java.util.ArrayList;

public class LyricServiceImplementation implements LyricService{

    @Override
    public int total(ArrayList<Lyric> lyrics) {
        return lyrics.size();
    }

    @Override
    public Lyric getByIndex(ArrayList<Lyric> lyrics, int index) {
        if (index >= this.total(lyrics)) {
            return null;
        }
        return lyrics.get(index);
    }
}
