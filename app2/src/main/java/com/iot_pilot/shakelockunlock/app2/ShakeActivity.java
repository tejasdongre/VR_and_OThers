package com.iot_pilot.shakelockunlock.app2;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.Menu;
import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.view.MenuItem;
import android.widget.Toast;
import android.app.KeyguardManager;


public class ShakeActivity extends Activity implements SensorEventListener{
    DevicePolicyManager deviceManager;
    ActivityManager activityManager;
    ComponentName componentName;
    Sensor sensr;
    SensorManager sensorMngr ;
    KeyguardManager keyGaurgMngr ;
     KeyguardManager.KeyguardLock keygaurdLock;
    PowerManager powerMngr;
    PowerManager.WakeLock wakeLock;
    BroadcastReceiver reciever;
    private long lastUpdate = 0;
    public static final int RESULT_ENABLE  = 1;
    private static final int SHAKE_THRESHOLD = 2000;
    private float last_x=0, last_y=0, last_z=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);
        sensorMngr = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensr = sensorMngr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        keyGaurgMngr = (KeyguardManager)getSystemService(Context.KEYGUARD_SERVICE);
        keygaurdLock = keyGaurgMngr.newKeyguardLock("MyKeyGaurdLock");
        powerMngr = (PowerManager)getSystemService(Context.POWER_SERVICE);
        wakeLock = powerMngr.newWakeLock(PowerManager.FULL_WAKE_LOCK
                | PowerManager.ACQUIRE_CAUSES_WAKEUP
                | PowerManager.ON_AFTER_RELEASE, "MyWakeLock");
        reciever = new ScreenWakeReciever(this);
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(reciever,filter);


        //deviceManager = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
       // activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
       // componentName = new ComponentName(this, myAdminClass.class);

    }

    public void PrintOnScreenOn()
    {
        Toast.makeText(this,"Screen is On",Toast.LENGTH_SHORT).show();
        sensorMngr.registerListener(this, sensr, SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM);
       //wakeLock.release();

    }
    public void PrintScreenIsOff()
    {
        Toast.makeText(this,"Screen is Off",Toast.LENGTH_SHORT).show();
        sensorMngr.unregisterListener(this);
            wakeLock.acquire();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.shake, menu);
        return true;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {

    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
       // Toast.makeText(this,"Called",Toast.LENGTH_SHORT).show();
       Sensor myAccelSensor = event.sensor;
       float xCord,yCord,zCord;
        if(myAccelSensor.getType()== Sensor.TYPE_ACCELEROMETER)
        {
            xCord = event.values[0];
            yCord = event.values[1];
            zCord = event.values[2];
            long curTime = System.currentTimeMillis();

            long timeDifference = curTime - lastUpdate;
            lastUpdate = curTime;
            float speed = Math.abs(xCord+yCord+xCord - last_x-last_y-last_z)/timeDifference*10000;
            if(speed>SHAKE_THRESHOLD)
            {

                Log.v(String.valueOf(speed),"test");
                Toast.makeText(this,String.valueOf(speed),Toast.LENGTH_SHORT).show();
                wakeLock.acquire();
            }
        }


        //Log.v("test","test");
    }

    @Override
    protected void onResume() {
        super.onResume();
       // sensorMngr.registerListener(this,SensorManager.SENSOR_ACCELEROMETER, SensorManager.SENSOR_DELAY_GAME);
        sensorMngr.registerListener(this, sensr, SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM);
        //sensorMngr.unregisterListener(this);
        //Intent devManagerIntent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        //devManagerIntent.putExtra(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN, componentName);
        //devManagerIntent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "Why??");
       // startActivityForResult(devManagerIntent, RESULT_ENABLE);

    }

    @Override
    protected void onPause() {
        super.onPause();
      //  sensorMngr.unregisterListener(this);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
   /*     if (requestCode == RESULT_ENABLE) {
            if(resultCode == Activity.RESULT_OK) {
                if (deviceManager.isAdminActive(componentName)) {
                  //  deviceManager.lockNow();

                }

            }

        }
*/    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public static class myAdminClass extends DeviceAdminReceiver {

        @Override
        public void onEnabled(Context context, Intent intent) {
            super.onEnabled(context, intent);
        }

        @Override
        public void onDisabled(Context context, Intent intent) {
            super.onDisabled(context, intent);
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
        }
    }
}
