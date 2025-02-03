package sena.servi.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.servi.entidad.Inmueble;

public interface InmuebleRepositorio extends JpaRepository<Inmueble, Integer> {
}
