package br.com.rafael.calc;

import br.com.rafael.enums.TipoVeiculo;
import br.com.rafael.model.TiqueteModel;

import java.math.BigDecimal;

public class ValorTiqueteCalc {


    private long getQuantidadeCiclosParaSeremCobrados(long diferencaEmMinutos) {
        long minutosTolerancia = 10;
        long minutosParaCadaCicloDeCobranca = 60;


        long quantidadePeriodosParaSeremCobrados = diferencaEmMinutos / minutosParaCadaCicloDeCobranca;
        boolean incrementarCobrancaNoUltimoPeriodo = (diferencaEmMinutos % minutosParaCadaCicloDeCobranca) > minutosTolerancia;

        if (incrementarCobrancaNoUltimoPeriodo)
            quantidadePeriodosParaSeremCobrados++;


        return quantidadePeriodosParaSeremCobrados;
    }


    private BigDecimal getValorPorHoraDoVeiculo(TipoVeiculo tipoVeiculo)
    {
        return switch (tipoVeiculo) {
            case MOTO -> new BigDecimal(2);
            case CARRO -> new BigDecimal(5);
            case ONIBUS -> new BigDecimal(10);
            case CAMINHAO ->  new BigDecimal(20);
        };
    }

    public BigDecimal calcularValorParaSerCobrado(TiqueteModel tiquete, long minutosQueSeraoCobrados) {
        var quantidadePeriodosParaSeremCobrados = getQuantidadeCiclosParaSeremCobrados(minutosQueSeraoCobrados);
        return getValorPorHoraDoVeiculo(tiquete.getTipoVeiculo()).multiply(new BigDecimal(quantidadePeriodosParaSeremCobrados));
    }

}
