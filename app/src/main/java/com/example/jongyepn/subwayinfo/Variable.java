package com.example.jongyepn.subwayinfo;

import java.util.ArrayList;

public class Variable {

    private static Variable variable;
    private static ArrayList<SubwayInfo> SubwayInfo = new ArrayList();
    private static ArrayList<SubwayInfo> UPSubwayInfo = new ArrayList();
    private static ArrayList<SubwayInfo> DNSubwayInfo = new ArrayList();

    private static String field1 = "";
    private static String field2 = "";
    private static String field3 = "";
    private static String field4 = "";

    public static String getField1() {
        return field1;
    }

    public static void setField1(String field1) {
        Variable.field1 = field1;
    }

    public static String getField2() {
        return field2;
    }

    public static void setField2(String field2) {
        Variable.field2 = field2;
    }

    public static String getField3() {
        return field3;
    }

    public static void setField3(String field3) {
        Variable.field3 = field3;
    }

    public static String getField4() {
        return field4;
    }

    public static void setField4(String field4) {
        Variable.field4 = field4;
    }

    private static ArrayList<String> Line4 = new ArrayList<>();

    private Variable() {
        variable = new Variable();
    }

    public static Variable getInstance(){
        return variable;
    }

    public static ArrayList<SubwayInfo> getSubwayInfo() {
        return SubwayInfo;
    }

    public static void setSubwayInfo(ArrayList<SubwayInfo> SubwayInfo) {
        Variable.SubwayInfo = SubwayInfo;
    }


    public static ArrayList<String> getLine4() {
        return Line4;
    }

    public static void setLine4(ArrayList<String> line4) {
        Line4 = line4;
    }

    public static ArrayList<SubwayInfo> getUPSubwayInfo() {
        return UPSubwayInfo;
    }

    public static void setUPSubwayInfo(ArrayList<SubwayInfo> UPSubwayInfo) {
        Variable.UPSubwayInfo = UPSubwayInfo;
    }

    public static ArrayList<SubwayInfo> getDNSubwayInfo() {
        return DNSubwayInfo;
    }

    public static void setDNSubwayInfo(ArrayList<SubwayInfo> DNSubwayInfo) {
        Variable.DNSubwayInfo = DNSubwayInfo;
    }



}
