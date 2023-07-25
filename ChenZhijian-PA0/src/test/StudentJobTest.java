package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Job;
import main.Person;

class StudentJobTest {
	Person person = new Person("Jack", "Cooper");
	Job job = new Job(person, 5);
	
	@Test
	void test() {
		//throw new UnsupportedOperationException("not implemented");
		assertEquals(job.toString(), "Job with Jack Cooper, desired floor is 5");
		assertEquals(job.desireFloor, 5);
		assertEquals(job.started, false);
		assertEquals(job.finished, false);
	}

}
