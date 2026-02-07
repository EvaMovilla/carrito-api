package edu.comillas.icai.gitt.pat.spring.carrito_api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/carritos")
public class ControladorCarrito {

    private final Map<String, ModeloCarrito> carritos = new HashMap<>();

    private double calcularPrecioFinal(int unidades){
        double precioUnitario = 9.99;
        return unidades * precioUnitario;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ModeloCarrito crear(@RequestBody ModeloCarrito nuevo) {

        double precioFinal = calcularPrecioFinal(nuevo.unidades());

        ModeloCarrito guardado = new ModeloCarrito(
                nuevo.idCarrito(),
                nuevo.idArticulo(),
                nuevo.descripcion(),
                nuevo.unidades(),
                precioFinal
        );

        carritos.put(guardado.idCarrito(), guardado);
        return guardado;
    }

    @GetMapping
    public java.util.Collection<ModeloCarrito> listar(){
        return carritos.values();
    }

    @GetMapping("/{idCarrito}")
    public ModeloCarrito obtener(@PathVariable String idCarrito) {
        ModeloCarrito carrito = carritos.get(idCarrito);
        if (carrito == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrito" + idCarrito + "no exite");
        }
        return carrito;
    }

    @PutMapping("/{idCarrito}")
    public ModeloCarrito actualizar(@PathVariable String idCarrito,
                                    @RequestBody ModeloCarrito datos){

        if(!carritos.containsKey(idCarrito)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrito" + idCarrito + "no exite");
        }

        double precioFinal = calcularPrecioFinal(datos.unidades());

        ModeloCarrito actualizado = new ModeloCarrito(
                idCarrito,
                datos.idArticulo(),
                datos.descripcion(),
                datos.unidades(),
                precioFinal
        );

        carritos.put(idCarrito, actualizado);
        return actualizado;
    }

    @DeleteMapping("/{idCarrito}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrar(@PathVariable String idCarrito){
        if(!carritos.containsKey(idCarrito)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrito" + idCarrito + "no exite");
        }
        carritos.remove(idCarrito);
    }
}
