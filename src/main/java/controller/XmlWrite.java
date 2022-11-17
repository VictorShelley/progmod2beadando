/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.json.JSONArray;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import controller.XmlRead;


/**
 *
 * @author PC
 */
public class XmlWrite {

   public static void Add(JSONArray uj) /*throws ParserConfigurationException, TransformerException*/ {
       
    JSONArray done = new JSONArray();
    XmlRead fa = new XmlRead();
    done = fa.ReadAllData();
    int eddigi = 0;
        //System.out.println("fa");
        //System.out.println(done.length());
        //System.out.println("max-5:" + done.get(done.length()-5));
    try {
        DocumentBuilderFactory dbFactory =
        DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();

        // root element
        Element rootElement = doc.createElement("submitted");
        doc.appendChild(rootElement);
        for(int i = 0;i<done.length();i=i+5){
        Element lineup = doc.createElement("lineup");
        rootElement.appendChild(lineup);

        Attr attr = doc.createAttribute("id");
        attr.setValue(String.valueOf(eddigi));
        lineup.setAttributeNode(attr);

        //if (eddigi!=(int)done.get(i))System.out.println("FUUUUUUUUUUUUUUUUUUUUUUUU" + eddigi + " -eddigi  done.get(i)-" + done.get(i));
        //else System.out.println("so far so good--" + eddigi + " " + done.get(i));
        
        Element map = doc.createElement("map");
        map.appendChild(doc.createTextNode(done.get(i+1).toString()));
        lineup.appendChild(map);

        Element landingLocation = doc.createElement("landingLocation");
        landingLocation.appendChild(doc.createTextNode(done.get(i+2).toString()));
        lineup.appendChild(landingLocation);

        Element aimLocation = doc.createElement("aimLocation");
        aimLocation.appendChild(doc.createTextNode(done.get(i+3).toString()));
        lineup.appendChild(aimLocation);

        Element UI = doc.createElement("UI");
        UI.appendChild(doc.createTextNode(done.get(i+4).toString()));
        lineup.appendChild(UI);
        eddigi++;
        }
        
        
        Element lineup = doc.createElement("lineup");
        rootElement.appendChild(lineup);

        Attr attr = doc.createAttribute("id");
        attr.setValue(String.valueOf(eddigi));
        lineup.setAttributeNode(attr);

        Element map = doc.createElement("map");
        map.appendChild(doc.createTextNode(uj.get(0).toString()));
        lineup.appendChild(map);

        Element landingLocation = doc.createElement("landingLocation");
        landingLocation.appendChild(doc.createTextNode(uj.get(1).toString()));
        lineup.appendChild(landingLocation);

        Element aimLocation = doc.createElement("aimLocation");
        aimLocation.appendChild(doc.createTextNode(uj.get(2).toString()));
        lineup.appendChild(aimLocation);

        Element UI = doc.createElement("UI");
        UI.appendChild(doc.createTextNode(uj.get(3).toString()));
        lineup.appendChild(UI);
        
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("D:\\Netbeans projects\\progmod2beadando\\src\\main\\java\\controller\\submitted.xml"));
        transformer.transform(source, result);
        
    } catch (Exception e) {
        e.printStackTrace();
    }//System.out.println("---------dfgdfgdfgdfg-dfgdf-g-dfg-dg-dfg-df-g-dfg-df-gdf-g-fdg-dfg-  " + eddigi);
  }
   
   public static void DelById(Integer del) /*throws ParserConfigurationException, TransformerException*/ {
       
    JSONArray done = new JSONArray();
    XmlRead fa = new XmlRead();
    done = fa.ReadAllData();
    int eddigi = 0;
        //System.out.println("fa");
        //System.out.println(done.length());
        //System.out.println("max-5:" + done.get(done.length()-5));
    try {
        DocumentBuilderFactory dbFactory =
        DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();

        // root element
        Element rootElement = doc.createElement("submitted");
        doc.appendChild(rootElement);
        for(int i = 0;i<done.length();i=i+5){
            if(Integer.parseInt(done.get(i).toString())==del)continue;
        //    System.out.println(done.get(i));
        Element lineup = doc.createElement("lineup");
        rootElement.appendChild(lineup);

        Attr attr = doc.createAttribute("id");
        attr.setValue(String.valueOf(eddigi));
        lineup.setAttributeNode(attr);

        //if (eddigi!=(int)done.get(i))System.out.println("FUUUUUUUUUUUUUUUUUUUUUUUU" + eddigi + " -eddigi  done.get(i)-" + done.get(i));
        //else System.out.println("so far so good--" + eddigi + " " + done.get(i));
        
        Element map = doc.createElement("map");
        map.appendChild(doc.createTextNode(done.get(i+1).toString()));
        lineup.appendChild(map);

        Element landingLocation = doc.createElement("landingLocation");
        landingLocation.appendChild(doc.createTextNode(done.get(i+2).toString()));
        lineup.appendChild(landingLocation);

        Element aimLocation = doc.createElement("aimLocation");
        aimLocation.appendChild(doc.createTextNode(done.get(i+3).toString()));
        lineup.appendChild(aimLocation);

        Element UI = doc.createElement("UI");
        UI.appendChild(doc.createTextNode(done.get(i+4).toString()));
        lineup.appendChild(UI);
        eddigi++;
        }
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("D:\\Netbeans projects\\progmod2beadando\\src\\main\\java\\controller\\submitted.xml"));
        transformer.transform(source, result);
        
    } catch (Exception e) {
        e.printStackTrace();
    }//System.out.println("---------dfgdfgdfgdfg-dfgdf-g-dfg-dg-dfg-df-g-dfg-df-gdf-g-fdg-dfg-  " + eddigi);
  }
}
