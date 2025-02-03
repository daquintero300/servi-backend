package sena.servi.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sena.servi.entidad.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

}
