package phy2049.projects.colordetectorplusplus;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.widget.FrameLayout;


public class CameraActivity extends Activity {

        private Camera mCamera;
        private CameraPreview mPreview;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_camera);

            // Create an instance of Camera
            mCamera = MainActivity.getCameraInstance();

            // Create our Preview view and set it as the content of our activity.
            mPreview = new CameraPreview(this, mCamera);
            FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
            preview.addView(mPreview);
        }
}