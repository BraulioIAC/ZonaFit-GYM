package gm.zona_fit.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gm.zona_fit.modelo.Cliente;
import gm.zona_fit.repositorio.ClienteRepositorio;

@Service
public class ClienteServicio implements IClienteServicio{
	
	@Autowired
	private ClienteRepositorio clienteRepositorio; //Se inyecta un objeto de tipo REPOSITORY

	@Override
	public List<Cliente> listarClientes() {
		return clienteRepositorio.findAll();
	}

	@Override
	public Cliente buscarClientePorId(Integer id) {
		return clienteRepositorio.findById(id).orElse(null); //Si encuentra, regresa un Optional, de lo constrario, regresas null
	}

	@Override
	public void guardarCliente(Cliente cliente) {
		clienteRepositorio.save(cliente);
	}

	@Override
	public Cliente eliminarCliente(Cliente cliente) {
		if(clienteRepositorio.existsById(cliente.getId())) {
			var tmpClient = cliente;
			clienteRepositorio.delete(cliente);
			return tmpClient;
		}else
			return null;
	}
	
}
