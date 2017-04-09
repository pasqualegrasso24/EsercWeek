package com.grassopasquale.model;

public class CellulareModel {
	
	private int codice;
	private String name;
	private String ram;
	private String cpu;
	private String displayPpi;
	private String displaySize;
	private String displayResolution;
	private String size;
	private int weight;
	private BrandModel brand;
	private String brandModello;
	private String sys;

	public CellulareModel() {
	};
	public CellulareModel(int codice,String name,String sys) {
		this.codice=codice;
		this.name=name;
		this.sys=sys;
	};
	
	public CellulareModel(int codice,String name) {
		this.codice=codice;
		this.name=name;
		
	};

	public CellulareModel(String name, String ram, String cpu, String displayPpi, String displaySize,
			String displayResolution, String size, int weight, String brandModello) {

		this.name = name;
		this.ram = ram;
		this.cpu = cpu;
		this.displayPpi = displayPpi;
		this.displaySize = displaySize;
		this.displayResolution = displayResolution;
		this.size = size;
		this.weight = weight;
		this.setBrandModello(brandModello);
	};

	public CellulareModel(String name, String ram, String cpu, String displayPpi, String displaySize,
			String displayResolution, String size, int weight, BrandModel brand) {

		this.setCodice(codice);
		this.name = name;
		this.ram = ram;
		this.cpu = cpu;
		this.displayPpi = displayPpi;
		this.displaySize = displaySize;
		this.displayResolution = displayResolution;
		this.size = size;
		this.weight = weight;
		this.brand = brand;
	};

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getDisplayPpi() {
		return displayPpi;
	}

	public void setDisplayPpi(String displayPpi) {
		this.displayPpi = displayPpi;
	}

	public String getDisplaySize() {
		return displaySize;
	}

	public void setDisplaySize(String displaySize) {
		this.displaySize = displaySize;
	}

	public String getDisplayResolution() {
		return displayResolution;
	}

	public void setDisplayResolution(String displayResolution) {
		this.displayResolution = displayResolution;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public BrandModel getBrand() {
		return brand;
	}

	public void setBrand(BrandModel brand) {
		this.brand = brand;
	}
	public String getBrandModello() {
		return brandModello;
	}

	public void setBrandModello(String brandModello) {
		this.brandModello = brandModello;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}
	public String getSys() {
		return sys;
	}
	public void setSys(String sys) {
		this.sys = sys;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("Name = ").append(name).append("\n").append("RAM = ").append(ram).append("\n").append("CPU = ")
				.append(cpu).append("\n").append("displayPpi = ").append(displayPpi).append("\n")
				.append("displaySize= ").append(displaySize).append("\n").append("displayResolution = ")
				.append(displayResolution).append("\n").append("size = ").append(size).append("\n")
				.append("weight = ").append(weight).append("\n").append("brand = ").append(brand.print())
				.append("\n");

		return builder.toString();
	}
	
	public String StampaCodice(){
		StringBuilder builder = new StringBuilder();
		builder.append("Codice = ").append(codice).append("\n");
		builder.append("Name = ").append(name).append("\n");
		
		
		return builder.toString();
	}

	public String Stampa() {
		StringBuilder builder = new StringBuilder();

		builder.append("Name = ").append(name).append("\n").append("RAM = ").append(ram).append("\n").append("CPU = ")
				.append(cpu).append("\n").append("displayPpi = ").append(displayPpi).append("\n")
				.append("displaySize= ").append(displaySize).append("\n").append("displaySizeResolution = ")
				.append(displayResolution).append("\n").append("size = ").append(size).append("\n")
				.append("weight = ").append(weight).append("\n").append("brand = ").append(brandModello).append("\n");

		return builder.toString();
	}
	public String print() {
		StringBuilder builder = new StringBuilder();

		builder.append("Name = ").append(name).append("\n").append("RAM = ").append(ram).append("\n").append("CPU = ")
				.append(cpu).append("\n").append("displayPpi = ").append(displayPpi).append("\n")
				.append("displaySize= ").append(displaySize).append("\n").append("displaySizeResolution = ")
				.append(displayResolution).append("\n").append("size = ").append(size).append("\n")
				.append("weight = ").append(weight).append("\n").append("brand = ").append(brand.print()).append("\n");

		return builder.toString();
	}
	

}
