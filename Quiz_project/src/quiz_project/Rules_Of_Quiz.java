package quiz_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class Rules_Of_Quiz extends JFrame implements ActionListener {

    String name;
    JButton Start, Back;

    Rules_Of_Quiz(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //lebel for Welcome text
        JLabel headding = new JLabel("Welcome " + this.name + " to Quiz_game");
        headding.setFont(new Font("Elephant", Font.BOLD, 28));//headding er font type and size
        headding.setForeground(Color.red);
        headding.setBounds(20, 20, 700, 30);
        add(headding);

        //lebel for rules  for Quiz_Exam
        JLabel Rules_Of_The_Quiz_Exam = new JLabel("Quiz_Game");
        Rules_Of_The_Quiz_Exam.setFont(new Font("Time New Roman", Font.PLAIN, 16));//headding er font type and size
        //Rules_Of_The_Quiz_Exam.setForeground(Color.red);
        Rules_Of_The_Quiz_Exam.setBounds(20, 50, 700, 500);
        Rules_Of_The_Quiz_Exam.setText(
                "<html>"
                + "1. Carefully read and understand the rules and guidelines provided for the online game. " + "<br><br>"
                + "2. Make sure you know what is allowed and what is not" + "<br><br>"
                + "3. Choose a quiet, well-lit, and distraction-free location to take the game." + "<br><br>"
                + "4. Ensure that your computer and internet connection are reliable." + "<br><br>"
                + "5. Be aware of the time limit for the game, and manage your time effectively to answer all questions" + "<br><br>"
                + "6. You will have 10 questions each question has 10 marks" + "<br><br>"
                + "7. Each question has 15 seconds you'll have to answer within this time" + "<br><br>"
                + "8. After 15 seconds autometically skip the current question" + "<br><br>"
                + "9. Do not communicate with other students or access external sources." + "<br><br>"
                + "10. Be aware if you are not allowed to go back and change answers; answer each question carefully." + "<br><br>"
                + "11. Maintain your integrety in the whole time of the game, and wish you good luck" + "<br><br>"
                + "<html>"
        );
        add(Rules_Of_The_Quiz_Exam);

        //Add back button
        Back = new JButton("Back");
        Back.setBounds(200, 550, 100, 30);
        Back.setBackground(Color.pink);//color of button background
        Back.setForeground(Color.black);//color of button text
        Back.setFont(new Font("Time New Roman", Font.BOLD, 18));//font of button text
        Back.addActionListener(this);//indentify that back button is clicked
        add(Back);//add ruels button

        //Add start button
        Start = new JButton("Start");
        Start.setBounds(500, 550, 100, 30);
        Start.setBackground(Color.pink);//color of button background
        Start.setForeground(Color.black);//color of button text
        Start.setFont(new Font("Time New Roman", Font.BOLD, 18));//font of button text
        Start.addActionListener(this);//identifiy that rules button is clicked
        add(Start);//add ruels button

        setSize(800, 650);
        setLocation(300, 80);
        setVisible(true);
    }

   

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==Start)
        {
            setVisible(false);
            new Quiz_Mechanism(name);
        }
        else if(ae.getSource()==Back)
        {
            setVisible(false);
            new Logging();
        }
    }
//    public static void main(String[] args) {
//        new Rules_Of_Quiz("User");
//    }
}
