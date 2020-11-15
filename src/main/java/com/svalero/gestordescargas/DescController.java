package com.svalero.gestordescargas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class DescController {

    public Label lbURL, lbVelocidad;
    public ProgressBar pbProgreso;

    @FXML
    public void parar(ActionEvent event){

    }

    public void pintarDatos(String url){
        lbURL.setText(url);
    }

}
