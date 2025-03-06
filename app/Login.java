package app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField tfname;
    JButton next;
    
    Login() {
        setTitle("Quiz Application - Login");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel heading = new JLabel("Welcome to the Quiz");
        heading.setBounds(150, 50, 300, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        add(heading);

        JLabel nameLabel = new JLabel("Enter your name:");
        nameLabel.setBounds(180, 120, 200, 30);
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(nameLabel);

        tfname = new JTextField();
        tfname.setBounds(180, 160, 240, 30);
        add(tfname);

        next = new JButton("Next");
        next.setBounds(250, 220, 100, 40);
        next.addActionListener(this);
        add(next);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(240, 248, 255));
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String name = tfname.getText();
        if (!name.isEmpty()) {
            setVisible(false);
            new Rules(name);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter your name!");
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
