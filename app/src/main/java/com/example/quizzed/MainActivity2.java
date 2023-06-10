package com.example.quizzed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick (View v){
                open1();
            }

        });
    }
    public void open1(){
        Intent intent= new Intent(this , MainActivity3.class);
        startActivity(intent);
        finish();
    }
    }
