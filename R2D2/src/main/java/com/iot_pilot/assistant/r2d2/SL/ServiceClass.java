package com.iot_pilot.assistant.r2d2.SL;

import android.app.IntentService;
import android.content.Intent;

import java.lang.Exception;
import java.lang.Override;

import BL.InteractionClass;


public  class   ServiceClass extends IntentService
{
    private InteractionClass interactionObj;



    public ServiceClass()
    {

        super("ServiceClass");


    }


    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public ServiceClass(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

                try{





                }
                catch (Exception ex)
                {



                }

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
}