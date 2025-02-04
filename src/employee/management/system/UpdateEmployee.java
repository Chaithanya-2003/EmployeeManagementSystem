package employee.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;

public class UpdateEmployee extends JFrame implements ActionListener {
    
    
    
    
    JTextField tfname,tfeducation,tffname,tfsalary,tfaddress,tfphone,tfemail,tfdesignation,tfanumber,tfdob;
    JDateChooser dcdob;
    JLabel lblempId;
    JButton add,back;
    String empId;
    
    UpdateEmployee(String empId){
        this.empId = empId;
        getContentPane().setBackground(new Color(163,255,188));
        setLayout(null);
        
        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("san serif",Font.BOLD,25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);
        
//        JLabel lblname = new JLabel();
//        lblname.setBounds(200,150,150,30);
//        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldob);
        
//        JLabel lbldob = new JLabel();
//        lbldob.setBounds(200,200,150,30);
//        add(lbldob);

        tfdob = new JTextField();
        tfdob.setBounds(200,200,150,30);
        add(tfdob);
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN,20));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("serif",Font.PLAIN,20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        JLabel labelphone = new JLabel("Phone Number");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("serif",Font.PLAIN,20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400,300,150,30);
        labeleducation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeleducation);
        
        
        
        tfeducation = new JTextField();
        tfeducation.setBounds(600,300,150,30);
        add(tfeducation);
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);
        
        JLabel labelanumber = new JLabel("Aadhar Number");
        labelanumber.setBounds(400,350,150,30);
        labelanumber.setFont(new Font("serif",Font.PLAIN,20));
        add(labelanumber);
        
//        JLabel lblaadhar = new JLabel();
//        lblaadhar.setBounds(600,350,150,30);
//        add(lblaadhar);

        tfanumber = new JTextField();
        tfanumber.setBounds(600,350,150,30);
        add(tfanumber);
        
        JLabel labelempId = new JLabel("Employee ID");
        labelempId.setBounds(50,400,150,30);
        labelempId.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempId);
        
        lblempId = new JLabel();
        lblempId.setBounds(200,400,150,30);
        lblempId.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempId);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where empId=?";
            c.pstmt=c.con.prepareStatement(query);
            c.pstmt.setString(1, empId);
            ResultSet rs = c.pstmt.executeQuery();
            //ResultSet rs=c.stmt.executeQuery(query);
            while(rs.next()){
                tfname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                tfdob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                tfdesignation.setText(rs.getString("designation"));
                tfanumber.setText(rs.getString("aadhar"));
                lblempId.setText(rs.getString("empId"));

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        add = new JButton("Update Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        add(back);
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = tfdob.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();
            String aadhar = tfanumber.getText();
            
            try{
                Conn conn = new Conn();
                String query = "UPDATE employee SET name = ?,fname = ?, dob = ?,salary = ?, address = ?, phone = ?, email = ?, education = ?, designation = ?, aadhar = ? WHERE empId = ?";
                PreparedStatement pstmt = conn.con.prepareStatement(query);

                pstmt.setString(1, name);
                pstmt.setString(2, fname);
                pstmt.setString(3, dob);
                pstmt.setString(4, salary);
                pstmt.setString(5, address);
                pstmt.setString(6, phone);
                pstmt.setString(7, email);
                pstmt.setString(8, education);
                pstmt.setString(9, designation);
                pstmt.setString(10, aadhar);
                pstmt.setString(11, empId);
                
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Details Updated successfully");
                setVisible(false);
                new Home();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}