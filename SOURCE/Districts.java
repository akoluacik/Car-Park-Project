
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Districts {

    private ArrayList<Integer> ids = new ArrayList<Integer>();
    private ArrayList<String> Parks = new ArrayList<String>();

    private String choosenDistrict;

    public Districts(String name) {
        isparkCurData allData = new isparkCurData();

        choosenDistrict = name;
        getAllParkId(allData.getAllParks());
        System.out.println("First task is completed");

        storeAllUniqueParks();
    }

    public ArrayList<String> getUniqueDistrict() {
        return Parks;
    }

    private void storeAllUniqueParks(){
        isparkCurData uniquePark = new isparkCurData();

        for (int i = 0; i < ids.size(); i++) {

            Parks.add(uniquePark.getById(ids.get(i)));
            System.out.println(i+" of "+ids.size()+" completed in second task");
        }
    }

    private void getAllParkId(String allData) {

        JSONArray parkArr = new JSONArray(allData);

        for (int i = 0; i < parkArr.length(); i++) {

            JSONObject parkjson = parkArr.getJSONObject(i);

            if (parkjson.getString("Ilce").equals(choosenDistrict)) {
                ids.add(parkjson.getInt("ParkID"));
            }

        }

    }

}