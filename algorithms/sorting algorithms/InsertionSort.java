public class InsertionSort implements SortingAlgo {

    private static void insertionSort(int[] A){

        for (int i = 1; i<A.length; i++){

            int key = A[i];
            int j = i - 1;

            while (j >= 0 && A[j] > key){
                A[j+1] = A[j];
                j--;
            }

            A[++j] = key;
        }
    }

    @Override
    public void sort(int[] A, int startIndex, int endIndex) {
        insertionSort(A);
    }
}
