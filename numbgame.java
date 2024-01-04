import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class numbgame implements ActionListener {
    Random r = new Random();
    static int remainingattempts = 5;
    static JFrame f;
    static JLabel l, l1, l2, l3;
    static JButton b;
    static JPanel p;
    static JTextField t1;
    static int ch;

    public static void main(String[] args) {

            numbgame m = new numbgame();

            try {

                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception e) {
                System.out.println(e);
            }
            f = new JFrame("Number Game");
            f.setSize(400, 400);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setBackground(Color.black);
            f.setForeground(Color.white);
            f.setLayout(new FlowLayout());
            l = new JLabel("-----------NumberGame-----------");
            p = new JPanel();
            l1 = new JLabel("Guess a number and test your luck");
            t1 = new JTextField(5);
            l2 = new JLabel("Enter your guess");
            b = new JButton("Confirm");
            p.add(l2);
            p.add(t1);
            l3 = new JLabel();
            f.add(l);
            f.add(l1);
            f.add(p);
            f.add(l3);
            f.add(b);
            f.setVisible(true);
            b.addActionListener(m);
        }

    public void actionPerformed(ActionEvent ae) {
        int x = r.nextInt(100);

        if (remainingattempts > 0) {
            String n = t1.getText();

            int n1=Integer.parseInt(n);

            if (x == n1) {
                JOptionPane.showMessageDialog(f, "Congratulations! You have guessed the number!Your score is"+(remainingattempts)*20+"!!");

                remainingattempts = 0;
            } else if(x>n1) {
                JOptionPane.showMessageDialog(f, "Incorrect guess.The number u have entered is too less than the genereated number.You have " + (--remainingattempts) + " attempts remaining.", "Oops", JOptionPane.ERROR_MESSAGE);

            }
            else if(x<n1) {
                JOptionPane.showMessageDialog(f, "Incorrect guess.The number u have entered is too high than the genereated number.You have " + (--remainingattempts) + " attempts remaining.", "Oops", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(f, "Sorry, you've run out of attempts. The correct number was not guessed.");
            JOptionPane.showConfirmDialog(f,"Do you want to play again");
            switch (ch){
                case 0:
                    remainingattempts = 5;
                    x = r.nextInt(100) + 1;
                    t1.setText("");
                    break;

                case 1:
                    System.exit(0);
                    break;
            }

        }
    }
}
