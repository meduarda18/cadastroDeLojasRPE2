package br.com.rpe.lojas.cadastro.repository;


import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rpe.lojas.cadastro.entity.LojaFisica;

@Repository
public interface LojaFisicaRepository extends JpaRepository<LojaFisica, UUID> {
  //resolvi fazer a ordenação da lista de lojas no repositorio para manter o princípio da responsabilidade única no meu método listarLojasFisicas
  List<LojaFisica> findAllByOrderByNomeAsc();

  List<LojaFisica> findAllByCnpj(String cnpj);
}
