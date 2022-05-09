import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class LeitorURL {


    public static void main(String[] args) {

        HttpURLConnection con = null;

        JsonToObj j1 = new JsonToObj();

        ObjectMapper mapper = new ObjectMapper();

        Scanner sc = new Scanner(System.in);

        System.out.println("Write a Json link: ");
        j1.setUrl_api((sc.next()));

        try {
            URL url = new URL(j1.getUrl_api());
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();

            switch (con.getResponseCode()) {
                case 200:
                    System.out.println("JSON recebido!");
                    String json = getJson(url);

                    JsonParser parser = new JsonParser();
                    JsonObject obj = (JsonObject) parser.parse(json);

                    System.out.println(obj);

                    System.out.println("");
                    System.out.println("_____________________________________________________");
                    System.out.println("");

                    HashMap result =
                            new ObjectMapper().readValue(json, HashMap.class);
                    System.out.println(result.toString());

                    break;
                case 500:
                    System.out.println("Status 500");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null)
                con.disconnect();
        }
    }

    public static String getJson(URL url) {
        if (url == null)
            throw new RuntimeException("URL is null");

        String html = null;
        StringBuilder sB = new StringBuilder();
        try (BufferedReader bR = new BufferedReader(new InputStreamReader(url.openStream()))) {
            while ((html = bR.readLine()) != null)
                sB.append(html);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sB.toString();
    }
}