package br.com.rafael.model;

import br.com.rafael.enums.TipoVeiculo;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class TiqueteModel {

    private Integer id;
    private TipoVeiculo tipoVeiculo;
    private LocalDateTime fimAtendimento;
    private LocalDateTime inicioAtendimento;
    private BigDecimal valor;
    private String placa;
    private String cor;


}
