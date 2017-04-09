package com.grassopasquale.controllers;

import com.grassopasquale.model.CellulareModel;
import com.grassopasquale.view.CellulareView;

public class CellulareController {
	private CellulareView cellulareView;
	private CellulareModel cellulareModel;

	public CellulareController() {

	}

	public CellulareController(CellulareView cellulareView, CellulareModel cellulareModel) {

		this.cellulareView = cellulareView;
		this.cellulareModel = cellulareModel;
	}

	public CellulareView getCellulareView() {
		return cellulareView;
	}

	public void setCellulareView(CellulareView cellulareView) {
		this.cellulareView = cellulareView;
	}

	public CellulareModel getCellulareModel() {
		return cellulareModel;
	}

	public void setCellulareModel(CellulareModel cellulareModel) {
		this.cellulareModel = cellulareModel;
	}

}
