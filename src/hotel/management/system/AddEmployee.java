package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    JTextField tfName,tfAge,tfPhone,tfSalary,tfEmail,tfAdhar;
    JRadioButton rbMale,rbFemale,others;
    JButton submit;
    JComboBox cbjob;
    AddEmployee(){
        setLayout(null);
        
        JLabel name=new JLabel("Name:");
        name.setBounds(60,30,120,30);
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(name);
        
        tfName=new JTextField();
        tfName.setBounds(150,30,150,25);
        add(tfName);
        
        JLabel age=new JLabel("Age:");
        age.setBounds(60,80,120,30);
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(age);
        
        tfAge=new JTextField();
        tfAge.setBounds(150,80,150,25);
        add(tfAge);
        
         JLabel gender=new JLabel("Gender:");
        gender.setBounds(60,130,120,30);
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(gender);
        
        rbMale=new JRadioButton("Male");
        rbMale.setBounds(150,130,80,25);
        rbMale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbMale.setBackground(Color.white);
        add(rbMale);
        
        rbFemale=new JRadioButton("Female");
        rbFemale.setBounds(250,130,80,25);
        rbFemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbFemale.setBackground(Color.white);
        add(rbFemale);
        
        others=new JRadioButton("Dont Want To Mention");
        others.setBounds(350,130,180,25);
        others.setFont(new Font("Tahoma",Font.PLAIN,14));
        others.setBackground(Color.white);
        add(others);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);
        bg.add(others);
        
         JLabel job=new JLabel("Job:");
        job.setBounds(60,180,120,30);
        job.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(job);
        
        String[] str={"Manager","Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiters","Acountant"};
         cbjob=new JComboBox(str);
         cbjob.setBounds(150, 180, 150, 25);
         cbjob.setBackground(Color.white);
         add(cbjob);
        
         JLabel salary=new JLabel("Salary:");
        salary.setBounds(60,230,120,30);
        salary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(salary);
        
       tfSalary=new JTextField();
        tfSalary.setBounds(150,230,150,25);
        add(tfSalary);
        
         JLabel phone=new JLabel("Phone:");
        phone.setBounds(60,280,120,30);
        phone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(phone);
        
        tfPhone=new JTextField();
        tfPhone.setBounds(150,280,150,25);
        add(tfPhone);
        
         JLabel email=new JLabel("Email:");
        email.setBounds(60,330,120,30);
        email.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(email);
        
        tfEmail=new JTextField();
        tfEmail.setBounds(150,330,150,25);
        add(tfEmail);
        
         JLabel adhar=new JLabel("Adhar No:");
        adhar.setBounds(60,380,120,30);
        adhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(adhar);
        
        tfAdhar=new JTextField();
        tfAdhar.setBounds(150,380,150,25);
        add(tfAdhar);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(130, 430, 100, 25);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/management.jpg"));
        Image i2=i1.getImage().getScaledInstance(450, 450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,20,450,450);
        add(image);
        
        setBounds(350,200,850,540);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String name=tfName.getText();
        String age=tfAge.getText();
        String salary=tfSalary.getText();
        String phone=tfPhone.getText();
        String email=tfEmail.getText();
        String adhar=tfAdhar.getText();
        
        String gender=null;
        
        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Name should not be empty");
            return;
        }
        
         if(phone.equals("")){
            JOptionPane.showMessageDialog(null,"Phone field should not be empty");
            return;
        }
         
          if(adhar.equals("")){
            JOptionPane.showMessageDialog(null,"Adhar field should not be empty");
            return;
        }
        
        if(rbMale.isSelected()){
            gender="Male";
        }else if(rbFemale.isSelected()){
            gender="Female";
        }else if(others.isSelected()){
        gender="Dont Want To Mention";
            
        }
        
        String job=(String)cbjob.getSelectedItem();
        try{
          Conn conn=new Conn();
          String query="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+adhar+"')";
          conn.s.executeUpdate(query);
          JOptionPane.showMessageDialog(null, "Employee added successfully");
          
          setVisible(false);
          
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args){
        new AddEmployee();
    }
    
}
