package br.com.rpe.lojas.cadastro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

import java.util.UUID;

@Entity
@Table(name = "lojasVirtuais")
public class LojaVirtual {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @NotEmpty(message = "Informe um CNPJ")
  @Size(min = 14, max = 14, message = "Informe um cnpj válido com 14 dígitos")
  private String cnpj;

  @NotEmpty(message = "Informe um nome")
  private String nome;

  @NotEmpty(message = "Informe um segmento")
  private String segmento;

  @NotEmpty(message = "Informe um telefone")
  @Pattern(regexp = "\\d{11}", message = "Informe um telefone válido com 11 dígitos")
  private String telefone;

  @NotEmpty(message = "Informe a URL do site")
  @URL(message = "Informe uma URL válida")
  private String url;

  @NotEmpty
  private String avaliacao;

  //construtor padrão para o hibernate
  public LojaVirtual(){}

  //construtor com argumentos
  public LojaVirtual(UUID id, String cnpj, String nome, String segmento, String telefone, String url, String avaliacao){
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