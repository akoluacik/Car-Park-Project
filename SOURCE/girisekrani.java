
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class girisekrani extends JFrame{
	

	public static void main(String arrgs[]) {
		Color ourblue = new Color(70,130,180);
		Color ourpink = new Color(224,17,95);
		Color ourgreen = new Color(0,168,107);
		Color ourorange = new Color(255,165,0);
		Color ourpurple = new Color(128,0,191);
		
		
	JFrame mainwindow = new JFrame();
	mainwindow.setTitle("Otopark");
	mainwindow.setLayout(null);
	mainwindow.setSize(400, 380);
	mainwindow.setLocation(500, 200);
	mainwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	

	//Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\hakan\\eclipse-workspace\\guitry\\image\\parklogo.png");    
	Image icon = Toolkit.getDefaultToolkit().getImage("parklogo.png");    

	mainwindow.setIconImage(icon);    

	mainwindow.setLayout(null);
   // mainwindow.setContentPane(new JLabel(new ImageIcon("C:\\\\Users\\\\hakan\\\\eclipse-workspace\\\\guitry\\\\image\\\\background3.jpg")));
	mainwindow.setContentPane(new JLabel(new ImageIcon("background3.jpg")));
	  
	
	JButton butonx = new JButton();
	butonx.setText("Find Your Car Park");
	butonx.setLocation(30, 220);
	butonx.setSize(170, 70);
	butonx.setBackground(ourpurple);
	butonx.setForeground(Color.yellow);
	butonx.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
		mainwindow.setVisible(false);
		guic mygui= new guic();
		
		}

	});
	mainwindow.add(butonx);
	
	
	JButton butony = new JButton();
	butony.setText("Car Park Automation");
	butony.setLocation(200, 220);
	butony.setSize(170, 70);
	butony.setBackground(ourpurple);
	butony.setForeground(Color.yellow);
        butony.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
		mainwindow.setVisible(false);
		DBScreen dbScreen = new DBScreen();
                dbScreen.setVisible(true);
		
		}

	});
	mainwindow.add(butony);
	
	JButton butoni = new JButton();
	butoni.setText("Uygulama 1");
	butoni.setLocation(60, 220);
	butoni.setSize(100, 70);
	butoni.setBackground(ourpurple);
	butoni.setForeground(Color.yellow);
	mainwindow.add(butoni);
	butoni.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e)
	    {   JOptionPane jop1 = new JOptionPane();
	    
	    jop1.showMessageDialog(jop1, "Bu uyguluma....");
	    }
	});
	
//	ImageIcon iconbi = new ImageIcon("C:\\Users\\hakan\\eclipse-workspace\\guitry\\image\\soru i�areti.png"); 
	ImageIcon iconbi = new ImageIcon("soru işareti.png"); 

	JButton butoninf = new JButton(iconbi);
	
	butoninf.setLocation(93, 177);
	butoninf.setSize(37, 37);
	butoninf.setBackground(ourpurple);
	
	mainwindow.add(butoninf);
	butoninf.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e)
	    {   JOptionPane jop1 = new JOptionPane();
	    
	    jop1.showMessageDialog(jop1, "You can find your car park which is nearby in your District!");
	    }
            
	});
	
	
	
	
	JButton butonii = new JButton(iconbi);
	
	butonii.setLocation(265, 177);
	butonii.setSize(37, 37);
	butonii.setBackground(ourpurple);

	mainwindow.add(butonii);
	butonii.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e)
	    {   JOptionPane jop1 = new JOptionPane();
	    
	    jop1.showMessageDialog(jop1, "This app could helps to you understand the process in your Car Park!");
	    }
	});
	
	
	
//ImageIcon iconw = new ImageIcon("C:\\Users\\hakan\\eclipse-workspace\\guitry\\image\\welcome.jpg"); 
	

ImageIcon iconw = new ImageIcon("welcome.jpg"); 
		
JButton butonw = new JButton(iconw);
	
	butonw.setLocation(108, 85);
	butonw.setSize(175, 78);
	butonw.setBackground(ourpurple);
	mainwindow.add(butonw);
	
	
		mainwindow.setVisible(true);
}
}