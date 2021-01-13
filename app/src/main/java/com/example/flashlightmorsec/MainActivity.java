package com.example.flashlightmorsec;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import static androidx.core.content.ContextCompat.getSystemService;

public class MainActivity extends AppCompatActivity {

    ImageView flashimg , vibrimg , setingsimg, infoimg;
    EditText mesage;
    TextView textView;

    private boolean flashLightStatus;
    private CameraManager cameraManager;



    boolean hasCameraFlash = false;
    private static final int CAMERA_REQUEST = 123;


    private AdView mAdView;

    GoLight goLight = new GoLight();

    CameraManager camManager;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setingsimg= findViewById(R.id.setings);

        setingsimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntens = new Intent(MainActivity.this, info.class);
                startActivity(newIntens);
            }
        });




        flashimg = findViewById(R.id.lanternaim);
        vibrimg = findViewById(R.id.vibrim);

        setingsimg = findViewById(R.id.setings);
        infoimg = findViewById(R.id.information);

        mesage = findViewById(R.id.editText);

        textView = findViewById(R.id.vieww);

        infoimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(MainActivity.this , decoder.class);
                startActivity(newIntent);

            }
        });






        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST);

        hasCameraFlash = getPackageManager().
                hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        flashLightStatus = false;

        camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        camManager = (CameraManager) this.getSystemService(Context.CAMERA_SERVICE);


        flashimg.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                String str_message = mesage.getText().toString();
                goLight.setCamManager(camManager);
                goLight.light(str_message);

                //morseToFlash(morz);

            }
        });

        vibrimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = mesage.getText().toString();

                String morz = "", morrr;

                for (int i = 0; i < message.length(); i++) {
                    char ch = message.charAt(i);

//                    String mc = morseEncode(ch);
//                    morrr = morz;
//                    morz = morrr + " " + mc;

                    //Log.d("sdsdsd", "" + morz);

                }

                vibrate(morz);

            }
        });

    }


    public void vibrate(String morse) {
        Handler handler = new Handler();
        int delay = 0,speed = 1;


        for (int x = 0; x < morse.length(); x++) {

            if (morse.charAt(x) == '.') {
                handler.postDelayed(new Runnable() {
                    @SuppressLint("NewApi")
                    public void run() {
                        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 500 milliseconds
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            v.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                        } else {

                            //deprecated in API 26
                            v.vibrate(200);
                        }
                    }
                }, (delay += (200 * speed)));

                handler.postDelayed(new Runnable() {
                    public void run() {
                        offvibrationonpunct();
                    }
                }, (delay += (200 * speed)));

            } else if (morse.charAt(x) == '-') {
                handler.postDelayed(new Runnable() {
                    @SuppressLint("NewApi")
                    public void run() {
                        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 500 milliseconds
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            v.vibrate(VibrationEffect.createOneShot(400, VibrationEffect.DEFAULT_AMPLITUDE));
                        } else {

                            //deprecated in API 26
                            v.vibrate(400);
                        }
                    }
                }, (delay += (400 * speed)));

                handler.postDelayed(new Runnable() {
                    public void run() {
                        offvibrationonpunct();
                    }
                }, (delay += (400 * speed)));

            } else if (morse.charAt(x) == ' ') {
                handler.postDelayed(new Runnable() {
                    public void run() {

                    }
                }, (delay += (600 * speed)));


                handler.postDelayed(new Runnable() {
                    public void run() {

                    }
                }, (delay += (600 * speed)));
            }
        }
    }



    public void onvibrationonpunct(){
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(-1, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {

            //deprecated in API 26
            v.vibrate(-1);
        }
    }
    public void offvibrationonpunct(){
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(0, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {

            //deprecated in API 26
            v.vibrate(0);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        hideNavigetionBar();
    }

    private void hideNavigetionBar(){
        this.getWindow().getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_FULLSCREEN|
                                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|
                                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|
                                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                );
    }
}
