package com.example.yourhoroscope;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    DatabaseReference databaseReference;
    List<String> title_list,scope_list;
    ArrayAdapter<String>  adapter;
    MyScope myScope;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView=findViewById(R.id.listView);
        databaseReference= FirebaseDatabase.getInstance().getReference("Horoscope");
        myScope=new MyScope();
        title_list=new ArrayList<>();
        scope_list=new ArrayList<>();
        adapter=new ArrayAdapter<>(this,R.layout.item,R.id.item_txt,title_list);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                title_list.clear();
                scope_list.clear();


            for (DataSnapshot ds : dataSnapshot.getChildren()){
                myScope=ds.getValue(MyScope.class);
                if (myScope != null) {
                    title_list.add(myScope.getTitle());
                }
                if (myScope != null) {
                    scope_list.add(myScope.getScope());
                }

            }
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(MainActivity.this,Next.class);
                    String p=scope_list.get(position);
                    intent.putExtra("key",p);



                    startActivity(intent);
                }
            });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
