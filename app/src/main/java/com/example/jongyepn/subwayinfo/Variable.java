package com.example.jongyepn.subwayinfo;

import java.util.ArrayList;

public class Variable {

    private static Variable variable;
    private static ArrayList<AllSubwayInfo> allSubwayInfo = new ArrayList<AllSubwayInfo>();


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


}
