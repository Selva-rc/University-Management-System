package university.management;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Splash extends JFrame {

    private final int targetWidth = 700;
    private final int targetHeight = 400;
    private final int animationDelayMs = 8;   // timer tick (ms)
    private final int growthStep = 8;         // pixels per tick

    private JProgressBar progressBar;

    public Splash() {
        // undecorated looks like a proper splash
        setUndecorated(true);
        setLayout(new BorderLayout());

        // Load image
        URL imgUrl = ClassLoader.getSystemResource("icons/first.jpg");
        JLabel imageLabel;
        if (imgUrl != null) {
            ImageIcon icon = new ImageIcon(imgUrl);
            Image img = icon.getImage().getScaledInstance(targetWidth, targetHeight - 30, Image.SCALE_SMOOTH);
            imageLabel = new JLabel(new ImageIcon(img));
        } else {
            // fallback if image not found
            imageLabel = new JLabel("Splash image not found", SwingConstants.CENTER);
            imageLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
            imageLabel.setPreferredSize(new Dimension(targetWidth, targetHeight - 30));
        }

        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        add(imageLabel, BorderLayout.CENTER);
        add(progressBar, BorderLayout.SOUTH);

        // start very small then animate to target size
        setSize(100, 60);
        centerOnScreen();
        setVisible(true);

        animateToSize(targetWidth, targetHeight);
    }

    private void centerOnScreen() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - getWidth()) / 2;
        int y = (screen.height - getHeight()) / 2;
        setLocation(x, y);
    }

    private void animateToSize(int w, int h) {
        Timer timer = new Timer(animationDelayMs, null);
        timer.addActionListener(e -> {
            int cw = getWidth();
            int ch = getHeight();

            int nw = Math.min(cw + growthStep, w);
            int nh = Math.min(ch + growthStep, h);

            setSize(nw, nh);
            centerOnScreen(); // keep centered while growing

            // update progress bar proportionally
            int progress = (int) (100.0 * nw / w);
            progressBar.setValue(Math.min(progress, 100));

            if (nw >= w && nh >= h) {
                ((Timer) e.getSource()).stop();
                // keep splash visible for a short time, then proceed
                new Timer(800, ev -> {
                    ((Timer) ev.getSource()).stop();
                    openNext();
                }).start();
            }
        });
        timer.start();
    }

    private void openNext() {
        // dispose splash and show login
        SwingUtilities.invokeLater(() -> {
            dispose();
            Login login = new Login();
            login.setVisible(true);
        });
    }

    public static void main(String[] args) {
        // Always start Swing on EDT
        SwingUtilities.invokeLater(Splash::new);
    }
}
