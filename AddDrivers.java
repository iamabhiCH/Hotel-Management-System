// Add Drivers for hotel services

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDrivers extends JFrame implements ActionListener {

    //Declare global data types
    JTextField nameTF,ageTF,carModel,carBrand,contactNo,licenceNo;
    JButton sbmt,cncl;
    JRadioButton bMale,bFemale;

    // Constructor
    AddDrivers(){
        setLayout(null);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/driver.jpg"));
        Image i1 = i.getImage().getScaledInstance(470,320,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel img = new JLabel(i2);
        img.setBounds(520,40,470,450);
        add(img);

        // Hotel name as heading
        JLabel hName = new JLabel("HOTEL RR");
        hName.setBounds(355,15,250,40);
        hName.setFont(new Font("Tahoma",Font.PLAIN,39));
        hName.setForeground(Color.lightGray);
        add(hName);

        // Add driver heading
        JLabel rHead = new JLabel("Add Driver");
        rHead.setBounds(185,60,120,35);
        rHead.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,25));
        rHead.setForeground(Color.GRAY);
        add(rHead);

        // Add Label and textfield for getting the name of driver
        JLabel name = new JLabel("Name");
        name.setBounds(100,115,130,30);
        name.setFont(new Font("Serif",Font.PLAIN,21));
        name.setForeground(Color.WHITE);
        add(name);

        nameTF = new JTextField();
        nameTF.setBounds(270,115,190,25);
        add(nameTF);

        // Add Driver's Age
        JLabel dAge = new JLabel("Age");
        dAge.setBounds(100,155,110,30);
        dAge.setForeground(Color.WHITE);
        dAge.setFont(new Font("Serif",Font.PLAIN,21));
        add(dAge);

        // Textfield for Driver's age
        ageTF = new JTextField();
        ageTF.setBounds(270,155,190,25);
        add(ageTF);

        // Add driver's gender
        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("serif",Font.PLAIN,21));
        gender.setForeground(Color.white);
        gender.setBounds(100,195,110,30);
        add(gender);

        // Radio buttons for male and female
        bMale = new JRadioButton("Male");
        bMale.setBackground(Color.black);
        bMale.setForeground(Color.white);
        bMale.setBounds(270,195,60,25);
        bMale.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(bMale);

        bFemale = new JRadioButton("Female");
        bFemale.setBackground(Color.black);
        bFemale.setForeground(Color.white);
        bFemale.setBounds(340,195,70,25);
        bFemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(bFemale);

        // Add buttons in a group
        ButtonGroup bg = new ButtonGroup();
        bg.add(bMale);
        bg.add(bFemale);

        // Driver's car brand name
        JLabel cc = new JLabel("Car Company");
        cc.setBounds(100,235,130,30);
        cc.setForeground(Color.white);
        cc.setFont(new Font("serif",Font.PLAIN,21));
        add(cc);

        carBrand = new JTextField();
        carBrand.setBounds(270,235,190,25);
        add(carBrand);

        // Driver's Car Model
        JLabel cm = new JLabel("Car Model");
        cm.setBounds(100,275,130,30);
        cm.setFont(new Font("Serif",Font.PLAIN,21));
        cm.setForeground(Color.WHITE);
        add(cm);

        carModel = new JTextField();
        carModel.setBounds(270,275,190,25);
        add(carModel);

        // Driver's Car Model
        JLabel contact = new JLabel("Contact");
        contact.setBounds(100,315,130,30);
        contact.setFont(new Font("Serif",Font.PLAIN,21));
        contact.setForeground(Color.WHITE);
        add(contact);

        contactNo = new JTextField();
        contactNo.setBounds(270,315,190,25);
        add(contactNo);

        // Driver's Car Model
        JLabel lcno = new JLabel("Licence No");
        lcno.setBounds(100,355,130,30);
        lcno.setFont(new Font("Serif",Font.PLAIN,21));
        lcno.setForeground(Color.WHITE);
        add(lcno);

        licenceNo = new JTextField();
        licenceNo.setBounds(270,355,190,25);
        add(licenceNo);

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
        setBounds(240,99,1050,550);
        setVisible(true);
    }

    // Add built-in class actionPerformed
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == sbmt){
            String drvName = nameTF.getText();
            String drvAge = ageTF.getText();
            String drvGender = null;
            String drvCar = carBrand.getText();
            String drvCarModel = carModel.getText();
            String phone = contactNo.getText();
            String lcncNo = licenceNo.getText();

            if(bMale.isSelected()){
                drvGender = "Male";
            } else if (bFemale.isSelected()) {
                drvGender = "Female";
            }

            if(drvName.equals("")){
                JOptionPane.showMessageDialog(null,"Name should not be empty.");
                return;
            }
            if(drvAge.equals("")){
                JOptionPane.showMessageDialog(null,"Age should not be empty.");
                return;
            }
            if(drvCar.equals("")){
                JOptionPane.showMessageDialog(null,"Car Company name is required.");
                return;
            }
            if(drvCarModel.equals("")){
                JOptionPane.showMessageDialog(null,"Car Model should not be empty.");
                return;
            }
            if(phone.equals("")){
                JOptionPane.showMessageDialog(null,"Driver's Contact Number is required.");
                return;
            }
            if(lcncNo.equals("")){
                JOptionPane.showMessageDialog(null,"Driver's Licence Number is required.");
                return;
            }

            // Store driver data in Database
            try {
                Connector cn = new Connector();
                String qry = "insert into drivers values('"+drvName+"','"+drvAge+"','"+drvGender+"','"+drvCar+"','"+drvCarModel+"','"+phone+"','"+lcncNo+"')";
                cn.stmt.executeUpdate(qry);

                JOptionPane.showMessageDialog(null,"New Driver Added Successfully.");
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
        new AddDrivers();
    }
}
