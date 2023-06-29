package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JTextField username;
    JPasswordField pass;
    JButton login,cancel;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
       
        
        JLabel user=new JLabel("Username");
        user.setBounds(40, 20, 100, 30);
        add(user);
        
         username=new JTextField();
        username.setBounds(150, 20, 150, 30);
        add(username);
        
         JLabel password=new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        add(password);
        
         pass=new JPasswordField();
        pass.setBounds(150, 70, 150, 30);
        add(pass);
        
        login=new JButton("Login");
        login.setBounds(40, 150, 120, 30);
        login.setBackground(Color.BLUE);
        login.setForeground(Color.CYAN);
        login.addActionListener(this);
        add(login);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(180, 150, 120, 30);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.CYAN);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/person1.png"));
        Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);
       
        
        
        
        
        setBounds(500,200,600,300);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            String user=username.getText();
            String pas=pass.getText();
            
            try{
                Conn c = new Conn();
                String query="select * from login where username='"+user+"' and password='"+pas+"'";
                ResultSet rs=c.s.executeQuery(query);
                
                if(rs.next()){
                   setVisible(false);
                   new Dashboard();
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);
                    
                }
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==cancel){
            setVisible(false);
            
        }
        
    }
    
    public static void main(String[] args){
        new Login();
        
        
    }
    
}
