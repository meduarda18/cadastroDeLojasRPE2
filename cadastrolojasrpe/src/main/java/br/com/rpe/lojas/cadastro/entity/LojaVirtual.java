package br.com.rpe.lojas.cadastro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "lojasVirtuais")
public class LojaVirtual {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private int cnpj;//verificar qual pe a melhor opção entre String e int
  private String nome;
  private String segmento;
  private String telefone;
  private String url;
  private String avaliacao;

  //construtor padrão
  public LojaVirtual(){}

  //construtor com argumentos
  public LojaVirtual(UUID id, int cnpj, String nome, String segmento, String telefone, String url, String avaliacao){
    this.id = id;
    this.cnpj = cnpj;
    this.nome = nome;
    this.segmento = segmento;
    this.telefone = telefone;
    this.url = url;
    this.avaliacao = avaliacao;
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

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getAvaliacao() {
    return avaliacao;
  }

  public void setAvaliacao(String avaliacao) {
    this.avaliacao = avaliacao;
  }

}