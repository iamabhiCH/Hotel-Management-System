// Creating Home Page or Dashboard

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    // We write our all code in constructor
    Home(){
        // Create frame
        setBounds(0,0,1550,1000);
        setLayout(null);

        // Set background image
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/hotel.jpg"));
        Image i1 = i.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel img = new JLabel(i2);
        img.setBounds(0,0,1500,1000);
        add(img);

        // Hotel name / heading
        JLabel txt = new JLabel("HOTEL RR WELCOMES YOU");
        txt.setBounds(7,50,900,70);
        txt.setFont(new Font("serif", Font.BOLD,55));
        txt.setForeground(Color.CYAN);
        img.add(txt);

        // Create menubar
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,50);
        mb.setBackground(Color.black);
        img.add(mb);

        // Cretate menu 1
        JMenu mn1 = new JMenu("Hotel Management");
        mn1.setBounds(0,0,100,45);
        mn1.setFont(new Font("serif",Font.PLAIN,18));
        mn1.setForeground(Color.RED);
        mb.add(mn1);

        // Add menuitem Reception
        JMenuItem rec = new JMenuItem("Reception");
        rec.addActionListener(this);
        mn1.add(rec);

        // Cretae menu 2
        JMenu mn2 = new JMenu("Admin");
        mn2.setBounds(100,0,100,45);
        mn2.setFont(new Font("serif",Font.PLAIN,18));
        mn2.setForeground(Color.blue);
        mb.add(mn2);

        // Add menuitem Add Employee
        JMenuItem addEmp = new JMenuItem("Add Employee");
        addEmp.addActionListener(this);
        mn2.add(addEmp);

        // Add menuitem Add Rooms
        JMenuItem addRoom = new JMenuItem("Add Rooms");
        addRoom.addActionListener(this);
        mn2.add(addRoom);

        // Add menuitem Add drivers
        JMenuItem addDvr = new JMenuItem("Add Drivers");
        addDvr.addActionListener(this);
        mn2.add(addDvr);

        // Set Visibility
        setVisible(true);
    }

    // Add built-in fn. actionPerformed
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Add Employee")){
            new AddEmployee();
        }
        else if(ae.getActionCommand().equals("Add Rooms")){
            new addRoom();
        }
        else if (ae.getActionCommand().equals("Add Drivers")) {
            new AddDrivers();
        }
        else if(ae.getActionCommand().equals("Reception")){
            new Reception();
        }
    }

    // Create main method...
    public static void main(String[] args) {
        new Home();
    }
}