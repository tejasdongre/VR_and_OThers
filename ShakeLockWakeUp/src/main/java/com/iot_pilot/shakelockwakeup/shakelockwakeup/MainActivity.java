package com.iot_pilot.shakelockwakeup.shakelockwakeup;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.iot_pilot.shakelockwakeup.shakelockwakeup.Services.SensorService;


public class MainActivity extends Activity {

    private SensorService sensorServiceObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main); //Do not need a UI as of now
        sensorServiceObj = new SensorService();
        sensorServiceObj.setContext(this);
        sensorServiceObj.startTheService();

        //start a service that listens to the Accelerometer changes
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorServiceObj.RegisterTheSensor();
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorServiceObj.UnRegisterTheSensor();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

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
}
