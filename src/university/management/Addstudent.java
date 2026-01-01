
package university.management;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;


public class Addstudent extends JFrame implements ActionListener{
    JTextField tfname,tffname,tfaddress,tfphone,tfemail,tfx,tfxii,tfaadhar;
    JLabel lbelroll;
    JDateChooser dcdob;
    JComboBox cbcourse,cbbranch;
    JButton submit,cancel;
    
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L)+1000L);
    Addstudent(){
        getContentPane().setBackground(Color.white);
        setSize(800,600);
        setLocation(250,60);
        
        
        setLayout(null);
        
        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(260, 30, 500, 50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        JLabel lbname = new JLabel("Name");
        lbname.setBounds(50, 130, 100, 40);
        lbname.setFont(new Font("serif",Font.BOLD,20));
        add(lbname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 142, 130, 20);
        add(tfname);
        
        
        JLabel lblname = new JLabel("Fathers's Name");
        lblname.setBounds(400, 130, 200, 40);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);
        
        tffname = new JTextField();
        tffname.setBounds(570, 142, 130, 20);
        add(tffname);
        
        JLabel lblroll = new JLabel("Roll Number");
        lblroll.setBounds(50, 192, 130, 40);
        lblroll.setFont(new Font("serif",Font.BOLD,20));
        add(lblroll);
        
        lbelroll = new JLabel("1598"+first4);
        lbelroll.setBounds(200, 200, 130, 20);
        lbelroll.setFont(new Font("serif",Font.BOLD,20));
        add(lbelroll);
        
        JLabel lbldateofbirth = new JLabel("Date of Birth");
        lbldateofbirth.setBounds(400, 192, 130, 40);
        lbldateofbirth.setFont(new Font("serif",Font.BOLD,20));
        add(lbldateofbirth);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(570, 200, 130, 20);
        //dcdob.setBounds(WIDTH, WIDTH, 130, HEIGHT);
        add(dcdob);
        
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 130, 40);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 260, 130, 20);
        add(tfaddress);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 252, 130, 40);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(570, 258, 130, 20);
        add(tfphone);
        
        
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 312, 130, 40);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 320, 130, 20);
        add(tfemail);
        
        
        JLabel lblx = new JLabel("Class X (%)");
        lblx.setBounds(400, 312, 130, 40);
        lblx.setFont(new Font("serif",Font.BOLD,20));
        add(lblx);
        
        tfx = new JTextField();
        tfx.setBounds(570, 316, 130, 20);
        add(tfx);
        
        
        JLabel lblxii = new JLabel("Class Xii (%)");
        lblxii.setBounds(50, 370, 130, 40);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);
        
        tfxii = new JTextField();
        tfxii.setBounds(200, 380, 130, 20);
        add(tfxii);
        
        
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(400, 372, 150, 40);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(570, 380, 130, 20);
        add(tfaadhar);
        
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50, 430, 130, 40);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);
        
        String course[] ={"B.Tech","B.E","BSC","B.Pharm","B.COM","BCA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200, 440, 130, 20);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(400, 430, 150, 40);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);
        
        String branch[] ={"Computer Science","Information Technology","Computer Application","Nurse","Accounts","Law"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(570, 444, 130, 20);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        
        submit = new JButton("Submit");
        submit.setBounds(200, 490, 150, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,16));
        add(submit);
        
        
        cancel = new JButton("Cancel");
        cancel.setBounds(400, 490, 150, 30);
        cancel.setBackground(Color.red);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,16));
        add(cancel);
        
        setVisible(true);
       // tfname,tffname,tfaddress,tfphone,tfemail,tfx,tfxii,tfaadhar
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = lbelroll.getText();
            String date =  ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone =  tfphone.getText();
            String mail =   tfemail.getText();
            String classx =  tfx.getText();
            String classxii = tfxii.getText();
            String aadhar = tfaadhar.getText();
            String course = (String)cbcourse.getSelectedItem();
            String branch = (String)cbbranch.getSelectedItem();
            
            try{
                String query ="insert into student values('"+name+"','"+fname+"','"+rollno+"','"+date+"','"+address+"','"+phone+"','"+mail+"','"+classx+"','"+classxii+"','"+aadhar+"','"+course+"','"+branch+"')";
                
                Connect con = new Connect();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Student Details inserted Successfully" );
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
            
            
        }else{
            dispose();
        }
    }
    
 
    
    
    public static void main(String args[]){
        new Addstudent();
        
    }
}
    

