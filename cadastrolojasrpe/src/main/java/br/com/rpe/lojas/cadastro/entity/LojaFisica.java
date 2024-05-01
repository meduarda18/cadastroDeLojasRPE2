package br.com.rpe.lojas.cadastro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
@Table(name = "lojasFisicas")
public class LojaFisica {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @NotEmpty(message = "Informe um CNPJ")
  //A validação com cnpj do hibernate aceita apenas cnpj existente e válido, coloquei uma validação básica para substituir essa validação real para testes
  @Size(min = 14, max = 14, message = "Informe um CNPJ válido com 14 dígitos")
  private String cnpj;

  @NotEmpty(message = "Informe um nome")
  private String nome;

  @NotEmpty(message = "Informe um segmento")
  private String segmento;

  @NotEmpty(message = "Informe um telefone")
  @Pattern(regexp = "\\d{11}", message = "Informe um telefone válido com 11 dígitos")
  private String telefone;

  @NotEmpty(message = "Informe um endereço")
  private String enderecoFisico;

  @NotNull
  private int numeroFuncionarios;

  //construtor padrao para o hibernate
  public LojaFisica(){}

  //construtor com argumentos
  public LojaFisica(UUID id, String cnpj, String nome, String segmento, String telefone, String enderecoFisico, int numeroFuncionarios){
    this.id = id;
    this.cnpj = cnpj;
    this.nome = nome;
    this.segmento = segmento;
    this.telefone = telefone;
    this.enderecoFisico = enderecoFisico;
    this.numeroFuncionarios = numeroFuncionarios;
  } 

  //getts e setts
  public UUID getId() {
    return id;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSegmento() {
    return segmento;
  }

  public void setSegmento(String segmento) {
    this.segmento = segmento;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getEnderecoFisico() {
    return enderecoFisico;
  }

  public void setEnderecoFisico(String enderecoFisico) {
    this.enderecoFisico = enderecoFisico;
  }

  public int getNumeroFuncionarios() {
    return numeroFuncionarios;
  }

  public void setNumeroFuncionarios(int numeroFuncionarios) {
    this.numeroFuncionarios = numeroFuncionarios;
  }

}
