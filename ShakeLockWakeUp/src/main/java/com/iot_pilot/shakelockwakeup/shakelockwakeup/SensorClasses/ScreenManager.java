package com.iot_pilot.shakelockwakeup.shakelockwakeup.SensorClasses;

import android.content.Context;
import android.os.PowerManager;

/**
 * Created by tejasad on 11/13/2014.
 */
public class ScreenManager {

    private Context appContext;
    private PowerManager powerManagerObj;
    private PowerManager.WakeLock wakeLockObj;

    public ScreenManager()
    {

    }
    public ScreenManager(Context context)
    {
            this.appContext = context;


    }

    public void WakeUpTheScreen()
    {


    }
    public void LockTheScreen()
    {



    }

}
