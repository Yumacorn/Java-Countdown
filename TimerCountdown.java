package Timer;
import java.util.Timer;
import java.util.TimerTask;

//sample class
public class TimerCountdown {
    //declare timer
    Timer t;
    
    //constructor of timer class
    public TimerCountdown(int seconds) {
        t = new Timer();
        //schedule the timer
        t.schedule(new rt(), seconds*1000);
    }

    //subclass that extends timer class
    class rt extends TimerTask {
        //task to perform on executing the program
        public void run() {
            System.out.println("Second you have input is over..!!!!");
            //stop thread of timer
            t.cancel();
        }
    }

    //main method
    public static void main(String[] args){
        //pass 5 seconds to Timer
        new TimerCountdown(5);
        System.out.println("Count down starts now!!");
    }
}