package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helloworld.lifecycle.ActivityA;
import com.example.helloworld.lifecycle.ActivityB;
import com.example.helloworld.lifecycle.ActivityC;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{
    private EditText eName;
    private Button bName;
    private Button bShare;
    private Button bSearch;
    private Button buttonA;
    private Button buttonB;
    private Button buttonC;
    private Spinner spin;
    private final String[] colors = {"White", "Red", "Green", "Blue", "Yellow"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName = (EditText) findViewById(R.id.eName);
        bName = (Button) findViewById(R.id.bClick);
        bShare = (Button) findViewById(R.id.bShare);
        bSearch = (Button) findViewById(R.id.bSearch);
        buttonA = (Button) findViewById(R.id.buttonA);
        buttonB = (Button) findViewById(R.id.buttonB);
        buttonC = (Button) findViewById(R.id.buttonC);
        spin = (Spinner) findViewById(R.id.spinner);

        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the color list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item, colors);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        bName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle(R.string.dialog_title)
                        .setMessage("Hello, " + eName.getText().toString())
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(getApplicationContext(),"you choose yes action for alertbox",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton(R.string.cancel,  new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"you choose no action for alertbox",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        bShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the text message with a string.
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, eName.getText().toString());
                sendIntent.setType("text/plain");

                // Try to invoke the intent.
                try {
                    startActivity(sendIntent);
                } catch (ActivityNotFoundException e) {
                    // Define what your app should do if no activity can handle the intent.
                }
            }
        });

        bSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the text message with a string.
                Intent sendIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + eName.getText().toString()));

                // Try to invoke the intent.
                try {
                    startActivity(sendIntent);
                } catch (ActivityNotFoundException e) {
                    // Define what your app should do if no activity can handle the intent.
                }
            }
        });

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
    }



    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(), colors[position] , Toast.LENGTH_LONG).show();
        bName.setTextColor(Color.parseColor(colors[position]));
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        bName.setTextColor(Color.parseColor("#FFFFFF"));
    }
}