package hotel.management.system;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddRooms extends JFrame implements ActionListener{
   
    JButton add,cancel;
    JTextField tfroom,tfprice;
    JComboBox typecombo,availablecombo,cleancombo;
    
    AddRooms(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
	heading.setBounds(194, 10, 120, 22);
	add(heading);
        
        
        JLabel lblroomno = new JLabel("Room Number");
	lblroomno.setForeground(new Color(25, 25, 112));
	lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblroomno.setBounds(60, 80, 120, 30);
	add(lblroomno);
        
        tfroom = new JTextField();
	tfroom.setBounds(200, 80, 150, 30);
	add(tfroom);
        
        JLabel lblavailable = new JLabel("Availabe");
	lblavailable.setForeground(new Color(25, 25, 112));
	lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblavailable.setBounds(60, 130, 120, 30);
	add(lblavailable);
        
        String availableOptions[]= { "Available", "Occupied" };
        availablecombo = new JComboBox(availableOptions);
	availablecombo.setBackground(Color.WHITE);
        availablecombo.setBounds(200, 130, 150, 30);
	add(availablecombo);
        
        JLabel lblclean = new JLabel("Cleaning Status");
	lblclean.setForeground(new Color(25, 25, 112));
	lblclean.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblclean.setBounds(60, 180, 120, 30);
	add(lblclean);
        
        String cleanOptions[]= { "Cleaned", "Uncleaned" };
        cleancombo = new JComboBox(cleanOptions);
	cleancombo.setBackground(Color.WHITE);
        cleancombo.setBounds(200, 180, 150, 30);
	add(cleancombo);
        
        
        JLabel lblprice = new JLabel("Price");
	lblprice.setForeground(new Color(25, 25, 112));
	lblprice.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblprice.setBounds(60, 230, 120, 30);
	add(lblprice);
        
        tfprice = new JTextField();
	tfprice.setBounds(200, 230, 150, 30);
	add(tfprice);
        
        
        JLabel lbltype = new JLabel("BED Type");
	lbltype.setForeground(new Color(25, 25, 112));
	lbltype.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lbltype.setBounds(60, 280, 120, 30);
	add(lbltype);
        
        String typeOptions[]= { "Single Bed", "Double Bed" };
        typecombo = new JComboBox(typeOptions);
	typecombo.setBackground(Color.WHITE);
        typecombo.setBounds(200, 280, 150, 30);
	add(typecombo);
        
        
        add = new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        add.setBounds(60,350,130,30);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550,450,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);
        
        
        
        setBounds(330, 200, 1000, 450);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{

            if(ae.getSource() == add){
                try{
                Conn c = new Conn();
                String roomnumber = tfroom.getText();
                String availablity = (String)availablecombo.getSelectedItem();
                String status = (String)cleancombo.getSelectedItem();
                String price  = tfprice.getText();
                String type = (String)typecombo.getSelectedItem();
                String str = "insert into room values( '"+roomnumber+"', '"+availablity+"', '"+status+"','"+price+"', '"+type+"')";


		c.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null, "Room Successfully Added");
                setVisible(false);

                }catch(Exception ee){
                    System.out.println(ee);
                }
            }
            else if(ae.getSource() == cancel){
                setVisible(false);
            }
        }catch(Exception eee){

        }
    }
    
    
    public static void main(String[] args) {
        new AddRooms();
    }
       
}

