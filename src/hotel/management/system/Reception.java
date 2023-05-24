package hotel.management.system;
import javax.swing.*;
import java.sql.*;	
import java.awt.event.*;
import java.awt.*;

public class Reception extends JFrame implements ActionListener{
    
    JButton newCustomer,rooms,customer,checkout,logout;
    
    Reception(){
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10, 120, 200, 30);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.addActionListener(this);
        add(newCustomer);
        
        
        rooms = new JButton("ROOMS");
        rooms.setBounds(10, 190, 200, 30);
        rooms.setForeground(Color.WHITE);
        rooms.setBackground(Color.BLACK);
        rooms.addActionListener(this);
        add(rooms);
        
        
        customer = new JButton("Customer Info");
        customer.setBounds(10, 270, 200, 30);
        customer.setForeground(Color.WHITE);
        customer.setBackground(Color.BLACK);
        customer.addActionListener(this);
        add(customer);
        
        /**/
        checkout = new JButton("Checkout");
        checkout.setBounds(10, 340, 200, 30);
        checkout.setForeground(Color.WHITE);
        checkout.setBackground(Color.BLACK);
        checkout.addActionListener(this);
        add(checkout);
        
       
        logout = new JButton("Logout");
        logout.setBounds(10, 410, 200, 30);
        logout.setForeground(Color.WHITE);
        logout.setBackground(Color.BLACK);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(250,30,500,470);
        add(image);
        
        setBounds(530, 200, 800, 570);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==newCustomer){
            setVisible(false);
            new AddCustomer();
        }else if(ae.getSource()==rooms){
            setVisible(false);
            new Room();
        }else if(ae.getSource()==customer){
            setVisible(false);
            new CustomerInfo();
        }else if(ae.getSource()==checkout){
            setVisible(false);
            new Checkout();
        }else if(ae.getSource()==logout){
            setVisible(false);
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
	new Reception();
    }
    
}
