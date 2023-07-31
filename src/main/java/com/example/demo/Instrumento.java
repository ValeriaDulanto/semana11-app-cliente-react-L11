package com.example.demo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Instrumento {

	private @Id @GeneratedValue Long id;
	private String nombre;
	private String categoria;
	private String description;

	public Instrumento(String nombre, String categoria, String description) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Instrumento instrumento = (Instrumento) o;
		return Objects.equals(id, instrumento.id) &&
			Objects.equals(nombre, instrumento.nombre) &&
			Objects.equals(categoria, instrumento.categoria) &&
			Objects.equals(description, instrumento.description);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, nombre, categoria, description);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getnombre() {
		return nombre;
	}

	public void setnombre(String nombre) {
		this.nombre = nombre;
	}

	public String getcategoria() {
		return categoria;
	}

	public void setcategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Instrumento{" +
			"id=" + id +
			", nombre='" + nombre + '\'' +
			", categoria='" + categoria + '\'' +
			", description='" + description + '\'' +
			'}';
	}
}