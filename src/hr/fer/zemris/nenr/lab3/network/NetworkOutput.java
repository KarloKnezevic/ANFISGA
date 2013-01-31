package hr.fer.zemris.nenr.lab3.network;

import hr.fer.zemris.nenr.lab3.ga.IFitness;
import hr.fer.zemris.nenr.lab3.rule.Rule;

import java.util.Arrays;

/**
 * Network output.
 * Implements IFitness.
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 *
 */
public class NetworkOutput implements IFitness {

	@Override
	public double compute(Rule[] rules, double x, double y) {
		
		if (rules == null) {
			System.err.println(
					"It's necessary to learn network. Please, learn the network.");
			System.exit(-1);
		}

		double[] α = new double[rules.length];
		Arrays.fill(α, 0);
		double Σα = 0;

		//LAYER 1 AND LAYER 2
		for (int i = 0; i < rules.length; i++) {
			α[i] = rules[i].α(x, y);
			Σα += α[i];
		}
		
		//Division by zero!
		if (Σα == 0) return 0;

		//LAYER 3, 4 AND LAYER 5
		double f = 0;
		for (int i = 0; i < rules.length; i++) {
			f += α[i]*rules[i].conclude(x, y)/Σα;
		}

		return f;
	}

}
