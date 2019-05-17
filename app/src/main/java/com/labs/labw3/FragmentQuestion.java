package com.labs.labw3;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class FragmentQuestion extends Fragment {

    private Button buttonOK;
    private OnFragmentInteractionListener listener;
    private CharSequence selectedText = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_question, container, false);

        buttonOK = (Button)view.findViewById(R.id.button);
        buttonOK.setEnabled(true);


        buttonOK.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                selectedText = ((FragmentVariants) getChildFragmentManager().findFragmentById(R.id.fragment3)).getAnswers();
                listener.onFragmentInteraction(selectedText);
            }
        });
        return view;
    }

    interface OnFragmentInteractionListener{
        void onFragmentInteraction(CharSequence answer);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnFragmentInteractionListener) context;
    }
}

