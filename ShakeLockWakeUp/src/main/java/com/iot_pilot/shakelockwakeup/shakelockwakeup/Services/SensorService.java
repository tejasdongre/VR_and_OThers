package com.iot_pilot.shakelockwakeup.shakelockwakeup.Services;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import com.iot_pilot.shakelockwakeup.shakelockwakeup.SensorClasses.AccelerometerClass;

import Interfaces.ISensorInterface;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class SensorService extends IntentService implements SensorEventListener {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.iot_pilot.shakelockwakeup.shakelockwakeup.action.FOO";
    private static final String ACTION_BAZ = "com.iot_pilot.shakelockwakeup.shakelockwakeup.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.iot_pilot.shakelockwakeup.shakelockwakeup.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.iot_pilot.shakelockwakeup.shakelockwakeup.extra.PARAM2";


    //

   private ISensorInterface IsensorInterfaceObj;
   private Context appContext;
   public SensorManager sensorManagerObj;

   public  Sensor sensorObj;
    public void setContext(Context context) {

        try
        {
            this.appContext = context;

                this.sensorManagerObj = (SensorManager)context.getSystemService(Context.SENSOR_SERVICE);
                if(this.sensorManagerObj.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)!=null)
                {
                    this.sensorObj = this.sensorManagerObj.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
                }




        }

        catch(Exception expc)
        {
            Log.v(expc.getMessage(),"test");

        }



    }

    public Context GetContext() {
        return this.appContext;
    }


    public  void RegisterTheSensor()
    {
        try{
                this.sensorManagerObj.registerListener(this,sensorObj, SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM);
        }
        catch(Exception expc)
        {


        }
    }
    public  void UnRegisterTheSensor()
    {
        try{
            this.sensorManagerObj.unregisterListener(this);
        }
        catch(Exception expc)
        {


        }

    }

    public void startTheService()
    {
     try{

         Intent intentObj = new Intent(this.appContext,SensorService.class);
         startService(intentObj);
     }
        catch(Exception expc)
        {

        }

    }


    public SensorService() {
        super("SensorService");

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // Sensor Events implementation

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

            IsensorInterfaceObj = new AccelerometerClass(appContext);
            this.IsensorInterfaceObj.UseSensorToGetStuffDone(event);

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    //
}
