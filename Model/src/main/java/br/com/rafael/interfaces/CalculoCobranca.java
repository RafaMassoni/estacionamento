package br.com.rafael.interfaces;

import br.com.rafael.model.TiqueteModel;

import java.math.BigDecimal;

public interface CalculoCobranca {


    BigDecimal calcularValor(TiqueteModel tiqueteModel);

}
