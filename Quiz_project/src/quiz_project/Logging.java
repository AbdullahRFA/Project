package quiz_project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Logging extends JFrame implements ActionListener {
        JButton rules,back;
        JTextField tfName;
    Logging() {
        getContentPane().setBackground(Color.WHITE);//background er by default color change 
        setLayout(null);//nijer lay out create korar jonne
        //set image
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Icon/login.jpeg"));//Image read from directory
        JLabel image = new JLabel(img);//farme er upor image add korar jonne.
        //muloto JLabel use kora hoi frame er upor jekono hedding likhar jonne
        image.setBounds(0, 0, 600, 500);
        add(image);
        //add funtion use for adding something on the frame 

        //lebel for Quiz_Exam
        JLabel headding = new JLabel("Quiz_Game");
        headding.setFont(new Font("Algerian", Font.BOLD, 40));//headding er font type and size
        headding.setForeground(Color.red);
        headding.setBounds(750, 60, 300, 35);
        add(headding);

         //lebel for Warm_Up_Your_Brain
        JLabel sub_headding = new JLabel("Warm_Up_Your_Brain");
        sub_headding.setFont(new Font("Blackadder ITC", Font.BOLD, 25));//headding er font type and size
        sub_headding.setForeground(Color.red);
        sub_headding.setBounds(750, 100, 300, 35);
        add(sub_headding);
        
        
        //lebel for user name
        JLabel name = new JLabel("Enter Your Name");
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));//headding er font type and size
        name.setForeground(Color.red);
        name.setBounds(810, 150, 300, 20);
        add(name);

        //For User name box
        tfName = new JTextField();
        tfName.setBounds(750, 200, 300, 25);
        tfName.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfName);

        //Add rules button
        rules = new JButton("Rules");
        rules.setBounds(735,270,120,25);
        rules.setBackground(Color.yellow);//color of button background
        rules.setForeground(Color.black);//color of button text
        rules.setFont(new Font("Time New Roman",Font.BOLD,18));//font of button text
        rules.addActionListener(this);//identifiy that rules button is clicked
        add(rules);//add ruels button
        
        //Add aback button
        back = new JButton("Back");
        back.setBounds(915,270,120,25);
        back.setBackground(Color.yellow);//color of button background
        back.setForeground(Color.black);//color of button text
        back.setFont(new Font("Time New Roman",Font.BOLD,18));//font of button text
        back.addActionListener(this);//indentify that back button is clicked
        add(back);//add ruels button
        
         
        setSize(1200, 500);
        setLocation(100, 150);
        setVisible(true);
    }
    //implemet for click action on rules button and back button

    /**
     *
     * @param ae
     */
        @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==rules)
        {
            String name=tfName.getText();
            setVisible(false);
            new Rules_Of_Quiz(name);
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
            new Logging(); //Annonimous object
    }

}
