package br.com.rafael.daos;

import br.com.rafael.endidades.TiqueteEntidade;
import br.com.rafael.mappers.TiqueteEntidadeMapper;
import br.com.rafael.model.TiqueteModel;
import br.com.rafael.repositorys.TiqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TiqueteDAOImpl implements TiqueteDAO {

    @Autowired
    private TiqueteRepository tiqueteRepository;

    private final TiqueteEntidadeMapper tiqueteEntidadeMapper = TiqueteEntidadeMapper.INSTANCE;

    @Override
    public TiqueteModel gravar(TiqueteModel tiqueteModel) {
        TiqueteEntidade tiqueteEndidade = tiqueteEntidadeMapper.toEntidade(tiqueteModel);
        TiqueteEntidade save = tiqueteRepository.save(tiqueteEndidade);
        return tiqueteEntidadeMapper.toModel(save);
    }

    @Override
    public Optional<TiqueteModel> buscarPorId(Integer idTiquete) {
        Optional<TiqueteEntidade> tiqueteEndidade = tiqueteRepository.findById(idTiquete);
        return tiqueteEndidade.map(tiqueteEntidadeMapper::toModel);

    }

    @Override
    public List<TiqueteModel> buscarTodos() {
        List<TiqueteEntidade> todosTiquetes = tiqueteRepository.findAll();
        return todosTiquetes.stream().map(tiqueteEntidadeMapper::toModel).toList();
    }


}
