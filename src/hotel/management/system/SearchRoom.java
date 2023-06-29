
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.*;


public class SearchRoom extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    JComboBox typebed;
    JCheckBox available;
    SearchRoom(){
        
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
       JLabel text=new JLabel("Search For Room");
       text.setFont(new Font("Tahoma",Font.BOLD,20));
       text.setBounds(400,20,300,30);
       add(text);
       
       JLabel bedType=new JLabel("Bed Type");
       bedType.setFont(new Font("Tahoma",Font.PLAIN,18));
       bedType.setBounds(50,100,100,20);
       add(bedType);
       
       typebed =new JComboBox(new String[]{"Single Bed","Double Bed"});
       typebed.setBounds(150,100,150,25);
       typebed.setBackground(Color.white);
       add(typebed);
       
       available=new JCheckBox("Only Display Available");
       available.setBounds(650,100,150,25);
       available.setBackground(Color.black);
       available.setForeground(Color.white);
       add(available);
       
        
        JLabel l1=new JLabel("Room Number");
        l1.setBounds(25, 180, 100, 20);
        add(l1);
        
         JLabel l2=new JLabel("Availability");
        l2.setBounds(250, 180, 100, 20);
        add(l2);
        
        JLabel l3=new JLabel("Cleaning Status");
        l3.setBounds(460, 180, 100, 20);
        add(l3);
        
        JLabel l4=new JLabel("Price");
        l4.setBounds(680, 180, 100, 20);
        add(l4);
        
        JLabel l5=new JLabel("Bed Type");
        l5.setBounds(870, 180, 100, 20);
        add(l5);
        
        table=new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from room");
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
                String query1="select * from room where bed_type='"+typebed.getSelectedItem()+"'";
                String query2="select * from room where availability='Available' AND bed_type='"+typebed.getSelectedItem()+"'";
                
                Conn con=new Conn();
                ResultSet rs;
                if(available.isSelected()){
                  rs=con.s.executeQuery(query2);  
                }else{
                     rs=con.s.executeQuery(query1); 
                }
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
        new SearchRoom();
        
        
    }
}

