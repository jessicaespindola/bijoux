package com.jessicaespindola.bijoux.rest.resources;

import com.jessicaespindola.bijoux.model.Peca;
import com.jessicaespindola.bijoux.rest.AbstractResource;
import com.jessicaespindola.bijoux.services.AbstractService;
import com.jessicaespindola.bijoux.services.PecaService;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("pecas")
public class PecaResource extends AbstractResource<Peca> {

    @Inject
    private PecaService service;
    
    @Override
    protected AbstractService<Peca> getService() {
        return service;
                
                
    }
    
}