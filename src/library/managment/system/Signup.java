
package library.managment.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.*;

public class Signup extends JFrame implements ActionListener{
    
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton b1,b2;
    private JComboBox comboBox;
    
    public static void main(String []args){
        new Signup().setVisible (true);
       }
    
    public Signup(){
        
        setBounds (600,250,606,406);
        contentPane =new JPanel();
        contentPane.setBorder(new EmptyBorder (5,5,5,5));
        setContentPane (contentPane);
        contentPane.setBackground(Color.white);
        contentPane.setLayout(null);
        
        JLabel lblUsername =new JLabel ("Username :");
        lblUsername.setForeground(Color.darkGray);
        lblUsername.setFont(new Font ("Tahoma",Font.BOLD,14));
        lblUsername.setBounds(99,86,92,26);
        contentPane.add(lblUsername);
        
        JLabel lblName =new JLabel ("Name :");
        lblName.setForeground(Color.darkGray);
        lblName.setFont(new Font ("Tahoma",Font.BOLD,14));
        lblName.setBounds(99,123,92,26);
        contentPane.add(lblName);
        
        JLabel lblPassword =new JLabel ("Password :");
        lblPassword.setForeground(Color.darkGray);
        lblPassword.setFont(new Font ("Tahoma",Font.BOLD,14));
        lblPassword.setBounds(99,160,92,26);
        contentPane.add(lblPassword);
        
        JLabel lblAnswer =new JLabel ("Answer :");
        lblAnswer.setForeground(Color.darkGray);
        lblAnswer.setFont(new Font ("Tahoma",Font.BOLD,14));
        lblAnswer.setBounds(99,234,92,26);
        contentPane.add(lblAnswer);

        comboBox =new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel (new String []{"Your NickName?","Your Lucky Number?",
                        "Your BestFriend?","Your Childhood name"
        }));
        
        comboBox.setBounds(265,202,148,20);
        contentPane.add(comboBox);
        
        JLabel lblSecurityQuestions =new JLabel("Security Questions :");
        lblSecurityQuestions.setForeground(Color.darkGray);
        lblSecurityQuestions.setFont(new Font ("Tahoma",Font.BOLD,14));
        lblSecurityQuestions.setBounds(99,197,140,26);
        contentPane.add(lblSecurityQuestions);
        
        textField =new JTextField();
        textField.setBounds(265,91,148,20);
        textField.setColumns(10);
        contentPane.add(textField);
        
        textField1 =new JTextField();
        textField1.setBounds(265,128,148,20);
        textField1.setColumns(10);
        contentPane.add(textField1);
        
        textField2 =new JTextField();
        textField2.setBounds(265,165,165,20);
        textField2.setColumns(10);
        contentPane.add(textField2);
        
        textField3=new JTextField();
        textField3.setBounds(265,239,148,20);
        textField3.setColumns(10);
        contentPane.add(textField3);
        
        b1=new JButton("Create");
        b1.addActionListener(this);
        b1.setFont(new Font ("Tahoma",Font.BOLD,13));
        b1.setBounds(140,289,100,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        contentPane.add(b1);
        
        b2=new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font ("Tahoma",Font.BOLD,13));
        b2.setBounds(300,289,100,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        contentPane.add(b2);
        
        
        JPanel panel =new JPanel ();
        panel.setForeground(new Color(34,139,34));
        panel.setBorder(new TitledBorder(new LineBorder (new Color (128,228,0),2),
                      "Create Account",TitledBorder.LEADING,TitledBorder.TOP,null,
                new Color(34,139,34)));
        panel.setBounds(31,46,476,296);
        panel.setBackground(Color.white);
        contentPane.add(panel);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        try{
            conn con=new conn();
            
            if (ae.getSource()==b1){
                String sql ="insert into account (username,name,password,sec_q,sec_ans)values(?,?,?,?,?)";
                PreparedStatement st =con.c.prepareStatement(sql);
                
                st.setString(1,textField.getText());
                st.setString(2,textField1.getText());
                st.setString(3,textField2.getText());
                st.setString(4,textField3.getText());
                st.setString(5,(String) comboBox.getSelectedItem());
                
                
                int i=st.executeUpdate();
                if(i>0){
                    JOptionPane.showMessageDialog(null,"Successfully Crated");
                }
                textField.setText("");
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
            }
            if (ae.getSource()==b2){
                this.setVisible(false);
                new Login_User().setVisible(true);
            }
            
        }
        catch(Exception e){
            
        }
    }
}
