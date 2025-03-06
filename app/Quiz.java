package app;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class Quiz extends JFrame implements ActionListener {
    String questions[][] = new String[10][5];
    String answers[] = new String[10];
    String userAnswers[] = new String[10];
    int count = 0, score = 0;
    JLabel qLabel;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup options;
    JButton next;

    String name;

    Quiz(String name) {
        this.name = name;
        setTitle("Quiz Application - Quiz");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        qLabel = new JLabel();
        qLabel.setBounds(50, 50, 700, 30);
        qLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(qLabel);

        opt1 = new JRadioButton();
        opt1.setBounds(50, 100, 700, 30);
        opt2 = new JRadioButton();
        opt2.setBounds(50, 140, 700, 30);
        opt3 = new JRadioButton();
        opt3.setBounds(50, 180, 700, 30);
        opt4 = new JRadioButton();
        opt4.setBounds(50, 220, 700, 30);

        options = new ButtonGroup();
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);

        add(opt1);
        add(opt2);
        add(opt3);
        add(opt4);

        next = new JButton("Next");
        next.setBounds(350, 280, 100, 40);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(224, 255, 255));

        setQuestions();
        loadQuestion();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (options.getSelection() != null) {
            userAnswers[count] = getSelectedAnswer();
            if (userAnswers[count].equals(answers[count])) {
                score += 10;
            }
            count++;
            if (count == questions.length) {
                setVisible(false);
                Leaderboard.addScore(name, score);
                new Score(name, score);
            } else {
                loadQuestion();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an option!");
        }
    }

    void setQuestions() {
        questions[0] = new String[]{"What is the capital of France?", "Berlin", "Madrid", "Paris", "London"};
        answers[0] = "Paris";
        
        questions[1] = new String[]{"What is the largest planet in our solar system?", "Earth", "Mars", "Jupiter", "Saturn"};
        answers[1] = "Jupiter";

        questions[2] = new String[]{"Who wrote 'Hamlet'?", "Shakespeare", "Dickens", "Hemingway", "Austen"};
        answers[2] = "Shakespeare";

        questions[3] = new String[]{"What is the square root of 64?", "6", "7", "8", "9"};
        answers[3] = "8";

        questions[4] = new String[]{"Which element has the chemical symbol 'O'?", "Oxygen", "Osmium", "Ozone", "Oganesson"};
        answers[4] = "Oxygen";

        questions[5] = new String[]{"What is the smallest country in the world?", "Monaco", "Vatican City", "San Marino", "Liechtenstein"};
        answers[5] = "Vatican City";

        questions[6] = new String[]{"What is the longest river in the world?", "Amazon River", "Nile River", "Yangtze River", "Mississippi River"};
        answers[6] = "Amazon River";

        questions[7] = new String[]{"In which country would you find the Great Barrier Reef?", "Australia", "New Zealand", "South Africa", "Philippines"};
        answers[7] = "Australia";

        questions[8] = new String[]{"What is the largest ocean on Earth?", "Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"};
        answers[8] = "Pacific Ocean";

        questions[9] = new String[]{"Which planet is known as the Red Planet?", "Venus", "Mars", "Jupiter", "Saturn"};
        answers[9] = "Mars";
    }

    void loadQuestion() {
        options.clearSelection();
        qLabel.setText((count + 1) + ". " + questions[count][0]);
        opt1.setText(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt4.setText(questions[count][4]);
    }

    String getSelectedAnswer() {
        if (opt1.isSelected()) return opt1.getText();
        if (opt2.isSelected()) return opt2.getText();
        if (opt3.isSelected()) return opt3.getText();
        return opt4.getText();
    }
}
