package com.example.yourhoroscope;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Next extends AppCompatActivity {
    TextView txt;
    Button button;
    Button share_btn;
    Button nbtn,pbtn;

    TextToSpeech  textToSpeech;

    //int position;        //remove it

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        txt=findViewById(R.id.next_txt);
        button=findViewById(R.id.copy_bton);
        share_btn=findViewById(R.id.share_bton);
        nbtn=findViewById(R.id.next_bton);
        pbtn=findViewById(R.id.prev_bton);


        final String t=getIntent().getStringExtra("key");
       //final String[] t=getIntent().getStringArrayExtra("key");          //remove it
         //position=getIntent().getIntExtra("position",0);   //remove it


        txt.setText(t);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Text",t);
                clipboard.setPrimaryClip(clip);

                Toast.makeText(Next.this,"COPIED THE CONTENT",Toast.LENGTH_LONG).show();
            }
        });

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,t);
                intent.setType("text/plain");
                intent=Intent.createChooser(intent,"Share By");
                startActivity(intent);
            }
        });

      /*  nbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position=(position+1)%t.length;
                TextView textView = null;
                textView.setText(t[position]);

            }
        });*/

       /* pbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position=(position-1)%t.length;
                TextView textView = null;
                textView.setText(t[position]);
            }
        });*/

            textToSpeech =new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if (status == textToSpeech.SUCCESS)
                    {
                        int lang = textToSpeech.setLanguage(Locale.ENGLISH);

                    }
                }
            });

            pbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s=txt.getText().toString();

                    int speech = textToSpeech.speak(s,textToSpeech.QUEUE_FLUSH,null);

                }
            });



            nbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openActivity3();

                }
            });



    }
    public void openActivity3(){
        Intent intent=new Intent(this,Activity3.class);
        startActivity(intent);
    }
}
