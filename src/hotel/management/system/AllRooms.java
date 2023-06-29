
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.*;


public class AllRooms extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    AllRooms(){
        
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/room1.jpg"));
        Image i2=i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500, 0, 600, 650);
        add(image);
        
        JLabel l1=new JLabel("Room Number");
        l1.setBounds(5, 10, 100, 20);
        add(l1);
        
         JLabel l2=new JLabel("Availability");
        l2.setBounds(120, 10, 100, 20);
        add(l2);
        
        JLabel l3=new JLabel("Cleaning Status");
        l3.setBounds(200, 10, 100, 20);
        add(l3);
        
        JLabel l4=new JLabel("Price");
        l4.setBounds(320, 10, 100, 20);
        add(l4);
        
        JLabel l5=new JLabel("Bed Type");
        l5.setBounds(420, 10, 100, 20);
        add(l5);
        
        table=new JTable();
        table.setBounds(0, 40, 500, 400);
        add(table);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back=new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(200, 500, 120, 30);
        add(back);
        
        
        
        
        setBounds(300,200,1050,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args){
        new AllRooms();
        
        
    }
}
