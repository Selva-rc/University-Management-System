
package university.management;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;


public class UpdateStudent extends JFrame implements ActionListener{
    JTextField tffcourse,tffname,tfaddress,tfphone,tffemail,tffbranch;
    JLabel lbelroll;
   
    JButton submit,cancel;
    Choice crollno;
    
    UpdateStudent(){
        getContentPane().setBackground(Color.white);
        setSize(800,600);
        setLocation(250,60);
        
        
        setLayout(null);
        
        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma",Font.ITALIC,35));
        add(heading);
        
        JLabel lblrollno = new JLabel("Select Roll Number ");
        lblrollno.setBounds(50, 100, 200, 20);
        lblrollno.setFont(new Font("serif",Font.PLAIN,20));
        add(lblrollno);
        
        crollno = new Choice();
        crollno.setBounds(250, 100, 200, 20);
        add(crollno);
        
        
        
        try{
            Connect c = new Connect();
            ResultSet rs =c.s.executeQuery("select*from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }        
        
        
        JLabel lbname = new JLabel("Name");
        lbname.setBounds(50, 130, 100, 40);
        lbname.setFont(new Font("serif",Font.BOLD,20));
        add(lbname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 142, 130, 20);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,18));        
        add(lblname);
        
        
        JLabel lblfname = new JLabel("Fathers's Name");
        lblfname.setBounds(400, 130, 200, 40);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);
        
        JLabel labelfname = new JLabel();
        labelfname.setBounds(570, 142, 130, 20);
        labelfname.setFont(new Font("Tahoma",Font.PLAIN,18));         
        add(labelfname);
        
        JLabel lblroll = new JLabel("Roll Number");
        lblroll.setBounds(50, 192, 130, 40);
        lblroll.setFont(new Font("serif",Font.BOLD,20));
        add(lblroll);
        
        lbelroll = new JLabel();
        lbelroll.setBounds(200, 200, 130, 20);
        lbelroll.setFont(new Font("Tahoma",Font.PLAIN,18));  
        add(lbelroll);
        
        JLabel lbldateofbirth = new JLabel("Date of Birth");
        lbldateofbirth.setBounds(400, 192, 130, 40);
        lbldateofbirth.setFont(new Font("serif",Font.BOLD,20));
        add(lbldateofbirth);
        
        JLabel dob = new JLabel();
        dob.setBounds(570, 200, 130, 20);
        dob.setFont(new Font("Tahoma",Font.PLAIN,18));
        //dob.setBounds(570, 200, 130, 20);
        
        //dcdob.setBounds(WIDTH, WIDTH, 130, HEIGHT);
        add(dob);
        
        
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
        
        tffemail = new JTextField();
        tffemail.setBounds(200, 320, 130, 20);
        add(tffemail);
        
        
        JLabel lblx = new JLabel("Class X (%)");
        lblx.setBounds(400, 312, 130, 40);
        lblx.setFont(new Font("serif",Font.BOLD,20));
        add(lblx);
        
        JLabel labelx = new JLabel();
        labelx.setBounds(570, 316, 130, 20);
        labelx.setFont(new Font("Tahoma",Font.PLAIN,18));

        add(labelx);
        
        
        JLabel lblxii = new JLabel("Class Xii (%)");
        lblxii.setBounds(50, 370, 130, 40);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);
        
        JLabel labelxii = new JLabel();
        labelxii.setBounds(200, 380, 130, 20);
        labelxii.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelxii);
        
        
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(400, 372, 150, 40);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);
        
        JLabel labelaadhar = new JLabel();
        labelaadhar.setBounds(570, 380, 130, 20);
        labelaadhar.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelaadhar);
        
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50, 430, 130, 40);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);
        
        
        tffcourse = new JTextField();
        tffcourse.setBounds(200, 440, 130, 20);
        tffcourse.setBackground(Color.WHITE);
        add(tffcourse);
        
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(400, 430, 150, 40);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);
        
        tffbranch = new JTextField();
        tffbranch.setBounds(570, 444, 130, 20);
        tffbranch.setBackground(Color.WHITE);
        add(tffbranch);
        
        try{
          Connect c = new Connect();
          String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
          ResultSet rs = c.s.executeQuery(query);
          while(rs.next()){
              lblname.setText(rs.getString("name"));
              labelfname.setText(rs.getString("fname"));
              dob.setText(rs.getString("dob"));
              tfaddress.setText(rs.getString("address"));
              tfphone.setText(rs.getString("phone"));
              tffemail.setText(rs.getString("email"));
              labelx.setText(rs.getString("class_x"));
              labelxii.setText(rs.getString("class_xii"));
              labelaadhar.setText(rs.getString("aadhar"));
              lbelroll.setText(rs.getString("rollno"));
              tffcourse.setText(rs.getString("course"));
              tffbranch.setText(rs.getString("branch"));
          }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        crollno.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){

                try{
                Connect c = new Connect();
                String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
              lblname.setText(rs.getString("name"));
              labelfname.setText(rs.getString("fname"));
              dob.setText(rs.getString("dob"));
              tfaddress.setText(rs.getString("address"));
              tfphone.setText(rs.getString("phone"));
              tffemail.setText(rs.getString("email"));
              labelx.setText(rs.getString("class_x"));
              labelxii.setText(rs.getString("class_xii"));
              labelaadhar.setText(rs.getString("aadhar"));
              lbelroll.setText(rs.getString("rollno"));
              tffcourse.setText(rs.getString("course"));
              tffbranch.setText(rs.getString("branch"));
          }
        }catch(Exception e){
            e.printStackTrace();
        }                
                
                
                
                
            }
        
    });
        
        
        submit = new JButton("Update");
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
            
            
            String rollno = lbelroll.getText();
            
            String address = tfaddress.getText();
            String phone =  tfphone.getText();
            String email =   tffemail.getText();

            
            String course = tffcourse.getText();
            String branch = tffbranch.getText();
            
            try{
                String query ="update student set address='"+address+"',phone ='"+phone+"',email='"+email+"',course ='"+course+"',branch='"+branch+"' where rollno ='"+rollno+"'";
                
                Connect con = new Connect();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Student Details Updated Successfully" );
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
            
            
        }else{
            dispose();
        }
    }
    
 
    
    
    public static void main(String args[]){
        new UpdateStudent();
        
    }
}
    

