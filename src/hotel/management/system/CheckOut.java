
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;



public class CheckOut extends JFrame implements ActionListener{
    Choice customerID;
    JLabel roomNumber,checkInTime,checkOutTime;
    JButton checkout,back;
    CheckOut(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading=new JLabel("Checkout");
        heading.setBounds(100, 20, 100, 30);
        heading.setForeground(Color.black);
        heading.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(heading);
        
        JLabel id=new JLabel("Customer ID");
        id.setBounds(30, 80, 100, 30);
        add(id);
        
        customerID=new Choice();
        customerID.setBounds(170, 83, 150, 30);
        add(customerID);
        
       
        
        
        
        JLabel room=new JLabel("Room Number");
        room.setBounds(30, 120, 100, 30);
        add(room);
        
        roomNumber=new JLabel();
        roomNumber.setBounds(170, 120, 100, 30);
        add(roomNumber);
        
        JLabel checkIN=new JLabel("Check-In Time");
        checkIN.setBounds(30, 160, 100, 30);
        add(checkIN);
        
        checkInTime=new JLabel();
        checkInTime.setBounds(170, 160, 100, 30);
        add(checkInTime);
        
        JLabel checkOut=new JLabel("Check-Out Time");
        checkOut.setBounds(30, 200, 100, 30);
        add(checkOut);
        
        
        Date date=new Date();
        checkOutTime=new JLabel(""+date);
        checkOutTime.setBounds(170, 200, 150, 30);
        add(checkOutTime);
        
        checkout=new JButton("Check-Out");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.white);
        checkout.setFont(new Font("Tahoma",Font.BOLD,12));
        checkout.setBounds(60, 260, 100, 30);
        checkout.addActionListener(this);
        add(checkout);
        
         back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setFont(new Font("Tahoma",Font.BOLD,12));
        back.setBounds(190, 260, 100, 30);
        back.addActionListener(this);
        add(back);
        
        
         try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                customerID.add(rs.getString("number"));
                checkInTime.setText(rs.getString("checkIn"));
                roomNumber.setText(rs.getString("room"));
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/deal.jpg"));
        Image i5=i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel images=new JLabel(i6);
        images.setBounds(350, 50, 400, 250);
        add(images);
        
        
        
        setBounds(300,200,800,400);
        setVisible(true);
        
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkout){
            String query="delete from customer where number='"+customerID.getSelectedItem()+"'";
            String query2="update room set availability='Available' where room_number='"+roomNumber.getText()+"'";
            
            try{
                Conn c=new Conn();
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Check-Out Done");
                setVisible(false);
                new Reception();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new Reception();
        }
    }
    
    
    public static void main(String[] args){
        new CheckOut();
        
    }
}
