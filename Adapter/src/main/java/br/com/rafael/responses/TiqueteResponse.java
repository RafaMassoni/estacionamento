package br.com.rafael.responses;

import br.com.rafael.enums.TipoVeiculo;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public record TiqueteResponse(LocalDateTime inicioAtendimento,
                              Integer id,
     TipoVeiculo tipoVeiculo,
     LocalDateTime fimAtendimento,
     BigDecimal valor,
     String placa,
     String cor
){

}
