public class QuickSort implements SortingAlgo{

	private static int partition(int[] A, int p, int q) {
		int m = p, i = p, j = q;
		
		while (i < j) {
			while (i < q && A[++i] < A[m])
				;
			
			while (j > p && A[j] > A[m])
				j--;
			
			if (i < j) {
				int t = A[i];
				A[i] = A[j];
				A[j] = t;
			}
			else
				break;
		}
		int t = A[m];
		A[m] = A[j];
		A[j] = t;
		
		return j;
	}
	
	private static void qSort(int[] A, int p, int q) {
		
		int m;
		
		if (p < q)
		{
			m = partition(A, p, q);
			qSort(A, p, m-1);
			qSort(A, m+1, q);
		}
		
	}
	
    public static void quickSort(int[] A){
    	qSort(A, 0, A.length-1);
    }

    @Override
    public void sort(int[] A, int startIndex, int endIndex) {
    	quickSort(A);
    }
}
