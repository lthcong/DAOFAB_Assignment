package com.example.daofab_assignment.file;

import com.example.daofab_assignment.model.Child;
import com.example.daofab_assignment.model.Parent;
import org.json.simple.parser.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONReader {

    public JSONReader() {}

    public List<Parent> readParent() {
        List<Parent> parents = new ArrayList<>();

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("Parent.json"))
        {
            Object obj = jsonParser.parse(reader);

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray parentList = (JSONArray) jsonObject.get("data");
            for (Object o : parentList) {
                Parent parent = new Parent();
                parent.setId(Integer.parseInt(String.valueOf(((JSONObject) o).get("id"))));
                parent.setTotalAmount(Integer.parseInt(String.valueOf(((JSONObject) o).get("totalAmount"))));
                parent.setReceiver(String.valueOf(((JSONObject) o).get("receiver")));
                parent.setSender(String.valueOf(((JSONObject) o).get("sender")));

                parents.add(parent);
            }
        } catch (Exception e) {
            parents = new ArrayList<>();
            e.printStackTrace();
        }

        return parents;
    }

    public List<Child> readChild() {
        List<Child> children = new ArrayList<>();

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("Child.json"))
        {
            Object obj = jsonParser.parse(reader);

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray parentList = (JSONArray) jsonObject.get("data");
            for (Object o : parentList) {
                Child child = new Child();
                child.setId(Integer.parseInt(String.valueOf(((JSONObject) o).get("id"))));
                child.setParentId(Integer.parseInt(String.valueOf(((JSONObject) o).get("parentId"))));
                child.setPaidAmount(Double.parseDouble(String.valueOf(((JSONObject) o).get("paidAmount"))));

                children.add(child);
            }
        } catch (Exception e) {
            children = new ArrayList<>();
            e.printStackTrace();
        }

        return children;
    }
}
