package com.example.allinoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //exit button
        Button exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //calender button
        Button calenderButton = findViewById(R.id.calenderButton);
        calenderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalenderPage.class);
                startActivity(intent);
            }
        });

        //calculator button
        Button calculatorButton = findViewById(R.id.calculatorButton);
        calculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalculatorPage.class);
                startActivity(intent);
            }
        });

        //time
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();

                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView time = findViewById(R.id.time);
                                Date now = Calendar.getInstance().getTime();

                                time.setText(now.toString());
                            }
                        });
                    }
                } catch (InterruptedException e) {};
            }
        };

        thread.start();

        //notepad button
        Button notepad = findViewById(R.id.NotepadButton);
        notepad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Notepad.class);
                startActivity(intent);

            }
        });

    }
}
