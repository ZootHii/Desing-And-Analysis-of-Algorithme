import java.util.Arrays;

public class Algorithme
{
    
    static int[] countingSort(int arr[], int sortedArr[], int max)
    {

        int range = max + 1; // [0...k]
        
        sortedArr = new int[arr.length]; // output -> B
        
        
        int[] count = new int[range]; // count -> C  LET C BE A NEW ARRAY
        for (int i = 0; i < max; ++i)
        {
          count[i] = 0;
        }

        // C[i] now contains the number of elements equal to i
        for (int i = 0; i < arr.length; i++)
        {
          count[arr[i]]++; // increase 1 each recurse so for example we have at count[0] = 2 because we have 2 zeros 
        }

        // C[i] now contains the number of elements less than or equal to i.
        for (int i = 1; i <= max; i++)
        {
          count[i] += count[i - 1];
        }

        // Find the index of each element of the arr in count array (C), and put the elements in sortedArr
        for (int i = arr.length - 1; i >= 0; i--)
        {
          sortedArr[count[arr[i]] - 1] = arr[i];
          count[arr[i]]--;
        }
        
        // Return the sortedArray so we dont change the original array (arr)
        return sortedArr;
    }

    public static void main(String args[])
    {

        int[] data = { 2, 5, 3, 0, 2, 3, 0, 3 };
        int[] output = new int[data.length];

        // FINDS LARGEST JAVA API
        int max = Arrays.stream(data).max().getAsInt(); // max -> k

        output = countingSort(data, output, max);

        System.out.println("Unsorted Array -> " + Arrays.toString(data));
        System.out.println("Sorted Array -> " + Arrays.toString(output));
    }
}
