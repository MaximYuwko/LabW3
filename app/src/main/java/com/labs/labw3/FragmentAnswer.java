package com.labs.labw3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentAnswer extends Fragment {

    TextView textViewAnswer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_answer, container, false);
        textViewAnswer = (TextView)view.findViewById(R.id.textViewAnswer);
        return view;
    }

    public void setAnswer(CharSequence answer){
        textViewAnswer.setText(answer);
    }
}
