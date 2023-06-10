package com.example.quizzed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class Fragment3 extends Fragment {
TextView textname,textquestions;
String name,ques;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view= inflater.inflate(R.layout.fragment_3, container, false);


        textname=view.findViewById(R.id.textView5);

        textquestions=view.findViewById(R.id.toalquestions1);
        Bundle args=getArguments();
       if(args!=null){
           ques=args.getString("queno");
           name=args.getString("name");

        }
        textname.setText(name);

        textquestions.setText(ques);

        return view;
    }
}