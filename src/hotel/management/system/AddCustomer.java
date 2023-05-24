package hotel.management.system;


import java.awt.*;
import java.awt.event.*;
import java.util.Date;


import java.awt.Image;
import java.sql.*;	
import javax.swing.*;



public class AddCustomer extends JFrame implements ActionListener{
    
    JComboBox comboid;
    JTextField tfnumber,tfname,tfcountry,tfdeposit;
    JRadioButton rmnale,rfemale;
    Choice croom;
    JLabel checkintime;
    JButton add,back;
    
    AddCustomer(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("NEW CUSTOMER FORM");
	text.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
	text.setBounds(100, 20, 300, 30);
	add(text);
        
        
        JLabel lblid = new JLabel("ID");
	lblid.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
	lblid.setBounds(35, 80, 100, 20);
	add(lblid);
        
        String options[]= { "Passport", "Aadhar Card", "Driving license" };
        comboid = new JComboBox(options);
	comboid.setBackground(Color.WHITE);
        comboid.setBounds(200,80,150,25);
	add(comboid);
        
        JLabel lblnumber = new JLabel("Number :");
        lblnumber.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblnumber.setBackground(Color.WHITE);
	lblnumber.setBounds(35, 120, 100, 20);
	add(lblnumber);
        
        tfnumber = new JTextField();
	tfnumber.setBounds(200, 120, 150, 25);
	add(tfnumber);
        
        JLabel lblname = new JLabel("Name :");
        lblname.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblname.setBackground(Color.WHITE);
	lblname.setBounds(35, 160, 100, 20);
	add(lblname);
        
        tfname = new JTextField();
	tfname.setBounds(200, 160, 150, 25);
	add(tfname);
        
        JLabel lblgender = new JLabel("Gender :");
        lblgender.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblgender.setBackground(Color.WHITE);
	lblgender.setBounds(35, 200,100,20);
	add(lblgender);
        
        rmnale = new JRadioButton("Male");
        rmnale.setBackground(Color.WHITE);
	rmnale.setBounds(200, 200,60,25);
        add(rmnale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
	rfemale.setBounds(270, 200,100,25);
        add(rfemale);
        
        JLabel lblcountry = new JLabel("Country :");
        lblcountry.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblcountry.setBackground(Color.WHITE);
	lblcountry.setBounds(35, 240, 100, 20);
	add(lblcountry);
        
        
        tfcountry = new JTextField();
	tfcountry.setBounds(200, 240, 150, 25);
	add(tfcountry);
        
        JLabel lblroom = new JLabel("Room Number :");
        lblroom.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblroom.setBackground(Color.WHITE);
	lblroom.setBounds(35, 280, 150, 25);
	add(lblroom);
        
        croom=new Choice();
        try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from room where availability = 'Available'");
                    while(rs.next()){
                        croom.add(rs.getString("roomnumber"));    
                    }
                }catch(Exception e){ }
        
        croom.setBounds(200, 280, 150, 25);
        add(croom);
        
        JLabel lbltime = new JLabel("Checkin Time :");
        lbltime.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lbltime.setBackground(Color.WHITE);
	lbltime.setBounds(35, 320, 150, 25);
	add(lbltime);
        
        Date date = new Date();
        
        
        checkintime = new JLabel("" + date);
        checkintime.setFont(new Font("Yu Mincho", Font.PLAIN, 18));
        checkintime.setBackground(Color.WHITE);
	checkintime.setBounds(200, 320, 150, 15);
	add(checkintime);
        
        JLabel lbldeposit = new JLabel("Payment :");
        lbldeposit.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lbldeposit.setBackground(Color.WHITE);
	lbldeposit.setBounds(35, 360, 150, 20);
	add(lbldeposit);
        
        tfdeposit = new JTextField();
	tfdeposit.setBounds(200, 360, 150, 25);
	add(tfdeposit);
        
        
        add = new JButton("Add");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        add.setBounds(50,410,120,30);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(200,410,120,30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550,450,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);
        
        
        
        setBounds(350, 200, 800, 550);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        
        if(ae.getSource() == add){
            String id = (String)comboid.getSelectedItem();
            String number =  tfnumber.getText();
	    String name =  tfname.getText();
            String gender =  null;
            if(rmnale.isSelected()){ 
                gender = "Male";
            }
            else if(rfemale.isSelected()){ 
                gender = "Female";
            }
            
         String country =  tfcountry.getText();
	 String room =  croom.getSelectedItem();
         String time =  checkintime.getText();  
         String deposit = tfdeposit.getText();
            
            try{

                String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String query2 = "update room set availability = 'Occupied' where roomnumber = "+room+"";
                
                Conn c = new Conn();
                
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "New Customer added Successfully");
                setVisible(false);
                new Reception();
                
	    	}catch(SQLException e1){
	    		System.out.println(e1.getMessage());
	    		}
		    	catch(NumberFormatException s){
		    			JOptionPane.showMessageDialog(null, "Please enter a valid Number");
			}
            
        }else if(ae.getSource() == back){
            setVisible(false);
              new Reception();
        }
                            
        
    }
    
    public static void main(String[] args) {
        new AddCustomer();
    }
}
