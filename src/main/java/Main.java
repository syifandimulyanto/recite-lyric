import entity.Lyric;
import helper.LyricHelper;
import helper.LyricTestHelper;
import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final String lyricJsonFilePath = "src/main/java/lyrics.json";

    public static void main(String[] args)
    {
        System.out.println("Menu Option (please select menu option)");
        System.out.println("1. Phase 1 Generate Sentence");
        System.out.println("2. Phase 2 Randomize Sentence");
        System.out.println("3. Phase 3 Get Subject");
        System.out.println("4. Phase 4 Get Subject with Randomize");

        Scanner sc= new Scanner(System.in);
        System.out.println("Please select menu =");
        int menu = sc.nextInt();
        System.out.println("Input recite =");
        int recite = sc.nextInt();

        LyricHelper lyricHelper = new LyricHelper();
        try {
            JSONArray lyrics = lyricHelper.getFileJson(lyricJsonFilePath);
            ArrayList<Lyric> listLyrics = lyricHelper.mappingJsonToEntityLyric(lyrics);
            LyricTestHelper lyricTestHelper = new LyricTestHelper(listLyrics);

            switch (menu) {
                case 1:
                    System.out.println(lyricTestHelper.phaseOne(recite, 0));
                    break;
                case 2:
                    System.out.println(lyricTestHelper.phaseTwo(recite));
                    break;
                case 3:
                    System.out.println(lyricTestHelper.phaseThree(recite));
                    break;
                case 4:
                    System.out.println(lyricTestHelper.phaseFour(recite));
                    break;
                default:
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
