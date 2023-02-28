// Creating class for show customers information....
// Import required packages.....

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame implements ActionListener {
    // Creating Jtable object
    JTable tbl;
    JButton btn;
    // Creating constructor
    CustomerInfo(){
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);

        JLabel head1 = new JLabel ("Customers Information");
        head1.setForeground(Color.CYAN);
        head1.setBackground(Color.GRAY);
        head1.setFont(new Font("Serif",Font.PLAIN,26));
        head1.setBounds(500,10,250,40);
        add(head1);

        JLabel l1 = new JLabel("ID Card Type");
        l1.setBounds(62,55,110,30);
        l1.setForeground(Color.white);
        add(l1);

        JLabel l2 = new JLabel("ID Card Number");
        l2.setForeground(Color.white);
        l2.setBounds(219,55,110,30);
        add(l2);

        JLabel l3 = new JLabel("Name");
        l3.setForeground(Color.white);
        l3.setBounds(385,55,110,30);
        add(l3);

        JLabel l4 = new JLabel("Gender");
        l4.setForeground(Color.white);
        l4.setBounds(520,55,110,30);
        add(l4);

        JLabel l5 = new JLabel("Country");
        l5.setForeground(Color.white);
        l5.setBounds(670,55,110,30);
        add(l5);

        JLabel l6 = new JLabel("Room Number");
        l6.setForeground(Color.white);
        l6.setBounds(805,55,110,30);
        add(l6);

        JLabel l7 = new JLabel("Check-in Time");
        l7.setForeground(Color.white);
        l7.setBounds(940,55,110,30);
        add(l7);

        JLabel l8 = new JLabel("Deposit Amount");
        l8.setForeground(Color.white);
        l8.setBounds(1080,55,110,30);
        add(l8);

        tbl = new JTable();
        tbl.setBounds(40,87,1155,450);
        add(tbl);

        try{
            Connector cn = new Connector();
            ResultSet rst  = cn.stmt.executeQuery("select * from customer");
            tbl.setModel(DbUtils.resultSetToTableModel(rst));
        }
        catch (Exception er){
            er.printStackTrace();
        }

        btn = new JButton("Back");
        btn.setBackground(Color.black);
        btn.setForeground(Color.white);
        btn.setBounds(555,560,120,35);
        btn.setFont(new Font("Serif",Font.PLAIN,20));
        btn.addActionListener(this);
        add(btn);

        setBounds(240,99,1250,650);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent a){
        setVisible(false);
        new Reception();
    }

    // Creating main function
    public static void main(String[] args) {
        new CustomerInfo();
    }
}