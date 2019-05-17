package com.labs.labw3;



import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileOutputStream;

import static com.labs.labw3.R.id.fragment2;

public class MainActivity extends AppCompatActivity implements FragmentQuestion.OnFragmentInteractionListener {

    final String saveFileName = "Saved data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, OpenAnswersActivity.class);
        intent.putExtra("saveFileName", saveFileName);
        startActivity(intent);
    }

    @Override
    public void onFragmentInteraction(CharSequence answer) {
        FragmentAnswer fragmentAnswer = (FragmentAnswer) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        if (fragmentAnswer != null && fragmentAnswer.isInLayout()) {
            fragmentAnswer.setAnswer(answer);
        }
        saveAnswer(answer);
    }

    private void saveAnswer(CharSequence answer){
        String answerText = answer.toString();
        try{
            FileOutputStream fileOutputStream = openFileOutput(saveFileName,MODE_APPEND);
            fileOutputStream.write(answerText.getBytes());
            Toast.makeText(this, "Your answer saved",Toast.LENGTH_SHORT).show();
            if(fileOutputStream!=null)
                fileOutputStream.close();
        }
        catch(Exception exception){
            Toast.makeText(this, exception.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
