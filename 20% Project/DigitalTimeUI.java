import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 * Write a description of class DigitalTimeUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DigitalTimeUI extends JFrame
{
   public static GregorianCalendar currentDate;
   final static int CLOCKWIDTH = 605;
   final static int CLOCKHEIGHT = 200;

    public static void main(String[] args) {
    int numOfDigits = 6;
    int startingX = 0;
    int startingY = 0;

    Font clockFont = new Font("Tahoma", Font.BOLD, 72);
    JFrame clock = new JFrame();

    clock.setSize(CLOCKWIDTH, CLOCKHEIGHT);
    clock.setVisible(true);
    clock.setResizable(false);
    clock.setDefaultCloseOperation(EXIT_ON_CLOSE);

    TitlePanel titlePanel = new TitlePanel();
    JLabel title = new JLabel("DIGITAL CLOCK");
    title.setFont(clockFont);
    title.setForeground(Color.BLACK);
    titlePanel.add(title);
    clock.add(titlePanel);

    DigitPanel digitPanel = new DigitPanel();
    JLabel digit;
    startingY = 115;
    while (numOfDigits > 0) {
        if ((numOfDigits % 2) == 0) {
            startingX += 5;
            digit = new JLabel(String.valueOf(0));

        }

    }
   }
}

