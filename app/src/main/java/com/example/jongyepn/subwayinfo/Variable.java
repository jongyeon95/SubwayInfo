package com.example.jongyepn.subwayinfo;

import java.util.ArrayList;

public class Variable {

    private static Variable variable;
    private static ArrayList<SubwayInfo> SubwayInfo = new ArrayList();
    private static ArrayList<SubwayInfo> UPSubwayInfo = new ArrayList();
    private static ArrayList<SubwayInfo> DNSubwayInfo = new ArrayList();


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
