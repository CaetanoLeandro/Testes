import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class JsonApp {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        Person p1 = new Person();

        JSONObject jsonObject = new JSONObject();
        FileWriter writeFile = null;

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);


        System.out.println("Write your name");
        p1.name = (sc.next());

        System.out.println("Write your age");
        p1.age = (sc.next());

        jsonObject.put("name", p1.name);
        jsonObject.put("Age", p1.age);

        try {
            writeFile = new FileWriter("out.json");
            writeFile.write(jsonObject.toJSONString());
            writeFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(jsonObject);

        try {
            Person person = mapper.readValue(new File"{name :}", Person.class);
            System.out.println("Name: " + person.name);
            System.out.println("Age: " + person.age);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}