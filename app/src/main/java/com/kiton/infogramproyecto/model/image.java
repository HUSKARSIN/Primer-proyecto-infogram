package com.kiton.infogramproyecto.model;

public class image {
    private String urlImage;
    private String username;
    private String cantidadDias;
    private String cantidadMeGusta;

    public image(String urlImage, String username, String cantidadDias, String cantidadMeGusta) {
        this.setUrlImagen(urlImage);
        this.setUsername(username);
        this.setCantidadDias(cantidadDias);
        this.setCantidadMeGusta(cantidadMeGusta);
    }


    public String getUrlImagen() {
        return urlImage;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImage = urlImagen;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(String cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public String getCantidadMeGusta() {
        return cantidadMeGusta;
    }

    public void setCantidadMeGusta(String cantidadMeGusta) {
        this.cantidadMeGusta = cantidadMeGusta;
    }
}