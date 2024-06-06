package pl.edu.agh.mwo;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.time.LocalDateTime;

public class PitStop {
    private long session_key;
    private long smeeting_key;
    private String  sdate;
    private long sdriver_number;
    private double spit_duration;
    private long slap_number;

    public PitStop() {

    }

    public long getSession_key() {
        return session_key;
    }

    public PitStop(long session_key, long smeeting_key, String   sdate, long sdriver_number, double spit_duration, long slap_number) {
        this.session_key = session_key;
        this.smeeting_key = smeeting_key;
        this.sdate = sdate;
        this.sdriver_number = sdriver_number;
        this.spit_duration = spit_duration;
        this.slap_number = slap_number;
    }

    public PitStop(JSONObject jsonObject) throws IOException, ParseException {


        this.session_key = (long) jsonObject.get("session_key");
        this.smeeting_key = (long) jsonObject.get("meeting_key");
        this.sdate = (String ) jsonObject.get("date");
        this.sdriver_number = (long) jsonObject.get("driver_number");
        this.spit_duration = (double) jsonObject.get("pit_duration");
        this.slap_number = (long) jsonObject.get("lap_number");

    }

    public void setSession_key(long session_key) {
        this.session_key = session_key;
    }

    public long getSmeeting_key() {
        return smeeting_key;
    }

    public void setSmeeting_key(long smeeting_key) {
        this.smeeting_key = smeeting_key;
    }

    public String   getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public long getSdriver_number() {
        return sdriver_number;
    }

    public void setSdriver_number(long sdriver_number) {
        this.sdriver_number = sdriver_number;
    }

    public double getSpit_duration() {
        return spit_duration;
    }

    public void setSpit_duration(double spit_duration) {
        this.spit_duration = spit_duration;
    }

    public long getSlap_number() {
        return slap_number;
    }

    public void setSlap_number(long slap_number) {
        this.slap_number = slap_number;
    }
}
