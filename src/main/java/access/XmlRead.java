/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package access;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author PC
 */
public class XmlRead {
    
    
    public void handleException(Exception ex){
    
        try{ //Integer id,MapEnum map, String landingLocation, String aimLocation, String UI
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            File f = new File("submitted.xml");
            Document xml = builder.parse(f);
            xml.normalize();
            Element root = xml.getDocumentElement();
            Element lineup = xml.createElement("lineup");
            Element map = xml.createElement("map");
            map.setTextContent(ex.getMessage());
            Element landingL = xml.createElement("landingL");
            landingL.setTextContent(ex.getMessage());
            Element aimL = xml.createElement("aimL");
            aimL.setTextContent(ex.getMessage());
            Element UI = xml.createElement("UI");
            UI.setTextContent(ex.getMessage());
            //TODO: adatokat ki kell még menteni!!!!
            
            lineup.appendChild(map);
            lineup.appendChild(landingL);
            lineup.appendChild(aimL);
            lineup.appendChild(UI);
            root.appendChild(lineup);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(xml);
            StreamResult result = new StreamResult(f);
            transformer.transform(source, result);
            
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        
    }
}
