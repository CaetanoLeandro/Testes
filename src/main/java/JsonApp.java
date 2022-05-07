import com.google.gson.Gson;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JsonApp {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Person p1 = new Person();

        JSONObject jsonObject = new JSONObject();
        FileWriter writeFile;

        System.out.println("Write your name: ");
        p1.setName((sc.next()));

        System.out.println("Write your age: ");
        p1.setAge((sc.next()));

        jsonObject.put("name", p1.getName());
        jsonObject.put("Age", p1.getAge());

        try {
            writeFile = new FileWriter("json-file");
            writeFile.write(jsonObject.toJSONString());
            writeFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("################# JSON #####################");
        System.out.println(jsonObject);
        p1.setJson(jsonObject.toJSONString());
        System.out.println("############################################");
        System.out.println("");

        Person person = new Gson().fromJson(p1.getJson(), Person.class);
        System.out.println("");
        System.out.println("################# OBJ #####################");
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("############################################");
    }
}