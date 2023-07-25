/**
* <This class will construct a person instance with name, status, location and his/her desire floor>
* Known Bugs: <None>
*
* @author Zhijian Chen
* <Chen5340@brandeis.edu>
* <Sep 9, 2022> 
* COSI 21A PA0
*/
//>Start of your class here<

package main;

public class Person {
	public String personName;
	public int desireFloor;
	public boolean arrived;
	public boolean entered;
	public int location;
	public String status;
	public Elevator elevator;
	
	/**
	 * construct a person instance with given first name and last name.
	 * @param firstName string of first name.
	 * @param lastName string of last name.
	 */
	public Person(String firstName, String lastName) {
		personName = firstName + " " + lastName;
		arrived = false;
		desireFloor = -1;
		location = -1;
		status = "";
	}
	
	
	/**
	 * This method mainly used to determine if that person's desire floor is inside the building he/she want to. 
	 * @param building The building the person want to go into.
	 * @param floor The floor the person want go to.
	 * @return Return true if the floor is exist, return false if not.
	 */

	public boolean enterBuilding(Building building, int floor) {
		desireFloor = floor;
		if(building.enterElevatorRequest(this, floor) == false) {
			status = "In Lobby";
			entered = false;
			return false;
		}else {
			status = "Waiting to be serviced";
			return true;
		}
	}
	
	/**
	 * This method mainly keep track of person's status.
	 * @return a string that used to show what status he/she is.
	 */
	
	public String getLocation() {
		if(arrived == false) {
			return status;
		}else {
			return ("In Floor " + location);
		}
	}
	
	/**
	 * change person instance into printable string
	 */
	
	public String toString() {
		return "Person with target floor of " + desireFloor + " and currently is " + status + " at " + location;
	}
}
