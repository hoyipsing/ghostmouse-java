package edu.utils;

import javax.swing.*;
import java.awt.*;

public class GhostMouse {
    public static void main(String[] args) throws AWTException {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                start();
            }
        });
        startRobot();
    }

    private static void startRobot() throws AWTException {
        final Robot robot = new Robot();
        while (true) {
            final PointerInfo pointerInfo = MouseInfo.getPointerInfo();
            final Point location = pointerInfo.getLocation();
            final int newX = location.x + 10;
            final int newY = location.y + 10;
            robot.mouseMove(newX, newY);
            robot.mouseMove(location.x, location.y);

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
            }
        }
    }

    private static void start() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Robot");
        frame.add(label);
        frame.setVisible(true);
    }

}
