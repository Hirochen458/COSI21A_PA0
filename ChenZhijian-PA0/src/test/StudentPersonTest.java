package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Person;
import main.Building;

class StudentPersonTest {
	
	Person person = new Person("Jack", "Cooper");
	Building khalifa = new Building(500);

	@Test
	void test() {
		//throw new UnsupportedOperationException("not implemented");
		assertEquals(person.personName, "Jack Cooper");
		assertEquals(person.arrived, false);
		assertEquals(person.desireFloor, -1);
		assertEquals(person.status, "");
		
		person.enterBuilding(khalifa, 250);
		assertEquals(person.desireFloor, 250);
		assertEquals(person.getLocation(), "Waiting to be serviced");
		assertEquals(person.toString(), "Person with target floor of 250 and currently is Waiting to be serviced at -1");
	}

}
