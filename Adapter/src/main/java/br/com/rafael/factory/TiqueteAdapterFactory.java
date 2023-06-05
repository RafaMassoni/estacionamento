package br.com.rafael.factory;

import br.com.rafael.controllers.TiqueteAdapter;
import br.com.rafael.daos.TiqueteDAO;
import br.com.rafael.services.TiqueteService;

public class TiqueteAdapterFactory {

    public static final TiqueteAdapterFactory factory = new TiqueteAdapterFactory();

    private TiqueteAdapterFactory() {
    }

    public TiqueteAdapter criar(TiqueteDAO tiqueteDAO)
    {
        TiqueteService tiqueteService = TiqueteServiceFactory.factory.criar(tiqueteDAO);
        return new TiqueteAdapter(tiqueteService);
    }

}
