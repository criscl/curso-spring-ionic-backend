package com.cristiano.cursospring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cristiano.cursospring.domain.Categoria;
import com.cristiano.cursospring.repositories.CategoriaRepository;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursospringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		  Categoria cat1 = new Categoria(1, "Informática"); 
		  Categoria cat2 = new Categoria(2, "Escritório"); 
		  
		  categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		 		
	}

	
}

