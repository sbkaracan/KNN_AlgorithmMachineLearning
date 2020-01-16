import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;


public class HelperMethods {

	private static double[][] canArray = new double[1000][5];//all datas divided by split in this array. 
	
	private double[] unsortedArr = new double[1000];//the euclidian distances stored in this array. distances are unsorted
	private double[] sortedArr = new double[1000];//the euclidian distances stored in this array. Distances sorted smaller to bigger
	
	
	public void readFile() throws IOException {
																		//path of the data file
	    BufferedReader bufReader = new BufferedReader(new FileReader("/home/sbk24/Desktop/spacesoldiers")); //This path won't work on your pc
	    ArrayList<String> listOfLines = new ArrayList<>(); //created new arraylist

	    String line = bufReader.readLine();//line equals first line of our code
	    
	    while (line != null) {//if line is not null. If there is a line...
	      listOfLines.add(line);	//then add the line to our arraylist
	      line = bufReader.readLine();//check the other line
	    }
	    
	    for (int i = 0; i < canArray.length; i++) {
			for (int j = 0; j < canArray[0].length; j++) {
				String string = listOfLines.get(i);			// get the first element of arraylist. (first element is first line for this arraylist.)
			    String[] parts = string.split(",");			// we get the first line then we split all 5 variables using the split method
				canArray[i][j] = Double.valueOf(parts[j]);	//we add the elements of parts array to canArray which is double dimensional array
				
			}
		}
	    
	    
	    bufReader.close();//close the buffered reader
	}
	
	public void calculateEuclid(NewCandidate n){//new method it has been called from main method
		   
        for (int i = 0; i < canArray.length; i++) {//used canArray's length because our datas in can array's first and second column.
            
        	unsortedArr[i] = Math.sqrt(Math.pow(canArray[i][0]-n.getSocial(), 2)+ Math.pow(canArray[i][1] - n.getAlg(), 2));//the formula of euclidian distance. Adding to unsortedArray
                
        }
        
    }
	
	
	public void listDistances() {
		System.out.println("Distances to new Candidate");
		for (int i = 0; i < unsortedArr.length; i++) {
	    	System.out.println("Data "+(i+1) + " " +unsortedArr[i]);
	    	
		}
	}
	
	
	
	public void sortInArray() {
		
		for (int i = 0; i < unsortedArr.length; i++) {
			sortedArr[i] = unsortedArr[i];//add all elements in unsorted array to sorted array.
			
		}
		
		MergeSort ob = new MergeSort(); //call the MergeSort class and make it object
	    ob.sort(sortedArr, 0, sortedArr.length-1); // sort the sorted array
	    
	}
	
	public void listSortedDistances() {
		System.out.println("Distances to new Candidate (Smaller to Bigger)");
		for (int i = 0; i < sortedArr.length; i++) {
	    	System.out.println("Data "+(i+1) + " " +sortedArr[i]);
	    	
		}
	}
	
	public void nearestNeighbors(int nearest) {
		
		
		
		System.out.println();
		System.out.println("Value of Nearest "+nearest+" neighbors.");
		System.out.println();
		
		
		
		
		double sum = 0;//create a variable sum which is 0
		
	    for (int i = 0; i <nearest; i++) {//nearest is the value which we will look nearest how many neighbors.
	    	
	    	for (int j = 0; j < sortedArr.length; j++) {
				/*
				 In this code block.
				 If sortedArr's i'th index equals unsortedArr's j'th index:
				 Add j'th row and 4'th column of canArray to the sum. 4th column is the value which is about getting the job (0 or 1).
				 
				 
				 This block's time complexity is NOT n^2 because nearest is a NUMBER not an array. Let's say nearest number is 5, then time complexity is 5n it means it is linear.
				 
				 
				 
				 
				 */
	    		if (sortedArr[i] == unsortedArr[j]) {//if i'th index of array equals j'th index of arraylist
	    			System.out.println("Value of Nearest data "+ (i+1) + " = "+canArray[j][4]+"\nSocial Skill Point= "+canArray[j][0]+" | Algorithm Skill Point= "+canArray[j][1]);
	    			System.out.println();
	    			sum = canArray[j][4] + sum;//add 4th index (0 or 1) to a sum
	    			
	    		}
				
			}
			
		}
	    System.out.println();
	    
	    
	    
	    
	    	if (sum > nearest/2) {//if sum value is bigger than the half of the nearest value. Candidate gets the job.
				
				System.out.println("Nearest "+sum+" out of "+nearest+" neighbor got the job");
				System.out.println("It means Candidate got the job!");
			}
		    else {//if sum value is smaller than the half of the nearest value. Candidate can't get the job.
		    	
		    	System.out.println("Nearest "+sum+" out of "+nearest+" neighbor got the job");
		    	System.out.println("It means Candidate couldn't get the job");
		    }
	
	
	}
	
	
	
	
}