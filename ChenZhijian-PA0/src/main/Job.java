/**
* <This class is mainly a class of pending jobs that need to be done by elevator>
* Known Bugs: <None>
*
* @author Zhijian Chen
* <Chen5340@brandeis>
* <Sep 9, 2022> 
* COSI 21A PA0
*/
//>Start of your class here<

package main;

public class Job {
	public Person people;
	public int desireFloor;
	public boolean started;
	public boolean finished;
	public Job jobs;
	
	/**
	 * construct a job instance with given person instance and his/her desire floor.
	 * @param person person instance.
	 * @param floor person' desire floor.
	 */
	public Job(Person person, int floor) {
		people = person;
		desireFloor = floor;
		started = false;
		finished = false;
	}
	
	/**
	 * change job instance into printable string.
	 */
	public String toString() {
		return "Job with " + people.personName + ", desired floor is " + desireFloor;
	}
}