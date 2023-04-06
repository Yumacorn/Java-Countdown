import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class CountdownClock {
    //declare the Timer t and Float i
    static Timer t;
    static long i;
    //main method
    public static void main(String[] args) {
        System.out.println("Countdown Clock intiated");
        Scanner sc  = new Scanner(System.in);

        //input the seconds you want to count down
        System.out.print("Enter the seconds you want to count down: ");

        //save the seconds that is input to the variable sec
        String sec  = sc.nextLine();

        //set delay and period as 5000
        int delay = 500;
        int period = 100;
        t = new Timer();
        i = Integer.parseInt((sec))*1000;

        //t Timer performs the specified task at period intervals after waiting delay 
        t.scheduleAtFixedRate(new TimerTask(){
            //task to be performed
            public void run() {
                seti(period);
                double res = ((double) i)/((double) 1000);
                System.out.println(res);
            }
        }, delay, period);
        try {
            Thread.sleep(i+1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Countdown Clock ended");
        System.out.println("Total duration: "+sec+" second(s)");
    }

    private static final long seti(int period) {
        //if interval becomes zero or negative, end
        if (i > 0) {
            i = i - period;
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
        else t.cancel();

        return i;
    }
}