package sena.servi.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.servi.entidad.Inmueble;
import sena.servi.repositorio.InmuebleRepositorio;

import java.util.List;

@Service
public class InmuebleServicio implements IInmuebleServicio{

    @Autowired
    private InmuebleRepositorio inmuebleRepositorio;

    @Override
    public List<Inmueble> listarInmuebles() {
        return inmuebleRepositorio.findAll();
    }

    @Override
    public Inmueble buscarInmueblePorId(Integer idInmueble) {
        return inmuebleRepositorio.findById(idInmueble).orElse(null);
    }

    @Override
    public Inmueble guardarInmueble(Inmueble inmueble) {
        return inmuebleRepositorio.save(inmueble);
    }

    @Override
    public void eliminarInmueble(Inmueble inmueble) {
        inmuebleRepositorio.delete(inmueble);
    }
}
