
import java.text.ParseException;
import mypack.TimeClass;


public class Vehicle {
    private String ownerName;
    private String ownerSurname;
    private String vehicleType;
    private String licplate;
    private String checkIntime;
    

    public Vehicle(String ownerName, String ownerSurname, String licplate, String vehicleType, String checkIntime) {
        this.ownerName = ownerName;
        this.ownerSurname = ownerSurname;
        this.vehicleType = vehicleType;
        this.licplate = licplate;
        this.checkIntime = checkIntime;
    }
    
  
    
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public void setOwnerSurname(String ownerSurname) {
        this.ownerSurname = ownerSurname;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    
    public String getLicplate() {
        return licplate;
    }

    public void setLicplate(String licplate) {
        this.licplate = licplate;
    }

    public String getCheckIntime() {
        return checkIntime;
    }

    public void setCheckIntime(String checkIntime) {
        this.checkIntime = checkIntime;
    }
    
}

