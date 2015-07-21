package com.b_UMDA;

import com.z_PORTFOLIO.Individual;
import com.z_PORTFOLIO.PORTFOLIO;
import com.z_PORTFOLIO.Problem;
import com.z_PORTFOLIO.SelectedSet;

import java.util.List;

class UniModel{
	public final int offspringSize;
	
	public UniModel(int offSize){offspringSize = offSize;}	
	
	public List<Individual> sampleNewIndividuals(SelectedSet selectedSet, List<Individual> newIndividuals){
		newIndividuals.clear();
		int[] frequencies = selectedSet.getUniFrequencies();
		int NS = selectedSet.getN();
		for(int i = 0; i < offspringSize; i++){
			Individual x = new Individual();
			newIndividuals.add( x );
			final char[] data = x.getIndividual();
			for(int j = 0; j < Problem.n; j++){
				double probJ = ((double)(frequencies[j]))/NS;
				data[j] = (PORTFOLIO.random.nextDouble() < probJ) ? '1' : '0';;
			}
		}
		return newIndividuals;
	}
	
}