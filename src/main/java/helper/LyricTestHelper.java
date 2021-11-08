package helper;

import entity.Lyric;
import service.LyricService;
import service.LyricServiceImplementation;
import java.util.ArrayList;

public class LyricTestHelper {
    private static final String prefix = "This is";
    private final ArrayList<Lyric> listLyrics;

    private LyricHelper lyricHelper = new LyricHelper();
    private LyricService lyricService = new LyricServiceImplementation();

    public LyricTestHelper(ArrayList<Lyric> listLyrics) {
        this.listLyrics = listLyrics;
    }

    /**
     * Function will return output of sentence
     * ex:
     * recite 1 = This is the house that Jack built
     * recite 2 = This is the malt that lay in the house that Jack built
     * @param input
     * @param endInput
     * @return string
     */
    public String phaseOne(int input, int endInput)
    {
        int total = lyricService.total(listLyrics);
        if (input > total || input <= 0) {
            return null;
        }
        input = input - 1;

        int inputProcess = total - input;
        int endProcess = total - endInput;
        String output = "";
        for (int i = inputProcess; i <= endProcess; i++) {
            Lyric lyric = lyricService.getByIndex(listLyrics, i-1);
            output += " " + lyric.getBody();
        }
        return prefix + output;
    }

    /**
     * Function will return output of sentence but randomize
     * but the sentence also use normal recite
     * @param input
     * @return string
     */
    public String phaseTwo(int input)
    {
        int random = lyricHelper.getRandomNumberInRange(2, 12);

        if (input == 1) {
            return lyricService.getByIndex(listLyrics, random).getBody();
        }

        boolean execute = true;
        String output = "";
        while (execute) {
            if (random < input) {
                random = lyricHelper.getRandomNumberInRange(2, 12);
                execute = true;
            } else {
                output = this.phaseOne(random, random - input);
                execute = false;
            }
        }

        return output;
    }

    /**
     * Function will return only subject of the sentence
     * @param input
     * @return string
     */
    public String phaseThree(int input)
    {
        int total = lyricService.total(listLyrics);
        if (input > total || input <= 0) {
            return null;
        }
        input = input - 1;

        int inputProcess = total - input;
        int endProcess = total - 0;
        String output = "";
        for (int i = inputProcess; i <= endProcess; i++) {
            String endPrefix = (endProcess != i) ? "," : "";
            Lyric lyric = lyricService.getByIndex(listLyrics, i-1);
            output += " " + String.join(",", lyric.getSubject()) + endPrefix;
        }
        return prefix + output;
    }

    /**
     * Function will return only subject of the sentence
     * but the subject is random
     * @param input
     * @return string
     */
    public String phaseFour(int input)
    {
        String output = "";
        for (int i = 1; i <= input; i++) {
            int random = lyricHelper.getRandomNumberInRange(1, 12);
            Lyric lyric = lyricService.getByIndex(listLyrics, random-1);
            String endPrefix = (input != i) ? "," : "";
            output += " " + String.join(",", lyric.getSubject()) + endPrefix;
        }
        return output;
    }
}
