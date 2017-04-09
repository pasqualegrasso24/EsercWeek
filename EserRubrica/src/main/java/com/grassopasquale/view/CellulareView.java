package com.grassopasquale.view;

import com.grassopasquale.model.CellulareModel;

public class CellulareView {
	private CellulareModel cellulareModel;

	public CellulareView() {

	}

	public CellulareView(CellulareModel cellulareModel) {

		this.cellulareModel = cellulareModel;
	}

	public void printInfo() {
		System.out.println(cellulareModel.Stampa());
	}

	public void printCodici() {
		System.out.println(cellulareModel.StampaCodice());
	}

	public CellulareModel getCellulareModel() {
		return cellulareModel;
	}

	public void setCellulareModel(CellulareModel cellulareModel) {
		this.cellulareModel = cellulareModel;
	}

}
