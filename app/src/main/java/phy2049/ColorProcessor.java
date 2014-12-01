package phy2049;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;

public class ColorProcessor {


    public static Bitmap loadBitmap(String path){

        Bitmap bitmap = new BitmapFactory().decodeFile(path);
        return bitmap;
    }

    public static String getCenterPixelArrayColor(Bitmap bitmap){

        int hexPixel = bitmap.getPixel(bitmap.getWidth()/2, bitmap.getHeight()/2);
        String hexColor = String.format("#%06X", (0xFFFFFF & hexPixel));

        return hexColor;
    }

}

