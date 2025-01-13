package gm.zona_fit.servicio;

import java.util.List;

import gm.zona_fit.modelo.Cliente;

public interface IClienteServicio {
	public List<Cliente> listarClientes();
	public Cliente buscarClientePorId(Integer id);
	public void guardarCliente(Cliente cliente); //Puede insertar o actualizar un registro con el metodo save
	public Cliente eliminarCliente(Cliente cliente);
}
