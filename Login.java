// Creating a login page for user login

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    // Declaring Variables Globally
    JLabel usr,uid,psw;
    JTextField un,uidtf;
    JPasswordField pstf;
    JButton btn1,btn2,psdbtn;
    boolean psdShow = false;

    // Create constructor..
    Login(){
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);

        //Set hotel name/ heading
        JLabel hd = new JLabel("HOTEL RR WELCOMES YOU");
        hd.setBounds(155,15,700,40);
        hd.setForeground(Color.WHITE);
        hd.setFont(new Font("serif",Font.BOLD,38));
        add(hd);

        // Label for user name
        usr = new JLabel("Username");
        usr.setBounds(90,110,170,30);
        usr.setFont(new Font("serif", Font.PLAIN,25));
        add(usr);

        // Text field for user name
        un = new JTextField();
        un.setBounds(220,110,250,35);
        add(un);

        // Label for user id
        uid = new JLabel("User ID");
        uid.setBounds(90,190,170,30);
        uid.setFont(new Font("serif", Font.PLAIN,25));
        add(uid);

        // Text field for user id
        uidtf = new JTextField();
        uidtf.setBounds(220,190,250,35);
        add(uidtf);

        // Label for password
        psw = new JLabel("Password");
        psw.setBounds(90,270,170,30);
        psw.setFont(new Font("serif", Font.PLAIN,25));
        add(psw);

        // Text field for password
        pstf = new JPasswordField();
        pstf.setBounds(220,270,170,35);
        add(pstf);

        // Adding button for showing and hiding password
        psdbtn = new JButton("Show");
        psdbtn.setBounds(400,270,70,35);
        psdbtn.setBackground(Color.BLUE);
        psdbtn.setForeground(Color.WHITE);
        psdbtn.setFont(new Font("Serif",Font.PLAIN,16));
        psdbtn.addActionListener(this);
        add(psdbtn);

        // Adding Login or forgot password buttons
        btn1 = new JButton("Login");
        btn2 = new JButton("Cancel");
        btn1.setBounds(140,345,95,40);
        btn2.setBounds(270,345,100,40);
        btn1.setBackground(Color.BLACK);
        btn2.setBackground(Color.BLACK);
        btn1.setForeground(Color.white);
        btn2.setForeground(Color.WHITE);
        btn1.setFont(new Font("serif",Font.PLAIN,18));
        btn2.setFont(new Font("serif",Font.PLAIN,18));
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        add(btn1);
        add(btn2);

        // Adding a image just for looking good
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/user.jpg"));
        JLabel img = new JLabel(i);
        img.setBounds(470,-23,360,450);
        add(img);

        // Creating frame and set visibility
        setBounds(295,140,820,450);
        setVisible(true);
    }

    // Declaring action perfoemed method for login in our database....
    public void actionPerformed(ActionEvent ae){

        if (ae.getSource() == psdbtn) {
            psdShow = !psdShow;
            if (psdShow) {
                psdbtn.setText("Hide");
                pstf.setEchoChar((char) 0);
            } else {
                psdbtn.setText("Show");
                pstf.setEchoChar('\u2022');
            }
        }

        // This is for login button.
        if(ae.getSource() == btn1){
            // Getting data of user what he/she entered for checking availability in our database...
            String user = un.getText();
            String userId = uidtf.getText();
            String pwd = pstf.getText();

            // In this try, we run query in our database through the java and chack user validation...
            try{
                Connector c = new Connector();
                String qry = "select * from logindata where userid = '" + userId +"' and password = '" + pwd + "'";
                ResultSet rs = c.stmt.executeQuery(qry);

                if(rs.next()){
                    setVisible(false);
                    new Home();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid data....");
                    setVisible(false);
                }
            }
            catch (Exception er){
                er.printStackTrace();
            }
        }
        // This is for cancel button
        else if (ae.getSource() == btn2) {
            setVisible(false);
        }
    }

    // Create main method
    public static void main(String[] args) {
        new Login();
    }
}
