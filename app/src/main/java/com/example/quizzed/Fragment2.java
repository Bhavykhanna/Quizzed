package com.example.quizzed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class Fragment2 extends Fragment {

private TextView textView;
private TextView textView1;
private TextView textView2;
private Button button ;
    Fragment me;
String mystring,quizname1,quizd;
    public Fragment2() {
        // Required empty public constructor
    }

    public static String TAG = "Fragment2";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_2, container, false);

        textView=view.findViewById(R.id.question_no);
        textView1=view.findViewById(R.id.quizname123);
        textView2=view.findViewById(R.id.questiondate12);
        Bundle data=getArguments();
        if(data!=null){
            mystring=data.getString("questionno");
            quizname1=data.getString("questioname");
            quizd=data.getString("questiondate");
        }
            textView.setText(mystring);
        textView1.setText(quizname1);
        textView2.setText(quizd);
        button=view.findViewById(R.id.startquiz);
        me=this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction f= getFragmentManager().beginTransaction();
                Fragment3 fragment3=new Fragment3();

                Bundle b=new Bundle();
                b.putString("name",quizname1);
                b.putString("queno",mystring);
                b.putString("qued",quizd);
                fragment3.setArguments(b);
                f.replace(R.id.container,fragment3);
                f.commit();
                f.addToBackStack(null);


            }
        });



        return view;
    }

}