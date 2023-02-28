// Creating  Class for rooms....
// import required packages.....

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Rooms extends JFrame implements ActionListener {
    // Creating Jtable object
    JTable tbl;
    JButton btn;
    // Creating constructor
    Rooms(){
        getContentPane().setBackground(Color.black);
        setLayout(null);

        JLabel rInfo = new JLabel("All Rooms Information");
        rInfo.setBackground(Color.BLACK);
        rInfo.setForeground(Color.lightGray);
        rInfo.setFont(new Font("Serif",Font.PLAIN,25));
        rInfo.setBounds(430,10,260,35);
        add(rInfo);

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(35,55,110,30);
        l1.setForeground(Color.white);
        add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setForeground(Color.white);
        l2.setBounds(136,55,110,30);
        add(l2);

        JLabel l3 = new JLabel("Cleaning Status");
        l3.setForeground(Color.white);
        l3.setBounds(235,55,110,30);
        add(l3);

        JLabel l4 = new JLabel("Bed Type");
        l4.setForeground(Color.white);
        l4.setBounds(340,55,110,30);
        add(l4);

        JLabel l5 = new JLabel("Price");
        l5.setForeground(Color.white);
        l5.setBounds(440,55,110,30);
        add(l5);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/room12.jpg"));
        Image i1 = i.getImage().getScaledInstance(390,450,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel img = new JLabel(i2);
        img.setBounds(600,60,390,450);
        add(img);

        tbl = new JTable();
        tbl.setBounds(35,85,500,400);
        add(tbl);

        try{
            Connector cn = new Connector();
            ResultSet rst  = cn.stmt.executeQuery("select * from rooms");
            tbl.setModel(DbUtils.resultSetToTableModel(rst));
        }
        catch (Exception er){
            er.printStackTrace();
        }

        btn = new JButton("Back");
        btn.setBackground(Color.gray);
        btn.setForeground(Color.white);
        btn.setBounds(416,525,120,35);
        btn.setFont(new Font("Serif",Font.PLAIN,20));
        btn.addActionListener(this);
        add(btn);

        setBounds(240,99,1050,650);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent a){
        setVisible(false);
        new Reception();
    }

    // Creating main function
    public static void main(String[] args) {
        new Rooms();
    }
}
