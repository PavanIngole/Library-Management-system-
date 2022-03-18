package library.managment.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Loading extends JFrame implements Runnable {

    private JPanel contentPane;
    private JProgressBar progressBar;
    Connection conn;
    int s;
    Thread th;
    
    public static void main (String  args[])
    {
        new Loading().setVisible (true);
    }
    
    public void setUploading(){
        setVisible(false);
        th.start();
    }
    
    public void run(){
        try{
            for (int i=0;i<200;i++){
                s=s+1;
                int m=progressBar.getMaximum();
                int v=progressBar.getValue();
                
                if(v<m){
                    progressBar.setValue(progressBar.getValue()+1);
                }
                else{
                    i=201;
                    setVisible(false);
//                    new Home().setVisible(true);
                }
                Thread.sleep(50);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Loading(){
        super("Loadiong..");
        th=new Thread((Runnable)this);
        
        setBounds(600,300,600,400);
        contentPane =new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel l1=new JLabel("GPW LIBRARY 2022");
        l1.setForeground(Color.MAGENTA);
        l1.setFont(new Font ("Trebuchet MS",Font.BOLD,35));
        l1.setBounds(130,46,300,25);
        contentPane.add(l1);
        
        
        progressBar =new JProgressBar();
        progressBar.setFont(new Font("Tahoma",Font.BOLD,12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(130,135,300,25);
        contentPane.add(progressBar);
        
        JLabel l2=new JLabel ("Please Wait..");
        l2.setFont(new Font ("Times New Roman",Font.BOLD,20));
        l2.setForeground(Color.PINK);
        contentPane.add(l2);
        
        JPanel panel =new JPanel();
        panel.setBackground(Color.white);
        panel.setBounds(0,0,590,390);
        
        
        setUploading();
        
        
    }
    
}
