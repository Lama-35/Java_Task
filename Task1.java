package myinternshiptasks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Task1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Basic Calculator");
        frame.setSize(450, 220);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label1 = new JLabel("Number 1:");
        label1.setBounds(20, 20, 100, 30);
        label1.setFont(new Font("Arial", Font.BOLD, 16));
        JTextField num1Field = new JTextField();
        num1Field.setBounds(130, 20, 200, 30);
        num1Field.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel label2 = new JLabel("Number 2:");
        label2.setBounds(20, 60, 100, 30);
        label2.setFont(new Font("Arial", Font.BOLD, 16));
        JTextField num2Field = new JTextField();
        num2Field.setBounds(130, 60, 200, 30);
        num2Field.setFont(new Font("Arial", Font.BOLD, 16));

        JButton add = new JButton("+");
        add.setBounds(30, 110, 80, 40);
        add.setFont(new Font("Arial", Font.BOLD, 18));
        add.setBackground(Color.CYAN);

        JButton subtract = new JButton("-");
        subtract.setBounds(120, 110, 80, 40);
        subtract.setFont(new Font("Arial", Font.BOLD, 18));
        subtract.setBackground(Color.CYAN);

        JButton multiply = new JButton("×");
        multiply.setBounds(210, 110, 80, 40);
        multiply.setFont(new Font("Arial", Font.BOLD, 18));
        multiply.setBackground(Color.CYAN);

        JButton divide = new JButton("/");
        divide.setBounds(300, 110, 80, 40);
        divide.setFont(new Font("Arial", Font.BOLD, 18));
        divide.setBackground(Color.CYAN);

        frame.add(label1);
        frame.add(num1Field);
        frame.add(label2);
        frame.add(num2Field);
        frame.add(add);
        frame.add(subtract);
        frame.add(multiply);
        frame.add(divide);

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        ActionListener action = e -> {
            try {
                double a = Double.parseDouble(num1Field.getText());
                double b = Double.parseDouble(num2Field.getText());
                double result = 0;

                if (e.getSource() == add) result = a + b;
                else if (e.getSource() == subtract) result = a - b;
                else if (e.getSource() == multiply) result = a * b;
                else if (e.getSource() == divide) {
                    if (b == 0) {
                        JOptionPane.showMessageDialog(frame, "Cannot divide by zero!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    result = a / b;
                }

                JOptionPane.showMessageDialog(frame, "Result: " + result, "Result", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        };

        add.addActionListener(action);
        subtract.addActionListener(action);
        multiply.addActionListener(action);
        divide.addActionListener(action);
    }
}






