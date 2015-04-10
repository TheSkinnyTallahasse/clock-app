public class AlarmClockTester {
  public static void main(String[] args) {
    AlarmClock ac = new AlarmClock();
    // It's an early day tomorrow - let's set the alarm.
    ac.setAlarm(0,15,11);
    System.out.println("Alarm setting is " + ac.getAlarm(0)[0] + ":" + ac.getAlarm(0)[1]);
  }
}