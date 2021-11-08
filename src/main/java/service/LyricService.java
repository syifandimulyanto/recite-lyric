package service;

import entity.Lyric;

import java.util.ArrayList;

public interface LyricService {

    /**
     * Function count total of ArrayList
     * @param lyrics
     * @return int
     */
    public int total(ArrayList<Lyric> lyrics);

    /**
     * Function get entity Lyric by Index
     * @param ArrayList<Lyric>
     * @param index
     * @return Lyric|null
     */
    public Lyric getByIndex(ArrayList<Lyric> lyrics, int index);
}
