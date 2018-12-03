package com.example.jongyepn.subwayinfo;

import java.util.ArrayList;

public class Variable {

    private static Variable variable;
    private static ArrayList<AllSubwayInfo> allSubwayInfo = null;
    private static ArrayList<AllSubwayInfo> UPSubwayInfo = null;
    private static ArrayList<AllSubwayInfo> DNSubwayInfo = null;


    private static ArrayList<String> Line4 = new ArrayList<>();

    private Variable() {
        variable = new Variable();
    }

    public static Variable getInstance(){
        return variable;
    }

    public static ArrayList<AllSubwayInfo> getAllSubwayInfo() {
        return allSubwayInfo;
    }

    public static void setAllSubwayInfo(ArrayList<AllSubwayInfo> allSubwayInfo) {
        Variable.allSubwayInfo = allSubwayInfo;
    }


    public static ArrayList<String> getLine4() {
        return Line4;
    }

    public static void setLine4(ArrayList<String> line4) {
        Line4 = line4;
    }

    public static ArrayList<AllSubwayInfo> getUPSubwayInfo() {
        return UPSubwayInfo;
    }

    public static void setUPSubwayInfo(ArrayList<AllSubwayInfo> UPSubwayInfo) {
        Variable.UPSubwayInfo = UPSubwayInfo;
    }

    public static ArrayList<AllSubwayInfo> getDNSubwayInfo() {
        return DNSubwayInfo;
    }

    public static void setDNSubwayInfo(ArrayList<AllSubwayInfo> DNSubwayInfo) {
        Variable.DNSubwayInfo = DNSubwayInfo;
    }



}
