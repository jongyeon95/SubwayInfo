package com.example.jongyepn.subwayinfo;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

public class GetData extends GetRequest {
    public GetData(Activity activity) {
        super(activity);
    }
    Variable variable;
    @Override
    protected void onPreExecute() {



        String serverURLStr = MainActivity.mainurl;

        try {
            url = new URL(serverURLStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPostExecute(String jsonString) {

         TextView textView = activity.findViewById(R.id.Information);


        try {
//          JSONArray jsonArray = new JSONArray(jsonString);
            JSONObject jsonObject = new JSONObject(jsonString);
            String Seo = jsonObject.getString("feeds").substring(1, jsonObject.getString("feeds").length() - 1);
            JSONObject jsonObject2 = new JSONObject(Seo);
            Log.e("로그", jsonObject.getString("feeds"));
            Log.e("로그", jsonObject2.getString("field2"));

            String field = jsonObject2.getString("field1");
            // 1번 칸에 사용합니다.


            String field1 = jsonObject2.getString("field1");
            String field2 = jsonObject2.getString("field2");
            String field3 = jsonObject2.getString("field3");
            String field4 = jsonObject2.getString("field4");


            variable.setField1(field1);
            variable.setField2(field2);
            variable.setField3(field3);
            variable.setField4(field4);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}