package com.jessicaespindola.bijoux.services;

import com.jessicaespindola.bijoux.model.Carrinho;
import com.jessicaespindola.bijoux.utils.GenericDao;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;


@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class CarrinhoService extends AbstractService<Carrinho> {

    @Inject
    private GenericDao<Carrinho> dao;
    
    @Override
    protected GenericDao<Carrinho> getDao() {
        return dao;
    }
}