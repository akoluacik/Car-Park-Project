
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Scrollbar;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class guic extends JFrame {
	
	public guic(){
		Color ourblue = new Color(70,130,180);
		Color ourpink = new Color(224,17,95);
		Color ourgreen = new Color(0,168,107);
		Color ourorange = new Color(255,165,0);
		
		JFrame window = new JFrame();
		window.setTitle("Otopark");
		window.setLayout(null);
		window.setSize(400, 380);
		window.setLocation(500, 200);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	//	Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\hakan\\eclipse-workspace\\guitry\\image\\parklogo.png");    
		Image icon = Toolkit.getDefaultToolkit().getImage("parklogo.png");    

		window.setIconImage(icon);    
		
		window.getContentPane().setBackground(ourblue);
		
		
		JTextField bosluk = new JTextField();
		
		bosluk.setLocation(223, 160);
		bosluk.setSize(120, 25);
		bosluk.setBackground(Color.DARK_GRAY);
		bosluk.setForeground(Color.white);
		window.add(bosluk);
		
       JTextField bosluk2 = new JTextField();
		
		bosluk2.setLocation(03, 160);
		bosluk2.setText("Lütfen Büyük Harflerle Bir ilçe Giriniz :");
		bosluk2.setSize(220, 25);
		bosluk2.setBackground(ourblue);
		bosluk2.setForeground(ourorange);
		window.add(bosluk2);
	
		JPanel dugme = new JPanel();
		dugme.setLayout(null);
		dugme.setLocation(10, 10);
		dugme.setSize(350, 275);
		dugme.setBackground(ourblue);
		window.add(dugme);
	
		
		
		
		
		JButton buton1 = new JButton();
		buton1.setText("OK");
		buton1.setLocation(103, 190);
		buton1.setSize(90, 20);
		buton1.setBackground(ourgreen);
		buton1.setForeground(Color.black);
		dugme.add(buton1);
		buton1.addActionListener(new ActionListener() {
			
		  public void actionPerformed(ActionEvent e) {
			//window.setVisible(false);
			District ilce = new District(bosluk.getText());
			parkGui agui = new parkGui(ilce.getParkObject());
		  }
			  
	    });
		
		
		
		
	
		
		JButton buton2 = new JButton();
		buton2.setText("Cancel");
		buton2.setLocation(203, 190);
		buton2.setSize(90, 20);
		buton2.setBackground(ourpink);
		buton2.setForeground(Color.black);
		dugme.add(buton2);
		buton2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		        System.exit(0);
		    }
		});
		
		
		ImageIcon icon2 = new ImageIcon("carparklogo.jpeg"); 
		JButton buton3 = new JButton(icon2);
		buton3.setLocation(123, 25);
		buton3.setSize(120, 120);
		buton3.setBackground(ourgreen);
		buton3.setForeground(Color.black);
		dugme.add(buton3);
		buton3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {   JOptionPane jop1 = new JOptionPane();
		    
		    jop1.showMessageDialog(jop1, "Bu uyguluma istanbuladaki isparklar hakkında bilgi vermek adına birkac öğrenci tarafından özenle tasarlanmıştır.");
		    }
		});
		
		
		
		window.setVisible(true);
		
		
	}

}
