package com.diningphilosopher;


public class DiningMain {
	
	
	
	
	

	public static void main(String[] args) {

		Philosopher[] philosophers = new Philosopher[5];

		// make the table ready with 5 philosophers and 5 forks SHARED between them.

		Object[] forks = new Object[philosophers.length];
		for (int i = 0; i < forks.length; i++) {
			forks[i] = new Object();
		}

		for (int k = 0; k < philosophers.length; k++) {
			
			Object leftFork = forks[k];
			
			Object rightFork = forks[(k + 1) % forks.length];
			
			
			if(k == philosophers.length-1) {//For the last philosopher need to take right fork first, so that the dead lock is re
				philosophers[k] = new Philosopher(rightFork,leftFork);
			}else {
				philosophers[k] = new Philosopher(leftFork,rightFork);
			}

			
			//Table is now ready
			
			
			Thread t = new Thread(philosophers[k],"Philosoper "+(k+1));
			
			t.start();
		}
		
		

	}


}
