
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AddRooms extends JFrame implements ActionListener{
    JButton add,cancel;
    JTextField tfroomNumber,tfprice;
    JComboBox availablecombo,cleancombo,bedtypecombo;
    AddRooms(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading=new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);
        
        JLabel roomNumber=new JLabel("Room Number");
        roomNumber.setFont(new Font("Tahoma",Font.PLAIN,18));
        roomNumber.setBounds(70, 80, 200, 30);
        add(roomNumber);
        
        tfroomNumber=new JTextField();
        tfroomNumber.setBounds(220, 80, 150, 25);
        add(tfroomNumber);
        
        JLabel availabe=new JLabel("Availability");
        availabe.setFont(new Font("Tahoma",Font.PLAIN,18));
        availabe.setBounds(70, 120, 200, 30);
        add(availabe);
        
        String availableOption[]={"Available","Occupied"};
        availablecombo=new JComboBox(availableOption);
        availablecombo.setBounds(220, 120, 150, 25);
        availablecombo.setBackground(Color.white);
        add(availablecombo);
      
         JLabel clean=new JLabel("Cleaning Status");
        clean.setFont(new Font("Tahoma",Font.PLAIN,18));
        clean.setBounds(70, 160, 200, 30);
        add(clean);
        
        String cleaningOption[]={"Cleaned","Not Cleaned"};
        cleancombo=new JComboBox(cleaningOption);
        cleancombo.setBounds(220, 160, 150, 25);
        cleancombo.setBackground(Color.white);
        add(cleancombo);
        
         JLabel price=new JLabel("Price");
        price.setFont(new Font("Tahoma",Font.PLAIN,18));
        price.setBounds(70, 200, 200, 30);
        add(price);
        
        tfprice=new JTextField();
        tfprice.setBounds(220, 200, 150, 25);
        add(tfprice);
        
        JLabel bedtype=new JLabel("Bed Type");
        bedtype.setFont(new Font("Tahoma",Font.PLAIN,18));
        bedtype.setBounds(70, 240, 200, 30);
        add(bedtype);
        
        String bedtypeoption[]={"Single Bed","Double Bed"};
        bedtypecombo=new JComboBox(bedtypeoption);
        bedtypecombo.setBounds(220, 240, 150, 25);
        bedtypecombo.setBackground(Color.white);
        add(bedtypecombo);
        
        add=new JButton("Add");
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Tahoma",Font.BOLD,15));
        add.setBackground(Color.black);
        add.setBounds(80,300,100,25);
        add.addActionListener(this);
        add(add);
        
        cancel=new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        cancel.setBackground(Color.black);
        cancel.setBounds(250,300,100,25);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/room3.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400, 30, 500, 300);
        add(image);
        
        
        setBounds(330,200,940,470);
        setVisible(true);
        
        
        
        
    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==add){
           String  roomnumber=tfroomNumber.getText();
           String availability=(String)availablecombo.getSelectedItem();
           String status=(String)cleancombo.getSelectedItem();
           String  price=tfprice.getText();
           String type=(String)bedtypecombo.getSelectedItem();
           
            if(roomnumber.equals("")){
            JOptionPane.showMessageDialog(null,"Room Number field should not be empty");
            return;
        }
            if(price.equals("")){
            JOptionPane.showMessageDialog(null,"Price field should not be empty");
            return;
        }
           
          try{
              Conn conn=new Conn();
              String str="insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
              conn.s.executeUpdate(str);
              JOptionPane.showMessageDialog(null, "New Room Added Successfully");
              setVisible(false);
          }catch(Exception e){
              e.printStackTrace();
          }
               
       }else{
           setVisible(false);
       }
    }
    
    public static void main(String[] args){
        new AddRooms();
    }
    
}
