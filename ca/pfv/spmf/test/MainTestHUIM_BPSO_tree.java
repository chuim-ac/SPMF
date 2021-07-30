package ca.pfv.spmf.test;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Scanner;

import ca.pfv.spmf.algorithms.frequentpatterns.HUIM_BPSO_tree.AlgoHUIM_BPSO_tree;

/**
 * Example of how to use the HUIM-BPSO-tree algorithm 
 * from the source code.
 * @author Jerry Chun-Wei Lin, Lu Yang, Philippe Fournier-Viger, 2016
 */
public class MainTestHUIM_BPSO_tree {

	public static void main(String [] arg) throws IOException{

		File file = new File(".");
		String[] directories = file.list();
		System.out.println(directories);

		for (int i = 0; i < directories.length; ++i) {
			System.out.println(i + 1 + ". " + directories[i]);
		}

		System.out.print("\nSelect the dataset : ");
		Scanner sc = new Scanner(System.in);
		int index = sc.nextInt();

		System.out.print("Enter the minUtil : ");
		int min_utility = sc.nextInt();

		//String input = fileToPath("contextHUIM.txt");
		
		String output = ".//output.txt";

		//int min_utility = 40;  //
		
		// Applying the huim_bpso_tree algorithm
		AlgoHUIM_BPSO_tree huim_bpso_tree = new AlgoHUIM_BPSO_tree();
		huim_bpso_tree.runAlgorithm(directories[index-1], output, min_utility);
		huim_bpso_tree.printStats();

	}

	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestHUIM_BPSO_tree.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}
