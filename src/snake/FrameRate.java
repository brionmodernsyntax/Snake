package snake;

import java.io.IOException;
import javafx.animation.AnimationTimer;

public class FrameRate extends AnimationTimer {

    //speed of the frame refresh
    static int speed;
    //initializing variable which tells the time since the last update
    long lastUpdate = 0;

    @Override
    public void handle(long now) {
        //sets downtime to the current time minus the time of the last update
        long downTime = now - lastUpdate;
        //if downtime is greater than or equal to speed * 1,000,000, update the
        //frame and set the time of the last update to now.
        if (downTime >= speed * 10e5) {
            try {
                Frame.frameUpdate(Main.graphicsContext);
            } catch (IOException ex) {
            }
            lastUpdate = now;
        }

    }

}
