import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
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
 * Write a description of class TestPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitlePanel extends JPanel
{
     private DigitalPanel hour;
     private DigitalPanel min;
     private DigitalPanel second;
     private int tick = 0;
     private JLabel[] seperator;
     public TitlePanel(){
        setLayout(new GridBagLayout());

            hour = new DigitalPanel();
            min = new DigitalPanel();
            second = new DigitalPanel();
            seperator = new JLabel[]{new JLabel(":"), new JLabel(":")};

            add(hour);
            add(seperator[0]);
            add(min);
            add(seperator[1]);
            add(second);

            Timer timer = new Timer(500, new ActionListener() {
                
                public void actionPerformed(ActionEvent e) {
                    Calendar cal = Calendar.getInstance();
                    hour.setValue(cal.get(Calendar.HOUR_OF_DAY));
                    min.setValue(cal.get(Calendar.MINUTE));
                    second.setValue(cal.get(Calendar.SECOND));

                    if (tick % 2 == 1) {
                        seperator[0].setText(" ");
                        seperator[1].setText(" ");
                    } else {
                        seperator[0].setText(":");
                        seperator[1].setText(":");
                    }
                    tick++;
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
        }

        }
