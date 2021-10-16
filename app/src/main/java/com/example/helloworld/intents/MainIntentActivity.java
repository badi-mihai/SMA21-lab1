package com.example.helloworld.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.R;
import com.example.helloworld.lifecycle.ActivityA;

public class MainIntentActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_intent);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the text message with a string.
                Intent sendIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));

                // Try to invoke the intent.
                try {
                    startActivity(sendIntent);
                } catch (ActivityNotFoundException e) {
                    // Define what your app should do if no activity can handle the intent.
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the text message with a string.
                Intent sendIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:00401213456"));

                // Try to invoke the intent.
                try {
                    startActivity(sendIntent);
                } catch (ActivityNotFoundException e) {
                    // Define what your app should do if no activity can handle the intent.
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the text message with a string.
                Intent sendIntent = new Intent("MSA.LAUNCH", Uri.parse("http://www.google.com"));

                // Try to invoke the intent.
                try {
                    startActivity(sendIntent);
                } catch (ActivityNotFoundException e) {
                    // Define what your app should do if no activity can handle the intent.
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acest url nu ar trebui sa fie procesat, deoarece IntentFilterActivity ar trebui sa fie
                // compatibil doar cu data schemes de tipul http sau https
                Intent sendIntent = new Intent("MSA.LAUNCH", Uri.parse("tel:00401213456"));

                // Try to invoke the intent.
                try {
                    startActivity(sendIntent);
                } catch (ActivityNotFoundException e) {
                    // Define what your app should do if no activity can handle the intent.
                }
            }
        });
    }
}