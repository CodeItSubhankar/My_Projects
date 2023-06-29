package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    JComboBox comboid;
    JTextField tfnumber,tfName,tfcountry,tfadvance;
    JRadioButton rbMale,rbFemale,others;
    Choice allocRoom;
    JLabel checkIn;
    JButton add,back;
    
    AddCustomer(){
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        
        JLabel heading=new JLabel("New Customer Form");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);
        
        JLabel id=new JLabel("Customer ID");
        id.setFont(new Font("Tahoma",Font.PLAIN,18));
        id.setBounds(70, 70, 150, 20);
        add(id);
        
        String idOption[]={"Adhar Card","Passport","Driving License","Pancard"};
        comboid=new JComboBox(idOption);
        comboid.setBounds(250, 70, 150, 20);
        comboid.setBackground(Color.white);
        add(comboid);
        
        JLabel number=new JLabel("ID Number");
        number.setFont(new Font("Tahoma",Font.PLAIN,18));
        number.setBounds(70, 110, 150, 20);
        add(number);
        
        tfnumber=new JTextField();
        tfnumber.setBounds(250, 110, 150, 25);
        add(tfnumber);
        
         JLabel name=new JLabel("Name");
        name.setBounds(70,150,150,20);
        name.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(name);
        
        tfName=new JTextField();
        tfName.setBounds(250,150,150,25);
        add(tfName);
        
        JLabel gender=new JLabel("Gender");
        gender.setBounds(70,190,150,20);
        gender.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(gender);
        
        rbMale=new JRadioButton("Male");
        rbMale.setBounds(250,190,60,25);
        rbMale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbMale.setBackground(Color.white);
        add(rbMale);
        
        rbFemale=new JRadioButton("Female");
        rbFemale.setBounds(350,190,80,25);
        rbFemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbFemale.setBackground(Color.white);
        add(rbFemale);
        
        others=new JRadioButton("Others");
        others.setBounds(450,190,80,25);
        others.setFont(new Font("Tahoma",Font.PLAIN,14));
        others.setBackground(Color.white);
        add(others);
        
         ButtonGroup bg=new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);
        bg.add(others);
        
         JLabel country=new JLabel("Country");
        country.setBounds(70,230,150,20);
        country.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(country);
        
        tfcountry=new JTextField();
        tfcountry.setBounds(250,230,150,25);
        add(tfcountry);
        
         JLabel allocatedRoom=new JLabel("Allocated Room");
        allocatedRoom.setBounds(70,270,150,20);
        allocatedRoom.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(allocatedRoom);
        
        allocRoom=new Choice();
        
        
        try{
            Conn con=new Conn();
            String query="select * from room where availability ='Availabe'";
           ResultSet rs= con.s.executeQuery(query);
           while(rs.next()){
               allocRoom.add(rs.getString("room_number"));
           }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        allocRoom.setBounds(250, 270, 150, 25);
        add(allocRoom);
        
        JLabel checkinTime=new JLabel("Check-In Time");
        checkinTime.setBounds(70,310,150,20);
        checkinTime.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(checkinTime);
        
        Date date=new Date();
        
        checkIn=new JLabel(""+date);
        checkIn.setBounds(250,310,200,20);
        checkIn.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(checkIn);
        
         JLabel advance=new JLabel("Advance Paid");
        advance.setBounds(70,350,150,20);
        advance.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(advance);
        
        tfadvance=new JTextField();
        tfadvance.setBounds(250,350,150,25);
        add(tfadvance);
        
        add=new JButton("Add");
        add.setBounds(150,400,80,25);
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.addActionListener(this);
        add(add);
        
        back=new JButton("Back");
        back.setBounds(250,400,80,25);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/deal.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(510, 50, 300, 350);
        add(image);
        
        
        
        
        
        
        setBounds(250,110,800,550);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
             String  comboID=(String)comboid.getSelectedItem();
             String number=tfnumber.getText();
             String name=tfName.getText();
             String gender=null;
              
             
             if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Name should not be empty");
            return;
        }
              if(number.equals("")){
            JOptionPane.showMessageDialog(null,"Number should not be empty");
            return;
        }
             
            if(rbMale.isSelected()){
            gender="Male";
        }else if(rbFemale.isSelected()){
            gender="Female";
        }else if(others.isSelected()){
        gender="Dont Want To Mention";
            
        }
            
            String country=tfcountry.getText();
            String roomalloc=allocRoom.getSelectedItem();
            String time=checkIn.getText();
            String advance=tfadvance.getText();
            
             try{
                 String query="insert into customer values('"+comboID+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+roomalloc+"','"+time+"','"+advance+"')";
                 String query2="update room set availability='Occupied' where room_number='"+roomalloc+"'";
                 Conn conn=new Conn();
                 conn.s.executeUpdate(query);
                 conn.s.executeUpdate(query2);
                 JOptionPane.showMessageDialog(null, "New Customer Added Successfulyy");
                 
                 setVisible(false);
                 new Reception();
                 
                 
                 
                 
             }catch(Exception e){
                 e.printStackTrace();
             }
             
             
             
        }else if(ae.getSource()== back){
            setVisible(false);
                 new Reception();
        }
            
       
        
        
        
    }
    public static void main(String[] args){
        new AddCustomer();
    }
    
}
