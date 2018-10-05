package com.holamundo.personasmaterial;

public class Carro {
    private int foto;
    private String placa;
    private int marca;
    private String precio ;
    private int color;

    public Carro(int foto, String placa, int marca, String precio, int color) {
        this.foto = foto;
        this.placa = placa;
        this.marca = marca;
        this.precio = precio;
        this.color = color;
    }

    public Carro(int foto, String placa, String precio, int color, int marca) {
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void guardar() { Datos.agregar(this);    }
}
