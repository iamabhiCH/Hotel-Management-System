// Create class for update room status ...... ( like - cleaning and availabiliy).
// Import required libraries.......

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class UpdateRoomStatus extends JFrame implements ActionListener{

    // Declare Variables globally...
    Choice ch;
    JTextField RoomNo,available, cleanStatus;
    JButton checkBtn, updateBtn, backBtn;

    // Create Constuctor......
    UpdateRoomStatus(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel head = new JLabel("Update Room Status");
        head.setFont(new Font("Tahoma",Font.PLAIN,24));
        head.setBounds(370,15,280,35);
        head.setForeground(Color.BLUE);
        add(head);

        JLabel csId = new JLabel("Customer Id");
        csId.setBounds(80,98,100,30);
        csId.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(csId);

        ch = new Choice();
        ch.setBounds(215,100,165,30);
        add(ch);

        try{
            Connector cn = new Connector();
            ResultSet rs = cn.stmt.executeQuery("select * from customer");

            while(rs.next()){
                ch.add(rs.getString("ID_No"));
            }
        }
        catch(Exception er){
            er.printStackTrace();
        }

        JLabel csRN = new JLabel("Room Number");
        csRN.setBounds(80,155,100,30);
        csRN.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(csRN);

        RoomNo = new JTextField();
        RoomNo.setBounds(215,155,165,25);
        add(RoomNo);

        JLabel csName = new JLabel("Availability");
        csName.setBounds(80,210,120,30);
        csName.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(csName);

        available = new JTextField();
        available.setBounds(215,210,165,25);
        add(available);

        JLabel chkIn = new JLabel("Cleaning Status");
        chkIn.setBounds(80,265,120,30);
        chkIn.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(chkIn);

        cleanStatus = new JTextField();
        cleanStatus.setBounds(215,265,165,25);
        add(cleanStatus);

        checkBtn = new JButton("Check");
        checkBtn.setBounds(100,330,110,35);
        checkBtn.setFont(new Font("Tahoma",Font.PLAIN,17));
        checkBtn.setForeground(Color.white);
        checkBtn.setBackground(Color.black);
        checkBtn.addActionListener(this);
        add(checkBtn);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(240,330,110,35);
        updateBtn.setFont(new Font("Tahoma",Font.PLAIN,17));
        updateBtn.setForeground(Color.white);
        updateBtn.setBackground(Color.black);
        updateBtn.addActionListener(this);
        add(updateBtn);

        backBtn = new JButton("Cancel");
        backBtn.setBounds(175,395,110,35);
        backBtn.setFont(new Font("Tahoma",Font.PLAIN,17));
        backBtn.setForeground(Color.white);
        backBtn.setBackground(Color.black);
        backBtn.addActionListener(this);
        add(backBtn);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/customer1.jpeg"));
        Image i1 = i.getImage().getScaledInstance(370,350,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel img = new JLabel(i2);
        img.setBounds(515,72,370,350);
        add(img);

        setBounds(280,109,1000,500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkBtn){
            try{
                String id = ch.getSelectedItem();
                String qry = "select * from customer where ID_No = '"+id+"'";

                Connector cn = new Connector();
                ResultSet rs = cn.stmt.executeQuery(qry);

                while(rs.next()){
                    RoomNo.setText(rs.getString("Room_No"));
                }

                ResultSet rs1 = cn.stmt.executeQuery("select * from rooms where Room_No = '"+RoomNo.getText()+"'");
                while(rs1.next()){
                    available.setText(rs1.getString("Availability"));
                    cleanStatus.setText(rs1.getString("Cleaning_Status"));
                }

            }catch (Exception er){
                er.printStackTrace();
            }
        }
        else if(ae.getSource() == updateBtn){

            String numb = ch.getSelectedItem();
            String room = RoomNo.getText();
            String avl = available.getText();
            String status = cleanStatus.getText();

            try{
                Connector cn = new Connector();
                cn.stmt.executeUpdate("update rooms set availability = '"+avl+"', cleaning_status = '"+status+"' where room_no = '"+room+"'");
                JOptionPane.showMessageDialog(null, "Data Updated Successfully.");

                setVisible(false);
                new Reception();
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource() == backBtn){
            setVisible(false);
            new Reception();
        }
    }

    // Create main method..
    public static void main(String[] args) {
        new UpdateRoomStatus();
    }
}
