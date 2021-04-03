package com.clases.fundamentales;

import android.app.Activity;
import android.hardware.SensorEventListener2;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
public class AcelerometerTest extends Activity implements SensorEventListener {

    StringBuilder builder = new StringBuilder();
    TextView testView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        testView = new TextView(this);
        setContentView(testView);
        SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        if(sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER).size()==0){
            testView.setText("No hay acelerometro instalado");
        }else{
            Sensor acelerometer = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
            if(!sensorManager.registerListener(this,acelerometer,SensorManager.SENSOR_DELAY_GAME)){
                testView.setText("No se ha podido registrar el sensor listener");
            }
        }
    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        builder.setLength(0);
        builder.append("x: ");
        builder.append(sensorEvent.values[0]);
        builder.append(", y");
        builder.append(sensorEvent.values[1]);
        builder.append(", z");
        builder.append(sensorEvent.values[2]);
        testView.setText(builder.toString());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
