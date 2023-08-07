package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final InstrumentoRepository repository;
	private final MusicoRepository repository;
	

	@Autowired
	public DatabaseLoader(InstrumentoRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception {
		this.repository.save(new Instrumento("Guitarra", "Viento", "de madera, con caja de resonancia, 6 cuerdas templadas"));
		this.repository.save(new Instrumento("Ukele", "Cuerda", "pequeña, de madera"));
		this.repository.save(new Instrumento("Melodica", "Viento", "teclado pequeño de 2 octavas"));

	}

	@Autowired
	public DatabaseLoader(MusicoRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception {
		this.repository.save(new Musico("Guitarra"));
		this.repository.save(new Musico("Ukele"));
		this.repository.save(new Musico("Melodica"));

	}
}