package com.jessicaespindola.bijoux.rest.resources;

import com.jessicaespindola.bijoux.model.Carrinho;
import com.jessicaespindola.bijoux.rest.AbstractResource;
import com.jessicaespindola.bijoux.services.AbstractService;
import com.jessicaespindola.bijoux.services.CarrinhoService;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("carrinho")
public class CarrinhoResource extends AbstractResource<Carrinho> {

    @Inject
    private CarrinhoService service;
    
    @Override
    protected AbstractService<Carrinho> getService() {
        return service;
    }
    
}
