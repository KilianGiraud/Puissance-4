import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener {

    private final JButton play = new JButton("🎮 Jouer");
    private final JButton rule = new JButton("📘 Règles");

    public Menu() {
        super("Menu - Puissance 4");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        setIconImage(new ImageIcon(getClass().getResource("/img/img.png")).getImage());

        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        Color bgColor = new Color(30, 30, 30);
        getContentPane().setBackground(bgColor);

        for (JButton btn : new JButton[]{play, rule}) {
            btn.setFont(buttonFont);
            btn.setPreferredSize(new Dimension(250, 60));
            btn.setBackground(new Color(70, 130, 180));
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn.addActionListener(this);
        }

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 0, 20, 0);
        gbc.gridx = 0;

        add(play, gbc);
        gbc.gridy = 1;
        add(rule, gbc);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        if (e.getSource() == play) {
            new Puissance4().setVisible(true);
        } else if (e.getSource() == rule) {
            new RuleWindow();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Menu::new);
    }
}