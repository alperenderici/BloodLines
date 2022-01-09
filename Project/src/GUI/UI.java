package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class UI {
    JFrame frame;
    JPanel firstPanel;
    JPanel secondPanel;
    JPanel thirdPanel;
    Border border = BorderFactory.createLineBorder(Color.black);

    UI(){
        firstPanel = new JPanel();
        firstPanel.setBorder(border);
        firstPanel.setBounds(0, 0, 1100, 800);
        firstPanel.setLayout(null);

        secondPanel = new JPanel();
        secondPanel.setBorder(border);
        secondPanel.setBounds(1100, 0, 430, 400);
        secondPanel.setLayout(null);

        thirdPanel = new JPanel();
        thirdPanel.setBorder(border);
        thirdPanel.setBounds(1100, 400, 430, 400);
        thirdPanel.setLayout(null);

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

        frame.add(firstPanel);
        frame.add(secondPanel);
        frame.add(thirdPanel);
    }

    public static void main(String[] args) {
        UI ui = new UI();

    }
}
