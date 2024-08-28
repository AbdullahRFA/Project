package quiz_project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Quiz_Mechanism extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswer[][] = new String[10][2];
    JLabel Question_NO, Question;
    JButton submit, next, LifeLine;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupOption;
    public static int timer = 20;
    public static int ans_given = 0;
    public  int count = 0;
    public  int score = 0;
String name;
    Quiz_Mechanism(String name) {
        this.name=name;
        
        
        setBounds(100, 0, 1200, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //set image
        ImageIcon qimage = new ImageIcon(ClassLoader.getSystemResource("Icon/quiz.jpg"));//Image read from directory
        JLabel image = new JLabel(qimage);//farme er upor image add korar jonne.
        //muloto JLabel use kora hoi frame er upor jekono hedding likhar jonne
        image.setBounds(0, 0, 1200, 392);
        add(image);

        //for set question
        Question_NO = new JLabel();
        Question_NO.setBounds(50, 450, 50, 30);
        Question_NO.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(Question_NO);

        Question = new JLabel();
        Question.setBounds(100, 450, 900, 30);
        Question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(Question);

        //setting Question
        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        //Setting answer
        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        //for option button
        opt1 = new JRadioButton();
        opt1.setBounds(135, 490, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(135, 530, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(135, 570, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(135, 610, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupOption = new ButtonGroup();
        groupOption.add(opt1);
        groupOption.add(opt2);
        groupOption.add(opt3);
        groupOption.add(opt4);

        //for next button
        next = new JButton("Next");
        next.setBounds(900, 450, 200, 40);
        next.setFont(new Font("Times And Roman", Font.PLAIN, 22));
        next.setBackground(Color.GREEN);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        add(next);

        //for lifiline button
        LifeLine = new JButton("50-50 Lifeline");
        LifeLine.setBounds(900, 530, 200, 40);
        LifeLine.setFont(new Font("Times And Roman", Font.PLAIN, 22));
        LifeLine.setBackground(Color.GREEN);
        LifeLine.setForeground(Color.BLACK);
        LifeLine.addActionListener(this);
        add(LifeLine);

        //for Sum=bmit button
        submit = new JButton("Submit");
        submit.setBounds(900, 610, 200, 40);
        submit.setFont(new Font("Times And Roman", Font.PLAIN, 22));
        submit.setBackground(Color.GREEN);
        submit.setForeground(Color.BLACK);
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);

        //quiz start hobe ei function er maddhome
        start_quiz(count);
        
        
        setVisible(true);

    }

    /**
     *
     * @param g
     */
    @Override
    public void paint(Graphics g)//paint class automatically call hoi ar parameter hisebe graphics class er object nei
    {
        super.paint(g);//super keyword use kora hoi supper class er kono method ba constructor call korar jonno
        String time = "Time left - " + timer + " seconds";
        g.setColor(Color.red);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        if (timer > 0) {
            g.drawString(time, 850, 450);
            //drawString use kora hoi kono ekta string ke frame kothay dekhano hobe tar jonno
        } else {
            g.drawString("Times Up!!", 950, 450);
        }

        timer--;
        try {///Exception Handle
            Thread.sleep(1000);//method of Exicution ke 1 second delay korar jonno Thread class use kora hoiche
            repaint();//paint methond ke re call ba re paint kore repaint method
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (ans_given == 1)//jodi user ans kore
        {
            ans_given = 0;//ams_ginen =0 korte hobe poroporti question er jonno
            timer = 20;//ar timer abar suru theke set korte hobe 
        } else if (timer < 0)//jodi time sesh hoyr jai
        {
            timer = 20;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8)//10 number question a giye next button disnable hobee ar submit button enable hobe
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            
            if (count == 9)//submit button autometically press when if user does not press at the last question
            {
                
                
                if (groupOption.getSelection() == null)//user MCQ ans na kore
                {//getSelection ekta pointer return kore je user kiso select koreche ki na
                    useranswer[count][0] = "";//faka string user ans er moddhe store korte hibe
                } else {
                    useranswer[count][0] = groupOption.getSelection().getActionCommand();//jodi ans kore taile ta dynamically store korte hobe
                }//getSelection().getActionCommand() return kore ki value select koreche
                
                for (int i = 0; i < useranswer.length; i++) {
                    if(useranswer[i][0].equals(answers[i][1]))
                    {
                        score+=10;
                    }
                   
                }
                setVisible(false);
                new Obtained_Score(name,score);
                
            } 
            else {//for next button
                
                
                if (groupOption.getSelection() == null)//user MCQ ans na kore
                {//getSelection ekta pointer return kore je user kiso select koreche ki na
                    useranswer[count][0] = "";//faka string user ans er moddhe store korte hibe
                } else {
                    useranswer[count][0] = groupOption.getSelection().getActionCommand();//jodi ans kore taile ta dynamically store korte hobe
                }//getSelection().getActionCommand() return kore ki value select koreche

                count++;//counter man 1 briddhi
                start_quiz(count);//porer proshner jonne function abar call korlam
                
                
            }

        }
    }

    /**
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            ans_given = 1;

            if (groupOption.getSelection() == null)//user MCQ ans na kore
            {//getSelection ekta pointer return kore je user kiso select koreche ki na
                useranswer[count][0] = "";//faka string user ans er moddhe store korte hibe
            } else {
                useranswer[count][0] = groupOption.getSelection().getActionCommand();//jodi ans kore taile ta dynamically store korte hobe
            }//getSelection().getActionCommand() return kore ki value select koreche

            if (count == 8)//10 number question a giye next button disenable hobee ar submit button enable hobe
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start_quiz(count);

        } else if (ae.getSource() == LifeLine) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            LifeLine.setEnabled(false);//ekbar sudhu use korte parbe
        } else {
            
            ans_given=1;
              if (groupOption.getSelection() == null)//user MCQ ans na kore
                {//getSelection ekta pointer return kore je user kiso select koreche ki na
                    useranswer[count][0] = "";//faka string user ans er moddhe store korte hibe
                } else {
                    useranswer[count][0] = groupOption.getSelection().getActionCommand();//jodi ans kore taile ta dynamically store korte hobe
                }//getSelection().getActionCommand() return kore ki value select koreche
                
                for (int i = 0; i < useranswer.length; i++) {
                    if(useranswer[i][0].equals(answers[i][1]))
                    {
                        score+=10;
                    }
                   
                }
                setVisible(false);
                new Obtained_Score(name,score);
                
                
        }
    }

    public void start_quiz(int count) {
        Question_NO.setText("" + (count + 1) + ". ");
        Question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);//user je option select korbe ta groupOption opt te set korar jonne

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupOption.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz_Mechanism("User");
    }
}
