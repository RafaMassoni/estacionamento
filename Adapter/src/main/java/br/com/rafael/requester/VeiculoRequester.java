package br.com.rafael.requester;

import br.com.rafael.enums.TipoVeiculo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public record VeiculoRequester(@NotNull TipoVeiculo tipoVeiculo,
                               @NotEmpty String placa,
                               @NotEmpty String cor) {

}