
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mypack.TimeClass;


public abstract class VehicleActions {
    private Connection con = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    private String licplate;
    private String checkIntime,checkOutime;
    
    
    /* Getter - Setter Start */
    
    public String getCheckIntime() {
        return checkIntime;
    }
    
    public void setCheckIntime(String checkIntime) {
        this.checkIntime = checkIntime;
    }

    public String getCheckOutime() {
        return checkOutime;
    }

    public void setCheckOutime(String checkOutime) {
        this.checkOutime = checkOutime;
    }
    
   
    
    public String getLicplate() {
        return licplate;
    }

    public void setLicplate(String licplate) {
        this.licplate = licplate;
    }
    
    
    /* Getter Setter End*/
    
    /*Constructor. When an object is derived from VehicleActions, we connect to our db.*/
    public VehicleActions(){
        String url = "jdbc:sqlite:" + Database.filePath;
        try{
            Class.forName(Database.className);
        }catch(ClassNotFoundException ex){
            System.out.println("Driver cannot be found. Please be sure that Database.filepath variable is equal to your test.db directory. ");
        }
        try {
            con = DriverManager.getConnection(url);
            //System.out.println("Bağlantı Başarılı");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    
    
    /* Return each vehicle in database. */
    public ArrayList<Vehicle> getVehicles() {
        ArrayList<Vehicle> output = new ArrayList<Vehicle>();
        try {
            String query = "SELECT * from carpark";
            pstmt = con.prepareStatement(query);
            //pstmt.setString(1, "automobile");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String vehicleType = rs.getString("type");
                String licplate = rs.getString("licplate");
                String enteringtime = rs.getString("enteringtime");
                output.add(new Vehicle(name, surname, licplate, vehicleType,enteringtime));
            }
            return output;
        } catch (SQLException ex) {
            Logger.getLogger(VehicleActions.class.getName()).log(Level.SEVERE, null, ex);
            return null;
    }
     }
    
    /* To calculate price of each vehicle, we should set checkOut time. In database, we name it exitingtime. */
    /* We did not add check-out time to GUI. We just use it to calculate difference between check-out time and check-in time.*/
    public void update (){
        try {
            String query = "UPDATE carpark set exitingtime = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, new TimeClass().getTime());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VehicleActions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /* set check-in and check-out times to vehicle. */
    public void getTimes(){
       
       String query = "SELECT exitingtime,enteringtime from carpark where licplate=?";
       try{
            con = DriverManager.getConnection("jdbc:sqlite:" + Database.filePath);
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, this.licplate);
            ResultSet rs = pstmt.executeQuery();
            this.setCheckIntime(rs.getString("enteringtime"));
            this.setCheckOutime(rs.getString("exitingtime"));
            pstmt.close();
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
       
    }
    
    
    
    public void checkInpark(String name, String surname, String licplate, String type) {
        
        try {
            String query = "INSERT INTO carpark(name, surname, licplate, type, enteringtime) VALUES(?,?,?,?,?)";
            con = DriverManager.getConnection("jdbc:sqlite:" + Database.filePath);
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, surname);
            pstmt.setString(3, licplate);
            pstmt.setString(4, type);
            pstmt.setString(5, new TimeClass().getTime());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VehicleActions.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    public void checkOutpark() {
        
        try {
            String query = "DELETE from carpark where licplate = ?";
            update();
            getTimes();
            con = DriverManager.getConnection("jdbc:sqlite:" + Database.filePath);
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, getLicplate());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VehicleActions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public abstract double fee();
    
    
}
