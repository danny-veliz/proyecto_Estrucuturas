/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;

/**
 *
 * @author Usuario
 */
public class listasImagenes {
     public static  LCDE<face> listaFace;
     
     
     
     
     
     
     
  public  static void  llenarLCDEface(){
       listaFace= new LCDE<face>();
      
        File folder = new File("src\\main\\resources\\images\\faces");
        File[] files = folder.listFiles();
        
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".png")) {
                   String nom= file.getName();
                    FileInputStream archi;
                    Image im;
                    face f;
                    try {
                        archi = new FileInputStream("src\\main\\resources\\images\\faces\\"+nom);
                        im= new Image(archi);
                        f = new face(nom, im);
                        listaFace.add(f);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                        
            }
        }
    }
}
}
