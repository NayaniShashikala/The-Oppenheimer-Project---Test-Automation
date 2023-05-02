package models;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class InsertSinglePerson {

    private JSONObject jsonObject;

    String birthday, gender, name, natid, salary, tax;

    public InsertSinglePerson(String birthday, String gender, String name, String natid, String salary, String tax) {
        this.birthday = birthday;
        this.gender = gender;
        this.name = name;
        this.natid = natid;
        this.salary = salary;
        this.tax = tax;
    }

    public void setRequestModel() {
        jsonObject = new JSONObject();
        jsonObject.put("birthday", birthday);
        jsonObject.put("gender", gender);
        jsonObject.put("name", name);
        jsonObject.put("natid", natid);
        jsonObject.put("salary", salary);
        jsonObject.put("tax", tax);

    }

    public JSONObject getRequestModel() {
        return jsonObject;
    }
}
