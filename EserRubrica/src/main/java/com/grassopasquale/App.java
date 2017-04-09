package com.grassopasquale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.grassopasquale.InterfacesDAO.CellulareDAO;
import com.grassopasquale.InterfacesDAO.PersonDAO;
import com.grassopasquale.InterfacesDAO.implemen.DefaultCellulareDAO;
import com.grassopasquale.InterfacesDAO.implemen.DefaultPersonDAO;
import com.grassopasquale.controllers.CellulareController;
import com.grassopasquale.controllers.PersonController;
import com.grassopasquale.model.CellulareModel;
import com.grassopasquale.model.PersonModel;
import com.grassopasquale.view.CellulareView;
import com.grassopasquale.view.PersonView;

public class App {
	final static Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {
		try {
			int choice;
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.defaultCharset()));
			PersonModel personModel = new PersonModel();
			PersonView personView = new PersonView();
			PersonController personController = new PersonController(personView, personModel);
			CellulareModel cellulareModel = new CellulareModel();
			CellulareView cellulareView = new CellulareView();
			CellulareController cellulareController = new CellulareController();

			String name, surname, phoneNumber, email, indirizzo;
			int codice = 0;
			String menu = "MAIN MENU\n1.Inserisci utente e suo telefono\n2.Inserisci telefono\n"
					+ "3.Visualizza utente\n4.Visualizza informazione cellulare di una persona\n"
					+ "5.Aggiorna numero cellulare utente\n" + "6.Cancella un utente\n0.Esci";
			do {
				System.out.println(menu);
				choice = Utils.parseNumber(in);
				int num;
				switch (choice) {
				case 1:
					phoneNumber = Utils.insert(in, "numero di telefono");
					try {
						num = Integer.parseInt(phoneNumber);

						if (!searchPerson(phoneNumber)) {

							name = Utils.insert(in, "nome");
							surname = Utils.insert(in, "surname");
							email = Utils.insert(in, "email");
							indirizzo = Utils.insert(in, "indirizzo");
							getCellulareFromDB();
							System.out.println("Inserisci codice telefono:");
							codice = Utils.parseNumber(in);
							if (searchCellulare(codice)) {
								personModel.setNum_cell(phoneNumber);
								personModel.setName(name);
								personModel.setSurname(surname);
								personModel.setEmail(email);
								personModel.setIndirizzo(indirizzo);
								personModel.setCodiceTel(codice);
								if (insertPerson(personModel)) {
									System.out.println("Inserimento avvenuto con successo.");
								} else {
									System.out.println("Errore: Inserimento non riuscito!");
								}
							} else {
								System.out.println("Codice telefono non presente");
							}
						} else {
							System.out.println("Persona già presente");
						}
					} catch (NumberFormatException e) {
						System.out.println("Numero non valido");
					}
					break;

				case 3:
					phoneNumber = Utils.insert(in, "numero di telefono");
					try {
						num = Integer.parseInt(phoneNumber);
						if (searchPerson(phoneNumber)) {
							personModel = getPersonFromDB(phoneNumber);
							personController.setPersonModel(personModel);
							personController.updateView(personModel);
							personView.printInfo();

						} else {
							System.out.println("Questo numero di telefono non è salvato in rubrica");
						}
					} catch (NumberFormatException e) {
						System.out.println("Numero non valido");
					}

					break;
				case 4:
					phoneNumber = Utils.insert(in, "numero di telefono");
					try {
						num = Integer.parseInt(phoneNumber);
						if (searchPerson(phoneNumber)) {
							personModel = getPersonCellFromDB(phoneNumber);
							personController.setPersonModel(personModel);
							personController.updateView(personModel);
							personView.printInfoCell();

						} else {
							System.out.println("Questo numero di telefono non è salvato in rubrica");
						}
					} catch (NumberFormatException e) {
						System.out.println("Numero non valido");
					}

					break;
				case 5:
					phoneNumber = Utils.insert(in, "numero di telefono da modificare");
					String numberNew = Utils.insert(in, "nuovo numero di telefono");
					if (updateUser(phoneNumber, numberNew)) {
						personModel = getPersonFromDB(numberNew);
						personController.setPersonModel(personModel);
						personController.updateView(personModel);
						System.out.println("Utente aggiornato");
						personView.printInfo();
					} else {
						System.out.println("Questo numero di telefono non è salvato in rubrica");
					}
					break;
				case 6:
					phoneNumber = Utils.insert(in, "numero di telefono dell'utente da cancellare");
					if (deleteUser(phoneNumber)) {
						personModel = getPersonFromDB(phoneNumber);
						personController.updateView(personModel);
						System.out.println("Utente cancellato!");
						personView.printInfo();
					} else {
						System.out.println("Questo numero di telefono non è salvato in rubrica");
					}

					break;

				case 0:
					System.out.println("Ciao");
					break;
				default:
					System.out.println("Scelta errata!");
					break;
				}
			} while (choice != 0);
		} catch (

		IOException ex) {
		}

	}

	//cancella utente
	private static boolean deleteUser(String number) {
		PersonDAO personDAO = new DefaultPersonDAO();
		return personDAO.deletePersonInfo(number);
	}
	//aggiorna dati utente
	private static boolean updateUser(String numberOld, String numberNew) {
		PersonDAO personDAO = new DefaultPersonDAO();
		return personDAO.updatePersonInfo(numberOld, numberNew);
	}
	//recupera informazione dell'utente
	private static PersonModel getPersonFromDB(String cell) {

		PersonDAO personDAO = new DefaultPersonDAO();
		return personDAO.getPersonInfo(cell);
	}
	//recupera informazione del cellullare dell'utente
	private static PersonModel getPersonCellFromDB(String phoneNumber) {
		PersonDAO personDAO = new DefaultPersonDAO();
		return personDAO.getPersonCellInfo(phoneNumber);
	}
	//Inserisce nuovo utente
	private static boolean insertPerson(PersonModel personModel) {
		PersonDAO personDAO = new DefaultPersonDAO();
		return personDAO.insertUser(personModel);
	}
	//verifica se è presente l'utente
	private static boolean searchPerson(String phoneNumber) {
		PersonDAO personDAO = new DefaultPersonDAO();
		return personDAO.searchPerson(phoneNumber);
	}
	//verifica se è presente il modello di cellulare
	private static boolean searchCellulare(int codice) {
		CellulareDAO cellulareDAO = new DefaultCellulareDAO();
		return cellulareDAO.searchCellulare(codice);
	}

	/*private static CellulareModel getCellulareFromDB(int codice) {

		CellulareDAO cellulareDAO = new DefaultCellulareDAO();
		return cellulareDAO.getCellulareInfo(codice);
	}*/

	private static void getCellulareFromDB() {

		CellulareDAO cellulareDAO = new DefaultCellulareDAO();
		cellulareDAO.getListFromDB();
		 cellulareDAO.print();
	}
}
