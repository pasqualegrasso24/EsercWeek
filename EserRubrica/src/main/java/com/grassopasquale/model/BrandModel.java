package com.grassopasquale.model;

public class BrandModel {

	private String name;
	private String description;
	private String company;

	public BrandModel() {
	};
	public BrandModel(String name, String description) {

		this.name = name;
		this.description = description;
		
	}
	public BrandModel(String name, String description, String company) {

		this.name = name;
		this.description = description;
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("Name = ").append(name).append("\n").append("Description = ").append(description).append("\n")
				.append("Company = ").append(company).append("\n");

		return builder.toString();
	}
	
	public String print(){
		StringBuilder builder = new StringBuilder();

		builder.append("Name = ").append(name).append("\n").append("Description = ").append(description).append("\n")
				.append("\n");

		return builder.toString();
	}

}
