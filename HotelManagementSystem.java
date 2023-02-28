//Import Packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementSystem extends JFrame implements ActionListener {

    // Creating Constructor...
    HotelManagementSystem(){
        // Create window / frame
        setBounds(150,65,1220,680);
        // Set image on frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/b2.jpg"));
        JLabel img = new JLabel(i1);
        img.setBounds(0,0,1220,680);
        add(img);

        // Add text on Image
        JLabel txt = new JLabel("HOTEL MANAGEMENT SYSTEM");
        txt.setBounds(40,40,800,40);
        txt.setForeground(Color.WHITE);
        txt.setFont(new Font("serif",Font.PLAIN,50));
        img.add(txt);

        //Set button for next
        JButton btn = new JButton("Next >>");
        btn.setBounds(1020,580,150,50);
        btn.setBackground(Color.YELLOW);
        btn.setForeground(Color.RED);
        btn.addActionListener(this);
        btn.setFont(new Font("serif",Font.PLAIN,25));
        img.add(btn);


        // Set visibility of frame
        setVisible(true);

        // Make our heading dipper....
        while(true){
            txt.setVisible(false);
            try {
                Thread.sleep(500);
            }
            catch (Exception er){
                er.printStackTrace();
            }
            txt.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch (Exception er){
                er.printStackTrace();
            }
        }
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }

    // Creating main method for the class....
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}
