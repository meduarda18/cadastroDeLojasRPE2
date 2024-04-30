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

  //loja Fisica

  @PostMapping("/fisicas")
  public void criarLojaFisica(@Valid @RequestBody LojaFisica loja){
    lojaService.criarLojaFisica(loja);
  }

  @GetMapping("/fisicas")
  public List<LojaFisica> listarLojasFisicas(){
    return lojaService.listarLojasFisicas();
  }

  @GetMapping("/fisicas/{cnpj}")
  public List<LojaFisica> buscarLojaFisicaCnpj(@PathVariable("cnpj") String cnpj){
    return lojaService.buscarLojaFisicaCnpj(cnpj);
  }

  @PutMapping("/fisicas")
  public void editarLojaFisica(@Valid @RequestBody LojaFisica loja){
    lojaService.editarLojaFisica(loja);
  }

  @DeleteMapping("/fisicas/{id}")
  public void removerLojaFisica(@PathVariable("id") UUID id){
    lojaService.removerLojaFisica(id);
  }
  
  //loja virtual

  @PostMapping("/virtuais")
  public void criarLojaVirtual(@Valid @RequestBody LojaVirtual loja){
    lojaService.criarLojaVirtual(loja);
  }

  @GetMapping("/virtuais")
  public List<LojaVirtual> listarLojasVirtuais(){
    return lojaService.listarLojasVirtuais();
  }

  @GetMapping("/virtuais/{cnpj}")
  public List<LojaVirtual> buscarLojaVirtualCnpj(@PathVariable("cnpj") String cnpj){
    return lojaService.buscarLojaVirtualCnpj(cnpj);
  }

  @PutMapping("/virtuais")
  public void editarLojaVirtual(@Valid @RequestBody LojaVirtual loja){
    lojaService.editarLojaVirtual(loja);
  }

  @DeleteMapping("/virtuais/{id}")
  public void removerLojaVirtual(@PathVariable("id") UUID id){
    lojaService.removerLojaVirtual(id);
  }

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
