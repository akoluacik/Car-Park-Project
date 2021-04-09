
package mypack;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class TimeClass {

    
    public String getTime(){
       LocalDateTime datetime = LocalDateTime.now();
       DateTimeFormatter frmt = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
       
       String formatDate = datetime.format(frmt);
       return formatDate;
    }
    public long getDiff(String time1, String time2) throws ParseException{
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        Date date1 = format.parse(time1);
        Date date2 = format.parse(time2);
        long difference = date1.getTime() - date2.getTime();
        difference = difference / (60 * 60 * 1000) % 24;
        return difference;
        
    }
    
}