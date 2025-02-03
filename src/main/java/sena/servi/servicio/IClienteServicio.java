package sena.servi.servicio;

import sena.servi.entidad.Cliente;

import java.util.List;

public interface IClienteServicio {
    public List<Cliente> listarClientes();

    public Cliente buscarClientePorId(Integer idCliente);

    public Cliente guardarCliente(Cliente cliente);

    public void eliminarCliente(Cliente cliente);

}
