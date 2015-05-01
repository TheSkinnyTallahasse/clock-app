import java.util.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
/**
 * Class pvfhdjdrjoe - write a description of the class here
 * 
 * @author (your name) 
 * @version (a version number)
 */
public class Alarm extends Applet {
    public static void main(String args[]) throws Exception
    {
        String txt,time,g="";
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the time you want it to ring; please include AM or PM");
        time=String.join("", in.nextLine().split(" "));
        System.out.println("Enter a reminder");
        txt=in.nextLine();
        boolean on = true;
        while(on)
        {
            Calendar c=Calendar.getInstance();//updating the calendar class everytime.
            if(c.get(Calendar.AM_PM)==1)
            {
                g=""+c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+"PM";
                System.out.println(g);
            }
            else
            {
                if(c.get(Calendar.HOUR)==0)
                    g=""+12+":"+c.get(Calendar.MINUTE)+"AM";
                else
                g=""+c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+"AM";
            }
            if(g.equalsIgnoreCase(time))
            {
                System.out.println(txt);
                URL url=AlarmClock.class.getResource("ClockAlarmSound.mp3");//getting the name of the sound file using local host
                AudioClip clip=Applet.newAudioClip(url);
                AudioClip clip1 = Applet.newAudioClip(url);
                clip.play();//playing the sound.
                Thread.sleep(1000);//making the program to suspend for 1000 milliseconds
                clip1.loop();//making the sound to play again
                Thread.sleep(20000);//againg making the program to suspend for 20000 milliseconds
                clip1.stop();//stopping the sound to play
                break;
            }
            else
            {
                g="";
            }
        }
    }
}