package sena.servi.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.servi.entidad.Servicio;
import sena.servi.exception.RecursoNoEncontradoExcepcion;
import sena.servi.servicio.ServicioServicio;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("servi")
// http://localhost:8080/servi
@CrossOrigin(value = "http://localhost:3000")
public class ServicioControlador {

    @Autowired
    ServicioServicio servicioServicio;

    @GetMapping("/servicios")
    // http://localhost:8080/servi/servicios
    public List<Servicio> servicios(){
        return servicioServicio.listarServicios();
    }

    @GetMapping("/servicios/idServicio={idServicio}")
    // http://localhost:8080/servi/servicios/idServicio={idServicio}
    public ResponseEntity<Servicio> servicio(@PathVariable Integer idServicio) {
        Servicio servicio = servicioServicio.buscarServicioPorId(idServicio);
        if (servicio == null) {
            throw new RecursoNoEncontradoExcepcion("El id proporcionado no existe: " + idServicio);
        } else {
            return ResponseEntity.ok(servicio);
        }
    }

    @GetMapping("/servicios/idInmueble={idInmueble}")
    // http://localhost:8080/servi/servicios/idInmueble={idInmueble}
    public List<Servicio> serviciosPorInmueble(@PathVariable Integer idInmueble) {
        List<Servicio> servicios = servicioServicio.listarServicios();
        List<Servicio> serviciosInmueble = new ArrayList<>();
        for (Servicio servicio : servicios) {
            if (servicio.getIdInmueble().equals(idInmueble)) {
                serviciosInmueble.add(servicio);
                System.out.println("Servicio encontrado: " + servicio);
            }
        }
        return serviciosInmueble;
    }

    @PutMapping("/servicios/idServicio={idServicio}")
    // http://localhost:8080/servi/servicios/idServicio={idServicio}
    public ResponseEntity<Servicio> modificarServicio(@PathVariable Integer idServicio, @RequestBody Servicio servicio) {
        Servicio servicioAEncontrar = servicioServicio.buscarServicioPorId(idServicio);
        if (servicio == null) {
            throw new RecursoNoEncontradoExcepcion("El id del servicio proporcionado no existe: " + idServicio);
        } else {
            servicioServicio.guardarServicio(servicio);
            return ResponseEntity.ok(servicio);
        }
    }
}
