// Add hotels rooms

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addRoom extends JFrame implements ActionListener {

    //Declare global data types
    JTextField rnTF,prcTF;
    JComboBox roomAvail,bedType,cleanStat;
    JButton sbmt,cncl;

    // Constructor
    addRoom(){
        setLayout(null);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/room.jpg"));
        Image i1 = i.getImage().getScaledInstance(320,320,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel img = new JLabel(i2);
        img.setBounds(600,40,320,450);
        add(img);

        // Hotel name as heading
        JLabel hName = new JLabel("HOTEL RR");
        hName.setBounds(400,15,250,40);
        hName.setFont(new Font("Tahoma",Font.PLAIN,39));
        hName.setForeground(Color.lightGray);
        add(hName);

        // Add rooms heading
        JLabel rHead = new JLabel("Add Room");
        rHead.setBounds(185,65,120,35);
        rHead.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,25));
        rHead.setForeground(Color.GRAY);
        add(rHead);

        // Add Label and textfield for room price
        JLabel rn = new JLabel("Room Number");
        rn.setBounds(100,120,130,30);
        rn.setFont(new Font("Serif",Font.PLAIN,21));
        rn.setForeground(Color.WHITE);
        add(rn);

        rnTF = new JTextField();
        rnTF.setBounds(270,120,190,25);
        add(rnTF);

        // Check availability of room
        JLabel rAvail = new JLabel("Available");
        rAvail.setBounds(100,175,110,30);
        rAvail.setForeground(Color.WHITE);
        rAvail.setFont(new Font("Serif",Font.PLAIN,21));
        add(rAvail);

        // Dropdown for choose Yes or no for room availability
        String str1[] = {"Yes","No"};
        roomAvail = new JComboBox(str1);
        roomAvail.setBounds(270,175,190,25);
        add(roomAvail);

        // Add Bed type of room
        JLabel bed = new JLabel("Bed Type");
        bed.setFont(new Font("serif",Font.PLAIN,21));
        bed.setForeground(Color.white);
        bed.setBounds(100,230,110,30);
        add(bed);

        String str2[] = {"Single Bed","Double Bed"};
        bedType = new JComboBox(str2);
        bedType.setBounds(270,230,190,25);
        add(bedType);

        // Room Cleaning status
        JLabel rc = new JLabel("Cleaning Status");
        rc.setBounds(100,285,130,30);
        rc.setForeground(Color.white);
        rc.setFont(new Font("serif",Font.PLAIN,21));
        add(rc);

        String str3[] = {"Cleaned","Dirty"};
        cleanStat = new JComboBox(str3);
        cleanStat.setBounds(270,285,190,25);
        add(cleanStat);

        // Add Label and textfield for room number
        JLabel prc = new JLabel("Price");
        prc.setBounds(100,340,130,30);
        prc.setFont(new Font("Serif",Font.PLAIN,21));
        prc.setForeground(Color.WHITE);
        add(prc);

        prcTF = new JTextField();
        prcTF.setBounds(270,340,190,25);
        add(prcTF);

        // Add submit and cancel buttons
        sbmt = new JButton("Submit");
        sbmt.setFont(new Font("serif",Font.PLAIN,24));
        sbmt.setBounds(125,425,140,38);
        sbmt.setBackground(Color.LIGHT_GRAY);
        sbmt.addActionListener(this);
        add(sbmt);

        cncl = new JButton("Cancel");
        cncl.setFont(new Font("serif",Font.PLAIN,24));
        cncl.setBounds(290,425,140,38);
        cncl.setBackground(Color.lightGray);
        cncl.addActionListener(this);
        add(cncl);

        // Background color of frame, bounds and visibility
        getContentPane().setBackground(Color.BLACK);
        setBounds(240,99,1050,535);
        setVisible(true);
    }

    // Add built-in class actionPerformed
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == sbmt){
            String roomNo = rnTF.getText();
            String availability = (String) roomAvail.getSelectedItem();
            String cleanness = (String) cleanStat.getSelectedItem();
            String bdType = (String) bedType.getSelectedItem();
            String roomPrice = prcTF.getText();

            try {
                Connector cn = new Connector();
                String qry = "insert into rooms values('"+roomNo+"','"+availability+"','"+cleanness+"','"+bdType+"','"+roomPrice+"')";
                cn.stmt.executeUpdate(qry);

                JOptionPane.showMessageDialog(null,"New Room Added Successfully.");
                setVisible(false);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }

    // Create main function
    public static void main(String[] args) {
        new addRoom();
    }
}
