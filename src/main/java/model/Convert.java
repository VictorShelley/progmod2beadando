/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import business.MapEnum;
import business.Lineup;
import layout.LineupLayout;
import org.json.JSONArray;

/**
 *
 * @author Marci
 */
public class Convert {
    
    
    public static JSONArray StringToLineup(String szoveg) {
        String szetszedve[] = szoveg.split("-",4);
        //String szetszedve[] = {"Bind","A","B","C"};
        MapEnum map = MapEnum.valueOf(szetszedve[0]);
        //String map = szetszedve[0];
        String landingLocation = szetszedve[1];
        String aimLocation = szetszedve[2];
        String UI = szetszedve[3];
        
        LineupLayout temp = new LineupLayout(map, landingLocation, aimLocation, UI);
        JSONArray test = temp.toJsonArray();
        
        return test;
    }
}
