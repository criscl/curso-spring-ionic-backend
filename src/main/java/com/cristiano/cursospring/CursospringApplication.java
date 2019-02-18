package com.cristiano.cursospring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cristiano.cursospring.domain.Categoria;
import com.cristiano.cursospring.domain.Cidade;
import com.cristiano.cursospring.domain.Cliente;
import com.cristiano.cursospring.domain.Endereco;
import com.cristiano.cursospring.domain.Estado;
import com.cristiano.cursospring.domain.Produto;
import com.cristiano.cursospring.domain.enums.TipoCliente;
import com.cristiano.cursospring.repositories.CategoriaRepository;
import com.cristiano.cursospring.repositories.CidadeRepository;
import com.cristiano.cursospring.repositories.ClienteRepository;
import com.cristiano.cursospring.repositories.EnderecoRepository;
import com.cristiano.cursospring.repositories.EstadoRepository;
import com.cristiano.cursospring.repositories.ProdutoRepository;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursospringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		  Categoria cat1 = new Categoria(1, "Informática"); 
		  Categoria cat2 = new Categoria(2, "Escritório"); 
		  
		  Produto p1 = new Produto(null, "Computador", 2000.00);
		  Produto p2 = new Produto(null, "Computador", 800.00);
		  Produto p3 = new Produto(null, "Computador", 80.00);
		  
		  cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		  cat2.getProdutos().addAll(Arrays.asList(p2));
		  
		  p1.getCategorias().addAll(Arrays.asList(cat1));
		  p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		  p3.getCategorias().addAll(Arrays.asList(cat1));
		  
		  categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		  produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		  
		  Estado est1 = new Estado(null, "Minas Gerais");
		  Estado est2 = new Estado(null, "São Paulo");
		  
		  Cidade c1 = new Cidade(null, "Uberlândia", est1);
		  Cidade c2 = new Cidade(null, "São Paulo", est2);
		  Cidade c3 = new Cidade(null, "Campinas", est2);
		  
		  est1.getCidades().addAll(Arrays.asList(c1));
		  est2.getCidades().addAll(Arrays.asList(c2,c3));
		  
		  estadoRepository.saveAll(Arrays.asList(est1, est2));
		  cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		  
		  Cliente cli1 = new Cliente(null, "Maria", "maria@gmail.com", "000", TipoCliente.PESSOAFISICA);
		  cli1.getTelefones().addAll(Arrays.asList("213333333","2133333332"));
		  
		  Endereco e1 = new Endereco(null, "Rua 1", "300", "apto 1", "Jardim", "38204204", cli1, c1);
		  Endereco e2 = new Endereco(null, "Rua 2", "130", "apto 2", "Jardim", "38204204", cli1, c2);
		  
		  cli1.getEndereco().addAll(Arrays.asList(e1, e2));
		  
		  clienteRepository.saveAll(Arrays.asList(cli1));
		  enderecoRepository.saveAll(Arrays.asList(e1));
		  
		 		
	}

	
}

