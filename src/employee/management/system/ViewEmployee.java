package employee.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewEmployee extends JFrame implements ActionListener {
    
    JTable table;
    Choice cemployeeId;
    JButton search,print,update,back;

    ViewEmployee() {
        
        JLabel searchlbl = new JLabel("Search by Employee Id");
        searchlbl.setBounds(20,20,150,20);
        add(searchlbl);
        
        cemployeeId = new Choice();
        cemployeeId.setBounds(180,20,150,20);
        add(cemployeeId);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee";
            c.pstmt = c.con.prepareStatement(query);
            ResultSet rs = c.pstmt.executeQuery();
            while(rs.next()){
                cemployeeId.add(rs.getString("empId"));
            }     
        }catch(Exception e){
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try{
            Conn c = new Conn();
            String query = "select * from employee";
            c.pstmt = c.con.prepareStatement(query);
            ResultSet rs = c.pstmt.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);
        
        setSize(900,700);
        setLocation(300,100);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            Conn c = new Conn();
            String query = "select * from employee where empId=?";
            try{
                c.pstmt = c.con.prepareStatement(query);
                c.pstmt.setString(1, cemployeeId.getSelectedItem());
                ResultSet rs = c.pstmt.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==update){
            setVisible(false);
            new UpdateEmployee(cemployeeId.getSelectedItem());
        }else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args) {
        
        new ViewEmployee();
        
    }
}
