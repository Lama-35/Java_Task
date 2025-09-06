package myinternshiptasks;

import javax.swing.*;
import java.awt.*;

public class Task3 {
    public static long factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Factorial Calculator");
        frame.setSize(450, 240); 
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Bigger label for prompt
        JLabel promptLabel = new JLabel("Enter a number:");
        promptLabel.setBounds(20, 20, 180, 30);
        promptLabel.setFont(new Font("Arial", Font.BOLD, 16)); 

        
        JTextField numberField = new JTextField();
        numberField.setBounds(200, 20, 200, 30);
        numberField.setFont(new Font("Arial", Font.BOLD, 16));

 
        JButton calcButton = new JButton("Calculate");
        calcButton.setBounds(70, 70, 120, 35);
        calcButton.setBackground(Color.CYAN);

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(220, 70, 120, 35);
        clearButton.setBackground(Color.LIGHT_GRAY);

    
        JLabel resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setBounds(20, 120, 400, 60);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));


        frame.add(promptLabel);
        frame.add(numberField);
        frame.add(calcButton);
        frame.add(clearButton);
        frame.add(resultLabel);

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

   
        calcButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(numberField.getText());

                if (num < 0) {
                		resultLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
                    resultLabel.setText("⚠️ Factorial not defined for negative numbers!");
                    resultLabel.setForeground(Color.RED);
                } else {
                    long fact = factorial(num);
                    resultLabel.setText("Factorial of " + num + " is: " + fact);
                    resultLabel.setForeground(Color.GREEN.darker());
                }

            } catch (NumberFormatException ex) {
            		resultLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
                resultLabel.setText("⚠️ Please enter a valid integer!");
                resultLabel.setForeground(Color.RED);
            }
        });

        clearButton.addActionListener(e -> {
            numberField.setText("");
            resultLabel.setText("");
        });
    }
}



