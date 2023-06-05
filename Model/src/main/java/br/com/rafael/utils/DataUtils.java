package br.com.rafael.utils;

import br.com.rafael.model.TiqueteModel;

import java.time.Duration;
import java.time.LocalDateTime;

public class DataUtils {


    public static final DataUtils instance = new DataUtils();

    private DataUtils() {
    }

    public long diferencaEmMinutos(LocalDateTime de,LocalDateTime ate)
    {
        Duration duracao = Duration.between(de, ate);
        return duracao.toMinutes();
    }

}
