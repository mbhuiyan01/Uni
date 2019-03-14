import java.util.Arrays;
import java.util.Random;

public class TestSort {

    private static boolean testShuffled(SortingAlgo sortingAlgo){

        return true;
    }

    private static boolean testMultiplePairs(SortingAlgo sortingAlgo){

        return true;
    }

    private static int[][] testAsymptoticBehaviour(SortingAlgo sortingAlgo, int range, int step){

        return new int[][]{};
    }

    private static int[] getRandomArray(int length, int minInt, int maxInt){
        Random rnd = new Random();
        int[] lst = new int[length];

        for (int i = 1; i<length; i++){
            lst[i-1] = rnd.nextInt(maxInt - minInt + 1) + minInt;
        }

        return lst;
    }

    public static void main(String[] args) {
    	
    	int length = 5000;
    	int[] data = new int[length];
    	SortingAlgo sortingAlgo = new QuickSort();
    	
    	data = getRandomArray(data.length, 0, 5000);
    	
    	sortingAlgo.sort(data, 0, data.length);
    	
    	for (int i = 0; i < data.length-1; i++)
    		assert data[i+1] >= data[i]: "data[" + (i+1) + "] less than data[" + i + "]" ;
    		    	
    }
}
