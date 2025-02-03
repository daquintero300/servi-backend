package sena.servi.servicio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.servi.entidad.Cliente;
import sena.servi.repositorio.ClienteRepositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@Service
public class ClienteServicio implements IClienteServicio{

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente buscarClientePorId(Integer idCliente) {
        return clienteRepositorio.findById(idCliente).orElse(null);
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clienteRepositorio.delete(cliente);
    }
}