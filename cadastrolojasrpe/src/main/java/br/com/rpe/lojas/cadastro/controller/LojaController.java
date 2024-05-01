package br.com.rpe.lojas.cadastro.controller;

import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

import br.com.rpe.lojas.cadastro.entity.LojaFisica;
import br.com.rpe.lojas.cadastro.entity.LojaVirtual;
import br.com.rpe.lojas.cadastro.service.LojaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/lojas")
public class LojaController {
  private final LojaService lojaService;
  
  public LojaController(LojaService lojaService){
    this.lojaService = lojaService;
  }

  //lojas Fisicas

  @PostMapping("/fisicas")
  public void criarLojaFisica(@Valid @RequestBody LojaFisica loja){
    lojaService.criarLoja(loja);
  }

  @GetMapping("/fisicas")
  public List<LojaFisica> listarLojasFisicas(){
    return lojaService.listarLojasFisicas();
  }

  @GetMapping("/fisicas/{cnpj}")
  public List<LojaFisica> buscarLojaFisicaCnpj(@PathVariable("cnpj") String cnpj){
    return lojaService.buscarLojaFisicaCnpj(cnpj);
  }

  @PutMapping("/fisicas/editar/{id}")
  public void editarLojaFisica(@PathVariable("id") UUID id, @Valid @RequestBody LojaFisica loja){
    lojaService.editarLoja(id, loja, LojaFisica.class);
  }

  @DeleteMapping("/fisicas/remover/{id}")
  public void removerLojaFisica(@PathVariable("id") UUID id){
    lojaService.removerLoja(id, LojaFisica.class);
  }
  
  //lojas virtuais

  @PostMapping("/virtuais")
  public void criarLojaVirtual(@Valid @RequestBody LojaVirtual loja){
    lojaService.criarLoja(loja);
  }

  @GetMapping("/virtuais")
  public List<LojaVirtual> listarLojasVirtuais(){
    return lojaService.listarLojasVirtuais();
  }

  @GetMapping("/virtuais/{cnpj}")
  public List<LojaVirtual> buscarLojaVirtualCnpj(@PathVariable("cnpj") String cnpj){
    return lojaService.buscarLojaVirtualCnpj(cnpj);
  }

  @PutMapping("/virtuais/editar/{id}")
  public void editarLojaVirtual(@PathVariable("id") UUID id, @Valid @RequestBody LojaVirtual loja){
    lojaService.editarLoja(id, loja, LojaVirtual.class);
  }

  @DeleteMapping("/virtuais/remover/{id}")
  public void removerLojaVirtual(@PathVariable("id") UUID id){
    lojaService.removerLoja(id, LojaVirtual.class);
  }

  //Listas todas em /lojas
  @GetMapping
  public List<Object> listarTodasAsLojas() {
    List<LojaFisica> lojasFisicas = lojaService.listarLojasFisicas();
    List<LojaVirtual> lojasVirtuais = lojaService.listarLojasVirtuais();
    
    List<Object> todasAsLojas = new ArrayList<>();
    todasAsLojas.addAll(lojasFisicas);
    todasAsLojas.addAll(lojasVirtuais);
    
    return todasAsLojas;
  }

}
