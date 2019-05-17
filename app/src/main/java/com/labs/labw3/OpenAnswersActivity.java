package com.labs.labw3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class OpenAnswersActivity extends AppCompatActivity {

    String saveFileName;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_answers);
        Intent intent = getIntent();
        textView = findViewById(R.id.textView2);
        saveFileName = intent.getStringExtra("saveFileName");
        try {
            FileInputStream fileInputStream = openFileInput(saveFileName);
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            String text = new String (bytes);
            textView.setText(text);
            if(fileInputStream!=null)
                fileInputStream.close();
        }
        catch (Exception exception){
            Toast.makeText(this,exception.getMessage(),Toast.LENGTH_SHORT);
        }
    }

    public void onClick(View view){
        try{
            FileOutputStream fileOutputStream = openFileOutput(saveFileName,MODE_PRIVATE);
            fileOutputStream.write("".getBytes());
            Toast.makeText(this, "File clear",Toast.LENGTH_SHORT).show();
            textView.setText("");
            if(fileOutputStream!=null)
                fileOutputStream.close();
        }
        catch(Exception exception){
            Toast.makeText(this, exception.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
