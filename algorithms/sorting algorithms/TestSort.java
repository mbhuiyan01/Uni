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
    }
}
