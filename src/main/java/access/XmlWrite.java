/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package access;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author PC
 */
public class XmlWrite {
    
    public static void Write(){
          XMLOutputFactory output = XMLOutputFactory.newInstance();

          try{
              XMLStreamWriter writer = output.createXMLStreamWriter(new FileOutputStream("submitted.xml"));
              
              writer.writeStartDocument();
          }
          catch (FileNotFoundException e){
              e.printStackTrace();
          } catch (XMLStreamException ex) {
            Logger.getLogger(XmlWrite.class.getName()).log(Level.SEVERE, null, ex);
          }/*

          writer.writeStartDocument();

          writer.writeStartElement("test");

  // write other XML elements

          writer.writeEndDocument();

          writer.flush();

          writer.close();*/
    }
    
}
