package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

        

        public HotelManagementSystem() {

                setBounds(0,0,1800,900);
                setLayout(null);

		



                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
                Image i2 = i1.getImage().getScaledInstance(1800,900,Image.SCALE_DEFAULT);
                ImageIcon i3 =  new ImageIcon(i2);
                JLabel image = new JLabel(i3);
                image.setBounds(0,0,1800,900);
                add(image);
                
                JLabel text =new JLabel("HOTEL MANAGEMENT SYSTEM");
                text.setBounds(30,300,1500,100);
                text.setFont(new Font("serif",Font.ITALIC,50));
                text.setForeground(Color.WHITE);
                image.add(text);
                
                JButton next = new JButton("Next");
                next.setBounds(1150,450,150,50);
                next.setBackground(Color.WHITE);
                next.setForeground(Color.BLACK);
                next.addActionListener(this);
                next.setFont(new Font("serif",Font.ITALIC,24));
                image.add(next);
                
                setVisible(true);

                /*while(true){
                        lid.setVisible(false); // lid =  j label
                    try{
                        Thread.sleep(500); //1000 = 1 second
                    }catch(Exception e){} 
                        lid.setVisible(true);
                    try{
                        Thread.sleep(500);
                    }catch(Exception e){}
                }*/
	}

        public void actionPerformed(ActionEvent e){
            
                setVisible(false);
                new Login();

        }

        public static void main(String[] args) {
                 new HotelManagementSystem();
                //window.setVisible(true);			
	}
}