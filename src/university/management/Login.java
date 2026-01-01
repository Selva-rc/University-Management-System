package university.management;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login,cancel;
    JTextField tfusername,tfpassword;
     Login(){
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
         JLabel lblusername = new JLabel("Username");
         lblusername.setBounds(200, 80, 150, 20);
         lblusername.setFont(new Font("ROMAN",Font.BOLD,15));
         add(lblusername);
         
          tfusername = new JTextField();
         tfusername.setBounds(300, 80, 150, 20);
         
         add(tfusername);
         
         JLabel lblpassword = new JLabel("Password");
         lblpassword.setBounds(200, 130, 150, 20);
         lblpassword.setFont(new Font("ROMAN",Font.BOLD,15));
         add(lblpassword);
         
          tfpassword = new JPasswordField();
         tfpassword.setBounds(300, 130, 150, 20);
         add(tfpassword);
         
         
          login = new JButton("Login");
         login.setBounds(200, 225, 150, 40);
         login.setBackground(Color.BLACK);
         login.setForeground(Color.white);
         login.addActionListener(this);
         login.setFont(new Font("Tahoma",Font.BOLD,16));
         add(login);
         
          cancel = new JButton("Cancel");
         cancel.setBounds(380, 225, 100, 40);
         cancel.setBackground(Color.red);
         cancel.setForeground(Color.BLACK);
         cancel.addActionListener(this);
         cancel.setFont(new Font("Tahoma",Font.BOLD,15));
         add(cancel);
         
          ImageIcon landing = new ImageIcon(ClassLoader.getSystemResource("icons/user.png"));
          Image l1 =landing.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
          ImageIcon l2= new ImageIcon(l1);
          JLabel image = new JLabel(l2);
          image.setBounds(500, 80, 100, 100);
          add(image);
         
         
         setLocation(300,200);
         setSize(700,400);
         setVisible(true);
        
    }
     public void actionPerformed(ActionEvent ae){
         
         if(ae.getSource()== login  ){
             String username = tfusername.getText();
             String password = tfpassword.getText();
             
             String query = "select * from login where username ='"+username+"' and password='"+password+"'";
             
             try{
                 Connect c= new Connect();
                 ResultSet rs = c.s.executeQuery(query);
                 
                 if(rs.next()){
                     setVisible(false);
                     new Project();
                 }else{
                     
                     JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                     setVisible(false);
                 }
                 
             } catch(Exception e){
                 
                 e.printStackTrace();
                 
             }
             
         }else if(ae.getSource()== cancel ){
             dispose();
         }
         
     }
     
     
     
     
    
    public static void main(String[] args){
        new Login();
    }
    
}

