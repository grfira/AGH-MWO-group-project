package pl.edu.agh.mwo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, ParseException {
        System.out.println( "Hello World!" );

        List<PitStop> pitStopList = new ArrayList<>();

        JSONArray jsonArray = PitStopReader.readJsonFromFile("pitstops-data.json");
        Iterator<JSONObject> iterator = jsonArray.iterator();

        while (iterator.hasNext()) {
            pitStopList.add(new PitStop(iterator.next()));
        }

        Statistic statistic = new Statistic(pitStopList);

        System.out.println("Najnizszy pit duration miał kierowca o numerze: " + statistic.getMinPitDuration().getSdriver_number());

       // System.out.println(pitStopList.get(5).getSession_key());


    }
}
