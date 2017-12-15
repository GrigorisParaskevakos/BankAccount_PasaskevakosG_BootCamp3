package mainapplication;

/**
 *
 * @author Paraskevakos Grigoris
 */
import java.util.logging.Level;
import java.util.logging.Logger;

//create a Thread class to consume in main program
public class DelayThread extends Thread {

    long time = 0;

    void delay(long time) {
        this.time = time;
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(DelayThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
