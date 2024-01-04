import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener {
    static JLabel l1, l4, l2, l3, l5;
    static JButton b;
    static JTextField t1, t2, t3, t4, t5;
    static JFrame f;
    static char grade;
    static ImageIcon iconi;

    public static void main(String[] args) {
        Main m = new Main();
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception e){
            System.out.println(e);
        }
         iconi = new ImageIcon("C:/Users/user/Desktop/icon.jpg");
        f = new JFrame("Grade calculator");
        f.setSize(400, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("Enter mark of subject 1");
        l2 = new JLabel("Enter mark of subject 2");
        l3 = new JLabel("Enter mark of subject 3");
        l4 = new JLabel("Enter mark of subject 4");
        l5 = new JLabel("Enter mark of subject 5");

        t1 = new JTextField(5);
        t2 = new JTextField(5);
        t3 = new JTextField(5);
        t4 = new JTextField(5);
        t5 = new JTextField(5);

        b = new JButton("Calculate");
        b.addActionListener(m);


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        panel.add(l1);
        panel.add(t1);
        panel.add(l2);
        panel.add(t2);
        panel.add(l3);
        panel.add(t3);
        panel.add(l4);
        panel.add(t4);
        panel.add(l5);
        panel.add(t5);
        panel.add(b);


        f.add(panel);
        panel.setBackground(Color.LIGHT_GRAY);
        l1.setForeground(Color.BLACK);
        l2.setForeground(Color.BLACK);
        l3.setForeground(Color.BLACK);
        l4.setForeground(Color.BLACK);
        l5.setForeground(Color.BLACK);



        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

int n1=Integer.parseInt(t1.getText());
        int n2=Integer.parseInt(t2.getText());
        int n3=Integer.parseInt(t3.getText());
        int n4=Integer.parseInt(t4.getText());
        int n5=Integer.parseInt(t5.getText());
       float res=(n1+n2+n3+n4+n5)/5;

       if(res>=90)
           grade='S';
        if(res>=80&&res<90)
            grade='A';
        if(res>=70&&res<80)
            grade='B';
        if(res>=60&&res<70)
            grade='C';
        if(res>=50&&res<60)
            grade='D';
        if(res<50)
            grade='F';
        JOptionPane.showMessageDialog(f,"Your grade is"+grade);




    }
}
