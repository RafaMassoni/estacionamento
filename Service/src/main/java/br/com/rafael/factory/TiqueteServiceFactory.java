package br.com.rafael.factory;

import br.com.rafael.daos.TiqueteDAO;
import br.com.rafael.services.TiqueteService;

public class TiqueteServiceFactory {

    public static final TiqueteServiceFactory factory = new TiqueteServiceFactory();

    private TiqueteServiceFactory() {
    }

    public TiqueteService criar(TiqueteDAO tiqueteDAO)
    {
        return new TiqueteService(tiqueteDAO);
    }

}
