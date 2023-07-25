package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Building;
import main.Person;


class StudentBuildingTest {
	Building khalifa = new Building(500);
	Person person = new Person("Jack", "Cooper");
	

	@Test
	void test() {
		assertEquals(khalifa.totalFloors, 500);
		assertEquals(khalifa.currentFloor, 0);
		for(int i = 0; i < khalifa.totalFloors;i++) {
			System.out.println(khalifa.floor[i]);
		}
		assertEquals(khalifa.enterElevatorRequest(person, 250), true);
		assertEquals(khalifa.floor.length, 500);
		assertEquals(khalifa.floor[0], null);
	}
}
