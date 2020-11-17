package com.svalero.gestordescargas;


import com.svalero.gestordescargas.util.R;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class AppController {

    public TextField tfURL;
    public Button btAnadir;
    public ScrollPane spDescargas;
    public VBox vbDescargas;

    @FXML
    public void anadir(ActionEvent event){
        String URL = tfURL.getText();
        try{
            FXMLLoader loader = new FXMLLoader();

            DescController controller = new DescController();

            loader.setLocation(R.getUI("descarga.fxml"));
            loader.setController(controller);
            VBox descarga = loader.load();

            spDescargas.setContent(vbDescargas);
            vbDescargas.getChildren().add(descarga);

            controller.pintarDatos(URL);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}