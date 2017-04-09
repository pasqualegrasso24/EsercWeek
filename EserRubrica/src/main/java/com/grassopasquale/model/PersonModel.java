package com.grassopasquale.model;

public class PersonModel {
	private String name;
	private String surname;
	private String email;
	private String indirizzo;
	private String num_cell;
	private String telefonoModello;
	private CellulareModel telefono;
	int codiceTel;

	

	public PersonModel() {
	}
	
	public PersonModel(String num_cell, String name, String surname, String email, String indirizzo,
			int codiceTel) {

		this.name = name;
		this.surname = surname;
		this.email = email;
		this.indirizzo = indirizzo;
		this.codiceTel=codiceTel;
		this.num_cell = num_cell;
	}
	public PersonModel(String num_cell, String name, String surname, String email, String indirizzo,
			String telefonoModello) {

		this.name = name;
		this.surname = surname;
		this.email = email;
		this.indirizzo = indirizzo;
		this.setTelefonoModello(telefonoModello);
		this.num_cell = num_cell;
	}

	public PersonModel(String num_cell, String name, String surname, String email, String indirizzo,
			CellulareModel telefono) {

		this.name = name;
		this.surname = surname;
		this.email = email;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.num_cell = num_cell;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("Name = ").append(name).append("\n").append("Surname = ").append(surname).append("\n")
				.append("email = ").append(email).append("\n").append("indirizzo = ").append(indirizzo).append("\n")
				.append("Numero = ").append(num_cell).append("\n").append("Tipo Telefono = ")
				.append(telefono.toString()).append("\n");

		return builder.toString();
	}

	public String Stampa() {
		StringBuilder builder = new StringBuilder();

		builder.append("Name = ").append(name).append("\n").append("Surname = ").append(surname).append("\n")
				.append("email = ").append(email).append("\n").append("indirizzo = ").append(indirizzo).append("\n")
				.append("Numero = ").append(num_cell).append("\n").append("Tipo Telefono = ").append(telefonoModello)
				.append("\n");

		return builder.toString();
	}
	public String print() {
		StringBuilder builder = new StringBuilder();

		builder.append("Numero = ").append(num_cell).append("\n").append("Name = ").append(name).append("\n").append("Surname = ").append(surname).append("\n")
				.append("Tipo Telefono = ").append(telefono.toString()).append("\n");

		return builder.toString();
	}

	

	public int getCodiceTel() {
		return codiceTel;
	}

	public void setCodiceTel(int codiceTel) {
		this.codiceTel = codiceTel;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public CellulareModel getTelefono() {
		return telefono;
	}

	public void setTelefono(CellulareModel telefono) {
		this.telefono = telefono;
	}

	public String getNum_cell() {
		return num_cell;
	}

	public void setNum_cell(String num_cell) {
		this.num_cell = num_cell;
	}

	public String getTelefonoModello() {
		return telefonoModello;
	}

	public void setTelefonoModello(String telefonoModello) {
		this.telefonoModello = telefonoModello;
	}

}
