package com.zzolta.flashlight;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Camera camera = Camera.open();
        final Parameters cameraParameters = camera.getParameters();

        final Switch switchLight = (Switch) findViewById(R.id.switchLight);
        switchLight.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    switchLight.setText(R.string.cameraOn);
                    cameraParameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
                    camera.setParameters(cameraParameters);
                    camera.startPreview();
                } else {
                    switchLight.setText(R.string.cameraOff);
                    cameraParameters.setFlashMode(Parameters.FLASH_MODE_OFF);
                    camera.setParameters(cameraParameters);
                    camera.stopPreview();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }
}
