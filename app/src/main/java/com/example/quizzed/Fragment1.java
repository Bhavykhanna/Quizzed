package com.example.quizzed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Locale;


public class Fragment1 extends Fragment {

TextView textView,textView1;
String email12;
String name;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_1, container, false);
       textView=view.findViewById(R.id.username);
       textView1=view.findViewById(R.id.usere);
        Bundle data=getArguments();
        if(data!=null){

            email12=data.getString("email");

            int l=0;
            for(int i=0;i<email12.length();i++){
                if(email12.charAt(i)=='@'){
                    l=i;
                }
            }
            name=email12.substring(0,l).toUpperCase(Locale.ROOT);

        }

        textView.setText(email12);
        textView1.setText(name);

        return view;
    }
}