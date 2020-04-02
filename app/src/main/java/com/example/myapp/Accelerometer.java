package com.example.myapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Accelerometer extends AppCompatActivity implements SensorEventListener {
    private static final float ALPHA = 0.25f; // if ALPHA = 1 OR 0, no filter applies
    private float[] sensorVal;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private TextView xVal, yVal, zVal, text;
    private MediaPlayer mpLeft;
    private MediaPlayer mpUpsideDown;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        mpLeft = MediaPlayer.create(this, R.raw.left);
        mpUpsideDown = MediaPlayer.create(this, R.raw.upsidedown);


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
        text = (TextView)findViewById(R.id.text);

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
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            sensorVal = lowPass(event.values.clone(), sensorVal);
            xVal.setText("X: " + event.values[0]);
            yVal.setText("Y: " + event.values[1]);
            zVal.setText("Z: " + event.values[2]);
        }

        if(Math.round(sensorVal[0]) > 9.0 && Math.abs(sensorVal[1]) < 2 && Math.abs(sensorVal[2]) < 2) {
            text.setText("Mobilen ligger på vänstersidan");
            mpLeft.start();
        }
        else if(Math.round(sensorVal[0]) < 0 && Math.abs(sensorVal[1]) < 2 && Math.abs(sensorVal[2]) < 2) {
            text.setText("Mobilen ligger på högersidan");
        }
        else if(Math.round(sensorVal[1]) > 9.0 && Math.abs(sensorVal[0]) < 2 && Math.abs(sensorVal[2]) < 2) {
            text.setText("Mobilen står på högkant");
        }
        else if(Math.round(sensorVal[1]) < 0 && Math.abs(sensorVal[0]) < 2 && Math.abs(sensorVal[2]) < 2) {
            text.setText("Mobilen står upp och ner");
            mpUpsideDown.start();

        }
        else if(Math.abs(sensorVal[2]) > 9.0 && Math.abs(sensorVal[0]) < 2 && Math.abs(sensorVal[1]) < 2) {
            text.setText("Mobilen ligger ner");
        } else {
            text.setText("");
        }



    }

    protected float[] lowPass( float[] input, float[] output ) {
        if ( output == null ) return input;
        for ( int i=0; i<input.length; i++ ) {
            output[i] = output[i] + (ALPHA*(input[i] - output[i]));
        }
        return output;
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
