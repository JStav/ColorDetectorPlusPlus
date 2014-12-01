package phy2049.projects.colordetectorplusplus;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import phy2049.ColorProcessor;


public class MainActivity extends Activity {


    private final int CAPTURE_IMAGE_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isCameraOperational = checkCameraHardware(getApplicationContext());

        if (isCameraOperational){
            CharSequence cameraReadyToast = "Camera is operational";
            Toast toast = Toast.makeText(getApplicationContext(), cameraReadyToast, Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            CharSequence cameraReadyToast = "Camera unavailable";
            Toast toast = Toast.makeText(getApplicationContext(), cameraReadyToast, Toast.LENGTH_SHORT);
            toast.show();
        }

        ActionBar actionBar = getActionBar();

        if(actionBar != null) {
            actionBar.hide();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }

    public void startCamera(View view){

//        Toast toast = new Toast(getApplicationContext());
//        toast.setText("Place the object in the middle of the picture");
//        toast.setDuration(Toast.LENGTH_SHORT);
//        toast.show();
        Uri fileUri;
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        fileUri = MediaOutputHandler.getOutputMediaFileUri();
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        startActivityForResult(intent, CAPTURE_IMAGE_REQUEST_CODE);
    }

    public void processColor(View view){
        Bitmap image = ColorProcessor.loadBitmap(MediaOutputHandler.getOutputMediaFileUri().getPath());
        String hexColor = ColorProcessor.getCenterPixelArrayColor(image);

        FrameLayout colorDisplay = (FrameLayout)findViewById(R.id.frameLayout);

        System.out.println(hexColor);

        int hexInt = Color.parseColor(hexColor);

        colorDisplay.setBackgroundColor(hexInt);
    }

}
