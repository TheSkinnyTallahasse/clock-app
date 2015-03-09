import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 * Write a description of class DigitalPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DigitalPanel
{
        private int value;
        
        public Dimension getPreferredSize() {
            FontMetrics fm = getFontMetrics(getFont());
            return new Dimension(fm.stringWidth("00"), fm.getHeight());
        }

        public void setValue(int aValue) {
            if (value != aValue) {
                int old = value;
                value = aValue;
                firePropertyChange("value", old, value);
                repaint();
            }
        }

        public int getValue() {
            return value;
        }

        protected String pad(int value) {
            StringBuilder sb = new StringBuilder(String.valueOf(value));
            while (sb.length() < 2) {
                sb.insert(0, "0");
            }
            return sb.toString();
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g); 
            String text = pad(getValue());
            FontMetrics fm = getFontMetrics(g.getFont());
            int x = (getWidth() - fm.stringWidth(text)) / 2;
            int y = ((getHeight()- fm.getHeight()) / 2) + fm.getAscent();
            g.drawString(text, x, y);
        }        
}
