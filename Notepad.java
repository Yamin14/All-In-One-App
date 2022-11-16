package com.example.allinoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Debug;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Notepad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);

        //back button
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //System.out.println("Working");
                finish();

            }
        });


        //load text
        EditText textView = findViewById(R.id.text);
        String text = "";

        FileInputStream fis = null;
        try {
            fis = openFileInput("data.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }
            textView.setText(sb);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //save text
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence txt, int i, int i1, int i2) {
                File path = getApplicationContext().getFilesDir();
                try {
                    FileOutputStream fos = new FileOutputStream(new File(path, "data.txt"));
                    fos.write(txt.toString().getBytes());
                    fos.close();
                    //System.out.println(txt.toString());
                } catch (Exception e) {e.printStackTrace();}
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}
