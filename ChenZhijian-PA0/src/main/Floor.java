/**
* <This class is actually used to collect the person who are already arrived in this floor>
* Known Bugs: <None>
*
* @author Zhijian Chen
* <Chen5340@brandeis.edu>
* <Sep 9, 2022> 
* COSI 21A PA0
*/
//>Start of your class here<

package main;

public class Floor {
	public Person[] people;
	public int floorNumber;
	
	public Floor() {
		people = new Person[10];
	}
	
	/**
	 * This method can add person instance into this floor instance.
	 * @param person The person who have entered this floor.
	 */
	
	public void enterFloor(Person person) {
		if(people[people.length-1] != null) {
			Person[] newPeople = new Person[people.length+10];
			for(int t = 0; t<people.length; t++) {
				newPeople[t] = people[t];
			}
			people = newPeople;
		}
		
		for (int i = 0; i < people.length; i++) {
			if (people[i] == null) {
				people[i] = person;
				people[i].location = floorNumber;
			}
		}
	}
	
	/**
	 * change floor instance into printable string.
	 */
	public String toString() {
		return "Floor " + floorNumber+ " with " + people;
	}
}
