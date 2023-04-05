package Timer;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

public class TimerCountdown3 {
    //declare tk and t

    Toolkit tk;
    Timer t;

    //constructor of TimerCountdown3 class
    public TimerCountdown3() {
        tk = Toolkit.getDefaultToolkit();
        t = new Timer();
        
        //initial delay and subsequent rate
        t.schedule(new rt(), 0, 1*1000);
    }

    class rt extends TimerTask {
        //declare a variable beep
        int beep = 3;

        //task to be performed
        public void run() {
            //if beep variable is greater than ZERO
            if (beep > 0) {
                //perform beep operation and print after each second
                tk.beep();
                System.out.println("One second over ... Beep!");

                //decrement the value beep
                beep--;
            } else { //if beep variable is less than ZERO
                tk.beep();
                System.out.println("The time's over. . .!");
                //AWT thread stops
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Task is going to start . . .");
        new TimerCountdown3();
        System.out.println("Task that is set up is scheduled. . .");
    }
}