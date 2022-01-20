//-----------------------------------------------------
// Title: Main class
// Author: Sencer Yücel
// Section: 02
// Assignment: 2
// Task: 1
//-----------------------------------------------------

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
class Merge {
    //stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        //copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        //merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            //in less method, indices switch in auxiliary array to make this method sort in descending order.
            else if (less(aux[i], aux[j])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
    //mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    //helper function. Is v < w?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}

public class main {

    //Insertion sort but sorts the array in descending order and also starts from the right. (Step 2)
    public static void descendingInsertionSort(int[] arr){
        int n = arr.length-1;
        for(int i = n; i >= 0; i--){
            int key = arr[i];
            int j = i+1;
            while(j < arr.length&&arr[j]>=key){
                arr[j-1] = arr[j];
                j++;
            }
            arr[j-1] = key;
        }
    }
    //This is the overloaded version of the method above for double inputs. (Step 3)
    public static void descendingInsertionSort(double[] arr){
        for(int i = arr.length-1; i >= 0; i--){
            double key = arr[i];
            int j = i+1;
            while(j < arr.length&&arr[j]>=key){
                arr[j-1] = arr[j];
                j++;
            }
            arr[j-1] = key;
        }
    }

    //Bubble sort in descending order. (Step 4)
    public static void descendingBubbleSort(int[] array){
        int n = array.length;
        int temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] < array[j+1])
                {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }else{ }
            }
        }
    }

    //I did not want to create Person's IDs with hand. Therefore, I created an ID generator.
    public static long idGenerator(){
        long x = 10000000000L;
        long y = 99999999999L;
        Random r = new Random();
        long id = x+((long)(r.nextDouble()*(y-x)));
        if(id % 2 == 1){
            id -= 1;
        }
        return id;
    }

    public static void main(String[] args) throws FileNotFoundException {

        //First step of the question, takes input and put them in an array.
        Scanner i1 = new Scanner(new FileReader("intFile.txt"));
        boolean hasInput = true;
        int arraySize = i1.nextInt();
        int[] array = new int[arraySize];
        int arrayIndex = 0;
        while(hasInput){
            try{
                array[arrayIndex] = i1.nextInt();
                arrayIndex++;
            }catch(NoSuchElementException e){
                hasInput = false;
            }
        }
        int[] tempArr;
        tempArr = Arrays.copyOfRange(array, 0, array.length);
        System.out.println("Array from txt file is: " + Arrays.toString(array));
        descendingInsertionSort(array);
        System.out.println("Sorted array with insertion sort: " + Arrays.toString(array));
        array = Arrays.copyOfRange(tempArr, 0, tempArr.length);
        System.out.println("First array again: " + Arrays.toString(array));
        descendingBubbleSort(array);
        System.out.println("Sorted array with bubble sort: " + Arrays.toString(array));
        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");



        Merge merge = new Merge();

        Comparable[] ids = new Comparable[10];
        int counter = 0;

        long tempId = idGenerator();
        Person p1 = new Person("Kemal", "Bahçeli", tempId);
        ids[counter] = tempId;
        counter++;

        tempId = idGenerator();
        Person p2 = new Person("Turgut", "Evren", tempId);
        ids[counter] = tempId;
        counter++;

        tempId = idGenerator();
        Person p3 = new Person("Binali", "Arınç", tempId);
        ids[counter] = tempId;
        counter++;

        tempId = idGenerator();
        Person p4 = new Person("Cem", "Ecevit", tempId);
        ids[counter] = tempId;
        counter++;

        tempId = idGenerator();
        Person p5 = new Person("Deniz", "Kılıçdaroğlu", tempId);
        ids[counter] = tempId;
        counter++;

        tempId = idGenerator();
        Person p6 = new Person("Mansur", "İhsanoğlu", tempId);
        ids[counter] = tempId;
        counter++;

        tempId = idGenerator();
        Person p7 = new Person("Muharrem", "İmamoğlu", tempId);
        ids[counter] = tempId;
        counter++;

        tempId = idGenerator();
        Person p8 = new Person("Numan", "Soylu", tempId);
        ids[counter] = tempId;
        counter++;

        tempId = idGenerator();
        Person p9 = new Person("Besim", "Perinçek", tempId);
        ids[counter] = tempId;
        counter++;

        tempId = idGenerator();
        Person p10 = new Person("Kenan", "Babacan", tempId);
        ids[counter] = tempId;
        counter++;

        System.out.println("IDs:");
        for(int i = 0; i < ids.length; i++){
            System.out.print(ids[i] + " ; ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Sorted IDs in descending order with Merge Sort:");
        System.out.println("NAME \t\t SURNAME \t\t ID");

        Comparable[] helperArray = new Comparable[ids.length];
        merge.sort(ids, helperArray,0, ids.length-1);

        for(int i = 0; i < ids.length; i++){
            if(ids[i].equals(p1.getId()))
                System.out.println(p1.getName() + "\t\t" + p1.getSurname() + "\t\t\t" + p1.getId());
            else if(ids[i].equals(p2.getId()))
                System.out.println(p2.getName() + "\t\t" + p2.getSurname() + "\t\t\t" + p2.getId());
            else if(ids[i].equals(p3.getId()))
                System.out.println(p3.getName() + "\t\t" + p3.getSurname() + "\t\t\t" + p3.getId());
            else if(ids[i].equals(p4.getId()))
                System.out.println(p4.getName() + "\t\t\t" + p4.getSurname() + "\t\t\t" + p4.getId());
            else if(ids[i].equals(p5.getId()))
                System.out.println(p5.getName() + "\t\t" + p5.getSurname() + "\t" + p5.getId());
            else if(ids[i].equals(p6.getId()))
                System.out.println(p6.getName() + "\t\t" + p6.getSurname() + "\t\t" + p6.getId());
            else if(ids[i].equals(p7.getId()))
                System.out.println(p7.getName() + "\t" + p7.getSurname() + "\t\t" + p7.getId());
            else if(ids[i].equals(p8.getId()))
                System.out.println(p8.getName() + "\t\t" + p8.getSurname() + "\t\t\t" + p8.getId());
            else if(ids[i].equals(p9.getId()))
                System.out.println(p9.getName() + "\t\t" + p9.getSurname() + "\t\t" + p9.getId());
            else
                System.out.println(p10.getName() + "\t\t" + p10.getSurname() + "\t\t\t" + p10.getId());
        }
    }
}

