package hr.fer.zemris.nenr.lab3.dataset;

import hr.fer.zemris.nenr.lab3.util.Pair;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Dataset.
 * @author Karlo Knezevic, karlo.knezevic@fer.hr
 *
 */
public class Dataset {

	private String dataFileName = "res/NENRProjekt3.txt";

	private List<Pair> trainingSet;

	/**
	 * Constructor.
	 */
	public Dataset() {

		readFile();
	}

	/**
	 * Constructor.
	 * @param fileName File with learning data.
	 */
	public Dataset(String fileName) {

		dataFileName = fileName;
		
		readFile();
		
	}

	/**
	 * File Reader.
	 */
	private void readFile() {
		
		trainingSet = new ArrayList<Pair>();

		BufferedReader br = null;

		try {

			br = new BufferedReader(
					new InputStreamReader(
							new BufferedInputStream(
									new FileInputStream(dataFileName)), "UTF-8"));

		} catch (Exception e) { e.printStackTrace(); System.exit(-1); }
		
		String line = null;
		while (true) {
			
			try {
				
				line = br.readLine();
				
				if (line == null) break;
				
				if (line.isEmpty()) continue;
			
			} catch (Exception e) { e.printStackTrace(); continue; }
			
			//one or more spaces as delimiter
			//STRICT FORMAT!
			String pattern[] = line.split("\\s+");
			
			trainingSet.add(
					new Pair(
							Double.valueOf(pattern[0]), 
							Double.valueOf(pattern[1]), 
							Double.valueOf(pattern[2])
							)
					);
			
		}

	}
	
	/**
	 * Training Set.
	 * @return Training Set
	 */
	public List<Pair> getTrainingSet() {
		return trainingSet;
	}

}