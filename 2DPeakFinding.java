public class Algorithme 
{

    static int findIndexOfMax(int[][] arr, int rows, int mid, int max)
    {
        int indexOfMax = 0;
        for (int i = 0; i < rows; i++)
        {
            if (max < arr[i][mid])
            {
                max = arr[i][mid];
                indexOfMax = i; // the index of max row value arr[0][2] == 2 so i(index of max) == 0 "FOR FIRST ATTEMPT"
            }
        }
        return indexOfMax;
    }

    static int maxValue(int[][] arr, int rows, int mid, int max)
    {
        for (int i = 0; i < rows; i++)
        { 
            if (max < arr[i][mid])
            {
                max = arr[i][mid]; // the max row value arr[0][2] == 2 so max(the value) == 2 "FOR FIRST ATTEMPT"
            }
        }
        return max;
    }

    static int findPeakRecurse(int[][] arr, int rows, int columns, int mid)
    {
        int max = 0;
        int indexOfMax = findIndexOfMax(arr, rows, mid/*columns/2*/, max); // 0
        max = maxValue(arr, rows, mid, max); // 2

        if (mid == 0 || mid == columns - 1) // FALSE "FOR FIRST ATTEMPT"
        {
            return max;
        }

        if (max >= arr[indexOfMax][mid - 1] && max >= arr[indexOfMax][mid + 1]) // "arr[indexOfMax][mid - 1] == [0][1] == 3" = FALSE so FALSE "FOR FIRST ATTEMPT"
        {
            return max;
        }

        if (max < arr[indexOfMax][mid - 1]) // "arr[indexOfMax][mid - 1] == [0][1] == 3" == TRUE "FOR FIRST ATTEMPT"
        {
            return findPeakRecurse(arr, rows, columns, (int)(mid - (double) mid / 2)); // arr, rows, columns, "(2/2 == 1.0 -> mid - 1.0 -> 2 - 1.0 == 1.0 -> (int) 1.0 == 1)"
        }

        return findPeakRecurse(arr, rows, columns, (int)(mid + (double) mid / 2)); 
    } 

    static int findPeak(int[][] arr, int rows, int columns)  
    { 
        return findPeakRecurse(arr, rows, columns, columns / 2); 
    } 
 
    public static void main(String[] args) {

        int[][] arr = {{ 0, 3, 2, 0 },
                       { 0, 4, 1, 0 },
                       { 0, 8, 0, 0 },
                       { 0, 6, 7, 0}};

        int rows = 4, columns = 4;
        System.out.println(findPeak(arr, rows, columns));
    }
}
