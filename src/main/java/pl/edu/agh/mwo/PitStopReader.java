package pl.edu.agh.mwo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class PitStopReader {

//    private List<PitStop> pitstops = new ArrayList()<>;


    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            jsonText =  jsonText.substring(1, jsonText.length()-2) ;
//            jsonText = "{" + jsonText.substring(1, jsonText.length()-2) + "}";
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static void main(String[] args) throws IOException, JSONException {
        ObjectMapper mapper = new ObjectMapper();

        // JSON file to Java object
//        PitStop obj = mapper.readValue(new File("pitstop.json"), PitStop.class);

        // JSON URL to Java object
//        Person obj = mapper.readValue(new URL("http://some-domains/api/person.json"), Person.class);


        JSONObject json = readJsonFromUrl("https://api.openf1.org/v1/pit?session_key=9515");
//        try{
////        PitStop obj = mapper.readValue(json, PitStop.class);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println(json.toString());
        System.out.println(json.get("date"));
    }
}
