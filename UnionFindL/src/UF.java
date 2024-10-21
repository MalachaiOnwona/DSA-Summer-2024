
public class UF {
	
	private int[] id;
	private int count;
	
	public UF (int n) { //Initialize component id array
		
		count = n;
		id = new int[n];
		
		for (int i = 0; i < n; i++) {
			
			id[i] = i;
			
		}
		
	}
	
	
	public int count() {
		return count;
	}
	
	public int find (int p) {}
	
	public boolean connected(int p, int q) {
		
		return find(p) == find(q);
		
	}
	
	public void union(int p, int q) {}
	
	
	public static void main(String[] args) { //Read, process, and solve the dynamic connectivity problem file
		
		int n = StdIn.readInt();
		
		UF uf = new UF(n);
		
		while(!StdIn.isEmpty()) {
			
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			
			if (uf.connected(p, q)) {
				continue;
			}
			
			uf.union(p, q);
			StdOut.println(p + " " + q);
			
		}
		
		StdOut.println(uf.count() + "components");
		
		
	}

}
