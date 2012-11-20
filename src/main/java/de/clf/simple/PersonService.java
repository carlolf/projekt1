package de.eitco.clf.simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Service-Klasse für Personen, die mit einem Gruß bedacht werden.
 * <p>
 * Diese Klasse implementiert das Singleton-Pattern.
 * </p>
 * @author carlo
 *
 */
public class PersonService {

	private final List<Person> persons;

	private final Random rd;

	private static final PersonService me = new PersonService();

	private PersonService() {
		persons = new ArrayList<Person>();
		rd = new Random(91238121);
	}

	/**
	 * Liefert das Service-Objekt
	 * @return Zugriff auf das Singleton
	 */
	public static PersonService getInstance() {
		return me;
	}

	/**
	 * Grüße alle Personen, die dem Service bekannt sind, und verwende dabei die übergebene Liste von
	 * Grußbotschaften mit beliebiger Auswahl.
	 * @param greetings Grußbotschaften
	 */
	public void greetAll(final List<String> greetings) {
		if (CollectionUtils.isEmpty(greetings)) {
			throw new IllegalArgumentException("cannot greet without defined greetings");
		}
		if (persons.isEmpty()) {
			System.out.println("no persons to greet!");
		}

		Collections.sort(persons);

		final int max = greetings.size();

		for (Person p : persons) {
			int idx = rd.nextInt(max);
			String greet = greetings.get(idx);
			p.markGreeted();
			String greetMsg = "Hello " + p.getName() + " " + greet;
			System.out.println(greetMsg); 		
		}
	}

	/**
	 * Erstelle eine Person zum übergebenen Namen, die als Grußkandidat aufgenommen wird.
	 * @param name Name der Person - darf nicht null oder leer sein
	 * @throws IllegalArgumentException wenn der Parameter null oder leer ist
	 */
	public void addPerson(final String name) {
		if (StringUtils.isEmpty(name)) {
			throw new IllegalArgumentException("cannot add a null or no-named person");
		}
		persons.add(new Person(name));
	}

	/**
	 * Liefert die Liste der registrierten Personen. 
	 * @return Kopie der Personenliste
	 */
	public List<Person> getPersons() {
		return new ArrayList<Person>(persons);
	}
}