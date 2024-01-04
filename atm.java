import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class Bank {
    double balance;

    Bank() {
        this.balance = 0.0;
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            showMessage("Withdrawn: " + amount);
        } else {
            showMessage("Invalid withdrawal amount or insufficient funds.");
        }
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            showMessage("Deposited: " + amount);
        } else {
            showMessage("Invalid deposit amount.");
        }
    }

    void checkBalance() {
        showMessage("Balance: " + balance);
    }

    void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Transaction Result", JOptionPane.INFORMATION_MESSAGE);
    }
}

public class atm implements ActionListener {
    static JLabel l1;
    static JButton b1, b2, b3;
    static JFrame f;
    static Bank bank;

    public static void main(String[] args) {
        f = new JFrame("ATM");
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println(e);
        }

        bank = new Bank();

        b1 = new JButton("Withdraw");
        b2 = new JButton("Deposit");
        b3 = new JButton("Check Balance");
        atm m = new atm();

        l1 = new JLabel("Hello! Welcome to our ATM. What would you like to do?");
        f.setLayout(new FlowLayout());
        f.setSize(600, 200);

        b1.addActionListener(m);
        b2.addActionListener(m);
        b3.addActionListener(m);

        f.add(l1);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter withdrawal amount:"));
            bank.withdraw(amount);
        } else if (e.getSource() == b2) {
            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter deposit amount:"));
            bank.deposit(amount);
        } else if (e.getSource() == b3) {
            bank.checkBalance();
        }
    }
}
