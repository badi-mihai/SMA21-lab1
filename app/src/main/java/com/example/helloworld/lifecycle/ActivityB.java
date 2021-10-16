package com.example.helloworld.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.R;

public class ActivityB extends AppCompatActivity {

    private Button buttonA;
    private Button buttonB;
    private Button buttonC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        buttonA = (Button) findViewById(R.id.buttonA);
        buttonB = (Button) findViewById(R.id.buttonB);
        buttonC = (Button) findViewById(R.id.buttonC);

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityA.class);

                // Try to invoke the intent.
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    // Define what your app should do if no activity can handle the intent.
                }
            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityB.class);

                // Try to invoke the intent.
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    // Define what your app should do if no activity can handle the intent.
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityC.class);

                // Try to invoke the intent.
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    // Define what your app should do if no activity can handle the intent.
                }
            }
        });

        Log.d("ActivityB", "onCreate B");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ActivityB", "onStart B");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ActivityB", "onResume B");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ActivityB", "onPause B");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ActivityB", "onStop B");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ActivityB", "onDestroy B");
    }
}