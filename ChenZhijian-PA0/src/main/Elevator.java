/**
* <This class will create a instance of an elevator in one building and running with people and their order>
* Known Bugs: <None>
*
* @author Zhijian Chen
* <Chen5340@brandeis.edu>
* <Sep 9, 2022> 
* COSI 21A PA0
*/
//>Start of your class here<

package main;

public class Elevator {
	public int beginFloor;
	public int currentFloor;
	public int targetFloor;
	public int beginNum;
	public int endNum;
	public int jobNumbers;
	

	/**
	 * This specifies the number of people that can be brought to their floors by an Elevator 
	 * instance at any given time. 
	 * <p>DO NOT REMOVE THIS FIELD</p>
	 * <p>You may edit it. But keep it public.</p>
	 */
	public static int maxOccupants = 3;
	
	public Person person;
	public Building building;
	public Job[] jobs;
	public Job[] workingJobs;
	public Job job;
	
	
	/**
	 * construct a elevator with some of this property. 
	 * @param b building instance
	 */
	public Elevator(Building b) {
		building = b;
		jobs = new Job[10];
		workingJobs = new Job[10];
		beginFloor = 0;
		currentFloor = 0;
		beginNum = 0;
		endNum = maxOccupants;
		jobNumbers = 0;
	}
	
	/**
	 * This method will create  jobs for elevator to run.
	 * @param person The person with given name with desire floor.
	 * @param floor The floor which the person want go.
	 */
	
	public void createJob(Person person, int floor) {
		this.person = person;
		targetFloor = floor;
		
		Job newJob = new Job(person, targetFloor);
		jobNumbers +=1;
		
		if(jobs[jobs.length-1] != null) {
			Job[] newJobs = new Job[jobs.length+10];
			for(int t = 0; t<jobs.length; t++) {
				newJobs[t] = jobs[t];
			}
			jobs = newJobs;
		}
		
		for (int i = beginNum; i < jobs.length; i++) {
			if (jobs[i] == null) {
				jobs[i] = newJob;
				break;
			}
		}
	}
	
	/**
	 * This method is actually the elevator is running and carrying people while showing current floor.
	 */
	
	public void processAllJobs() {
		int numberInElevator = 0;
	/**first check if the elevator is at lobby*/
		while(jobNumbers != 0) {
		if (currentFloor == 0) {
			System.out.println("Elevator at Lobby");
		}else {
			for(int i = currentFloor; i >= 0; i--) {
				if (i != 0) {
					System.out.println("Evelator at floor " + currentFloor);
					currentFloor--;
				}else {
					System.out.println("Evelator at lobby");
				}
			}
		}
	/**sub-array to three job or less than three at a time.*/
		int t = 0;
		for (int x = beginNum; x < endNum; x++) {
			if (jobs[x] != null && jobs[x].finished == false /*&& job.desireFloor[x] == -1*/) {
				workingJobs[t] = jobs[x];
				numberInElevator++;
				jobs[x].people.status = "Serving";
				t++;
				jobs[x] = null;
			}
		}
		
	/**running the elevator.*/
		int currentFloor =1;
		int personIndex = 0;
			while(personIndex <= maxOccupants && numberInElevator != 0 && jobNumbers != 0) {
				if(workingJobs[personIndex] != null) {
					if(0 <= currentFloor && workingJobs[personIndex].desireFloor < currentFloor && currentFloor < building.totalFloors) {
						System.out.println("Elevator at floor " + currentFloor);
						workingJobs[personIndex].people.location = currentFloor;
						currentFloor--;
					}else if(building.totalFloors > currentFloor && workingJobs[personIndex].desireFloor > currentFloor && currentFloor >= 0) {
						System.out.println("Elevator at floor " + currentFloor);
						workingJobs[personIndex].people.location = currentFloor;
						currentFloor++;
					}else if(currentFloor == workingJobs[personIndex].desireFloor){
						System.out.println("Elevator at floor " + currentFloor);
						exit(workingJobs[personIndex].people, currentFloor);
						building.floor[currentFloor-1].enterFloor(workingJobs[personIndex].people);
						workingJobs[personIndex].finished = true;
						workingJobs[personIndex] = null;
						numberInElevator -=1;
						personIndex+=1;
						jobNumbers -=1;
					}
				}
			}
			for(int q = currentFloor; q >= 0; q--) {
				if (q != 0) {
					System.out.println("Evelator at floor " + currentFloor);
					currentFloor--;
				}else {
					System.out.println("Evelator at lobby");
				}
			}
			if(beginNum + maxOccupants > jobs.length) {
				beginNum = jobs.length-beginNum - 1;
				endNum = beginNum+1;
			}else if(beginNum + maxOccupants == jobs.length){
				beginNum -= 1;
				endNum += beginNum;
			}else {
				beginNum += maxOccupants;
				endNum += maxOccupants;
			}
		}
	}
	
	
	
	/**
	 * This method used to let elevator to run with one job.
	 * @param job job in the job class
	 */
	
	public void processJob(Job job) {
		if (job.finished == false) {
	/** first check if the elevator is at lobby */
			if (currentFloor == 0) {
				System.out.println("Elevator at Lobby");
			}else {
				for(int i = currentFloor; i >= 0; i--) {
					System.out.println("Evelator at floor " + currentFloor);
				}
			}
		
	/**running the elevator.*/
			for (int i = 1; i < building.totalFloors; i++) {
				currentFloor = i;
				System.out.println("Elevator at floor " + currentFloor);
			
	/**check if someone is at the desire floor */
				for (int n = 0; n < maxOccupants; n++) {
					if (job.desireFloor == currentFloor) {
						exit(job.people, currentFloor);
						building.floor[currentFloor-1].enterFloor(job.people);
						job.finished = true;
					}
				}
			}
		}
	
	}
	
	/**
	 * This method mainly used to let people out of the elevator if they arrived.
	 * @param person The people in the elevator
	 * @param floor The floor that is people's desire floor
	 */
	
	public void exit(Person person, int floor) {
		person.arrived = true;
		person.location = currentFloor;
		person.status = "Arrived";
	}
	
	/**
	 * change elevator instance into printable string.
	 */
	public String toString() {
		return "Elevator with Max number of people of " + maxOccupants + "Currently is at " + currentFloor;
	}
}