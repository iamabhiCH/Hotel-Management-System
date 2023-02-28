// Creating class for check update ( when customer checked - out the hotel room )....
// Import required libraries.......

import javax.naming.Name;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class UpdateCheck extends JFrame implements ActionListener{

    // Declare Variables globally...
    Choice ch;
    JTextField RoomNo,Name, checkIn, price,pending;
    JButton checkBtn, updateBtn, backBtn;

    // Create Constuctor......
    UpdateCheck(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel head = new JLabel("Update Customer's Status");
        head.setFont(new Font("Tahoma",Font.PLAIN,24));
        head.setBounds(370,15,280,35);
        head.setForeground(Color.BLUE);
        add(head);

        JLabel csId = new JLabel("Customer Id");
        csId.setBounds(80,75,100,30);
        csId.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(csId);

        ch = new Choice();
        ch.setBounds(215,76,165,30);
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
        csRN.setBounds(80,120,100,30);
        csRN.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(csRN);

        RoomNo = new JTextField();
        RoomNo.setBounds(215,120,165,25);
        add(RoomNo);

        JLabel csName = new JLabel("Customer Name");
        csName.setBounds(80,165,120,30);
        csName.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(csName);

        Name = new JTextField();
        Name.setBounds(215,165,165,25);
        add(Name);

        JLabel chkIn = new JLabel("Checkin Time");
        chkIn.setBounds(80,205,120,30);
        chkIn.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(chkIn);

        checkIn = new JTextField();
        checkIn.setBounds(215,205,165,25);
        add(checkIn);

        JLabel prc = new JLabel("Amount Paid");
        prc.setBounds(80,250,120,30);
        prc.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(prc);

        price = new JTextField();
        price.setBounds(215,250,165,25);
        add(price);

        JLabel pendingAmt = new JLabel("Pending Amount");
        pendingAmt.setBounds(80,295,120,30);
        pendingAmt.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(pendingAmt);

        pending = new JTextField();
        pending.setBounds(215,298,165,25);
        add(pending);

        checkBtn = new JButton("Check");
        checkBtn.setBounds(100,368,110,35);
        checkBtn.setFont(new Font("Tahoma",Font.PLAIN,17));
        checkBtn.setForeground(Color.white);
        checkBtn.setBackground(Color.black);
        checkBtn.addActionListener(this);
        add(checkBtn);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(240,368,110,35);
        updateBtn.setFont(new Font("Tahoma",Font.PLAIN,17));
        updateBtn.setForeground(Color.white);
        updateBtn.setBackground(Color.black);
        updateBtn.addActionListener(this);
        add(updateBtn);

        backBtn = new JButton("Cancel");
        backBtn.setBounds(175,445,110,35);
        backBtn.setFont(new Font("Tahoma",Font.PLAIN,17));
        backBtn.setForeground(Color.white);
        backBtn.setBackground(Color.black);
        backBtn.addActionListener(this);
        add(backBtn);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/customer1.jpeg"));
        Image i1 = i.getImage().getScaledInstance(370,400,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel img = new JLabel(i2);
        img.setBounds(515,82,370,400);
        add(img);

        setBounds(240,99,1000,600);
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
                    Name.setText(rs.getString("Name"));
                    checkIn.setText(rs.getString("Check_in_Time"));
                    price.setText(rs.getString("Deposit_Amt"));
                }

                ResultSet rs1 = cn.stmt.executeQuery("select * from rooms where Room_No = '"+RoomNo.getText()+"'");
                while(rs1.next()){
                    String price1 = rs1.getString("Price");
                    int amtPaid = Integer.parseInt(price1) - Integer.parseInt(price.getText());
                    pending.setText("" + amtPaid);
                }

            }catch (Exception er){
                er.printStackTrace();
            }
        }
        else if(ae.getSource() == updateBtn){

            String numb = ch.getSelectedItem();
            String room = RoomNo.getText();
            String name = Name.getText();
            String check_in = checkIn.getText();
            String deposit = price.getText();

            try{
                Connector cn = new Connector();
                cn.stmt.executeUpdate("update customer set Room_No = '"+room+"', Name = '"+name+"', Check_in_Time = '"+check_in+"', Deposit_Amt = '"+deposit+"' whwere ID_No = '"+numb+"'");
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
        new UpdateCheck();
    }
}
