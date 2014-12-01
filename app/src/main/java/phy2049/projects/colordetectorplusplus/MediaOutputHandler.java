package phy2049.projects.colordetectorplusplus;

import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.File;

public class MediaOutputHandler {
    /** Create a file Uri for saving an image or video */
    public static Uri getOutputMediaFileUri(){
        return Uri.fromFile(getOutputMediaFile());
    }

    /** Create a File for saving an image or video */
    private static File getOutputMediaFile(){
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "ColorDetectorPlusPlus");
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("ColorDetectorPlusPlus", "failed to create directory");
                System.out.println("Help");
                return null;
            }
        }

        // Create a media file name
        File mediaFile;
        mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_ColorDetect.jpg");

        return mediaFile;
    }
}
