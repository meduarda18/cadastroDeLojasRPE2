package br.com.rpe.lojas.cadastro;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import br.com.rpe.lojas.cadastro.controller.LojaController;
import br.com.rpe.lojas.cadastro.entity.LojaFisica;
import br.com.rpe.lojas.cadastro.entity.LojaVirtual;
import jakarta.transaction.Transactional;

@SpringBootTest
class CadastrolojasrpeApplicationTests {

  @Autowired
  private LojaController lojaController;

  @Test
	//Sucesso ao criar uma loja fisica
  void testCriarLojaFisicaSuccess() throws Exception {
    LojaFisica lojaFisica = new LojaFisica();
    lojaFisica.setCnpj("12345678901234");
    lojaFisica.setNome("Loja Teste");
    lojaFisica.setSegmento("Teste");
    lojaFisica.setTelefone("12345678901");
    lojaFisica.setEnderecoFisico("Endereço Teste");
    lojaFisica.setNumeroFuncionarios(10);

    lojaController.criarLojaFisica(lojaFisica);
  }  

  @Test
	//Sucesso ao criar uma loja virtual
  void testeCriarLojaVirtualSucesso() throws Exception {
		LojaVirtual lojaVirtual = new LojaVirtual();
		lojaVirtual.setCnpj("12345678901234");
		lojaVirtual.setNome("Loja Teste");
		lojaVirtual.setSegmento("Teste");
		lojaVirtual.setTelefone("12345678901");
		lojaVirtual.setUrl("https://www.lojavirtualteste.com");
		lojaVirtual.setAvaliacao("10");
	
		lojaController.criarLojaVirtual(lojaVirtual);
	}

	@Test
	@Transactional
  @Rollback
	// Falha ao cria uma loja fisica
	void testeCriarLojaFisicaFalha(){
		LojaFisica lojaFisica = new LojaFisica();
		lojaFisica.setCnpj(""); 
		lojaFisica.setNome("");
		lojaFisica.setSegmento("");
		lojaFisica.setTelefone(""); 
		lojaFisica.setEnderecoFisico("");
		lojaFisica.setNumeroFuncionarios(0);

		lojaController.criarLojaFisica(lojaFisica);
	}

	@Test
	@Transactional
  @Rollback
	//Falha ao criar uma loja virtual
	void testeCriarLojaVitrtualFalha(){
		LojaVirtual lojaVirtual = new LojaVirtual();
		lojaVirtual.setCnpj(""); 
		lojaVirtual.setNome("");
		lojaVirtual.setSegmento("");
		lojaVirtual.setTelefone(""); 
		lojaVirtual.setUrl("");
		lojaVirtual.setAvaliacao("0");

		lojaController.criarLojaVirtual(lojaVirtual);
	}

	@Test
	//Sucesso ao remover uma loja fisica
	void testeRemoverLojaFisicaSucesso(){
		//Criei uma loja fisica primeiro para depois tentar remove-la
		LojaFisica lojaFisica = new LojaFisica();
    lojaFisica.setCnpj("12345678901234");
    lojaFisica.setNome("Loja Teste");
    lojaFisica.setSegmento("Teste");
    lojaFisica.setTelefone("12345678901");
    lojaFisica.setEnderecoFisico("Endereço Teste");
    lojaFisica.setNumeroFuncionarios(10);
      
		lojaController.criarLojaFisica(lojaFisica);

        // Obtenha o ID da loja física criada
    UUID id = lojaFisica.getId();

        // Remova a loja física
    lojaController.removerLojaFisica(id);
	}

	@Test
	//Sucesso ao remover uma loja virtual
	void testeRemoverLojaVirtualSucesso(){
		//Criei uma loja fisica primeiro para depois tentar remove-la
		LojaVirtual lojaVirtual = new LojaVirtual();
    lojaVirtual.setCnpj("12345678901234");
    lojaVirtual.setNome("Loja Teste");
    lojaVirtual.setSegmento("Teste");
    lojaVirtual.setTelefone("12345678901");
    lojaVirtual.setUrl("https://www.lojavirtualteste.com");
    lojaVirtual.setAvaliacao("10");
      
		lojaController.criarLojaVirtual(lojaVirtual);

        // Obtenha o ID da loja física criada
    UUID id = lojaVirtual.getId();

        // Remova a loja física
    lojaController.removerLojaVirtual(id);
	}

}