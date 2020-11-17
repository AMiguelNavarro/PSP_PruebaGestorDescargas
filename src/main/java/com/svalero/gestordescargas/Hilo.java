package com.svalero.gestordescargas;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class Hilo extends Thread{

    private Label lbNombre;
    private ProgressBar pbDescarga;

    public Hilo(Label lbNombre, ProgressBar pbDescarga){
        this.lbNombre = lbNombre;
        this.pbDescarga = pbDescarga;
    }

    /**
     * Este hilo comenzará a pintar la barra de progreso y los label con la info
     */
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie){
                ie.printStackTrace();
            }
            final int valor = i;
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    pbDescarga.setProgress((double)valor/5);
                }
            });

        }
    }
}