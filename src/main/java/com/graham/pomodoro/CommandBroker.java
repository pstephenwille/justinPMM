package com.graham.pomodoro;

/**
 * Created by stephen on 1/31/15.
 */
public class CommandBroker {
    /* list of static commands ? */
    
    
    protected static boolean closeApp() {
        Main.primaryStage.close();
        return true;
    }
    
    protected static boolean pauseApp() {
//        Main.primaryStage.pause();
        return true;
    }

    protected static boolean restartApp() {
//        Main.primaryStage.restart();
        return true;
    }

    protected static boolean resetApp() {
//        Main.primaryStage.reset();
        return true;
    }




}
