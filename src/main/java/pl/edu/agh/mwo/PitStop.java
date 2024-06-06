package pl.edu.agh.mwo;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.time.LocalDateTime;

public class PitStop {
    private int session_key;
    private int smeeting_key;
    private LocalDateTime sdate;
    private int sdriver_number;
    private double spit_duration;
    private int slap_number;

    public PitStop() {

    }

    public int getSession_key() {
        return session_key;
    }

    public PitStop(int session_key, int smeeting_key, LocalDateTime  sdate, int sdriver_number, double spit_duration, int slap_number) {
        this.session_key = session_key;
        this.smeeting_key = smeeting_key;
        this.sdate = sdate;
        this.sdriver_number = sdriver_number;
        this.spit_duration = spit_duration;
        this.slap_number = slap_number;
    }

    public PitStop(JSONObject jsonObject) throws IOException, ParseException {


        this.session_key = (int) jsonObject.get("session_key");
        this.smeeting_key = (int) jsonObject.get("meeting_key");
        this.sdate = (LocalDateTime) jsonObject.get("date");
        this.sdriver_number = (int) jsonObject.get("driver_number");
        this.spit_duration = (double) jsonObject.get("pit_duration");
        this.slap_number = (int) jsonObject.get("lap_number");

    }

    public void setSession_key(int session_key) {
        this.session_key = session_key;
    }

    public int getSmeeting_key() {
        return smeeting_key;
    }

    public void setSmeeting_key(int smeeting_key) {
        this.smeeting_key = smeeting_key;
    }

    public LocalDateTime  getSdate() {
        return sdate;
    }

    public void setSdate(LocalDateTime sdate) {
        this.sdate = sdate;
    }

    public int getSdriver_number() {
        return sdriver_number;
    }

    public void setSdriver_number(int sdriver_number) {
        this.sdriver_number = sdriver_number;
    }

    public double getSpit_duration() {
        return spit_duration;
    }

    public void setSpit_duration(int spit_duration) {
        this.spit_duration = spit_duration;
    }

    public int getSlap_number() {
        return slap_number;
    }

    public void setSlap_number(int slap_number) {
        this.slap_number = slap_number;
    }
}
