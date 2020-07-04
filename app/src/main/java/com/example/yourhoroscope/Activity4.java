package com.example.yourhoroscope;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity4 extends AppCompatActivity {
    private Button Btnmove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        Btnmove = findViewById(R.id.button5a);
        Btnmove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();

            }
        });


        }

    public void openActivity5(){

        Intent intent= new Intent(this,Activity5.class);
        startActivity(intent);


    }
}
