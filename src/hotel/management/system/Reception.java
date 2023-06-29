
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Reception extends JFrame implements ActionListener{
    JButton newCustomer,rooms,departments,allEmployee,manager,customer,searchRoom,update,roomStatus,pickup,checkout,logout;
    Reception(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        newCustomer =new JButton("New Customer Form");
        newCustomer.setBounds(10, 30, 200, 30);
        newCustomer.setBackground(Color.black);
        newCustomer.setForeground(Color.white);
        newCustomer.addActionListener(this);
        add(newCustomer);
        
        rooms =new JButton("Rooms");
        rooms.setBounds(10, 80, 200, 30);
        rooms.setBackground(Color.black);
        rooms.setForeground(Color.white);
        rooms.addActionListener(this);
        add(rooms);
        
        departments =new JButton("Departments");
        departments.setBounds(10, 130, 200, 30);
        departments.setBackground(Color.black);
        departments.setForeground(Color.white);
        departments.addActionListener(this);
        add(departments);
        
        allEmployee =new JButton("Employee Info");
        allEmployee.setBounds(10, 180, 200, 30);
        allEmployee.setBackground(Color.black);
        allEmployee.setForeground(Color.white);
        allEmployee.addActionListener(this);
        add(allEmployee);
        
        customer =new JButton("Customer Info");
        customer.setBounds(10, 230, 200, 30);
        customer.setBackground(Color.black);
        customer.setForeground(Color.white);
        customer.addActionListener(this);
        add(customer);
        
        manager =new JButton("Manager Info");
        manager.setBounds(10, 280, 200, 30);
        manager.setBackground(Color.black);
        manager.setForeground(Color.white);
        manager.addActionListener(this);
        add(manager);
        
        checkout =new JButton("Check Out");
        checkout.setBounds(10, 330, 200, 30);
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.addActionListener(this);
        add(checkout);
        
        update =new JButton("Update Status");
        update.setBounds(10, 380, 200, 30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);
        
        roomStatus =new JButton("Update Room Status");
        roomStatus.setBounds(10, 430, 200, 30);
        roomStatus.setBackground(Color.black);
        roomStatus.setForeground(Color.white);
        roomStatus.addActionListener(this);
        add(roomStatus);
        
        pickup =new JButton("Pickup Service");
        pickup.setBounds(10, 480, 200, 30);
        pickup.setBackground(Color.black);
        pickup.setForeground(Color.white);
        pickup.addActionListener(this);
        add(pickup);
        
        searchRoom =new JButton("Search Room");
        searchRoom.setBounds(10, 530, 200, 30);
        searchRoom.setBackground(Color.black);
        searchRoom.setForeground(Color.white);
        searchRoom.addActionListener(this);
        add(searchRoom);
        
        logout =new JButton("Logout");
        logout.setBounds(10, 580, 200, 30);
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/reception2.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
       
        image.setBounds(250,30,500,470);
        add(image);
        
        
        
        setBounds(350,200,800,570);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==newCustomer){
            setVisible(false);
            new AddCustomer();
        }else if(ae.getSource()==rooms){
            setVisible(false);
            new AllRooms();
        }else if(ae.getSource()==departments){
            setVisible(false);
            new Department();
        }else if(ae.getSource()==allEmployee){
            setVisible(false);
            new EmployeeInfo();
            
        }else if(ae.getSource()==manager){
            setVisible(false);
            new ManagerInfo();
        }else if(ae.getSource()==customer){
            setVisible(false);
            new CustomerInfo();
        }else if(ae.getSource()==searchRoom){
        
            setVisible(false);
            new SearchRoom();
        }else if(ae.getSource()==update){
        
            setVisible(false);
            new UpdateCheck();
        }else if(ae.getSource()==roomStatus){
        
            setVisible(false);
            new UpdateRoom();
        }else if(ae.getSource()==pickup){
        
            setVisible(false);
            new SearchDriver();
        }else if(ae.getSource()==checkout){
        
            setVisible(false);
            new CheckOut();
        }else if(ae.getSource()==logout){
        
            setVisible(false);
            
        }
        
    }
public static void main(String[] args){
    new Reception();
}
}
