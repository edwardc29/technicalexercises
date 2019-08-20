package com.carrion.edward.app2;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.carrion.edward.app2.databinding.ActivityMainBinding;

/**
 * @author Edward Carrion
 * @author https://github.com/edwardc29
 */
public class MainActivity extends AppCompatActivity implements ShakeDetector.OnShakeListener {
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private ShakeDetector shakeDetector;
    private boolean flag;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        shakeDetector = new ShakeDetector();
        shakeDetector.setOnShakeListener(this);
    }

    @Override
    public void onShake(int count) {
        handleShakeEvent(count);
    }

    private void handleShakeEvent(int count) {
        if (flag) {
            binding.root.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_blue_light));
        } else {
            binding.root.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
        }

        flag = !flag;
    }

    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(shakeDetector, accelerometer, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        sensorManager.unregisterListener(shakeDetector);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        sensorManager.unregisterListener(shakeDetector);
        super.onDestroy();
    }
}
