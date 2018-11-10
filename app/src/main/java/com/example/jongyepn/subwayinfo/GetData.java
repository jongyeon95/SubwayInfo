package com.example.jongyepn.subwayinfo;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;

public class GetData extends GetRequest {
    public GetData(Activity activity) {
        super(activity);
    }

    @Override
    protected void onPreExecute() {
        TextView textView =  activity.findViewById(R.id.text);

        String serverURLStr = "https://api.thingspeak.com/channels/553851/feeds.json?results=1";

        try {
            url = new URL(serverURLStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPostExecute(String jsonString) {

        // TextView textView =  activity.findViewById(R.id.text); 종연이꺼에는 아직 텍스트뷰 처리안함


        if (jsonString == null)
            return;
        //feed 앞에서 끊어줍니다.
        int index = jsonString.indexOf("\"feeds\"");
        String seo = jsonString.substring(index,jsonString.length());
        // , 로 나눠줍니다.
        String userData[] = seo.split(",");
        // 추출후에
        String userValue[] = new String[userData.length]; //추출후에 담을거
        // 생각해 윤석아.. 제발!!
        Log.d("값", String.valueOf(index));
        Log.d("값",seo);

        for (int i = 0; i < userData.length; i++) { //
            Log.d("값",userData[i]);
            int idx = userData[i].indexOf(":");
            if(i==11){
                int index2 = userData[i].indexOf("\"}]}");
                // 뒤에 없애주는 것
                userValue[i] = userData[i].substring(idx+2, userData[i].length() - (userData[i].length() - index2));
            } else{
                // 의미 없습니다. 이것들 굳이 안해줘도 되는데 , 앞에 값을 위해서 해준 것입니다.
                userValue[i] = userData[i].substring(idx+2, userData[i].length()-1);
            }
            //userValue[i].replace("\"", ""); //처음이랑 마지막꺼는 버려야함 이상한 값임
            Log.d("마지막", userValue[i]);
        }

        // textView.setText("온도 값 :" +userValue[2] +"습도 값 :" + userValue[3] +"혼잡도 :" + userValue[4]+"미세먼지 값 :" + userValue[5]);  // jsonString을 잘라야함
        Log.d("서윤석","온도 값 :" +userValue[2] +"습도 값 :" + userValue[3] +"혼잡도 :" + userValue[4]+"미세먼지 값 :" + userValue[5]);

    }

}