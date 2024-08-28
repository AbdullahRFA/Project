
package quiz_project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Obtained_Score extends JFrame implements ActionListener {
    String name;
    JButton Play_Again,exit;
    public static int score;
    Obtained_Score(String name,int score)
    {
        this.name=name;
        this.score=score;
        
        
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //set image
        ImageIcon simage = new ImageIcon(ClassLoader.getSystemResource("Icon/score.png"));//Image read from directory
        
        Image img=simage.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);//image scale korar jonne
        
        ImageIcon img1=new ImageIcon(img);
        
        JLabel image = new JLabel(img1);//farme er upor image add korar jonne.
        //muloto JLabel use kora hoi frame er upor jekono hedding likhar jonne
        image.setBounds(0, 200, 300, 250);
        add(image);

        //lebel for Quiz_Exam
        JLabel headding = new JLabel("Thank you "+name+" For Perticipating in Quiz_Game");
        headding.setFont(new Font("Algerian", Font.BOLD, 24));//headding er font type and size
        headding.setForeground(Color.red);
        headding.setBounds(45, 50, 700, 45);
        add(headding);
        
        //for showing score
         JLabel Scoreheadding = new JLabel("Your Score is "+score);
        Scoreheadding.setFont(new Font("Algerian", Font.BOLD, 36));//headding er font type and size
        headding.setForeground(Color.red);
        Scoreheadding.setBounds(350, 180, 700, 60);
        add(Scoreheadding);
        
        
         //for Play_Again  button
        Play_Again = new JButton("Play_Again");
        Play_Again.setBounds(380, 270, 200, 40);
        Play_Again.setFont(new Font("Times And Roman", Font.PLAIN, 22));
        Play_Again.setBackground(Color.YELLOW);
        Play_Again.setForeground(Color.BLACK);
        
        Play_Again.addActionListener(this);
        add(Play_Again);
        
        //for Play_Again  button
        exit = new JButton("Exit");
        exit.setBounds(380, 320, 200, 40);
        exit.setFont(new Font("Times And Roman", Font.PLAIN, 22));
        exit.setBackground(Color.YELLOW);
        exit.setForeground(Color.BLACK);
        
        exit.addActionListener(this);
        add(exit);
        
        setVisible(true);
        
    }
    
    /**
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Play_Again)
        {
            setVisible(false);
            new Logging();
        }
        else
        {
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new Obtained_Score("User",0);
    }
}
