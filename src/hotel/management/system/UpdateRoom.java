package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener{
    
    Choice cust;
    JTextField tfRoom,tfAvailable,tfCleaning,tfPaid,tfPending;
    JButton check,update,back;
    
    UpdateRoom(){
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel heading=new JLabel("Update Room Status");
        heading.setFont(new Font("Tahoma",Font.PLAIN,25));
        heading.setBounds(30,20,250,30);
        add(heading);
        heading.setForeground(Color.BLUE);
        
         JLabel id=new JLabel("Customer ID");
         id.setBounds(30,80,100,20);
         add(id);
        
        cust=new Choice();
        cust.setBounds(170, 80, 150, 30);
        add(cust);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                cust.add(rs.getString("number"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
         JLabel room=new JLabel("Room Number");
         room.setBounds(30,120,100,20);
         add(room);
         
         tfRoom=new JTextField();
         tfRoom.setBounds(170,120,150,25);
         add(tfRoom);
         
          JLabel available=new JLabel("Availability");
         available.setBounds(30,160,100,20);
         add(available);
         
         tfAvailable=new JTextField();
         tfAvailable.setBounds(170,160,150,25);
         add(tfAvailable);
        
         JLabel cleaning=new JLabel("Cleaning Status");
         cleaning.setBounds(30,200,100,20);
         add(cleaning);
         
         tfCleaning=new JTextField();
         tfCleaning.setBounds(170,200,150,25);
         add(tfCleaning);
         
        
         
         check=new JButton("Check");
         check.setBackground(Color.black);
         check.setForeground(Color.white);
         check.setBounds(30,300,80,25);
         check.addActionListener(this);
         add(check);
         
         update=new JButton("Update");
         update.setBackground(Color.black);
         update.setForeground(Color.white);
         update.setBounds(130,300,80,25);
         update.addActionListener(this);
         add(update);
         
         back=new JButton("Back");
         back.setBackground(Color.black);
         back.setForeground(Color.white);
         back.setBounds(230,300,80,25);
         back.addActionListener(this);
         add(back);
         
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/room2.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400, 50, 500, 300);
        add(image);
         
        
        setBounds(300,200,980,500);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            String id=cust.getSelectedItem();
            String query="select * from customer where number='"+id+"'";
            try{
                Conn c=new Conn();
               ResultSet rs=c.s.executeQuery(query);
               while(rs.next()){
                   tfRoom.setText(rs.getString("room"));
                   
               }
               ResultSet rs2=c.s.executeQuery("select * from room where room_number='"+tfRoom.getText()+"'");
               while(rs2.next()){
                   tfAvailable.setText(rs2.getString("availability"));
                   tfCleaning.setText(rs2.getString("cleaning_status"));
                   
               }
               
               
               
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==update){
            
            String number=cust.getSelectedItem();
            String roomnumber=tfRoom.getText();
            String available=tfAvailable.getText();
            String cleaning=tfCleaning.getText();
           
            
            
            
            try{
                Conn c=new Conn();
                c.s.executeUpdate("update room set availability='"+available+"', cleaning_status='"+cleaning+"' where room_number='"+roomnumber+"'");
                JOptionPane.showMessageDialog(null, "Data Updated Succcessfully");
                setVisible(false);
                new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
            
            
            
        }else if(ae.getSource()==back){
             setVisible(false);
                new Reception();
        }
    }
    
    
    
    public static void main(String[] args){
        new UpdateRoom();
    }

   
}
