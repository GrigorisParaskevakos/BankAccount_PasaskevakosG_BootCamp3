package mainapplication;

import java.util.logging.Level;
import java.util.logging.Logger;

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
