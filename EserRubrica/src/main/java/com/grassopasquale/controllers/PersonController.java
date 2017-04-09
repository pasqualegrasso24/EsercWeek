package com.grassopasquale.controllers;

import com.grassopasquale.model.PersonModel;
import com.grassopasquale.view.PersonView;

public class PersonController {

	private PersonView personView;
	private PersonModel personModel;
	
	public PersonController(PersonView personView, PersonModel personModel){		
		this.personView = personView;
		this.personModel = personModel;		
	}
		
	public void updateView(PersonModel personModel){
		personView.setPerson(personModel);
	}
	
	public void updateModel(PersonView personView){
		
		this.personModel = personView.getPerson();		
	}

	public PersonView getPersonView() {
		return personView;
	}

	public void setPersonView(PersonView personView) {
		this.personView = personView;
	}

	public PersonModel getPersonModel() {
		return personModel;
	}

	public void setPersonModel(PersonModel personModel) {
		this.personModel = personModel;
	}
}
