package br.com.rafael.controllers;


import br.com.rafael.factory.CalculoCobrancaFactory;
import br.com.rafael.interfaces.CalculoCobranca;
import br.com.rafael.mappers.TiqueteResponseMapper;
import br.com.rafael.mappers.VeiculoModelMapper;
import br.com.rafael.model.TiqueteModel;
import br.com.rafael.model.VeiculoModel;
import br.com.rafael.requester.FinalizarTiqueteRequester;
import br.com.rafael.requester.VeiculoRequester;
import br.com.rafael.responses.TiqueteResponse;
import br.com.rafael.services.TiqueteService;

import java.util.List;


public class TiqueteAdapter {

    private final TiqueteService tiqueteService;
    private final TiqueteResponseMapper tiqueteResponseMapper = TiqueteResponseMapper.INSTANCE;
    private final VeiculoModelMapper veiculoModelMapper = VeiculoModelMapper.INSTANCE;

    public TiqueteAdapter(TiqueteService tiqueteService) {
        this.tiqueteService = tiqueteService;
    }

    public List<TiqueteResponse> buscarTodos()
    {
        List<TiqueteModel> tiqueteModels = tiqueteService.buscarTodos();
        return tiqueteModels.stream().map(tiqueteResponseMapper::toResponse).toList();
    }

    public TiqueteResponse criarNovoTiquete(VeiculoRequester veiculoRequester) {
        VeiculoModel veiculoModel = veiculoModelMapper.toModel(veiculoRequester);
        TiqueteModel tiqueteModel = tiqueteService.novoTiquete(veiculoModel);
        return tiqueteResponseMapper.toResponse(tiqueteModel);
    }

    public void finalizarTiquete(FinalizarTiqueteRequester finalizarTiqueteRequester) {
        CalculoCobranca calculoCobranca = CalculoCobrancaFactory.factory.criarCalculoCobranca(finalizarTiqueteRequester.tipoCobranca());
        tiqueteService.finalizarTiquete(finalizarTiqueteRequester.idTiquete(),calculoCobranca);
    }

    public TiqueteResponse buscarPorId(Integer idTiquete) {
        TiqueteModel tiqueteModel = tiqueteService.buscarPorId(idTiquete);
        return tiqueteResponseMapper.toResponse(tiqueteModel);
    }
}
