package br.com.rpe.lojas.cadastro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "lojasFisicas")
public class LojaFisica {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private int cnpj;//verificar qual pe a melhor opção entre String e int
  private String nome;
  private String segmento;
  private String telefone;
  private String enderecoFisico;
  private int numeroFuncionarios;

  //construtor padrao para o hibernate
  public LojaFisica(){}

  //construtor com argumentos
  public LojaFisica(UUID id, int cnpj, String nome, String segmento, String telefone, String enderecoFisico, int numeroFuncionarios){
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

  public void setId(UUID id) {
    this.id = id;
  }

  public int getCnpj() {
    return cnpj;
  }

  public void setCnpj(int cnpj) {
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
