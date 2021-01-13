package com.example.flashlightmorsec;

import android.annotation.SuppressLint;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Handler;

import androidx.annotation.RequiresApi;

import static com.example.flashlightmorsec.MorseEnCode.morseEncode;


public class GoLight {


    CameraManager camManager;

    int delay = 0,speed = 1;

    public void light(String str_Message){
        String str_MorseCode;

        str_MorseCode = enCodeMessage(str_Message);
        morseToFlash(str_MorseCode);

    }

    private String enCodeMessage(String str_Message){

        StringBuilder str_MorsCode = new StringBuilder();

        for (int i = 0; i < str_Message.length(); i++)
            str_MorsCode.append(" ").append(morseEncode(str_Message.charAt(i)));

        return str_MorsCode.toString();
    }

    public void morseToFlash(String morse) {

        for (int x = 0; x < morse.length(); x++) {

            char ch = morse.charAt(x);
            if (ch == '.')
                handleDelay(200);
            else if (ch == '-')
                handleDelay(400);
            else if (ch == ' ')
                handleDelay(600);

        }
    }

    private void handleDelay(int int_time){

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @SuppressLint("NewApi")
            public void run() {
                flashLightOn();
            }
        }, (delay += (int_time * speed)));

        handler.postDelayed(new Runnable() {
            public void run() {
                flashLightOff();
            }
        }, (delay += (int_time * speed)));
    }


    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void flashLightOn() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            try {
                camManager.setTorchMode(camManager.getCameraIdList()[0], true);   //Turn ON
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressLint("NewApi")
    public void flashLightOff() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            try {
                if (camManager != null) {
                    camManager.setTorchMode(camManager.getCameraIdList()[0], false);
                }
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }}

    }


    public void setCamManager(CameraManager camManager) {
        this.camManager = camManager;
    }




}
