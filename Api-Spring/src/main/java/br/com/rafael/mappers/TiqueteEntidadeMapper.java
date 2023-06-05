package br.com.rafael.mappers;

import br.com.rafael.endidades.TiqueteEntidade;
import br.com.rafael.model.TiqueteModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TiqueteEntidadeMapper {
    TiqueteEntidadeMapper INSTANCE = Mappers.getMapper(TiqueteEntidadeMapper.class);

    TiqueteEntidade toEntidade(TiqueteModel source);

    TiqueteModel toModel(TiqueteEntidade save);
}