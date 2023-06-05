package br.com.rafael.daos;

import br.com.rafael.model.TiqueteModel;

import java.util.List;
import java.util.Optional;
public interface TiqueteDAO {
    TiqueteModel gravar(TiqueteModel tiqueteModel);
    Optional<TiqueteModel> buscarPorId(Integer idTiquete);

    List<TiqueteModel> buscarTodos();
}
