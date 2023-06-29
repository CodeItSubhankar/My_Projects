
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.*;


public class SearchDriver extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    Choice typeOfCar;
    JCheckBox available;
    SearchDriver(){
        
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
       JLabel text=new JLabel("Pick-up Service");
       text.setFont(new Font("Tahoma",Font.BOLD,20));
       text.setBounds(400,20,300,30);
       add(text);
       
       JLabel carType=new JLabel("Car Type");
       carType.setFont(new Font("Tahoma",Font.PLAIN,18));
       carType.setBounds(50,100,100,20);
       add(carType);
       
       typeOfCar= new Choice();
       typeOfCar.setBounds(150, 100, 200, 25);
       add(typeOfCar);
       
       try{
           Conn c=new Conn();
           ResultSet rs=c.s.executeQuery("select * from driver");
           
           while(rs.next()){
               typeOfCar.add(rs.getString("model"));
           }
           
       }catch(Exception e){
           e.printStackTrace();
       }
       
       
       
       
        
        JLabel l1=new JLabel("Driver Name");
        l1.setBounds(10, 180, 100, 20);
        add(l1);
        
         JLabel l2=new JLabel("Age");
        l2.setBounds(200, 180, 100, 20);
        add(l2);
        
        JLabel l3=new JLabel("Gender");
        l3.setBounds(320, 180, 100, 20);
        add(l3);
        
        JLabel l4=new JLabel("Car Brand");
        l4.setBounds(450, 180, 100, 20);
        add(l4);
        
        JLabel l5=new JLabel("Car Model");
        l5.setBounds(590, 180, 100, 20);
        add(l5);
        
         JLabel l6=new JLabel("Availability");
        l6.setBounds(740, 180, 100, 20);
        add(l6);
        
        JLabel l7=new JLabel("Location");
        l7.setBounds(910, 180, 100, 20);
        add(l7);
        
        table=new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        submit=new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setBounds(300, 520, 120, 30);
        add(submit);
        
        back=new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(500, 520, 120, 30);
        add(back);
        
        
        
        
        setBounds(300,200,1000,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==submit){
            try{
                String query1="select * from driver where model='"+typeOfCar.getSelectedItem()+"'";
               
                
                Conn con=new Conn();
                ResultSet rs;
                
                  rs=con.s.executeQuery(query1);  
               
                 table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
            
        }else{
        setVisible(false);
        new Reception();
    }
    }
    
    public static void main(String[] args){
        new SearchDriver();
        
        
    }
}
