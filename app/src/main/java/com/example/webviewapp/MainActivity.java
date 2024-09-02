package com.example.webviewapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonStaticContent;
    private Button buttonRemoteContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView titleTextView = findViewById(R.id.titleTextView);
        buttonStaticContent = findViewById(R.id.buttonStaticContent);
        buttonRemoteContent = findViewById(R.id.buttonRemoteContent);

        buttonStaticContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StaticContentActivity.class);
                startActivity(intent);
            }
        });

        buttonRemoteContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RemoteContentActivity.class);
                startActivity(intent);
            }
        });
    }
}
