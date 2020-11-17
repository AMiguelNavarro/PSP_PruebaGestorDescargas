package com.svalero.gestordescargas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class DescController {

    public Label lbNombre, lbVelocidad, lbPorcentaje;
    public ProgressBar pbDescarga;
    public Button btParar;

    private Hilo hilo;

    @FXML
    public void parar(ActionEvent event){
        hilo.parar();
    }

    public void pintarDatos(String url){
        lbNombre.setText(url);
        hilo = new Hilo(lbNombre, pbDescarga, lbVelocidad, lbPorcentaje, btParar);
        hilo.start();
    }

}
