package de.eitco.clf.simple;

/**
	Simple Personen-Klasse. 
	<p>
	Gefragt für diesen Projektzweck sind nur:
	<ol>
	<li>Wie ist der Name der Person?</li>
	<li>Wurde die Person überhaupt gegrüßt? wie oft?</li>
	</ol>
	</p>
 */
public class Person implements Comparable<Person> {

	private final String name;

	private int wasGreeted;

	/**
	 * der Konstruktor benötigt immer einen Namen
	 * @param pName name
	 */
	public Person(final String pName) {
		name = pName;
		wasGreeted = 0;
	}

	/**
	 * wie ist der Name der Person?
	 * @return Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Markiere die Person als gegrüßt
	 */
	public void markGreeted() {
		wasGreeted++;
	}

	/**
	 * Wurde die Person jemals gegrüßt?
	 * @return true / false
	 */
	public boolean wasEverGreeted() {
		return wasGreeted > 0;
	}

	/**
	 * Wie oft wurde die Person gegrüßt?
	 * @return Anzahl Grüße
	 */
	public int wasGreetedHowMuch() {
		return wasGreeted;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(final Object other) {
		return other instanceof Person && ((Person)other).getName().equals(name);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public int compareTo(final Person other) {		
		return this.getName().compareTo(other.getName());
	}
}