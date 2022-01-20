//-----------------------------------------------------
// Title: Sorting Algorithm Tester
// ID: 16933103152
// Section: 02
// Assignment: 2
// Task: 2
//-----------------------------------------------------

import java.util.Random;
public class SortingAlgorithmTester {

    public static void main(String[] args) {
        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();

        Random random = new Random();

        //Random Array Creator.
        int[] arr = random.ints(100000,10,100000).toArray();

        //Ascending Array Creator.
        int[] ascArr = new int[100000];
        for(int i = 0; i < ascArr.length; i++){
            ascArr[i] = i;
        }

        //Descending Array Creator.
        int[] descArr = new int[100000];
        for(int i = descArr.length; i >= 0; i--){
            ascArr[i] = descArr.length - i;
        }

        long firstTime = System.currentTimeMillis();
        sortingAlgorithms.sort1(arr, 1693310315L);
        long secondTime = System.currentTimeMillis();
        System.out.println(secondTime-firstTime);
        firstTime = System.currentTimeMillis();
        sortingAlgorithms.sort2(arr,1693310315L);
        secondTime = System.currentTimeMillis();
        System.out.println(secondTime - firstTime);
        firstTime = System.currentTimeMillis();
        sortingAlgorithms.sort3(arr,1693310315L);
        secondTime = System.currentTimeMillis();
        System.out.println(secondTime - firstTime);
        firstTime = System.currentTimeMillis();
        sortingAlgorithms.sort4(arr,1693310315L);
        secondTime = System.currentTimeMillis();
        System.out.println(secondTime - firstTime);
        firstTime = System.currentTimeMillis();
        sortingAlgorithms.sort5(arr,1693310315L);
        secondTime = System.currentTimeMillis();
        System.out.println(secondTime - firstTime);

        /*System.out.println(Arrays.toString(arr2));*/

    }
}
