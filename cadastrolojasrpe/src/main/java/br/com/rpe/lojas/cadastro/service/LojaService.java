package br.com.rpe.lojas.cadastro.service;

import br.com.rpe.lojas.cadastro.entity.LojaFisica;
import br.com.rpe.lojas.cadastro.entity.LojaVirtual;
import br.com.rpe.lojas.cadastro.repository.LojaFisicaRepository;
import br.com.rpe.lojas.cadastro.repository.LojaVirtualRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class LojaService {
  private final LojaFisicaRepository lojaFisicaRepository;
  private final LojaVirtualRepository lojaVirtualRepository;
  
  public LojaService(LojaFisicaRepository lojaFisicaRepository, LojaVirtualRepository lojaVirtualRepository){
    this.lojaFisicaRepository = lojaFisicaRepository;
    this.lojaVirtualRepository = lojaVirtualRepository;
  }

  //criar loja fisica
  public void criarLojaFisica(LojaFisica loja){
    lojaFisicaRepository.save(loja);
  }

  //listar lojas fisicas existentes
  public List<LojaFisica> listarLojasFisicas(){
    return lojaFisicaRepository.findAllByOrderByNomeAsc();
  }

  //editar loja fisica
  public void editarLojaFisica(LojaFisica loja){
    lojaFisicaRepository.save(loja);
  }

  //remover loja fisica
  public void removerLojaFisica(UUID id){
    lojaFisicaRepository.deleteById(id);
  }

  //buscar loja fisica por cnpj
  public List<LojaFisica> buscarLojaFisicaCnpj(int cnpj){
    return lojaFisicaRepository.findAllByCnpj(cnpj);
  }


  //criar loja virtual
  public void criarLojaVirtual(LojaVirtual loja){
    lojaVirtualRepository.save(loja);
  }

  //listar lojas virtuais existentes
  public List<LojaVirtual> listarLojasVirtuais(){
    return lojaVirtualRepository.findAllByOrderByNomeAsc();
  }

  //editar loja virtual
  public void editarLojaVirtual(LojaVirtual loja){
    lojaVirtualRepository.save(loja);
  }

  //remover loja virtual
  public void removerLojaVirtual(UUID id){
    lojaVirtualRepository.deleteById(id);
  }

  public List<LojaVirtual> buscarLojaVirtualCnpj(int cnpj){
    return lojaVirtualRepository.findAllByCnpj(cnpj);
  }

}
