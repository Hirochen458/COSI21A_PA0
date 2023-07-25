/**
* <This class will construct a building instance that will contain a elevator and certain floors>
* Known Bugs: <None>
*
* @author Zhijian Chen
* <Chen5340@brandeis.edu>
* <Sep 9, 2022> 
* COSI 21A PA0
*/
//>Start of your class here<


package main;

public class Building {
	public int totalFloors;
	public int desireFloor;
	public int currentFloor;
	public Elevator elevator;
	public Person person;
	public Job job;
	public Person[] people;
	public Floor[] floor;
	
	/**
	 * construct a building with given number of floors
	 * @param numFloors value of floor that client will provide
	 */

	public Building(int numFloors) {
		elevator = new Elevator(this);
		people = new Person[100];
		totalFloors = numFloors;
		floor = new Floor[numFloors];
		for(int i = 0; i < floor.length;i++) {
			floor[i] = new Floor();
		}
		
	}
	
	/**
	 * To identity floors that the people who are entered this building are exist.
	 * @param person The person with his/her name.
	 * @param floor The floor that the person what to go.
	 * @return return true if the floors is exist, return false if not.
	 */
	
	public boolean enterElevatorRequest(Person person, int floor) {
		desireFloor = floor;
		if (desireFloor < 0 || desireFloor > totalFloors ) {
			return false;
		}else {
			elevator.createJob(person, floor);
			return true;
		}
	}
	
	/**
	 * This method will make the elevator in this building start working
	 */
	
	public void startElevator() {
		elevator.processAllJobs();
	}
	
	/**
	 * This method will record which floor that person is even that person is in elevator.
	 * @param person The person with given name
	 * @param floor The current floor that the person located
	 */
	
	public void enterFloor(Person person, int floor) {
		currentFloor = floor;
	}
	
	/**
	 * change building instance into printable string.
	 */
	public String toString() {
		return "Building with " + totalFloors + "floor";
	}
}
