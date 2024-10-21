/**
 * 
 */
package unionfind;

import java.util.*;

/**
 * @author Malachai Onwona
 *
 */

public class QuickFind {
	
	private int[] id;
	private int count;
	
	public QuickFind (int n) { //Initialize component id array
		
		count = n;
		id = new int[n];
		
		for (int i = 0; i < n; i++) {
			
			id[i] = i;
			
		}
		
	}
	
	
	public int count() {
		return count;
	}
	
	public int find (int p) {
		return id[p];
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	public void union(int p, int q) {
		
		int pID = find(p);
		int qID = find(q);
		
		if (pID == qID) {
			return;
		}
		
		for (int i = 0; i < id.length; i++) {
			
			if (id[i] == pID) {
				
				id[i] = qID;
				
			}
			
		}
		
		count--;
		
	}
	
	
	public static void main(String[] args) { //Read, process, and solve the dynamic connectivity problem file
		
		Scanner reader = new Scanner(System.in);
		
		int n = reader.nextInt();
		QuickFind qf = new QuickFind(n);
		
		while(reader.hasNextInt()) {
			
			int p = reader.nextInt();
			int q = reader.nextInt();
			
			if (qf.connected(p, q)) {
				continue;
			}
			
			qf.union(p, q);
			System.out.println(p + " " + q);
			
		}
		
		System.out.println(qf.count() + "components");
		reader.close();
		
	}

}

