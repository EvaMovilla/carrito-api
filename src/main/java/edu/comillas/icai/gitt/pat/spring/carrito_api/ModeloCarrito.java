package edu.comillas.icai.gitt.pat.spring.carrito_api;

public record ModeloCarrito (
    String idCarrito,
    String idArticulo,
    String descripcion,
    Integer unidades,
    Double precioFinal
) {}
