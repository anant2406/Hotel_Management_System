package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    /*JLabel l1,l2;*/
    JTextField username;
    JPasswordField password;
    JButton login,cancel;

    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        JLabel user = new JLabel("Username");
        user.setBounds(40,20,100,30);
        add(user);
        
        username=new JTextField();
        username.setBounds(150,20,150,30);
        add(username);
        
        JLabel pass = new JLabel("Password");
        pass.setBounds(40,70,100,30);
        add(pass);
        
        password=new JPasswordField ();
        password.setBounds(150,70,150,30);
        add(password);
        
        login = new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setFont(new Font("serif",Font.ITALIC,15));
        login.addActionListener(this);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);
        
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(180,140,120,30);
        cancel.setFont(new Font("serif",Font.ITALIC,15));
        cancel.addActionListener(this);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,150,150);
        add(image);
        
        
        setBounds(500,200,600,300);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
        try{
            Conn c = new Conn();
            String user = username.getText();
            String pass = String.valueOf(password.getPassword());


            String query = "select * from login where username='"+user+"' and password='"+pass+"'";

            ResultSet rs = c.s.executeQuery(query); 
            if(rs.next()){ 
                new Dashboard().setVisible(true);
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        }else if(ae.getSource()==cancel){
            setVisible(false);
        }

    }


    public static void main(String[] arg){
        new Login();
    }
}