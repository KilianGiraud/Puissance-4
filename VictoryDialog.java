import javax.swing.*;
import java.awt.*;

public class VictoryDialog extends JDialog {

    public VictoryDialog(JFrame parent, String message, Color color) {
        super(parent, "Information", true);
        setLayout(new BorderLayout());
        setSize(400, 200);
        setLocationRelativeTo(parent);
        getContentPane().setBackground(new Color(30, 30, 30));

        JLabel label = new JLabel(message, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(color);
        label.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton ok = new JButton("Retour au menu");
        ok.setFont(new Font("Arial", Font.PLAIN, 16));
        ok.setFocusPainted(false);
        ok.addActionListener(e -> {
            dispose();
            parent.dispose();
            new Menu();
        });

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(new Color(30, 30, 30));
        btnPanel.add(ok);

        add(label, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public static void showInfoOnly(JFrame parent, String message, Color color) {
        JDialog dialog = new JDialog(parent, "Information", true);
        dialog.setLayout(new BorderLayout());
        dialog.setSize(350, 150);
        dialog.setLocationRelativeTo(parent);
        dialog.getContentPane().setBackground(new Color(30, 30, 30));

        JLabel label = new JLabel(message, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(color);
        label.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton ok = new JButton("OK");
        ok.setFont(new Font("Arial", Font.PLAIN, 14));
        ok.setFocusPainted(false);
        ok.addActionListener(e -> dialog.dispose());

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(new Color(30, 30, 30));
        btnPanel.add(ok);

        dialog.add(label, BorderLayout.CENTER);
        dialog.add(btnPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
}