
import java.sql.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mypack.TimeClass;


public class MotorbikeActions extends VehicleActions{

    /*private Connection con = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;*/
    private double feePerhour = 4;

    public MotorbikeActions() {
        super();
    }
    
    
    

    @Override
    public double fee() {
        try {
            System.out.println(this.getCheckIntime());
            System.out.println(this.getCheckOutime());
            double fee = new TimeClass().getDiff(this.getCheckOutime(),this.getCheckIntime()) * this.feePerhour + this.feePerhour;
            return fee;
        } catch (ParseException ex) {
            System.out.println("Hata");
            Logger.getLogger(AutomobileActions.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
}
