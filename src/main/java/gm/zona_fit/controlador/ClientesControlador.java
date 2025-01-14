package gm.zona_fit.controlador;

import gm.zona_fit.modelo.Cliente;
import gm.zona_fit.servicio.IClienteServicio;
import jakarta.annotation.PostConstruct;
import org.hibernate.annotations.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientesControlador {
    private static final Logger logger = LoggerFactory.getLogger(ClientesControlador.class);
    private List<Cliente> clientes;
    @Autowired
    IClienteServicio clienteServicio;

    @PostConstruct //Después de llamar al constructor, se llama inmediatamente este método
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.clientes = this.clienteServicio.listarClientes();
        this.clientes.forEach(c -> logger.info(c.toString()));
    }
}
