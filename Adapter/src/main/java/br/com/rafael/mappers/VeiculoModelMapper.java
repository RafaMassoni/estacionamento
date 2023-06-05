package br.com.rafael.mappers;

import br.com.rafael.model.TiqueteModel;
import br.com.rafael.model.VeiculoModel;
import br.com.rafael.requester.VeiculoRequester;
import br.com.rafael.responses.TiqueteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VeiculoModelMapper {

    VeiculoModelMapper INSTANCE = Mappers.getMapper(VeiculoModelMapper.class);

    VeiculoModel toModel(VeiculoRequester source);

}