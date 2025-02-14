package com.a_SGA;

import com.z_PORTFOLIO.Individual;
import com.z_PORTFOLIO.PORTFOLIO;
import com.z_PORTFOLIO.Problem;

class Mutation{
	private final double pMutation;											// Probability of mutation;
	
	public Mutation(double pMutation){this.pMutation = pMutation;}
	
	public double getPMutation(){return pMutation;}
	
	public void mutate(Individual[] newIndividuals){
		if(pMutation > 0)												// Perform mutation only if pMutation > 0.
			for (Individual newIndividual : newIndividuals)
				for (int j = 0; j < Problem.n; j++)
					if (PORTFOLIO.random.nextDouble() < pMutation) {        // Perform mutation in every position with probability pMutation.
						char allele = newIndividual.getAllele(j);
						if (allele == '0')
							newIndividual.setAllele(j, '1');
						else
							newIndividual.setAllele(j, '0');
					}	
	}
}