package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    Dashboard(){
        setBounds(0,0,1550,1000);
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/villa.jpg"));
        Image i2=i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);
        
        JLabel text=new JLabel("The Marriott Group Welcomes You........!!!");
        text.setBounds(400, 80, 1000, 50);
        text.setFont(new Font("Tahoma",Font.PLAIN,46));
        text.setForeground(Color.CYAN);
        image.add(text);
        
        
        JMenuBar mb=new JMenuBar();
        mb.setBounds(0, 0, 1550, 30);
        image.add(mb);
        
        
        JMenu manage=new JMenu("Management");
        manage.setForeground(Color.black);
        mb.add(manage);
        
        
        JMenuItem reception = new JMenuItem("Reception");
        reception.addActionListener(this);
        manage.add(reception);
        
        
        JMenu admin=new JMenu("Adminstration");
        admin.setForeground(Color.black);
        mb.add(admin);
        
         JMenuItem addemployee = new JMenuItem("Add Employee");
         addemployee.addActionListener(this);
        admin.add(addemployee);
        
        JMenuItem addrooms = new JMenuItem("Add Rooms");
        addrooms.addActionListener(this);
        admin.add(addrooms);
        
          JMenuItem addDrivers = new JMenuItem("Add Drivers");
          addDrivers.addActionListener(this);
        admin.add(addDrivers);
        
        
        
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Add Employee")){
            new AddEmployee();
        }else if(ae.getActionCommand().equals("Add Rooms")){
            new AddRooms();
        }else if(ae.getActionCommand().equals("Add Drivers")){
            new AddDrivers();
        }else if(ae.getActionCommand().equals("Reception")){
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new Dashboard();
    }
    
}
