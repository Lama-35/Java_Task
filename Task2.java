package myinternshiptasks;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.ActionListener;

public class Task2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Number Guessing Game");
        frame.setSize(500, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel promptLabel = new JLabel("Guess a number (1-100):");
        promptLabel.setBounds(20, 20, 220, 30);
        promptLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JTextField guessField = new JTextField();
        guessField.setBounds(250, 20, 200, 30);
        guessField.setFont(new Font("Arial", Font.BOLD, 16));

        JButton guessButton = new JButton("Guess");
        guessButton.setBounds(90, 70, 120, 40);
        guessButton.setBackground(Color.CYAN);
        guessButton.setForeground(Color.BLACK);

        JButton restartButton = new JButton("Restart");
        restartButton.setBounds(250, 70, 120, 40);
        restartButton.setBackground(Color.LIGHT_GRAY);

        JLabel feedbackLabel = new JLabel("", SwingConstants.CENTER);
        feedbackLabel.setBounds(20, 130, 450, 50);
        feedbackLabel.setFont(new Font("Arial", Font.BOLD, 16));

        frame.add(promptLabel);
        frame.add(guessField);
        frame.add(guessButton);
        frame.add(restartButton);
        frame.add(feedbackLabel);

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        Random rand = new Random();
        final int[] targetNumber = {rand.nextInt(100) + 1};
        final int maxAttempts = 7;
        final int[] attempts = {0};

        ActionListener playGame = e -> {
            String input = guessField.getText();
            try {
                int guess = Integer.parseInt(input);

                if (guess < 1 || guess > 100) {
                    feedbackLabel.setText("Warning: Enter a number between 1 and 100!");
                    feedbackLabel.setForeground(Color.RED);
                    guessField.setText("");
                    return;
                }

                attempts[0]++;

                if (guess < targetNumber[0]) {
                    feedbackLabel.setText("Too low! Attempts left: " + (maxAttempts - attempts[0]));
                    feedbackLabel.setForeground(Color.RED);
                } else if (guess > targetNumber[0]) {
                    feedbackLabel.setText("Too high! Attempts left: " + (maxAttempts - attempts[0]));
                    feedbackLabel.setForeground(Color.RED);
                } else {
                    feedbackLabel.setText("Correct! You guessed it in " + attempts[0] + " attempts!");
                    feedbackLabel.setForeground(Color.GREEN.darker());
                }

                if (attempts[0] >= maxAttempts && guess != targetNumber[0]) {
                    feedbackLabel.setText("Game Over! The number was: " + targetNumber[0]);
                    feedbackLabel.setForeground(Color.RED);
                }

                guessField.setText("");
            } catch (NumberFormatException ex) {
                feedbackLabel.setText("Warning: Please enter a valid number!");
                feedbackLabel.setForeground(Color.RED);
            }
        };

        guessButton.addActionListener(playGame);

        restartButton.addActionListener(e -> {
            targetNumber[0] = rand.nextInt(100) + 1;
            attempts[0] = 0;
            feedbackLabel.setText("");
            guessField.setText("");
        });
    }
}


