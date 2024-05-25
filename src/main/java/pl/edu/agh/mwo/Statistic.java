package pl.edu.agh.mwo;

import java.util.ArrayList;
import java.util.List;

public class Statistic {
    private List<PitStop> pitstops = new ArrayList<>();

    public Statistic(List<PitStop> pitstops) {
        this.pitstops = pitstops;
    }

    public PitStop getMinPitDuration(){
        PitStop min = new PitStop();
        for(PitStop pitStop : pitstops){
            if(min == null) min = pitStop;
            if(pitStop.getSpit_duration() < min.getSpit_duration()){
                min = pitStop;
            }
         }
        return min;
    }

    public int getBestDurationFromDriverNumber(int driver){
        int duration=0;
        int min=0;
//        for(PitStop pitStop : pitstops){
//            if(pitStop.getSdriver_number() == driver){
////                 if(< min.getSpit_duration()){
////
////                }
//            }
//        }
        return min;
    }


}
