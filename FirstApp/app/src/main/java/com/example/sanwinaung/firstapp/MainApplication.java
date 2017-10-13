package com.example.sanwinaung.firstapp;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by SanWinAung on 9/23/2017.
 */

public class MainApplication extends Application {


    @Override
    public void onCreate(){
        super.onCreate();

        Toast.makeText(this, "Hello form Application", Toast.LENGTH_SHORT).show();
        Log.d("APPLICATION", "Application Started");
    }



    @Override
    public void onTerminate() {
        super.onTerminate();

        Log.d("APPLICATION","Application Terminated");

        Toast.makeText(this, "Hello from Termination", Toast.LENGTH_SHORT).show();


    }
}
