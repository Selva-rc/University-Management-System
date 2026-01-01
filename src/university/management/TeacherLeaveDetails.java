
package university.management;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherLeaveDetails extends JFrame implements ActionListener {
    Choice creempid;
    JTable table;
    JButton search,print,cancel;
    TeacherLeaveDetails(){
        
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Employee Id ");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        creempid = new Choice();
        creempid.setBounds(180, 20, 150, 20);
        add(creempid);
        
        
        
        try{
            Connect c = new Connect();
            ResultSet rs =c.s.executeQuery("select*from teacher");
            while(rs.next()){
                creempid.add(rs.getString("empId"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        table = new JTable();
            try{
            Connect c = new Connect();
            ResultSet rs =c.s.executeQuery("select * from teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));{
            creempid.add(rs.getString("empId"));
            }
            }catch(Exception e){
                e.printStackTrace();
            }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 700, 600);
        add(jsp);
        
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        

        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(700,500);
        setLocation(250,60);
        setVisible(true);
        
    }
    
    
   public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== search){
            String query = "select * from teacherleave where empId ='"+creempid.getSelectedItem()+"'";
            try{
                Connect c = new Connect();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()== print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }

        }else{
            dispose();
        }
    
    }
   
    public static void main(String[] args) {
        new TeacherLeaveDetails();
    }
}
