package com.iot_pilot.shakelockunlock.app2;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Created by tejasad on 10/29/2014.
 */
public class ScreenWakeReciever extends BroadcastReceiver {

    public Boolean isScreenAwake;
    public Activity ScreenActivity;
    public ScreenWakeReciever(Activity activity)
    {
        ScreenActivity = activity;


    }

    @Override

    public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(Intent.ACTION_SCREEN_OFF))
            {

                String str =  intent.getType();
                Activity act = (Activity) context;
                if(act instanceof ShakeActivity)
                {


                    ((ShakeActivity) act).PrintScreenIsOff();

                }


            }
            else if(intent.getAction().equals(Intent.ACTION_SCREEN_ON))
            {


                String str =  intent.getType();
                Activity act = (Activity) context;
                if(act instanceof ShakeActivity)
                {


                    ((ShakeActivity) act).PrintOnScreenOn();

                }

            }

    }
}
