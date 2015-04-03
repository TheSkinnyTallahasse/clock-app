import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
/**
 * Class that creates a clock
 * @author Talha Ahmed
 * @author Nick Harmon
 */
public class Clock {
    /**
     * runs the clock
     * @param String[] args,
     */
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        DigitalClock myClock = new DigitalClock();
        f.add(myClock);
        f.pack();
        f.setVisible(true);
        DateFormat format = new SimpleDateFormat("hh:mm:ss");
        String sT = format.format(new Date());
    }
    
    /**
     * 
     */
    static class DigitalClock extends JPanel {
        String sT;
        int hour, minute, second;
        String correctionHour = "";
        String correctionMinute = "";
        String correctionSecond = "";
        /**
         * 
         */
        public void setStringTime(String xyz) {
            this.sT = xyz;
        }
        
        /**
         * 
         */
        public int findMinimumBetweenTwoNumbers(int a, int b) {
            return (a <= b) ? a : b;
        }
        
        /**
         * 
         */
        DigitalClock() {
            Timer t1 = new Timer(1000, new ActionListener() {
                /**
                 * 
                 */
                public void actionPerformed(ActionEvent e) {

                    repaint();
                }
            });
            t1.start();
        }
        
        /**
         * 
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Calendar now = Calendar.getInstance();
            hour = now.get(Calendar.HOUR_OF_DAY);
            minute = now.get(Calendar.MINUTE);
            second = now.get(Calendar.SECOND);

            if (hour < 10) {
                this.correctionHour = "0";
            }
            if (hour >= 10) {
                this.correctionHour = "";
            }

            if (minute < 10) {
                this.correctionMinute = "0";
            }
            if (minute >= 10) {
                this.correctionMinute = "";
            }

            if (second < 10) {
                this.correctionSecond = "0";
            }
            if (second >= 10) {
                this.correctionSecond = "";
            }
            setStringTime(correctionHour + hour + ":" + correctionMinute+ minute + ":" + correctionSecond + second);
            g.setColor(Color.BLACK);
            int length = findMinimumBetweenTwoNumbers(this.getWidth(),this.getHeight());
            Font myFont = new Font("SansSerif", Font.PLAIN, length / 5);
            g.setFont(myFont);
            g.drawString(sT, (int) length/6, length/2);

        }
        
        /**
         * 
         */
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }
}