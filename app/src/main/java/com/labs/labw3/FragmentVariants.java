package com.labs.labw3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import java.util.ArrayList;




/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentVariants extends Fragment {

    private ArrayList<CheckBox> checkBoxes;

    public FragmentVariants() {
        // Required empty public constructor
    }



    public CharSequence getAnswers(){
        String answer = "";
        for (CheckBox checkBox:checkBoxes
        ) {
            if(checkBox.isChecked()){
                answer += checkBox.getText()+" ";
            }

        }
        answer+="\n";
        return answer;
    }


    //
    private ArrayList<View> getAllChildren(View v) {

        if (!(v instanceof ViewGroup)) {
            ArrayList<View> viewArrayList = new ArrayList<View>();
            viewArrayList.add(v);
            return viewArrayList;
        }

        ArrayList<View> result = new ArrayList<View>();

        ViewGroup viewGroup = (ViewGroup) v;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {

            View child = viewGroup.getChildAt(i);

            ArrayList<View> viewArrayList = new ArrayList<View>();
            viewArrayList.add(v);
            viewArrayList.addAll(getAllChildren(child));

            result.addAll(viewArrayList);
        }
        return result;
    }
    ////

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_variants, container, false);

        checkBoxes = new ArrayList<CheckBox>();
        for (View v:getAllChildren(view)
        ) {
            if(v instanceof CheckBox) {
                checkBoxes.add((CheckBox) v);
            }
        }


        return view;
    }

}
