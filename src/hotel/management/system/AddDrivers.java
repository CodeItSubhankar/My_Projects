
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AddDrivers extends JFrame implements ActionListener{
    JButton add,cancel;
    JTextField tfname,tfcarcompany,tfage,tfcarmodel,tflocation;
    JComboBox availablecombo,gendercombo;
    AddDrivers(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading=new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);
        
        JLabel name=new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.PLAIN,18));
        name.setBounds(70, 80, 200, 30);
        add(name);
        
         tfname=new JTextField();
        tfname.setBounds(220, 80, 150, 25);
        add(tfname);
        
        JLabel age=new JLabel("Age");
        age.setFont(new Font("Tahoma",Font.PLAIN,18));
        age.setBounds(70, 120, 200, 30);
        add(age);
        
        tfage=new JTextField();
        tfage.setBounds(220, 120, 150, 25);
        add(tfage);
        
        
        
        
      
         JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Tahoma",Font.PLAIN,18));
        gender.setBounds(70, 160, 200, 30);
        add(gender);
        
        String genderOption[]={"Male","Female"};
        gendercombo=new JComboBox(genderOption);
        gendercombo.setBounds(220, 160, 150, 25);
        gendercombo.setBackground(Color.white);
        add(gendercombo);
        
         JLabel carcompany=new JLabel("Car Company");
        carcompany.setFont(new Font("Tahoma",Font.PLAIN,18));
        carcompany.setBounds(70, 200, 200, 30);
        add(carcompany);
        
        tfcarcompany=new JTextField();
        tfcarcompany.setBounds(220, 200, 150, 25);
        add(tfcarcompany);
        
        JLabel carModel=new JLabel("Car Model");
        carModel.setFont(new Font("Tahoma",Font.PLAIN,18));
        carModel.setBounds(70, 240, 200, 30);
        add(carModel);
        
         tfcarmodel=new JTextField();
        tfcarmodel.setBounds(220, 240, 150, 25);
        add(tfcarmodel);
        
        JLabel available=new JLabel("Availability");
        available.setFont(new Font("Tahoma",Font.PLAIN,18));
        available.setBounds(70, 280, 200, 30);
        add(available);
        
        String availabilityOption[]={"Available","Busy"};
        availablecombo=new JComboBox(availabilityOption);
        availablecombo.setBounds(220, 280, 150, 25);
        availablecombo.setBackground(Color.white);
        add(availablecombo);
        
        
         JLabel location=new JLabel("Location");
        location.setFont(new Font("Tahoma",Font.PLAIN,18));
        location.setBounds(70, 320, 200, 30);
        add(location);
        
         tflocation=new JTextField();
        tflocation.setBounds(220, 320, 150, 25);
        add(tflocation);
        
        add=new JButton("Add");
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Tahoma",Font.BOLD,15));
        add.setBackground(Color.black);
        add.setBounds(80,380,100,25);
        add.addActionListener(this);
        add(add);
        
        cancel=new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        cancel.setBackground(Color.black);
        cancel.setBounds(250,380,100,25);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/carinvite.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400, 30, 500, 300);
        add(image);
        
        
        setBounds(300,200,980,470);
        setVisible(true);
        
        
        
        
    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==add){
           String  name=tfname.getText();
           String age=tfage.getText();
           String gender=(String)gendercombo.getSelectedItem();
           String  company=tfcarcompany.getText();
           String model=tfcarmodel.getText();
           String availability=(String)availablecombo.getSelectedItem();
           String location=tflocation.getText();
            if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Name field should not be empty");
            return;
        }
            if(availability.equals("")){
            JOptionPane.showMessageDialog(null,"Availability field should not be empty");
            return;
        
        }
             if(location.equals("")){
            JOptionPane.showMessageDialog(null,"Location field should not be empty");
            return;
        }
            
           
          try{
              Conn conn=new Conn();
              String str="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+availability+"','"+location+"')";
              conn.s.executeUpdate(str);
              JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
              setVisible(false);
          }catch(Exception e){
              e.printStackTrace();
          }
               
       }else{
           setVisible(false);
       }
    }
    
    public static void main(String[] args){
        new AddDrivers();
    }
    
}
