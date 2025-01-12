package gm.zona_fit;

import gm.zona_fit.modelo.Cliente;
import gm.zona_fit.servicio.IClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

//@SpringBootApplication //Ejectuar Aplicacion de consola
public class ZonaFitApplication implements CommandLineRunner {
	
	@Autowired
	private IClienteServicio clienteServicio; // ¿Por qué se ocupa la interfaz?

	private static final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class);
	String nl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Iniciando la aplicación");
		SpringApplication.run(ZonaFitApplication.class, args);
		logger.info("Aplicación finalizada\n");
	}
	
	@Override
	public void run(String... args) throws Exception {
		zonaFitApp();
	}

	private void zonaFitApp(){
		boolean salir = false;
		Scanner consola = new Scanner(System.in);
		while (!salir){
			try {
				int opcion = mostrarMenu(consola);
				salir = ejecutarOpciones(consola, opcion);
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
		}
	}//zonaFitApp

	private int mostrarMenu(Scanner consola){
		logger.info(""" 
				\n*** Aplicación ZonaFit (GYM) ***
				1. Listar Clientes
				2. Bucar Cliente por Id
				3. Agregar nuevo Cliente
				4. Modificar datos de Cliente
				5. Eliminar Cliente
				6. Salir
				""");
		return Integer.parseInt(consola.nextLine());
	}//mostrarMenu

	private boolean ejecutarOpciones(Scanner consola, int opcion) {
		boolean salir = false;
		switch(opcion) {
			case 1 ->{
				logger.info(nl + nl +"-------- Listado de Clientes ----------" + nl);
				List<Cliente> clientes = clienteServicio.listarClientes();
				clientes.forEach(c ->logger.info(c.toString() + nl));
				break;
			}
			case 2 ->{
				logger.info(nl + nl +"-------- Buscar Cliente por Id ----------" + nl);
				logger.info("Ingresa un Id: ");
				int id = Integer.parseInt(consola.nextLine());
				Cliente c = clienteServicio.buscarClientePorId(id);
				if (c != null)
					logger.info(c.toString());
				else
					logger.info("ERROR: Cliente con Id " + id + "no encontrado");
				break;
			}
			case 3 ->{
				logger.info(nl + "-------- Agregar nuevo Cliente ----------" + 
							nl + "Ingresa los datos del cliente " + 
							nl + "Nombre del Cliente: ");
				String nombre = consola.nextLine();
				logger.info(nl + "Apellido del Cliente: ");
				String apellido = consola.nextLine();
				logger.info(nl + "Membresia: ");
				int membresia = Integer.parseInt(consola.nextLine());
				Cliente c = new Cliente();
				c.setNombre(nombre);
				c.setApellido(apellido);
				c.setMembresia(membresia);
				clienteServicio.guardarCliente(c);
				logger.info(nl + "Cliente AGREGADO " + c +nl);
				break;
			}
			case 4 -> {
				logger.info(nl + "-------- Modificar datos de Cliente ----------" + 
						nl + "Ingresa el Id del Cliente ");
				int id = Integer.parseInt(consola.nextLine());
				Cliente c = clienteServicio.buscarClientePorId(id);
				if (c != null) {
					logger.info(nl + "Nombre: ");
					String nombre = consola.nextLine();
					logger.info("Apellido del Cliente: ");
					String apellido = consola.nextLine();
					logger.info("Membresia: ");
					int membresia = Integer.parseInt(consola.nextLine());
					c.setApellido(apellido);
					c.setMembresia(membresia);
					c.setNombre(nombre);
					clienteServicio.guardarCliente(c);
					logger.info(nl + "Cliente MODIFICADO " + c +nl);
				} else
					logger.info("ERROR: Cliente con Id " + id + " no encontrado");
				break;
			}
			case 5->{
				logger.info(nl + "-------- Eliminar datos de Cliente ----------" + 
						nl + "Ingresa el Id del Cliente ");
				int id = Integer.parseInt(consola.nextLine());
				Cliente c = clienteServicio.buscarClientePorId(id);
				if (c != null){
					clienteServicio.eliminarCliente(c);
					logger.info("Cliente ELIMINADO " + c + nl);
				} else
					logger.info("ERROR: Cliente con Id " + id + " no encontrado");
				break;
			}
			case 6->{
				salir = true;
				consola.close();
				logger.info("Hasta pronto!!!" +nl);
				break;
			}
			default ->{
				logger.info(nl + "OPCION " + opcion +" NO VALIDA");
			}
		}
		return salir;
	}//ejecutarOpciones

}
