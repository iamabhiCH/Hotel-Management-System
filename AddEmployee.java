// Class for add employee for the hotel

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {

    // Declare variables globally
    JLabel eName,eAge,eGender,job,eSal,ePhn,eMail,eAadhar;
    JTextField nameTf,ageTf,salTf,phnTf,emlTf,aadharTf;
    JRadioButton bMale,bFemale;
    JButton sbmt;
    JComboBox drpdwn;

    // Create constructor
    AddEmployee(){
        setLayout(null);

        // Image
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/staff2.jpg"));
        Image i2 = i.getImage().getScaledInstance(400,310,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(445,105,400,310);
        add(img);

        // Hotel name as heading
        JLabel hName = new JLabel("HOTEL RR");
        hName.setBounds(355,15,250,40);
        hName.setFont(new Font("Tahoma",Font.PLAIN,39));
        add(hName);

        // Heading for add new employee
        JLabel head = new JLabel("Add New Employee");
        head.setBounds(138,59,250,35);
        head.setFont(new Font("Tahoma",Font.PLAIN,21));
        add(head);

        // Taking new employee name
        eName = new JLabel("NAME");
        eName.setBounds(90,105,80,25);
        eName.setFont(new Font("Tahoma",Font.PLAIN,19));
        add(eName);

        nameTf = new JTextField();
        nameTf.setBounds(210,105,199,25);
        add(nameTf);

        // Taking new employee aadhar no...
        eAadhar = new JLabel("AADHAR");
        eAadhar.setBounds(90,145,80,25);
        eAadhar.setFont(new Font("Tahoma",Font.PLAIN,19));
        add(eAadhar);

        aadharTf = new JTextField();
        aadharTf.setBounds(210,145,199,25);
        add(aadharTf);

        // Taking employee age
        eAge = new JLabel("AGE");
        eAge.setBounds(90,185,80,25);
        eAge.setFont(new Font("Tahoma",Font.PLAIN,19));
        add(eAge);

        ageTf = new JTextField();
        ageTf.setBounds(210,185,199,25);
        add(ageTf);

        //Taking employee gender
        eGender = new JLabel("GENDER");
        eGender.setBounds(90,225,80,25);
        eGender.setFont(new Font("Tahoma",Font.PLAIN,19));
        add(eGender);

        // Radio buttons for male and female
        bMale = new JRadioButton("Male");
        bMale.setBackground(Color.lightGray);
        bMale.setBounds(210,225,60,25);
        bMale.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(bMale);

        bFemale = new JRadioButton("Female");
        bFemale.setBackground(Color.lightGray);
        bFemale.setBounds(280,225,70,25);
        bFemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(bFemale);

        // Add buttons in a group
        ButtonGroup bg = new ButtonGroup();
        bg.add(bMale);
        bg.add(bFemale);

        // Add Job Type
        job = new JLabel("JOB");
        job.setBounds(90,265,70,25);
        job.setFont(new Font("Tahoma",Font.PLAIN,19));
        add(job);

        // Create dropdown list of job types
        String str[] = {"Accountant","Chef","Front Desk Clerks","House Keeping","Kitchen Staff","Manager","Porters","Room Services","Waiter / Waitress"};
        drpdwn = new JComboBox(str);
        drpdwn.setBounds(210,265,198,25);
        add(drpdwn);

        // Assign employee salary
        eSal = new JLabel("SALARY");
        eSal.setBounds(90,305,80,25);
        eSal.setFont(new Font("Tahoma",Font.PLAIN,19));
        add(eSal);

        salTf = new JTextField();
        salTf.setBounds(210,305,199,25);
        add(salTf);

        // Taking employee phone
        ePhn = new JLabel("PHONE");
        ePhn.setBounds(90,345,80,25);
        ePhn.setFont(new Font("Tahoma",Font.PLAIN,19));
        add(ePhn);

        phnTf = new JTextField();
        phnTf.setBounds(210,345,199,25);
        add(phnTf);

        // Taking employee email
        eMail = new JLabel("EMAIL");
        eMail.setBounds(90,385,80,25);
        eMail.setFont(new Font("Tahoma",Font.PLAIN,19));
        add(eMail);

        emlTf = new JTextField();
        emlTf.setBounds(210,385,199,25);
        add(emlTf);

        // Submit Button

        sbmt = new JButton("SUBMIT");
        sbmt.setBounds(170,445,150,40);
        sbmt.setForeground(Color.WHITE);
        sbmt.setBackground(Color.BLACK);
        sbmt.setFont(new Font("Serif",Font.BOLD,20));
        sbmt.addActionListener(this);
        add(sbmt);

        // Background color of frame, bounds and visibility
        getContentPane().setBackground(Color.lightGray);
        setBounds(240,99,900,550);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        // Getting information for save in our database from the user...

        String name = nameTf.getText();
        String age = ageTf.getText();
        String aadhar = aadharTf.getText();
        String salary =  salTf.getText();
        String phone = phnTf.getText();
        String email = emlTf.getText();
        String gender = null;
        String job = (String) drpdwn.getSelectedItem();

        if(bMale.isSelected()){
            gender = "Male";
        }
        else if(bFemale.isSelected()){
            gender = "Female";
        }

        // Use Validation (chack any value is not equals to null)

        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Name should not be empty.");
            return;
        }
        if(aadhar.equals("")){
            JOptionPane.showMessageDialog(null,"Aadhar Number required.");
            return;
        }
        if(age.equals("")){
            JOptionPane.showMessageDialog(null,"Age should not be empty.");
            return;
        }
        if(salary.equals("")){
            JOptionPane.showMessageDialog(null,"Salary Amount required.");
            return;
        }
        if(phone.equals("")){
            JOptionPane.showMessageDialog(null,"Phone should not be empty.");
            return;
        }
        if(email.equals("")){
            JOptionPane.showMessageDialog(null,"Email should not be empty.");
            return;
        }

        try {
            Connector cn = new Connector();

            String qry = "insert into employee values('"+name+"','"+aadhar+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"')";
            cn.stmt.executeUpdate(qry);

            JOptionPane.showMessageDialog(null,"Employee Added Successfully.");
            setVisible(false);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    // Main method
    public static void main(String[] args) {
        new AddEmployee();
    }
}
