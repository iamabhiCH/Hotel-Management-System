// Creating class for customer checkout.......
// Import required libraries...

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener {
    // Declare global variables
    Choice cId;
    JLabel roomNo,chkTime,chkOut;
    JButton checkOutBtn,back;
    Checkout(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        // Add image for covering blank space
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/flower.jpg"));
        Image i1 = i.getImage().getScaledInstance(250,330,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel img = new JLabel(i2);
        img.setBounds(499,65,250,330);
        add(img);

        JLabel h1 = new JLabel("Coustomer Checkout");
        h1.setForeground(Color.BLUE);
        h1.setFont(new Font("Serif",Font.BOLD,23));
        h1.setBounds(335,15,250,35);
        add(h1);

        JLabel cstId = new JLabel("Customer ID");
        cstId.setBounds(75,75,100,25);
        cstId.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(cstId);

        cId = new Choice();
        cId.setBounds(225,75,150,25);
        cId.setBackground(Color.white);
        add(cId);

        JLabel room = new JLabel("Room Number");
        room.setBounds(75,135,150,25);
        room.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(room);

        roomNo = new JLabel();
        roomNo.setBounds(225,135,110,25);
        add(roomNo);

        JLabel checkin = new JLabel("Check-In Time");
        checkin.setBounds(75,195,150,25);
        checkin.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(checkin);

        chkTime = new JLabel();
        chkTime.setBounds(225,195,110,25);
        add(chkTime);

        JLabel checkout = new JLabel("Check-Out Time");
        checkout.setBounds(75,255,150,25);
        checkout.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(checkout);

        Date dt = new Date();
        chkOut = new JLabel(""+dt);
        chkOut.setBounds(225,255,150,25);
        add(chkOut);

        checkOutBtn = new JButton("Checkout");
        checkOutBtn.setBackground(Color.LIGHT_GRAY);
        checkOutBtn.setFont(new Font("Tahoma",Font.BOLD,18));
        checkOutBtn.setBounds(100,330,135,30);
        checkOutBtn.addActionListener(this);
        add(checkOutBtn);

        back = new JButton("Back");
        back.setBackground(Color.LIGHT_GRAY);
        back.setFont(new Font("Tahoma",Font.BOLD,18));
        back.addActionListener(this);
        back.setBounds(272,330,100,30);
        add(back);

        try{
            Connector cn = new Connector();
            ResultSet rs = cn.stmt.executeQuery("select * from customer");
            while(rs.next()){
                cId.add(rs.getString("ID_No"));
                roomNo.setText(rs.getString("Room_No"));
                chkTime.setText(rs.getString("Check_in_Time"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        setBounds(310,120,850,480);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkOutBtn){
            try{
                String qry1 = "delete from customer where ID_No = '"+cId.getSelectedItem()+"'";
                String qry2 = "update rooms set availability = 'Yes' where Room_No = '"+roomNo.getText()+"' ";

                Connector cn = new Connector();
                cn.stmt.executeUpdate(qry1);
                cn.stmt.executeUpdate(qry2);

                JOptionPane.showMessageDialog(null,"Customer Checked Out Successfully.");
                setVisible(false);
                new Reception();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new Checkout();
    }
}
