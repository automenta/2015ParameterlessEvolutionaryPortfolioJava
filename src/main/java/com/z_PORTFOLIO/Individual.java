package com.z_PORTFOLIO;

public class Individual {
	private final char[] individual;
	
	public Individual(){ individual = new char[Problem.n]; }															// Default constructor
	public Individual(Individual johnDoe){individual = johnDoe.getIndividual();}	// Non shallow copy of an Individual	
	public Individual(char[] individual){this.individual = individual;}				// Shallow copy of an Individual
	
	public char  getAllele(int j){return individual[j];}
	public char[] getIndividual(){return individual;}
	
	public void setAllele(int j, char c){individual[j] = c;}
	
	public float computeFitness(){return PortEngine.problem.computeFitness(this);}
	
	public char[] copyIndividual(){
		char[] copy = new char[Problem.n];
		System.arraycopy(individual, 0, copy, 0, Problem.n);
		return copy;
	}	
		
	public int distance(Individual johnDoe){										// Hamming Distance
		char[] thatIndividual = johnDoe.getIndividual();
		int dist = 0;
		for(int i = 0; i < Problem.n; i++)
			if(this.individual[i] != thatIndividual[i])
				dist++;
		return dist;
	}
	
	public boolean isZero(){
		for(int i = 0; i < Problem.n; i++)
			if(individual[i] != '0')
				return false;
		return true;
	}
	
	public boolean isOne(){
		for(int i = 0; i < Problem.n; i++)
			if(individual[i] != '1')
				return false;
		return true;
	}
	
	public String toString(){
		String str = "";
		for(int i = 0; i < Problem.n; i++)
			str += individual[i];
		return str;
	}
}
