import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
;

public class isparkCurData implements basicFunct{
   private String urlForId = "https://api.ibb.gov.tr/ispark/ParkDetay?id=";
   private String allParks = "https://api.ibb.gov.tr/ispark/Park";


public String getById (int id){
    String url = urlForId+id;
   // System.out.println(url);
    StringBuffer content = new StringBuffer();
try {

    URL urlWithId = new URL(url);

    HttpURLConnection con = (HttpURLConnection) urlWithId.openConnection();
    con.setRequestMethod("GET");
  
    BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
          content.append(inputLine);
      }
      in.close();

      con.disconnect();
    

    
} catch (Exception e) {
return "An error occured";
}
    
    return content.toString();
}




public String getAllParks()  {
    StringBuffer content = new StringBuffer();

try{

    URL urlforAll = new URL(allParks);

    HttpURLConnection con = (HttpURLConnection) urlforAll.openConnection();
    con.setRequestMethod("GET");
  
    BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
          content.append(inputLine);
      }
      in.close();
      con.disconnect();

}catch (Exception exception){

return "An error occured";
}

    
    
    return content.toString();
}

public String jsonprocess(String jsonString){

    JSONArray myAr=new JSONArray(jsonString);

//    JSONObject json = new JSONObject(jsonString);
 //   String park = json.getString("ParkAdi");
JSONObject myobj= myAr.getJSONObject(0);

return myobj.getString("ParkAdi");
}


}