package hr.fer.zemris.nenr.lab3.ga;

import hr.fer.zemris.nenr.lab3.rule.Rule;

/**
 * Interface.
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 *
 */
public interface IFitness {
	
	public double compute(Rule[] rules, double x, double y);

}
