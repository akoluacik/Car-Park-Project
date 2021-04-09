import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.BorderLayout;
import java.util.ArrayList;

public class parkGui extends JFrame{

    public parkGui(ArrayList<JSONObject> jsonList){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,600,500);

        JPanel cont = new JPanel();
        
        cont.setBorder(new EmptyBorder(5,5,5,5));
        cont.setLayout(new BorderLayout(0,0));
        setContentPane(cont);
        
        JTextArea textArea1=new JTextArea(10,10);
        fillText(jsonList, textArea1);
        textArea1.setEditable(false);
    
        cont.add(textArea1,BorderLayout.CENTER);
        JScrollPane sp = new JScrollPane(textArea1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        cont.add(sp);

        setVisible(true);

    }

    private void fillText(ArrayList<JSONObject> jsonList,JTextArea area1){

        for (int i=0;i<jsonList.size();i++){
            area1.append("Park :"+jsonList.get(i).getString("ParkAdi")+"\n");
            area1.append("Adres : "+jsonList.get(i).getString("Adres")+"\n");
            area1.append("Boş Kapasite: "+jsonList.get(i).getInt("BosKapasite")+"");
            area1.append("\n");

            JSONArray tarifeler = jsonList.get(i).getJSONArray("Tarifeler");
          for (int j=0;j<tarifeler.length();j++){
            JSONObject tarife =tarifeler.getJSONObject(j);
            area1.append(tarife.getString("Tarife")+"  >>> "+(int)(tarife.getDouble("Fiyat")/100)+" TL"+"\n");
          }
            area1.append("Güncelleme Tarihi: "+jsonList.get(i).getString("GuncellemeTarihi"));
            area1.append("\n\n\n");
        }


    }


}