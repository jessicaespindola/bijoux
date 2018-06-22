package com.jessicaespindola.bijoux.rest.resources;

import com.jessicaespindola.bijoux.model.Material;
import com.jessicaespindola.bijoux.rest.AbstractResource;
import com.jessicaespindola.bijoux.services.AbstractService;
import com.jessicaespindola.bijoux.services.MaterialService;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("material")
public class MaterialResource extends AbstractResource<Material> {

    @Inject
    private MaterialService service;
    
    @Override
    protected AbstractService<Material> getService() {
        return service;
                
                
    }
    
}