package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText eName;
    private TextView tName;
    private Button bName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName = (EditText) findViewById(R.id.eName);
        bName = (Button) findViewById(R.id.bClick);
        tName = (TextView) findViewById(R.id.tName);

        bName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tName.setText("Hello, " + eName.getText().toString());
            }
        });
    }
}