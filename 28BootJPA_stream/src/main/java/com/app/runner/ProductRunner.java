package com.app.runner;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.model.Product;
import com.app.repo.ProductRepository;
@Component
public class ProductRunner implements CommandLineRunner {
	@Autowired
	private ProductRepository repo;
	@Override
	public void run(String... args) throws Exception {
		/*
		 * List<Product> list=repo.findAll(); Stream<Product> stream=list.stream();
		 * stream.filter(p->p.getProdCode()!=null).forEach(System.out::println);;
		 */
		repo.findAll().stream().filter(p->p.getProdCost()!=null).
		sorted((p1,p2)->p1.getProdId()-p1.getProdId()).map(p->p.getProdCode()).forEach(System.out::println);
		 
		// @formatter:on

	}

}
