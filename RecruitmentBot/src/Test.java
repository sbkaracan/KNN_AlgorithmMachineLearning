
import java.io.IOException;


public class Test {
	
	public static void main(String[] args) throws IOException {
		HelperMethods h = new HelperMethods();
		h.readFile();
		NewCandidate n = new NewCandidate(3.0, 4.0, 5, 5);
		h.calculateEuclid(n);
		//h.listDistances(); //if you want to see the euclidian distances please activate this line.
		
		h.sortInArray();
		//h.listSortedDistances();//if you want to see the sorted euclidian distances please activate this line.
		h.nearestNeighbors(5);
		
		
		
		
	}

}