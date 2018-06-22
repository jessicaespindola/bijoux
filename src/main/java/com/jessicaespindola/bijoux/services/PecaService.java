package com.jessicaespindola.bijoux.services;

import com.jessicaespindola.bijoux.model.Peca;
import com.jessicaespindola.bijoux.utils.GenericDao;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;


@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class PecaService extends AbstractService<Peca>{

    @Inject
    private GenericDao<Peca> dao;
    
    @Override
    protected GenericDao<Peca> getDao() {
        return dao;
    }
}