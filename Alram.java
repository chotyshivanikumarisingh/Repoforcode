import java.time.LocalTime;
import java.util.concurrent.*;

public class Alarm {

    public static void main(String[] args) {

        // Set alarm time here (24-hour format)
        LocalTime alarmTime = LocalTime.of(8, 10);

        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(1);

        while (true) {
            LocalTime currentTime = LocalTime.now();

            if (currentTime.getHour() == alarmTime.getHour()
                    && currentTime.getMinute() == alarmTime.getMinute()) {

                System.out.println("⏰ ALARM! Wake up!");

                // Stop the program after alarm
                scheduler.shutdown();
                break;
            }

            try {
                Thread.sleep(1000); // Check every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
