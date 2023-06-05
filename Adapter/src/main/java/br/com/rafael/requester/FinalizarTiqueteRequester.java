package br.com.rafael.requester;

import br.com.rafael.enums.TipoCobranca;
import jakarta.validation.constraints.NotNull;


public record FinalizarTiqueteRequester(@NotNull Integer idTiquete,
                                        @NotNull TipoCobranca tipoCobranca) {

}