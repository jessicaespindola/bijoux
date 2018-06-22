package com.jessicaespindola.bijoux.services;

import com.jessicaespindola.bijoux.model.Material;
import com.jessicaespindola.bijoux.utils.GenericDao;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;


@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class MaterialService extends AbstractService<Material>{

    @Inject
    private GenericDao<Material> dao;
    
    @Override
    protected GenericDao<Material> getDao() {
        return dao;
    }
}