package com.example.jongyepn.subwayinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailLineinfo extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stationinfo);
        Intent intent=getIntent();
        String infostation=intent.getStringExtra("INFO");
        TextView staioninfotext=(TextView)findViewById(R.id.centertext);
        staioninfotext.setText(infostation);
    }
}
