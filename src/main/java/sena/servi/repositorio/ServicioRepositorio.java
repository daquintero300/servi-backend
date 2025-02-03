package sena.servi.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.servi.entidad.Servicio;

public interface ServicioRepositorio extends JpaRepository<Servicio, Integer> {
}
