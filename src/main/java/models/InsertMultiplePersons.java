package models;

import models.InsertSinglePerson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class InsertMultiplePersons {

    JSONArray people = new JSONArray();

    public void setRequestModel() {
        //1. person 1
        JSONObject person1, person2;
        InsertSinglePerson insertSinglePerson1 =new InsertSinglePerson("10011990","F","bonny bennet",
                "123-1234567","200000", "1000");
        insertSinglePerson1.setRequestModel();
        person1 = insertSinglePerson1.getRequestModel();

        InsertSinglePerson insertSinglePerson2 =new InsertSinglePerson("10011990","F","elena gilbert ",
                "123-1234567","200000", "1000");
        insertSinglePerson2.setRequestModel();
        person2 = insertSinglePerson2.getRequestModel();

        //put Json objects to the array
        people.add(person1);
        people.add(person2);

            }
    public JSONArray getRequestModel() {
        return people;
    }








    //    private List<InsertSinglePerson> persons;
//
//    public InsertMultiplePersons(List<InsertSinglePerson> persons) {
//        this.persons = persons;
//    }
//
//    public void setRequestModel() {
//        jsonObject = new JSONObject();
//        JSONArray jsonArray = new JSONArray();
//        for (InsertSinglePerson person : persons) {
//            jsonArray.add(person.getRequestModel());
//        }
//        jsonObject.put("persons", jsonArray);
//    }
//



}

