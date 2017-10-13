package com.example.sanwinaung.firstapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.sanwinaung.firstapp.MainActivity;
import com.example.sanwinaung.firstapp.R;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SECOND_ACTIVITY","Second Activity onCreate");
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("SECOND", "Second Activity onStart");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("SECOND", "Second Activity onStop");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("SECOND", "Second Activity onPostResume");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SECOND_ACTIVITY", "Second Activity onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("SECOND_ACTIVITY", "Second Activity onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("SECOND_ACTIVITY", "Second Activity onRestart");
    }


}
