package sena.servi.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.servi.entidad.Servicio;
import sena.servi.repositorio.ServicioRepositorio;

import java.util.List;

@Service
public class ServicioServicio implements IServicioServicio{

    @Autowired
    ServicioRepositorio servicioRepositorio;

    @Override
    public List<Servicio> listarServicios() {
        return servicioRepositorio.findAll();
    }

    @Override
    public Servicio buscarServicioPorId(Integer idServicio) {
        return servicioRepositorio.findById(idServicio).orElse(null);
    }

    @Override
    public Servicio guardarServicio(Servicio servicio) {
        return servicioRepositorio.save(servicio);
    }

    @Override
    public void eliminarServicio(Servicio servicio) {
        servicioRepositorio.delete(servicio);
    }
}
