package sena.servi.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.servi.entidad.Inmueble;
import sena.servi.exception.RecursoNoEncontradoExcepcion;
import sena.servi.servicio.IInmuebleServicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
// http://localhost:8080/servi
@RequestMapping("servi")
@CrossOrigin(value = "http://localhost:3000")
public class InmuebleControlador {

    @Autowired
    private IInmuebleServicio inmuebleServicio;

    @GetMapping("/inmuebles")
    // http://localhost:8080/servi/inmuebles
    public List<Inmueble> inmuebles() {
        return inmuebleServicio.listarInmuebles();
    }

    @GetMapping("/inmuebles/{idCliente}")
    // http://localhost:8080/servi/inmuebles/{idCliente}
    public List<Inmueble> inmueblesPorCliente(@PathVariable Integer idCliente) {
        List<Inmueble> inmuebles = inmuebleServicio.listarInmuebles();
        List<Inmueble> inmueblesCliente = new ArrayList<>();
        for (Inmueble inmueble : inmuebles){
            if (inmueble.getIdCliente().equals(idCliente) && inmueble.getEstado().equals("activo")) {
                inmueblesCliente.add(inmueble);
            }
        }
        System.out.println("Lista de los inmuebles del cliente: " + inmuebles);
        return inmueblesCliente;
    }

    @PostMapping("/inmuebles")
    // http://localhost:8080/servi/inmuebles
    public Inmueble agregarInmueble(@RequestBody Inmueble inmueble) {
        System.out.println("Inmueble a agregar:" + inmueble);
        return inmuebleServicio.guardarInmueble(inmueble);
    }

    @PutMapping("/inmuebles/{idInmueble}")
    // http://localhost:8080/servi/inmuebles/{idInmueble}
    public ResponseEntity<Inmueble> modificarInmueble(@RequestBody Inmueble inmueble, @PathVariable Integer idInmueble) {
        Inmueble inmuebleABuscar = inmuebleServicio.buscarInmueblePorId(idInmueble);
        if (inmuebleABuscar == null) {
            throw new RecursoNoEncontradoExcepcion("El inmueble que se quiere modificar no existe: " + inmueble);
        } else {
            inmuebleServicio.guardarInmueble(inmueble);
            System.out.println("Inmueble modificado: " + inmueble);
            return ResponseEntity.ok(inmueble);
        }
    }

    @GetMapping("/inmuebles/idInmueble={idInmueble}")
    // http://localhost:8080/servi/inmuebles/idInmueble={idInmueble}
    public ResponseEntity<Inmueble> obtenerInmueblePorId(@PathVariable Integer idInmueble) {
        Inmueble inmueble = inmuebleServicio.buscarInmueblePorId(idInmueble);
        if (inmueble == null) {
            throw new RecursoNoEncontradoExcepcion("El id proporcionado no existe: " + idInmueble);
        } else {
            System.out.println("inmueble seleccionado: " + inmueble);
            return ResponseEntity.ok(inmueble);
        }
    }

    @DeleteMapping("/inmuebles/{id}")
    // http://localhost:8080/servi/inmuebles/{id}
    public ResponseEntity<Map<String,Boolean>> eliminarInmueble(@PathVariable Integer id) {
        Inmueble inmueble = inmuebleServicio.buscarInmueblePorId(id);
        if (inmueble == null) {
            throw new RecursoNoEncontradoExcepcion("El id proporcionado no existe: " + id);
        } else {
            inmuebleServicio.eliminarInmueble(inmueble);
            Map<String,Boolean> respuesta = new HashMap<>();
            respuesta.put("Inmuebles eliminado",true);
            return ResponseEntity.ok(respuesta);
        }
    }
}
