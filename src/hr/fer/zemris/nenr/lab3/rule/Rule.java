package hr.fer.zemris.nenr.lab3.rule;

import hr.fer.zemris.nenr.lab3.membershipFunction.FuzzyTriangle;
import hr.fer.zemris.nenr.lab3.tNorm.EinsteinProduct;

/**
 * Rule.
 * @author Karlo Knazevic, karlo.knezevic@fer.hr
 *
 */
public class Rule {
	
	public FuzzyTriangle ftA;
	
	public FuzzyTriangle ftB;
	
	public EinsteinProduct norm;
	
	public Conclusion conclusion;
	
	public Rule(FuzzyTriangle ftA, FuzzyTriangle ftB, 
			EinsteinProduct norm, Conclusion conclusion) {
		
		this.ftA = ftA;
		this.ftB = ftB;
		this.norm = norm;
		this.conclusion = conclusion;
		
	}
	
	public double conclude(double x, double y) {
		return conclusion.compute(x, y);
	}
	
	public double α(double x, double y) {
		return norm.computeNorm(ftA.compute(x), ftB.compute(y));
	}
	
}
