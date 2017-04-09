package com.grassopasquale.InterfacesDAO;

import com.grassopasquale.model.PersonModel;

public interface PersonDAO {
	public PersonModel getPersonInfo(String num_cell);
	public boolean updatePersonInfo(String numberOld,String numberNew);
	public boolean insertUser(PersonModel personModel);
	public boolean searchPerson(String phoneNumber);
	public boolean deletePersonInfo(String number);
	public PersonModel getPersonCellInfo(String phoneNumber);
	

}
