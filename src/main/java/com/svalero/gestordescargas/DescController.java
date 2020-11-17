package com.svalero.gestordescargas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class DescController {

    public Label lbNombre, lbVelocidad;
    public ProgressBar pbDescarga;

    @FXML
    public void parar(ActionEvent event){

    }

    public void pintarDatos(String url){
        lbNombre.setText("Descargando --> " + url);
        Hilo hilo = new Hilo(lbNombre, pbDescarga);
        hilo.start();
    }

}
