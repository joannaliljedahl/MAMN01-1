package com.example.myapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Accelerometer extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private TextView xVal, yVal, zVal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        //create Sensor Manager
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        //create Accelerator Manager
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //Register sensor Listener
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        //Assign TextView
        xVal= (TextView)findViewById(R.id.xVal);
        yVal= (TextView)findViewById(R.id.yVal);
        zVal= (TextView)findViewById(R.id.zVal);

    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }



    @Override
    public void onSensorChanged(SensorEvent event) {
        xVal.setText("X: " + event.values[0]);
        yVal.setText("X: " + event.values[1]);
        zVal.setText("X: " + event.values[2]);



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
