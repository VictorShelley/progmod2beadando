/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONArray;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import access.XmlRead;
import business.MapEnum;
import layout.LineupLayout;
/**
 *
 * @author PC
 */
public class XmlService {
    
    public JSONArray getAllLog(){
        JSONArray exceptions = new JSONArray();
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            File f = new File("log.xml");
            Document xml = builder.parse(f);
            xml.normalize();
            NodeList nodes = xml.getElementsByTagName("lineup");
            for(int i = 0; i < nodes.getLength(); i++){
                Node node = nodes.item(i);
                Element ex = (Element)node;
                /*lineup.appendChild(map);
                lineup.appendChild(landingL);
                lineup.appendChild(aimL);
                lineup.appendChild(UI);*/
                String mapString = ex.getElementsByTagName("map").item(0).getTextContent();
                MapEnum map = MapEnum.valueOf(mapString);
                String landingL = ex.getElementsByTagName("landingL").item(0).getTextContent();
                String aimL = ex.getElementsByTagName("aimL").item(0).getTextContent();
                String UI = ex.getElementsByTagName("UI").item(0).getTextContent();
                exceptions.put(new LineupLayout(map, landingL, aimL, UI).toJson());
            }
        }
        catch(Exception ex){
            new XmlRead().handleException(ex);
        }
        return exceptions;
    }
            
}
