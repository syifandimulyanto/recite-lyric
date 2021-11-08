package helper;

import entity.Lyric;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LyricHelper {

    /**
     * Function to open file json
     * @param filePath
     * @return JSONArray|null
     */
    public JSONArray getFileJson(String filePath) {
        try {
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(filePath);
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            return (JSONArray) obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Function to mapping json data to entity liryc
     * @param listJson
     * @return ArrayList<Lyric>
     */
    public ArrayList<Lyric> mappingJsonToEntityLyric(JSONArray listJson)
    {
        ArrayList<Lyric> listLyrics = new ArrayList<Lyric>();
        //Iterate over data array
        listJson.forEach( object -> {
            JSONObject lyric = (JSONObject) object;
            String body = (String) lyric.get("body");
            JSONArray subjectJsonArrays = (JSONArray) lyric.get("subject");
            List<String> subjects = new ArrayList<>(subjectJsonArrays);
            listLyrics.add(new Lyric(subjects, body));
        } );

        return listLyrics;
    }

    /**
     * Function to generate 1 number random of ranges
     * @param min
     * @param max
     * @return int
     */
    public int getRandomNumberInRange(int min, int max)
    {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
