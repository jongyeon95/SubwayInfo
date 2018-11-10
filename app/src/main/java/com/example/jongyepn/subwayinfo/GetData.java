package com.example.jongyepn.subwayinfo;

import android.os.AsyncTask;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.net.URL;

/**
 * Created by kwanwoo on 2017. 10. 17..
 */

public class GetData extends AsyncTask<String, Void, Void> {

    AllSubwayInfo allSubwayInfo = AllSubwayInfo.getInstance();
    Variable variable = Variable.getInstance();


    String KEY = allSubwayInfo.getKEY();
    String TYPE = allSubwayInfo.getTYPE();
    String SERVICE = allSubwayInfo.getSERVICE();
    Integer START_INDEX = allSubwayInfo.getStartIndex();
    Integer END_INDEX = allSubwayInfo.getEndIndex();
    String statnNm = allSubwayInfo.getStatnNm();



    @Override
    protected Void doInBackground(String... strings) {


        boolean inrow = false;
        boolean inrowNum = false;
        boolean inselectedCount = false;
        boolean intotalCount = false;
        boolean insubwayId = false;
        boolean inupdnLine = false;
        boolean intrainLineNm = false;
        boolean insubwayHeading = false;
        boolean instatnFid = false;
        boolean instatnTid = false;
        boolean instatnId = false;
        boolean instatnNm = false;
        boolean inordkey = false;
        boolean insubwayList = false;
        boolean instatnList = false;
        boolean inbarvlDt = false;
        boolean inbtrainNo = false;
        boolean inbstatnId = false;
        boolean inbstatnNm = false;
        boolean inrecptnDt = false;
        boolean inarvlMsg2 = false;
        boolean inarvlMsg3 = false;
        boolean inarvlCd = false;


        String rowNum = null;
        String selectedCount = null;
        String totalCount = null;
        String subwayId = null;
        String updnLine = null;
        String trainLineNm = null;
        String subwayHeading = null;
        String statnFid = null;
        String statnTid = null;
        String statnId = null;
        //String statnNm = null;
        String ordkey = null;
        String subwayList = null;
        String statnList = null;
        String barvlDt = null;
        String btrainNo = null;
        String bstatnId = null;
        String bstatnNm = null;
        String recptnDt = null;
        String arvlMsg2 = null;
        String arvlMsg3 = null;
        String arvlCd = null;


        try {
            Log.d("로그", "에러가났습니당1");
            URL url = new URL("http://swopenAPI.seoul.go.kr/api/subway/" + KEY + "/" + TYPE + "/" + SERVICE + "/" + START_INDEX + "/" + END_INDEX + "/" + statnNm);

            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();
            Log.d("로그", url.toString());

            parser.setInput(url.openStream(), null);

            int parserEvent = parser.getEventType();

            Log.d("로그", "파싱시작합니다");


            //variable.getAllSubwayInfo();  // 하 시ㅡㅂ럴ㄹ


            while (parserEvent != XmlPullParser.END_DOCUMENT) {

                switch (parserEvent) {
                    case XmlPullParser.START_TAG://parser가 시작 태그를 만나면 실행
                        if (parser.getName().equals("rowNum")) { //title 만나면 내용을 받을수 있게 하자
                            inrowNum = true;
                        }
                        if (parser.getName().equals("selectedCount")) { //title 만나면 내용을 받을수 있게 하자
                            inselectedCount = true;
                        }
                        if (parser.getName().equals("totalCount")) { //title 만나면 내용을 받을수 있게 하자
                            intotalCount = true;
                        }
                        if (parser.getName().equals("subwayId")) { //title 만나면 내용을 받을수 있게 하자
                            insubwayId = true;
                        }
                        if (parser.getName().equals("updnLine")) { //title 만나면 내용을 받을수 있게 하자
                            inupdnLine = true;
                        }
                        if (parser.getName().equals("trainLineNm")) { //title 만나면 내용을 받을수 있게 하자
                            intrainLineNm = true;
                        }
                        if (parser.getName().equals("subwayHeading")) { //title 만나면 내용을 받을수 있게 하자
                            insubwayHeading = true;
                        }
                        if (parser.getName().equals("statnFid")) { //title 만나면 내용을 받을수 있게 하자
                            instatnFid = true;
                        }
                        if (parser.getName().equals("statnTid")) { //title 만나면 내용을 받을수 있게 하자
                            instatnTid = true;
                        }
                        if (parser.getName().equals("statnId")) { //title 만나면 내용을 받을수 있게 하자
                            instatnId = true;
                        }
                        if (parser.getName().equals("statnNm")) { //title 만나면 내용을 받을수 있게 하자
                            instatnNm = true;
                        }
                        if (parser.getName().equals("ordkey")) { //title 만나면 내용을 받을수 있게 하자
                            inordkey = true;
                        }
                        if (parser.getName().equals("subwayList")) { //title 만나면 내용을 받을수 있게 하자
                            insubwayList = true;
                        }
                        if (parser.getName().equals("statnList")) { //title 만나면 내용을 받을수 있게 하자
                            instatnList = true;
                        }
                        if (parser.getName().equals("barvlDt")) { //title 만나면 내용을 받을수 있게 하자
                            inbarvlDt = true;
                        }
                        if (parser.getName().equals("btrainNo")) { //title 만나면 내용을 받을수 있게 하자
                            inbtrainNo = true;
                        }
                        if (parser.getName().equals("bstatnId")) { //title 만나면 내용을 받을수 있게 하자
                            inbstatnId = true;
                        }
                        if (parser.getName().equals("bstatnNm")) { //title 만나면 내용을 받을수 있게 하자
                            inbstatnNm = true;
                        }
                        if (parser.getName().equals("recptnDt")) { //title 만나면 내용을 받을수 있게 하자
                            inrecptnDt = true;
                        }
                        if (parser.getName().equals("arvlMsg2")) { //title 만나면 내용을 받을수 있게 하자
                            inarvlMsg2 = true;
                        }
                        if (parser.getName().equals("arvlMsg3")) { //title 만나면 내용을 받을수 있게 하자
                            inarvlMsg3 = true;
                        }
                        if (parser.getName().equals("arvlCd")) { //title 만나면 내용을 받을수 있게 하자
                            inarvlCd = true;
                        }
                        break;

                    case XmlPullParser.TEXT:
                        if (inrowNum) {
                            rowNum = parser.getText();
                            inrowNum = false;
                        }
                        if (inselectedCount) {
                            selectedCount = parser.getText();
                            inselectedCount = false;
                        }
                        if (intotalCount) {
                            totalCount = parser.getText();
                            intotalCount = false;
                        }
                        if (insubwayId) {
                            subwayId = parser.getText();
                            insubwayId = false;
                        }
                        if (inupdnLine) {
                            updnLine = parser.getText();
                            inupdnLine = false;
                        }
                        if (intrainLineNm) {
                            trainLineNm = parser.getText();
                            intrainLineNm = false;
                        }
                        if (insubwayHeading) {
                            subwayHeading = parser.getText();
                            insubwayHeading = false;
                        }
                        if (instatnFid) {
                            statnFid = parser.getText();
                            instatnFid = false;
                        }
                        if (instatnTid) {
                            statnTid = parser.getText();
                            instatnTid = false;
                        }
                        if (instatnId) {
                            statnId = parser.getText();
                            instatnId = false;
                        }
                        if (instatnNm) {
                            statnNm = parser.getText();
                            instatnNm = false;
                        }
                        if (inordkey) {
                            ordkey = parser.getText();
                            inordkey = false;
                        }
                        if (insubwayList) {
                            subwayList = parser.getText();
                            insubwayList = false;
                        }
                        if (instatnList) {
                            statnList = parser.getText();
                            instatnList = false;
                        }
                        if (inrowNum) {
                            rowNum = parser.getText();
                            inrowNum = false;
                        }
                        if (inbarvlDt) {
                            barvlDt = parser.getText();
                            inbarvlDt = false;
                        }
                        if (inbtrainNo) {
                            btrainNo = parser.getText();
                            inbtrainNo = false;
                        }
                        if (inbstatnId) {
                            bstatnId = parser.getText();
                            inbstatnId = false;
                        }
                        if (inbstatnNm) {
                            bstatnNm = parser.getText();
                            inbstatnNm = false;
                        }
                        if (inrecptnDt) {
                            recptnDt = parser.getText();
                            inrecptnDt = false;
                        }
                        if (inarvlMsg2) {
                            arvlMsg2 = parser.getText();
                            inarvlMsg2 = false;
                        }
                        if (inarvlMsg3) {
                            arvlMsg3 = parser.getText();
                            inarvlMsg3 = false;
                        }
                        if (inarvlCd) {
                            arvlCd = parser.getText();
                            inarvlCd = false;
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("row")) {

                            allSubwayInfo.setRowNum(rowNum);
                            allSubwayInfo.setSelectedCount(selectedCount);
                            allSubwayInfo.setTotalCount(totalCount);
                            allSubwayInfo.setSubwayId(subwayId);
                            allSubwayInfo.setUpdnLine(updnLine);
                            allSubwayInfo.setTrainLineNm(trainLineNm);
                            allSubwayInfo.setSubwayHeading(subwayHeading);
                            allSubwayInfo.setStatnFid(statnFid);
                            allSubwayInfo.setStatnTid(statnTid);
                            allSubwayInfo.setStatnId(statnId);
                            allSubwayInfo.setStatnNm(statnNm);
                            allSubwayInfo.setOrdkey(ordkey);
                            allSubwayInfo.setSubwayList(subwayList);
                            allSubwayInfo.setStatnList(statnList);
                            allSubwayInfo.setBarvlDt(barvlDt);
                            allSubwayInfo.setBtrainNo(btrainNo);
                            allSubwayInfo.setBstatnId(bstatnId);
                            allSubwayInfo.setBstatnNm(bstatnNm);
                            allSubwayInfo.setRecptnDt(recptnDt);
                            allSubwayInfo.setArvlMsg2(arvlMsg2);
                            allSubwayInfo.setArvlMsg3(arvlMsg3);
                            allSubwayInfo.setArvlCd(arvlCd);


                             variable.getAllSubwayInfo().add(allSubwayInfo);  //여기서 왜 널포인트가 나는걸까???


                            Log.d("로그", rowNum + selectedCount + totalCount + subwayId + updnLine + trainLineNm + subwayHeading + statnFid
                                    + statnTid + statnId + statnNm + ordkey + subwayList + statnList + barvlDt + btrainNo + bstatnId + bstatnNm + recptnDt +
                                    arvlMsg2 + arvlMsg3 + arvlCd);
                        }
                }
                parserEvent = parser.next();

            }

            variable.getAllSubwayInfo().clear();

        } catch (IOException e) {
            e.printStackTrace();
            Log.d("로그", "에러가났습니당!");
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        return null;
    }

//    public GetData(Activity activity) {
//        super(activity);
//    }


}
