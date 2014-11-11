package com.iot_pilot.assistant.r2d2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.iot_pilot.assistant.r2d2.SL.ServiceClass;

import BL.InteractionClass;


public class ServiceActivity extends Activity {

    InteractionClass interaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        interaction = new InteractionClass(this);
    }



}
