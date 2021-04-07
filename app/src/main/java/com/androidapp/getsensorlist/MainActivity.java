package com.androidapp.getsensorlist;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mTxtSensors;
    SensorManager sensorMgr;
    List<Sensor> sensorList;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtSensors = findViewById(R.id.txtSensors);
//        mTxtSensors.setMovementMethod(new ScrollingMovementMethod());
        mButton = findViewById(R.id.button);

        mButton.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v) {
        sensorMgr = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorList = sensorMgr.getSensorList(Sensor.TYPE_ALL);

        mTxtSensors.append("(# Sensors: " + sensorList.size() + ")\n\n");
        for (Sensor sensor : sensorList) { // Enhanced for Loop
            mTxtSensors.append("Sensor name: " + sensor.getName() + "\n");
            mTxtSensors.append("Sensor name: " + sensor.getType() + "\n\n");
        }
    }
}
