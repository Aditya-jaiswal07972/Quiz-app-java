package app;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {
    String name;
    JButton start;

    Rules(String name) {
        this.name = name;

        setTitle("Quiz Application - Rules");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel heading = new JLabel("Hello " + name + ", Quiz Rules");
        heading.setBounds(120, 40, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 22));
        add(heading);

        JTextArea rules = new JTextArea(
            "1. 10 questions in total.\n" +
            "2. Each correct answer awards 10 points.\n" +
            "3. No negative marking.\n" +
            "4. You have 15 seconds per question.\n" +
            "5. Click 'Start' to begin."
        );
        rules.setBounds(100, 100, 400, 200);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setEditable(false);
        add(rules);

        start = new JButton("Start Quiz");
        start.setBounds(230, 320, 120, 40);
        start.addActionListener(this);
        add(start);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(250, 250, 210));
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Quiz(name);
    }
}
