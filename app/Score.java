package app;
import javax.swing.*;
import java.awt.*;

public class Score extends JFrame {
    Score(String name, int score) {
        setTitle("Quiz Application - Score");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JLabel result = new JLabel("Well done " + name + "! Your score is " + score);
        result.setFont(new Font("Tahoma", Font.BOLD, 18));
        result.setHorizontalAlignment(SwingConstants.CENTER);

        add(result);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
