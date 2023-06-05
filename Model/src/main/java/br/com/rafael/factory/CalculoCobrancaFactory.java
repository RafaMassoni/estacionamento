package br.com.rafael.factory;

import br.com.rafael.calc.ValorTiqueteCalc;
import br.com.rafael.enums.TipoCobranca;
import br.com.rafael.enums.TipoVeiculo;
import br.com.rafael.interfaces.CalculoCobranca;
import br.com.rafael.model.TiqueteModel;
import br.com.rafael.utils.DataUtils;

import java.math.BigDecimal;

public class CalculoCobrancaFactory {

    public final static CalculoCobrancaFactory factory = new CalculoCobrancaFactory();


    private final DataUtils dataUtils = DataUtils.instance;

    private final ValorTiqueteCalc valorTiqueteCalc = new ValorTiqueteCalc();

    private CalculoCobrancaFactory() {
    }


    public CalculoCobranca criarCalculoCobranca(TipoCobranca tipoCobranca) {
        return switch (tipoCobranca) {
            case GRATUITO -> ((tiquete) -> BigDecimal.ZERO);
            case DESCONTO_FUNCIONARIO -> this::calculoComDescontoParaFuncionario;
            case DESCONTO_CLIENTE_VIP -> this::calculoComDescontoParaClienteVip;
            case CONVENCIONAL -> this::calculoConvencional;
        };
    }



    private BigDecimal calculoComDescontoParaFuncionario(TiqueteModel tiquete) {
        var diferencaEmMinutos = dataUtils.diferencaEmMinutos(tiquete.getInicioAtendimento(), tiquete.getFimAtendimento());
        var toleranciaParaFuncionarios = 120;

        if (diferencaEmMinutos > toleranciaParaFuncionarios) {
            var  minutosQueSeraoCobrados = diferencaEmMinutos - toleranciaParaFuncionarios;
            return valorTiqueteCalc.calcularValorParaSerCobrado(tiquete, minutosQueSeraoCobrados);

        } else {
            return BigDecimal.ZERO;
        }
    }



    private BigDecimal calculoComDescontoParaClienteVip(TiqueteModel tiquete) {
     return calculoConvencional(tiquete).multiply(new BigDecimal("0.40"));
    }

    private BigDecimal calculoConvencional(TiqueteModel tiquete) {
        long diferencaEmMinutos = dataUtils.diferencaEmMinutos(tiquete.getInicioAtendimento(), tiquete.getFimAtendimento());
        return valorTiqueteCalc.calcularValorParaSerCobrado(tiquete, diferencaEmMinutos);
    }


}
