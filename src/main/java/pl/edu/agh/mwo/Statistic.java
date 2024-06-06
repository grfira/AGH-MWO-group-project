package pl.edu.agh.mwo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Statistic {
    private List<PitStop> pitstops = new ArrayList<>();


    public Statistic(){}

    public Statistic(List<PitStop> pitstops) {
        this.pitstops = pitstops;
    }

    public PitStop getMinPitDuration(){
        PitStop min = new PitStop();
        for(PitStop pitStop : pitstops){
            if(min.getSpit_duration() == 0) min = pitStop;
            if(pitStop.getSpit_duration() < min.getSpit_duration()){
                min = pitStop;
            }
         }
        return min;
    }

    public PitStop getMinPitDurationFromDriverNumber(int driver){
        PitStop min = new PitStop();
        for(PitStop pitStop : pitstops){
            if(pitStop.getSdriver_number() == driver) {
                if (min.getSpit_duration() == 0) min = pitStop;
                if (pitStop.getSpit_duration() < min.getSpit_duration()) {
                    min = pitStop;
                }
            }
        }
        return min;
    }


}
