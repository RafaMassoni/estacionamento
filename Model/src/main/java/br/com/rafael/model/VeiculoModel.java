package br.com.rafael.model;

import br.com.rafael.enums.TipoVeiculo;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class VeiculoModel {

    TipoVeiculo tipoVeiculo;
    String placa;
    String cor;
}
