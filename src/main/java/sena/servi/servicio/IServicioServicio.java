package sena.servi.servicio;

import sena.servi.entidad.Servicio;

import java.util.List;

public interface IServicioServicio {
    public List<Servicio> listarServicios();

    public Servicio buscarServicioPorId(Integer idServicio);

    public Servicio guardarServicio(Servicio servicio);

    public void eliminarServicio(Servicio servicio);
}
