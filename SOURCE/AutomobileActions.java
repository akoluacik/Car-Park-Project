
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mypack.TimeClass;


public class AutomobileActions extends VehicleActions{
    private double feePerhour = 8;

    public AutomobileActions() {
        super();
    }
    
    /* Calculating fee of each Automobile in the AutoPark.*/
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