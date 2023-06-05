package br.com.rafael.mappers;

import br.com.rafael.model.TiqueteModel;
import br.com.rafael.responses.TiqueteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TiqueteResponseMapper {

    TiqueteResponseMapper INSTANCE = Mappers.getMapper(TiqueteResponseMapper.class);

    TiqueteResponse toResponse(TiqueteModel source);

}