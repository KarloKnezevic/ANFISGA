package hr.fer.zemris.nenr.lab3.ga;

import hr.fer.zemris.nenr.lab3.rule.Rule;
import hr.fer.zemris.nenr.lab3.util.Pair;

import java.util.List;

/**
 * Interface to the system which learns fuzzy-neural network.
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 *
 */
public interface IFuzzyNeuralGenetic {

	/**
	 * Rules learning.
	 * @param learningDataset
	 * @return
	 */
	public Rule[] learn (List<Pair> learningDataset);

	/**
	 * Training more then one time.
	 * DOES NOT SET RULES; ONLY MAKES STATISTICS ABOUT BEST INDIVIDUAL 
	 * THROUGH GENERATIONS!
	 * @param μ
	 * @param times
	 * @param learningDataset
	 * @return
	 */
	public double[] trainAndGetBestAverageFitness(double μ, int times,
			List<Pair> learningDataset);

}
