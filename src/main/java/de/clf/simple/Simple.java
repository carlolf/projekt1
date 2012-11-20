package de.eitco.clf.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple Klasse, die einen Personengruß-Service verwendet.
 * 
 * @author carlo
 *
 */
public class Simple {

	private List<String> greets;

	private PersonService ps;

	/**
	 * default ctor
	 */
	public Simple() {
		super();
		init();
	}


	/**
	 * Grüße alle bekannten Personen mit einem Zufallsgruß
	 */
	public void greetAll() {
		ps.greetAll(greets);
	}

	/**
	 * Aufrufmethode
	 * @param args nicht verwendet
	 */
	public static void main(final String[] args) {
		Simple s = new Simple();
		s.greetAll();
	}

	private void init() {	
		ps = PersonService.getInstance();

		ps.addPerson("Alexander");
		ps.addPerson("Joerg");
		ps.addPerson("Karin");
		ps.addPerson("Carlo");
		ps.addPerson("Klaus");
		ps.addPerson("Iris");
		ps.addPerson("Dennis");
		ps.addPerson("Karl-Frank");
		ps.addPerson("Eva");
		ps.addPerson("Hans");
		ps.addPerson("Hans Dockter");
		ps.addPerson("Bjarne S.");
		ps.addPerson("James Gosling");
		ps.addPerson("Charly");


		greets = new ArrayList<String>();
		greets.add("Are you doing well?");
		greets.add("Have a nice day!");
		greets.add("do you like a cup of Java?");
		greets.add("Welcome to the party!");
		greets.add("Gruezzi!");
		greets.add("Hallole!");
	}

}