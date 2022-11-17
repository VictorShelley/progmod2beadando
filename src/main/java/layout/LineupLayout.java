/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layout;

import org.json.JSONObject;
import business.MapEnum;
import java.util.Map;
import org.json.JSONArray;
/**
 *
 * @author PC
 */
public class LineupLayout {
    
    public MapEnum map; //Split, Bind, Ascend, Pearl, Breeze, Icebox, Fracture, Haven
    public String landingLocation;
    public String aimLocation;
    public String UI;

    public LineupLayout(MapEnum map, String landingLocation, String aimLocation, String UI) {
        //this.map = MapEnum.valueOf(map);
        this.map = map;
        this.landingLocation = landingLocation;
        this.aimLocation = aimLocation;
        this.UI = UI;
    }

    /*public JSONObject toJsonObject(){
        JSONObject exception = new JSONObject();
        exception.put("map", this.map);
        exception.put("landingLocation", this.landingLocation);
        exception.put("aimLocation", this.aimLocation);
        exception.put("UI", this.UI);
        return exception;
    }*/
    public JSONArray toJsonArray(){
        JSONArray sor = new JSONArray();
        sor.put(this.map);
        sor.put(this.landingLocation);
        sor.put(this.aimLocation);
        sor.put(this.UI);
        return sor;
    }
    
    
    
}
