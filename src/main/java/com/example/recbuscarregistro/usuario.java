package com.example.recbuscarregistro;

public class usuario {

    private String codigo_pro;
    private String nombre_pro;
    private String precio_pro;
    private String cantidad_pro;

    public usuario(String codigo_pro, String nombre_pro, String precio_pro, String cantidad_pro) {
        this.codigo_pro = codigo_pro;
        this.nombre_pro = nombre_pro;
        this.precio_pro = precio_pro;
        this.cantidad_pro = cantidad_pro;
    }

    public String getCodigo_pro() {
        return codigo_pro;
    }

    public void setCodigo_pro(String codigo_pro) {
        this.codigo_pro = codigo_pro;
    }

    public String getNombre_pro() {
        return nombre_pro;
    }

    public void setNombre_pro(String nombre_pro) {
        this.nombre_pro = nombre_pro;
    }

    public String getPrecio_pro() {
        return precio_pro;
    }

    public void setPrecio_pro(String precio_pro) {
        this.precio_pro = precio_pro;
    }

    public String getCantidad_pro() {
        return cantidad_pro;
    }

    public void setCantidad_pro(String cantidad_pro) {
        this.cantidad_pro = cantidad_pro;
    }
}