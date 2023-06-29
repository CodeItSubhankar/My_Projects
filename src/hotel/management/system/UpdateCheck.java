
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateCheck extends JFrame implements ActionListener{
    
    Choice cust;
    JTextField tfRoom,tfName,tfCheckIn,tfPaid,tfPending;
    JButton check,update,back;
    
    UpdateCheck(){
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel heading=new JLabel("Update Status");
        heading.setFont(new Font("Tahoma",Font.PLAIN,20));
        heading.setBounds(90,20,200,30);
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
         
          JLabel name=new JLabel("Name");
         name.setBounds(30,160,100,20);
         add(name);
         
         tfName=new JTextField();
         tfName.setBounds(170,160,150,25);
         add(tfName);
        
         JLabel checkIn=new JLabel("Check-In Time");
         checkIn.setBounds(30,200,100,20);
         add(checkIn);
         
         tfCheckIn=new JTextField();
         tfCheckIn.setBounds(170,200,150,25);
         add(tfCheckIn);
         
         JLabel paid=new JLabel("Amount Paid");
         paid.setBounds(30,240,100,20);
         add(paid);
         
         tfPaid=new JTextField();
         tfPaid.setBounds(170,240,150,25);
         add(tfPaid);
         
          JLabel pendingAmount=new JLabel("Pending Amount");
         pendingAmount.setBounds(30,280,100,20);
         add(pendingAmount);
         
         tfPending=new JTextField();
         tfPending.setBounds(170,280,150,25);
         add(tfPending);
         
         check=new JButton("Check");
         check.setBackground(Color.black);
         check.setForeground(Color.white);
         check.setBounds(30,340,80,25);
         check.addActionListener(this);
         add(check);
         
         update=new JButton("Update");
         update.setBackground(Color.black);
         update.setForeground(Color.white);
         update.setBounds(130,340,80,25);
         update.addActionListener(this);
         add(update);
         
         back=new JButton("Back");
         back.setBackground(Color.black);
         back.setForeground(Color.white);
         back.setBounds(230,340,80,25);
         back.addActionListener(this);
         add(back);
         
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/checkInOut.png"));
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
                   tfName.setText(rs.getString("name"));
                   tfCheckIn.setText(rs.getString("checkIn"));
                   tfPaid.setText(rs.getString("advance"));
               }
               ResultSet rs2=c.s.executeQuery("select * from room where room_number='"+tfRoom.getText()+"'");
               while(rs2.next()){
                   String price=rs2.getString("price");
                   int amountPaid=Integer.parseInt(price)-Integer.parseInt(tfPaid.getText());
                   tfPending.setText(""+amountPaid);
               }
               
               
               
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==update){
            
            String number=cust.getSelectedItem();
            String roomnumber=tfRoom.getText();
            String name=tfName.getText();
            String checkin=tfCheckIn.getText();
            String paid=tfPaid.getText();
            String pending=tfPending.getText();
            
            
            
            try{
                Conn c=new Conn();
                c.s.executeUpdate("update customer set room='"+roomnumber+"', name='"+name+"',checkIn='"+checkin+"',advance='"+paid+"' where number ='"+number+"'");
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
        new UpdateCheck();
    }

   
}
