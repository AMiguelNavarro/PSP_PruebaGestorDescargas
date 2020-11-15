package com.svalero.gestordescargas;

public class Hilo extends Thread{

    private String url;

    public Hilo(String url){
        this.url = url;
    }

    /**
     * Este hilo comenzará a pintar la barra de progreso y los label con la info
     */
    @Override
    public void run() {

    }
}