package br.com.rpe.lojas.cadastro.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rpe.lojas.cadastro.entity.LojaVirtual;

public interface LojaVirtualRepository extends JpaRepository<LojaVirtual, UUID> {
  //resolvi fazer a ordenação da lista de lojas no repositorio para manter o princípio da responsabilidade única no meu método listarLojasFisicas
  List<LojaVirtual> findAllByOrderByNomeAsc();

  List<LojaVirtual> findAllByCnpj(int cnpj);
} 
