
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mypack.TimeClass;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anilk
 */
public class MinibusActions extends VehicleActions{
    private double feePerhour = 12;

    public MinibusActions() {
        super();
    }
    
    
    
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
