/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import business.MapEnum;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 *
 * @author PC
 */
public class XmlRead {
    
    //private static final String FILENAME = "submitted.xml";
    //private static final String FILENAME = "D:\\Netbeans Projects\\progmod2beadando\\src\\main\\java\\controller\\submitted.xml"; //PC
    private static final String FILENAME = "D:\\Netbeans projects\\progmod2beadando\\src\\main\\java\\controller\\submitted.xml"; //Laptop
    public JSONArray ReadAll() {
        JSONArray read = new JSONArray();
      
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

      try {
          
          DocumentBuilder db = dbf.newDocumentBuilder();

          Document doc = db.parse(new File(FILENAME));
          doc.getDocumentElement().normalize();

          System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
          System.out.println("------");
          
          NodeList list = doc.getElementsByTagName("lineup");

          for (int temp = 0; temp < list.getLength(); temp++) {

              Node node = list.item(temp);

              if (node.getNodeType() == Node.ELEMENT_NODE) {

                  Element element = (Element) node;

                  String id = element.getAttribute("id");//lineup id

                  //szöveg
                  String mapstring = element.getElementsByTagName("map").item(0).getTextContent();
                  MapEnum map= MapEnum.valueOf(mapstring);
                  String landingLocation = element.getElementsByTagName("landingLocation").item(0).getTextContent();
                  String aimLocation = element.getElementsByTagName("aimLocation").item(0).getTextContent();
                  String UI = element.getElementsByTagName("UI").item(0).getTextContent();

                  
                  read.put("id: " + id);
                  read.put("Map: " + map);
                  read.put("Landing Location: " + landingLocation);
                  read.put("Aim Location: " + aimLocation);
                  read.put("UI: " + UI);

              }
          }

      } catch (ParserConfigurationException | SAXException | IOException e) {
          e.printStackTrace();
      }
      
        return read;
  }
    
    public JSONArray ReadAllData() {
        JSONArray read = new JSONArray();
      
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

      try {
          
          DocumentBuilder db = dbf.newDocumentBuilder();

          Document doc = db.parse(new File(FILENAME));
          doc.getDocumentElement().normalize();

          System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
          System.out.println("------");
          
          NodeList list = doc.getElementsByTagName("lineup");

          for (int temp = 0; temp < list.getLength(); temp++) {

              Node node = list.item(temp);

              if (node.getNodeType() == Node.ELEMENT_NODE) {

                  Element element = (Element) node;

                  String id = element.getAttribute("id");//lineup id

                  //szöveg
                  String mapstring = element.getElementsByTagName("map").item(0).getTextContent();
                  MapEnum map= MapEnum.valueOf(mapstring);
                  String landingLocation = element.getElementsByTagName("landingLocation").item(0).getTextContent();
                  String aimLocation = element.getElementsByTagName("aimLocation").item(0).getTextContent();
                  String UI = element.getElementsByTagName("UI").item(0).getTextContent();

                  
                  read.put(id);
                  read.put(map);
                  read.put(landingLocation);
                  read.put(aimLocation);
                  read.put(UI);

              }
          }

      } catch (ParserConfigurationException | SAXException | IOException e) {
          e.printStackTrace();
      }
        //String asdfasz = read.get(3).toString();
        //for(int i =0;i<10;i++) read.put(asdfasz);
        return read;
  }
}
