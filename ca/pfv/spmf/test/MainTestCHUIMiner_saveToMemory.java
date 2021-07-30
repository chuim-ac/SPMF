package ca.pfv.spmf.test;

import java.io.*;
import java.net.URL;
import java.util.*;

import ca.pfv.spmf.algorithms.frequentpatterns.hui_miner.AlgoCHUIMiner;
import ca.pfv.spmf.algorithms.frequentpatterns.hui_miner.Itemset;


/**
 * Example of how to use the CHUI-Miner algorithm 
 * from the source code and save the result to memory.
 * @author Philippe Fournier-Viger, 2014
 */
public class MainTestCHUIMiner_saveToMemory {

	public static void main(String [] arg) throws IOException{
		// input file pathewq'''''''''''''''\
//		String input = fileToPath("DB_Utility.txt");
//		// the minutility threshold
//		int min_utility = 30;
		
		//String input = fileToPath("DB_Utility.txt");
		//File file = new File("out/artifacts/spmf_jar");
		File file = new File(".");
		String[] directories = file.list();
		System.out.println(directories);

		for (int i = 0; i < directories.length; ++i) {
			System.out.println(i + 1 + ". " + directories[i]);
		}

		System.out.print("\nSelect the dataset : ");
		Scanner sc = new Scanner(System.in);
		int index = sc.nextInt();
		//String input = "DB_Utility.txt";
        System.out.print("Enter the minUtil : ");
		int min_utility = sc.nextInt();
		
		// (1) Applying the  CHUI-Miner algorithm to find 
		// closed high utility itemsets (CHUIs)
		AlgoCHUIMiner chuiMiner = new AlgoCHUIMiner(false);
		List<List<Itemset>> closedItemsets = chuiMiner.runAlgorithm(directories[index-1], min_utility, "CHUI.txt");
		chuiMiner.printStats();
	}


	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestCHUIMiner_saveToMemory.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}
