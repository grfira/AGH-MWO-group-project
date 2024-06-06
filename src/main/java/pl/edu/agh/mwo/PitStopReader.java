package pl.edu.agh.mwo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class PitStopReader {

    private List<PitStop> pitstops = new ArrayList<>();

    public List<PitStop> getPitstops() {
        return pitstops;
    }

    public void setPitstops(List<PitStop> pitstops) {
        this.pitstops = pitstops;
    }

    public static JSONArray readJsonFromFile(String file)throws IOException, ParseException{
        JSONParser parser = new JSONParser();

        JSONArray data = (JSONArray) parser.parse(new FileReader(file));

        return data;
    }

//    private static String readAll(Reader rd) throws IOException {
//        StringBuilder sb = new StringBuilder();
//        int cp;
//        while ((cp = rd.read()) != -1) {
//            sb.append((char) cp);
//        }
//        return sb.toString();
//    }

    public static JSONArray readJsonFromUrl(String url) throws IOException, ParseException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
//            String jsonText = readAll(rd);
//            jsonText =  jsonText.substring(1, jsonText.length()-2) ;
////            jsonText = "{" + jsonText.substring(1, jsonText.length()-2) + "}";
//            JSONObject json = new JSONObject(jsonText);
            JSONParser parser = new JSONParser();
            JSONArray data = (JSONArray) parser.parse(new BufferedReader(rd));

          //  JSONObject obj = (JSONObject) data.get(5);
            return data;
        } finally {
            is.close();
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        //ObjectMapper mapper = new ObjectMapper();

        // JSON file to Java object
//        PitStop obj = mapper.readValue(new File("pitstop.json"), PitStop.class);

        // JSON URL to Java object
//        Person obj = mapper.readValue(new URL("http://some-domains/api/person.json"), Person.class);

        JSONArray jsonArrayFromFile = PitStopReader.readJsonFromFile("pitstops-data.json");
        JSONObject jsonObjectFromFile = (JSONObject) jsonArrayFromFile.get(5);
        System.out.println(jsonObjectFromFile.get("driver_number"));


        JSONArray jsonArrayFromWebsite = PitStopReader.readJsonFromUrl("https://api.openf1.org/v1/pit?session_key=9515");
        JSONObject jsonObjectFromWebsite = (JSONObject) jsonArrayFromWebsite.get(5);
//        try{
////        PitStop obj = mapper.readValue(json, PitStop.class);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println(jsonObjectFromWebsite.toString());
        System.out.println(jsonObjectFromWebsite.get("date"));
    }
}
