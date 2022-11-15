/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.json.JSONArray;
import org.w3c.dom.Document;
import org.w3c.dom.Element;



/**
 *
 * @author PC
 */
public class XmlWrite {
    
    public static void Add(JSONArray sor) throws ParserConfigurationException, TransformerException {
        
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("submitted");
        doc.appendChild(rootElement);
        
        doc.createElement("lineup");
        rootElement.appendChild(doc.createElement("lineup"));
    }
    
}
//https://www.tutorialspoint.com/compile_java_online.php

/*package com.tutorialspoint.xml;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

public class CreateXmlFileDemo {

   public static void main(String argv[]) {

      try {
         DocumentBuilderFactory dbFactory =
         DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.newDocument();
         
         // root element
         Element rootElement = doc.createElement("submitted");
         doc.appendChild(rootElement);
        for(int i = 0;i<3;i++){
         // supercars element
         Element lineup = doc.createElement("lineup");
         rootElement.appendChild(lineup);

         // setting attribute to element
         Attr attr = doc.createAttribute("id");
         String ident = String.valueOf(i);
         attr.setValue(ident);
         lineup.setAttributeNode(attr);

         // carname element
         Element map = doc.createElement("map");
         map.appendChild(doc.createTextNode("Bind"));
         lineup.appendChild(map);
         
         Element landingLocation = doc.createElement("la");
         landingLocation.appendChild(doc.createTextNode("land"));
         lineup.appendChild(landingLocation);
         
         Element aimLocation = doc.createElement("ai");
         map.appendChild(doc.createTextNode("Aim"));
         lineup.appendChild(map);
         
         Element UI = doc.createElement("UI");
         map.appendChild(doc.createTextNode("Cross"));
         lineup.appendChild(map);
}
         /*Element carname1 = doc.createElement("carname");
         Attr attrType1 = doc.createAttribute("type");
         attrType1.setValue("sports");
         carname1.setAttributeNode(attrType1);
         carname1.appendChild(doc.createTextNode("Ferrari 202"));
         lineup.appendChild(carname1);*/

         // write the content into xml file
/////////////itten
         /*TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer();
         DOMSource source = new DOMSource(doc);
         StreamResult result = new StreamResult(new File("C:\\cars.xml"));
         transformer.transform(source, result);
         
         // Output to console for testing
         StreamResult consoleResult = new StreamResult(System.out);
         transformer.transform(source, consoleResult);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}*/