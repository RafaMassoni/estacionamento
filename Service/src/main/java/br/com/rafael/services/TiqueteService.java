package br.com.rafael.services;


import br.com.rafael.daos.TiqueteDAO;
import br.com.rafael.interfaces.CalculoCobranca;
import br.com.rafael.model.TiqueteModel;
import br.com.rafael.model.VeiculoModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


public class TiqueteService {

    private final TiqueteDAO tiqueteDAO;

    public TiqueteService(TiqueteDAO tiqueteDAO) {
        this.tiqueteDAO = tiqueteDAO;
    }

    public TiqueteModel novoTiquete(VeiculoModel veiculoModel)
    {


        TiqueteModel tiqueteModel = new TiqueteModel();
        tiqueteModel.setInicioAtendimento(LocalDateTime.now());
        tiqueteModel.setTipoVeiculo(veiculoModel.getTipoVeiculo());
        tiqueteModel.setPlaca(veiculoModel.getPlaca());
        tiqueteModel.setCor(veiculoModel.getCor());

        return tiqueteDAO.gravar(tiqueteModel);
    }


    public TiqueteModel finalizarTiquete(Integer idTiquete, CalculoCobranca calculoCobranca)
    {


        TiqueteModel tiqueteModel = buscarPorId(idTiquete);
        tiqueteModel.setFimAtendimento(LocalDateTime.now());
        BigDecimal valorParaSerCobrado = calculoCobranca.calcularValor(tiqueteModel);
        tiqueteModel.setValor(valorParaSerCobrado);

        return tiqueteDAO.gravar(tiqueteModel);
    }

    public List<TiqueteModel> buscarTodos() {
        return tiqueteDAO.buscarTodos();
    }

    public TiqueteModel buscarPorId(Integer idTiquete) {
        return tiqueteDAO.buscarPorId(idTiquete)
                .orElseThrow(() -> new RuntimeException("Tiquete não existe na base de dados"));
    }
}
