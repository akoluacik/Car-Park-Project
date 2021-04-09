import java.util.ArrayList;

import org.json.JSONObject;

public class District extends sampleDistrict {
private int parksNumber;
    private ArrayList<JSONObject> myjson = new ArrayList<JSONObject>();

    public  District(String name) {

        Districts mydistrict = new Districts(name);
        parksNumber=mydistrict.getUniqueDistrict().size();
        for (int i=0;i<parksNumber;i++){
            myjson.add(new JSONObject(mydistrict.getUniqueDistrict().get(i)));
        }

    }

    public String name(int index) {
        
        return myjson.get(index).getString("ParkAdi");
    }

    public int Id(int index) {
        return myjson.get(index).getInt("ParkID");
    }

    public int capacity(int index) {
        return myjson.get(index).getInt("Kapasitesi");
    }

    public int availableCapacity(int index) {
        return myjson.get(index).getInt("BosKapasite");
    }

    public String address(int index) {
        return myjson.get(index).getString("Adres");
    }
    public int length(){
        return parksNumber;
    }

    public ArrayList<JSONObject> getParkObject(){
        return myjson;
    }



}