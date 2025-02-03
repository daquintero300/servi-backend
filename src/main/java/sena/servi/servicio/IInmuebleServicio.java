package sena.servi.servicio;

import sena.servi.entidad.Inmueble;

import java.util.List;

public interface IInmuebleServicio {
    public List<Inmueble> listarInmuebles();

    public Inmueble buscarInmueblePorId(Integer idInmueble);

    public Inmueble guardarInmueble(Inmueble inmueble);

    public void eliminarInmueble(Inmueble inmueble);
}
