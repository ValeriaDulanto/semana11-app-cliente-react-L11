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
		Instrumento employee = (Instrumento) o;
		return Objects.equals(id, employee.id) &&
			Objects.equals(nombre, employee.nombre) &&
			Objects.equals(categoria, employee.categoria) &&
			Objects.equals(description, employee.description);
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

	public String getFirstName() {
		return nombre;
	}

	public void setFirstName(String firstName) {
		this.categoria = firstName;
	}

	public String getLastName() {
		return categoria;
	}

	public void setLastName(String lastName) {
		this.categoria = lastName;
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