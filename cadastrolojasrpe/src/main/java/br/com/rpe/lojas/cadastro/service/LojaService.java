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

  //construtor
  public LojaService(LojaFisicaRepository lojaFisicaRepository, LojaVirtualRepository lojaVirtualRepository){
    this.lojaFisicaRepository = lojaFisicaRepository;
    this.lojaVirtualRepository = lojaVirtualRepository;
  }

  public <T> void criarLoja(T loja) {
    if (loja instanceof LojaFisica) {
      lojaFisicaRepository.save((LojaFisica) loja);
    } else if (loja instanceof LojaVirtual) {
        lojaVirtualRepository.save((LojaVirtual) loja);
    }
  }

  public <T> void editarLoja(UUID id, T loja, Class<?> tipoLoja) {
    if (tipoLoja.equals(LojaFisica.class)) {
      LojaFisica lojaExistente = lojaFisicaRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Loja física não encontrada com ID: " + id));
      // Atualizar os campos da loja existente com os valores da loja passada como parâmetro
      LojaFisica lojaAtualizada = (LojaFisica) loja;

      lojaExistente.setCnpj(lojaAtualizada.getCnpj());
      lojaExistente.setNome(lojaAtualizada.getNome());
      lojaExistente.setSegmento(lojaAtualizada.getSegmento());
      lojaExistente.setTelefone(lojaAtualizada.getTelefone());
      lojaExistente.setEnderecoFisico(lojaAtualizada.getEnderecoFisico());
      lojaExistente.setNumeroFuncionarios(lojaAtualizada.getNumeroFuncionarios());

      lojaFisicaRepository.save(lojaExistente);

    } else if (tipoLoja.equals(LojaVirtual.class)) {
        LojaVirtual lojaExistente = lojaVirtualRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Loja virtual não encontrada com ID: " + id));
        // Atualizar os campos da loja existente com os valores da loja passada como parâmetro
        LojaVirtual lojaAtualizada = (LojaVirtual) loja;
        lojaExistente.setCnpj(lojaAtualizada.getCnpj());
        lojaExistente.setNome(lojaAtualizada.getNome());
        lojaExistente.setSegmento(lojaAtualizada.getSegmento());
        lojaExistente.setTelefone(lojaAtualizada.getTelefone());
        lojaExistente.setUrl(lojaAtualizada.getUrl());
        lojaExistente.setAvaliacao(lojaAtualizada.getAvaliacao());
        lojaVirtualRepository.save(lojaExistente);
    }
}

  public void removerLoja(UUID id, Class<?> tipoLoja) {
    if (tipoLoja.equals(LojaFisica.class)) {
      lojaFisicaRepository.deleteById(id);
    } else if (tipoLoja.equals(LojaVirtual.class)) {
        lojaVirtualRepository.deleteById(id);
    }
  }

  //listar lojas fisicas existentes
  public List<LojaFisica> listarLojasFisicas(){
    return lojaFisicaRepository.findAllByOrderByNomeAsc();
  }

  //buscar loja fisica por cnpj
  public List<LojaFisica> buscarLojaFisicaCnpj(String cnpj){
    return lojaFisicaRepository.findAllByCnpj(cnpj);
  }

  //listar lojas virtuais existentes
  public List<LojaVirtual> listarLojasVirtuais(){
    return lojaVirtualRepository.findAllByOrderByNomeAsc();
  }

  //buscar lojas virtuais por cnpj
  public List<LojaVirtual> buscarLojaVirtualCnpj(String cnpj){
    return lojaVirtualRepository.findAllByCnpj(cnpj);
  }

}
