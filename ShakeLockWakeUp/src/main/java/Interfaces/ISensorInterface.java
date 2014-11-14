package Interfaces;


import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import java.lang.Override;

public interface ISensorInterface
{
        public void UseSensorToGetStuffDone(SensorEvent sensorEvent);
        public void UseSensorToStopSomeThings(SensorEvent sensorEvent);

}