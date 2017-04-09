package com.grassopasquale.view;

import com.grassopasquale.model.PersonModel;

public class PersonView {
	
	private PersonModel person;
	
	public PersonView(){
		
	}
	public PersonView(PersonModel person){
		this.person = person;
	}
	
	public void printInfo(){
		System.out.println(person.Stampa());
	}

	public PersonModel getPerson() {
		return person;
	}

	public void setPerson(PersonModel person) {
		this.person = person;
	}
	public void printInfoCell() {
		System.out.println(person.print());
		
	}
	
}
