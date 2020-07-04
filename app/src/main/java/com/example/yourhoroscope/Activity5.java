package com.example.yourhoroscope;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity5 extends AppCompatActivity {
       private Firebase Ref;
    private EditText username,feedback,rashi;
    Button response;

    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        username=findViewById(R.id.Username);
        feedback=findViewById(R.id.feedback);
        rashi=findViewById(R.id.Rashi);
        response=findViewById(R.id.response);

        Firebase.setAndroidContext(this);
        Ref= new Firebase("https://yourhoroscope-28464.firebaseio.com/");
    }

    public void feedbacksend(View view) {

        String usernameinput=username.getText().toString();
        String feedbackinput=feedback.getText().toString();
        String rashiinput=rashi.getText().toString();

        Firebase Reusername=Ref.child("Username");
        Reusername.setValue(usernameinput);

        Firebase Refeedback=Ref.child("Feedback");


        Firebase Rerashi=Ref.child("Rashi");

        Refeedback.child(usernameinput).setValue(usernameinput);
        Refeedback.child(feedbackinput).setValue(feedbackinput);
       // Refeedback.child(rashiinput).setValue(rashiinput);

        //rootNode = FirebaseDatabase.getInstance();


    }






}
