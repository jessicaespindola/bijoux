package com.jessicaespindola.bijoux.rest.resources;

import com.jessicaespindola.bijoux.model.Cliente;
import com.jessicaespindola.bijoux.rest.AbstractResource;
import com.jessicaespindola.bijoux.services.AbstractService;
import com.jessicaespindola.bijoux.services.ClienteService;
import javax.inject.Inject;
import javax.ws.rs.Path;


@Path("clientes")
public class ClienteResource extends AbstractResource<Cliente> {

    @Inject
    private ClienteService service;

    @Override
    protected AbstractService<Cliente> getService() {
        return service;
    }

}
