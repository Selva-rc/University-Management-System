
package university.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {
    Project(){
        setSize(1400,800);
        
          ImageIcon landing = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
          Image l1 =landing.getImage().getScaledInstance(1300, 700, Image.SCALE_DEFAULT);
          ImageIcon l2= new ImageIcon(l1);
          JLabel image = new JLabel(l2);
          //image.setBounds(500, 80, 100, 100);
          add(image);
          //MENU BAR
          JMenuBar mb = new JMenuBar();
          JMenu newInformation = new JMenu("New Information");
          newInformation.setForeground(Color.blue);
          mb.add(newInformation);
          //FACULTY INFO
          JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
          facultyInfo.addActionListener(this);
          facultyInfo.setBackground(Color.white);
          newInformation.add(facultyInfo);
          //
          JMenuItem studentInfo = new JMenuItem("New Student Information");
          studentInfo.setBackground(Color.white);
          studentInfo.addActionListener(this);
          newInformation.add(studentInfo);
          //Details
          JMenu details=new JMenu("View Details");
          details.setForeground(Color.red);
          mb.add(details);
        
          JMenuItem facultydetails=new JMenuItem("View Faculty Details");
          facultydetails.setBackground(Color.WHITE);
          facultydetails.addActionListener(this);
          details.add(facultydetails);
        
          JMenuItem studentdetails=new JMenuItem("View Student Details");
          studentdetails.setBackground(Color.WHITE);
          studentdetails.addActionListener(this);
          details.add(studentdetails);
          
          // leave
          JMenu leave=new JMenu("Apply Leave");
          leave.setForeground(Color.blue);
          mb.add(leave);
        
          JMenuItem facultyleave=new JMenuItem("Faculty Leave");
          facultyleave.setBackground(Color.WHITE);
          facultyleave.addActionListener(this);
          leave.add(facultyleave);
        
          JMenuItem studentleave=new JMenuItem("Student Leave");
          studentleave.setBackground(Color.WHITE);
          studentleave.addActionListener(this);
          leave.add(studentleave);
          
          // leave Details
          JMenu leaveDetails=new JMenu("Leave Details");
          leaveDetails.setForeground(Color.red);
          mb.add(leaveDetails);
        
          JMenuItem facultyleaveDetails=new JMenuItem("Faculty Leave Details");
          facultyleaveDetails.setBackground(Color.WHITE);
          facultyleaveDetails.addActionListener(this);
          leaveDetails.add(facultyleaveDetails);
        
          JMenuItem studentleaveDetails=new JMenuItem("Student Leave Details");
          studentleaveDetails.setBackground(Color.WHITE);
          studentleaveDetails.addActionListener(this);
          leaveDetails.add(studentleaveDetails);
          
          // exam
          JMenu exam=new JMenu("Examination");
          exam.setForeground(Color.blue);
          mb.add(exam);
        
          JMenuItem examinationDetails=new JMenuItem("Examination Results");
          examinationDetails.setBackground(Color.WHITE);
          examinationDetails.addActionListener(this);
          exam.add(examinationDetails);
        
          
          JMenuItem entermark=new JMenuItem("Enter Marks");          
          entermark.setBackground(Color.WHITE);
          entermark.addActionListener(this);
          exam.add(entermark);
          
          // update
          JMenu updateDetails=new JMenu("Update Details");
          updateDetails.setForeground(Color.red);
          mb.add(updateDetails);
        
          JMenuItem updatefaculty=new JMenuItem("Update Faculty Details");
          updatefaculty.setBackground(Color.WHITE);
          updatefaculty.addActionListener(this);
          updateDetails.add(updatefaculty);
        
          JMenuItem updatestudent=new JMenuItem("Update Student Details");
          updatestudent.setBackground(Color.WHITE);
          updatestudent.addActionListener(this);
          updateDetails.add(updatestudent);
          
          // fees details
          JMenu fee =new JMenu("Fee Details");
          fee.setForeground(Color.blue);
          mb.add(fee);
        
          JMenuItem feestructure=new JMenuItem("Fees Structure");
          feestructure.setBackground(Color.WHITE);
          feestructure.addActionListener(this);
          fee.add(feestructure);
        
          JMenuItem feeform=new JMenuItem("Student Fee Form");
          feeform.setBackground(Color.WHITE);
          feeform.addActionListener(this);
          fee.add(feeform);
          
          // Uitility
          JMenu utility =new JMenu("Utility");
          utility.setForeground(Color.red);
          mb.add(utility);
        
          JMenuItem notepad=new JMenuItem("Notepad");
          notepad.setBackground(Color.WHITE);
          notepad.addActionListener(this);
          utility.add(notepad);
        
          JMenuItem calc =new JMenuItem("Calculator");
          calc.setBackground(Color.WHITE);
          calc.addActionListener(this);
          utility.add(calc);
          
          //about
          JMenu About =new JMenu("About");
          About.setForeground(Color.blue);
          //About.addActionListener(this);
          mb.add(About);
          
          JMenuItem ab=new JMenuItem("About");
          ab.setBackground(Color.WHITE);
          ab.addActionListener(this);
          About.add(ab);
          
          
          
          // Exit
          JMenu Exit =new JMenu("Exit");
          Exit.setForeground(Color.red);
          Exit.addActionListener(this);
          mb.add(Exit);
          
          JMenuItem exit=new JMenuItem("Exit");
          exit.setBackground(Color.WHITE);
          exit.addActionListener(this);
          Exit.add(exit);
          
          
          
          setJMenuBar(mb);
        
          setVisible(true);
          
          //setJMenuBar(mb);
        
          //setVisible(true);
          
        
    }
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        
        if(msg.equals("Exit")){
            dispose();
        }else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
                
            } catch (Exception e) {
                
            }
        }else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
                
            } catch (Exception e) {
                
            }
            
        } else if(msg.equals("New Faculty Information")){
                  new  Addteacher();
                    }
                    else if(msg.equals("New Student Information")){
                        new  Addstudent();
                    }
                    else if(msg.equals("View Faculty Details")){
                        new  TeacherDetails();
                    }
                    else if(msg.equals("View Student Details")){
                        new  StudentDetails();
                    }
                    else if(msg.equals("Faculty Leave")){
                        new  TeacherLeave();
                    }
                    else if(msg.equals("Student Leave")){
                        new  StudentLeave();
                    }
                    else if(msg.equals("Faculty Leave Details")){
                        new  TeacherLeaveDetails();
                    }
                    else if(msg.equals("Student Leave Details")){
                        new  StudentLeaveDetails();
                    }
                    else if(msg.equals("Update Faculty Details")){
                        new  UpdateTeacher();
                    }
                    else if(msg.equals("Update Student Details")){
                        new  UpdateStudent();
                    }        
                    else if(msg.equals("Enter Marks")){
                        new  EnterMarks();
                    }
                    else if(msg.equals("Examination Results")){
                        new  ExaminationDetails();
                    }
                    else if(msg.equals("Fees Structure")){
                        new  FeeStructure();
                    }
                    else if(msg.equals("About")){
                        new  About();
                    }
                    else if(msg.equals("Student Fee Form")){
                        new  StudentFeeForm();
                    }
                   
        
        
    }
    
    
    public static void main(String args[]){
        new Project();
        
        
        
    }
}
