package br.com.rafael.repositorys;

import br.com.rafael.endidades.TiqueteEntidade;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TiqueteRepository extends JpaRepository<TiqueteEntidade, Integer> {
}
