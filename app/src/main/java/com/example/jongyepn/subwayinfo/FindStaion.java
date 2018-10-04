package com.example.jongyepn.subwayinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FindStaion extends AppCompatActivity {


    static StaionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findsubwaystaion);
        ArrayList<MyItem> data = new ArrayList<MyItem>();
        data.add(new MyItem(R.drawable.samplestaion, "Bella", "1"));
        data.add(new MyItem(R.drawable.samplestaion, "Charlie", "2"));
        data.add(new MyItem(R.drawable.samplestaion, "Daisy", "1.5"));
        data.add(new MyItem(R.drawable.samplestaion, "Duke", "1"));
        data.add(new MyItem(R.drawable.samplestaion, "Max", "2"));
        data.add(new MyItem(R.drawable.samplestaion, "Happy", "4"));
        data.add(new MyItem(R.drawable.samplestaion, "Luna", "3"));
        data.add(new MyItem(R.drawable.samplestaion, "Bob", "2"));

        //어댑터 생성
        adapter = new StaionAdapter(this, R.layout.findsubwaystaionitem, data);

        //어댑터 연결
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View vClicked,
                                    int position, long id) {
                //   String name = (String) ((TextView)vClicked.findViewById(R.id.textItem1)).getText();
                String name = ((MyItem) adapter.getItem(position)).nName;
                Toast.makeText(FindStaion.this, name + " selected",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),
                        staioninfo.class);
                startActivity(intent);
            }
        });
    }
}
