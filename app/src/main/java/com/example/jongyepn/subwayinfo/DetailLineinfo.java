package com.example.jongyepn.subwayinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class DetailLineinfo extends AppCompatActivity {

    Variable variable;
    TextView PreiviousStation;
    TextView NextStation;
    TextView Down1;
    TextView Down2;
    TextView Up1;
    TextView Up2;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stationinfo);
        Intent intent = getIntent();
        String infostation = intent.getStringExtra("INFO");  // 인텐트로 받은 현재역 넣은거
        TextView staioninfotext = (TextView) findViewById(R.id.centertext);   // 현재역 넣은거
        staioninfotext.setText(infostation);

        Log.e("지하철",variable.getDNSubwayInfo().get(0).getArvlMsg3() + "  " + variable.getDNSubwayInfo().get(0).getArvlMsg2());
        Log.e("지하철",variable.getDNSubwayInfo().get(1).getArvlMsg3() + "  " + variable.getDNSubwayInfo().get(0).getArvlMsg2());
        Log.e("지하철",variable.getDNSubwayInfo().get(2).getArvlMsg3() + "  " + variable.getDNSubwayInfo().get(0).getArvlMsg2());
        Log.e("지하철",variable.getDNSubwayInfo().get(3).getArvlMsg3() + "  " + variable.getDNSubwayInfo().get(0).getArvlMsg2());

        for (int i = 1; i < variable.getLine4().size(); i++) {  // 0은 제외로함 지금 왜냐면 첫역은 따로처리해야하니까

            if (infostation.equals(variable.getLine4().get(i))) {  // 한성대 였을때
                PreiviousStation.setText(variable.getLine4().get(i - 1));  // 성신여대
                NextStation.setText(variable.getLine4().get(i + 1));  // 혜화
            }
        }

        Down1.setText(variable.getDNSubwayInfo().get(0).getArvlMsg3() + "  " + variable.getDNSubwayInfo().get(0).getArvlMsg2());
        Down2.setText(variable.getDNSubwayInfo().get(1).getArvlMsg3() + "  " + variable.getDNSubwayInfo().get(1).getArvlMsg2());

        Up1.setText(variable.getUPSubwayInfo().get(0).getArvlMsg3() + "  " + variable.getUPSubwayInfo().get(0).getArvlMsg2());
        Up2.setText(variable.getUPSubwayInfo().get(1).getArvlMsg3() + "  " + variable.getUPSubwayInfo().get(1).getArvlMsg2());


    }
}
