/**
* <This class is a program that will simulate a building with people and running elevator. >
* Known Bugs: <None>
*
* @author Zhijian Chen
* <Chen5340@brandeis.edu>
* <Sep 9, 2022> 
* COSI 21A PA0
*/

package main;

public class Simulation {

    /**
     * main method used to running. 
     * @param args
     */
	public static void main(String[] args) {
		
		Building b = new Building(7);
		Person person1 = new Person("1","1");
		Person person2 = new Person("2","2");
		Person person3 = new Person("3","3");
		Person person4 = new Person("4","4");
		Person person5 = new Person("5","5");
		Person person6 = new Person("6","6");
		Person person7 = new Person("7","7");
				
		person1.enterBuilding(b, 3);
		person2.enterBuilding(b, 3);
		person3.enterBuilding(b, 3);
		b.startElevator();
		
//		person1.enterBuilding(b, 3);
//		person2.enterBuilding(b, 3);
//		person3.enterBuilding(b, 3);
//		person4.enterBuilding(b, 3);
//		person5.enterBuilding(b, 3);
//		person6.enterBuilding(b, 3);
//		person7.enterBuilding(b, 3);
//		b.startElevator();
//		
//		person4.enterBuilding(b, 7);
//		b.startElevator();
//		
//		person5.enterBuilding(b, 2);
//		person6.enterBuilding(b, 1);
//		b.startElevator();
	}
	

}
