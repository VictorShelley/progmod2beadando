/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author PC
 */
public class Lineup implements ILineup {
    private Integer id;
    private MapEnum map; //Split, Bind, Ascend, Pearl, Breeze, Icebox, Fracture, Haven
    private String landingLocation;
    private String aimLocation;
    private String UI;

    public Lineup(MapEnum map, String landingLocation, String aimLocation, String UI) {
        //this.map = MapEnum.valueOf(map);
        this.map = map;
        this.landingLocation = landingLocation;
        this.aimLocation = aimLocation;
        this.UI = UI;
    }
    
    public Lineup(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public MapEnum getMap() {
        return map;
    }

    public String getLandingLocation() {
        return landingLocation;
    }

    public String getAimLocation() {
        return aimLocation;
    }

    public String getUI() {
        return UI;
    }
    
    @Override
    public String toString(){
        return "id: " + this.id + ", map: " + this.map + ", landingLocation: " + this.landingLocation + ", aimLocation: " + this.aimLocation + ", UI: " + this.UI;
    }
}
