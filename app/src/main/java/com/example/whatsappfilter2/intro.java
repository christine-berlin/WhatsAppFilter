package com.example.whatsappfilter2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class intro extends Activity {
    static String names="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Button mybutton = (Button) findViewById(R.id.button);
        final EditText mytext = (EditText)findViewById(R.id.editText);

        mybutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            names=  mytext.getText().toString();
            intent.putExtra("names", names);
            startActivity(intent);
            }
        });
    }
}
