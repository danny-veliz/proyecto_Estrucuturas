package modelo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


import Clases.LCDE;
import Clases.face;
import Clases.listasImagenes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class ViewBienvenidoController implements Initializable {

    @FXML
    private ImageView nodo1;
    @FXML
    private ImageView nodo2;
    @FXML
    private ImageView nodo3;
    
    @FXML
    private ImageView nodo4;
    @FXML
    private ImageView fondo;
    
    public static LCDE<ImageView> listaNodos= new LCDE<>();
    @FXML
    private ImageView faceboceto;
    @FXML
    private BorderPane borderPane;
    @FXML
    private VBox vbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fondo_Aplicacion();
        AggnodoyAciones();
        listasImagenes.llenarLCDEface();
        List<face> listacaras= listasImagenes.listaFace;
       
        
        Image imagen1= listacaras.get(1).getImagenFace();
        nodo1.setImage(imagen1);
        Image imagen2= listacaras.get(2).getImagenFace();
        nodo2.setImage(imagen2);
        Image imagen3= listacaras.get(3).getImagenFace();
        nodo3.setImage(imagen3);
        Image imagen4= listacaras.get(4).getImagenFace();
        nodo4.setImage(imagen4);
        aggFondo_Emoji();
        
       
        
    }

public void aggFondo_Emoji(){
    
    String s= "src\\main\\resources\\Mas\\gifFondo.gif";
    
        try {
            FileInputStream fil = new FileInputStream(s);
            Image i= new Image(fil);
            fondo.setImage(i);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    
}  

public void asignarEmojis_AlaLista(){
        List<face> listacaras= listasImagenes.listaFace;
       
        
        Image imagen1= listacaras.get(1).getImagenFace();
        nodo1.setImage(imagen1);
        Image imagen2= listacaras.get(2).getImagenFace();
        nodo2.setImage(imagen2);
        Image imagen3= listacaras.get(3).getImagenFace();
        nodo3.setImage(imagen3);
        Image imagen4= listacaras.get(4).getImagenFace();
        nodo4.setImage(imagen4);
        aggFondo_Emoji();
        
        
}

    @FXML
    private void next_Imagen(ActionEvent event) {
        Image im;
        String nom=" ";
        face f;
       for(ImageView imageView:listaNodos){
           im= imageView.getImage();
           f= new face(nom, im);
           imageView.setImage(listasImagenes.listaFace.obtenerSiguiente(f).getImagenFace());
       }
        
               
    }

    
    
    @FXML
    private void previous_Imagen(ActionEvent event) {
        Image im;
        String nom=" ";
        face f;
        ImageView in;
       for(int i=listaNodos.size();i>0;i--){
           in= listaNodos.get(i);
           im= in.getImage();
           f= new face(nom, im);
           in.setImage(listasImagenes.listaFace.obtenerPrevio(f).getImagenFace());
       }
    }


public void AggnodoyAciones(){
        listaNodos.add(nodo1);
        listaNodos.add(nodo2);
        listaNodos.add(nodo3);
        listaNodos.add(nodo4);
        
        for(ImageView i: listaNodos){
           i.setOnMouseClicked((MouseEvent event) -> {
           faceboceto.setImage(i.getImage());
        });
        }
}


public void fondo_Aplicacion(){
    
    
    FileInputStream f;
        try {
            f = new FileInputStream("src\\main\\resources\\Mas\\fondoAplicacion.png");
            Image im= new Image(f);
            BackgroundImage imaba= new BackgroundImage(im, BackgroundRepeat.SPACE, BackgroundRepeat.SPACE, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background back= new Background(imaba);
            borderPane.setBackground(back);
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    
    
    
}
    

     }
    

