package com.iot_pilot.shakelockwakeup.shakelockwakeup.SensorClasses;

import android.content.Context;
import android.hardware.SensorEvent;

import Interfaces.ISensorInterface;

/**
 * Created by tejasad on 11/13/2014.
 */
public class AccelerometerClass  implements ISensorInterface{

    private Context appContext;
    private ScreenManager ScreenManagerObj;
    private float[] accelerometerValues;

    public  AccelerometerClass()
    {
        super();
    }
    public AccelerometerClass(Context context)
    {
        try {
            this.appContext = context;
            ScreenManagerObj = new ScreenManager(this.appContext);

        }
        catch(Exception expc)
        {


        }



    }

    @Override
    public void UseSensorToGetStuffDone(SensorEvent sensorEventOBj) {
            try{
                //On the event when the screen is on and unlocked and the shake is detected then lock the Screen
                    this.accelerometerValues = sensorEventOBj.values;

            }
            catch(Exception excp)
            {

            }
    }

    @Override
    public void UseSensorToStopSomeThings(SensorEvent sensorEventOBj) {

    }
}
