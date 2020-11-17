package com.svalero.gestordescargas;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class Hilo extends Thread{

    public Label lbNombre, lbVelocidad, lbPorcentaje;
    public ProgressBar pbDescarga;
    public String mensaje;
    public Button btParar;


    private boolean detener;

    public Hilo(Label lbNombre, ProgressBar pbDescarga, Label lbVelocidad, Label lbPorcentaje, Button btParar){
        this.lbNombre = lbNombre;
        this.pbDescarga = pbDescarga;
        this.lbVelocidad = lbVelocidad;
        this.lbPorcentaje = lbPorcentaje;
        this.btParar = btParar;
        this.detener = false;
    }

    /**
     * Este hilo comenzará a pintar la barra de progreso y los label con la info
     * Se pone un numero aleatorio entre 0 y 20 para simular el timepo de descarga y hacerlo más real, de forma que va cambiando.
     */
    @Override
    public void run() {
        String URL = lbNombre.getText();
        int intervalo = (int) (Math.random() * 20) + 5;
        for (int i = 1; i <= intervalo/*i <= (int) (Math.random() * 20) + 5*/; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie){
                ie.printStackTrace();
            }

            if (detener){
                return;
            }

            int numVelocidad = (int) (Math.random()*100)+20;
            mensaje = String.valueOf(numVelocidad);
            mensaje += "MB/s";
            final int valor = i;
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    pbDescarga.setProgress((double)valor/intervalo);
                    lbNombre.setText("Descargando --> " + URL);
                    lbVelocidad.setText(mensaje);
                    lbPorcentaje.setText(valor * 100 / intervalo + " %");
                }
            });

        }
        btParar.setDisable(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                lbNombre.setText("Descarga finalizada con exito!!!");
                lbVelocidad.setText(" -- MB/s");
            }
        });
    }


    public void parar(){
        detener = true;
        btParar.setDisable(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                lbNombre.setText("-- Descarga parada --");
                lbVelocidad.setText(" -- MB/s");
            }
        });
    }
}