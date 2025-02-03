package sena.servi.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.servi.entidad.Cliente;
import sena.servi.entidad.Inmueble;
import sena.servi.exception.RecursoNoEncontradoExcepcion;
import sena.servi.servicio.IClienteServicio;
import sena.servi.servicio.IInmuebleServicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//http://localhost:8080/servi
@RequestMapping("servi")
@CrossOrigin(value = "http://localhost:3000")
public class ClienteControlador {

    @Autowired
    private IClienteServicio clienteServicio;

    @Autowired
    private IInmuebleServicio inmuebleServicio;

    @GetMapping("/clientes")
    // http://localhost:8080/servi/clientes
    public List<Cliente> listaClientes() {
        return clienteServicio.listarClientes();
    }

    @PostMapping("/clientes")
    // http://localhost:8080/servi/clientes
    public Cliente agregarCliente(@RequestBody Cliente cliente) {
        System.out.println("Cliente a agregar: " + cliente);
        return clienteServicio.guardarCliente(cliente);
    }

    @GetMapping("/clientes/{id}")
    // http://localhost:8080/servi/clientes/{id}
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Integer id) {
        Cliente cliente = clienteServicio.buscarClientePorId(id);
        if (cliente == null) {
            throw new RecursoNoEncontradoExcepcion("El id proporcionado no existe: " + id);
        } else {
            System.out.println("Cliente encontrado: " + cliente);
            return ResponseEntity.ok(cliente);
        }
    }

    @GetMapping("/clientes/email={email}")
    // http://localhost:8080/servi/clientes/email={email}
    public Boolean existCliente(@PathVariable String email) {
        Boolean clienteEncontrado=false;
        List<Cliente> clientes= clienteServicio.listarClientes();
        for (Cliente cliente: clientes) {
            if (cliente.getEmail().equals(email)) {
                System.out.println("Cliente encontrado por email: " + cliente);
                clienteEncontrado = true;
                break;
            }
        }
        return clienteEncontrado;
    }


    @GetMapping("/clientes/email={email}/password={password}")
    // http://localhost:8080/servi/clientes/email={email}/password={password}
    public Cliente isClienteLogueado(@PathVariable String email, @PathVariable String password) {
        Cliente clienteEncontrado = null;
        List<Cliente> clientes = clienteServicio.listarClientes();
        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equals(email) && cliente.getContrasena().equals(password)) {
                System.out.println("Clientes encontrado " + cliente.toString());
                clienteEncontrado = cliente;
                break;
            }
        }if (clienteEncontrado != null) {
            System.out.println("Cliente logueado");
        } else {
            System.out.println("Cliente No logueado");
        }
        return clienteEncontrado;
    }



    @PutMapping("/clientes/{idCliente}")
    // http://localhost:8080/servi/clientes/{id}
    public ResponseEntity<Cliente> modificarCliente(@PathVariable Integer idCliente, @RequestBody Cliente clienteAModificar) {
        Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
        if (cliente == null) {
            throw new RecursoNoEncontradoExcepcion("El usuario que se quiere modificar no existe: " + cliente);
        } else {
            clienteServicio.guardarCliente(clienteAModificar);
            return ResponseEntity.ok(clienteAModificar);
        }
    }

    @DeleteMapping("/clientes/{id}")
    // http://localhost:8080/servi/clientes/{id}
    public ResponseEntity<Map<String, Boolean>> eliminarCliente(@PathVariable Integer id) {
        Cliente cliente = clienteServicio.buscarClientePorId(id);
        if (cliente == null) {
            throw new RecursoNoEncontradoExcepcion("El id recibido no existe: " + id);
        } else {
            List<Inmueble> inmuebles = inmuebleServicio.listarInmuebles();
            for (Inmueble inmueble : inmuebles) {
                if (inmueble.getIdCliente().equals(id)) {
                    inmuebleServicio.eliminarInmueble(inmueble);
                    System.out.println("Inmueble eliminado: " + inmueble.toString()) ;
                }
            }
            clienteServicio.eliminarCliente(cliente);
            System.out.println("Cliente eliminado: " + cliente.toString());
            Map<String, Boolean> respuesta = new HashMap<>();
            respuesta.put("Cliente eliminado",true);
            return ResponseEntity.ok(respuesta);
        }
    }
}
