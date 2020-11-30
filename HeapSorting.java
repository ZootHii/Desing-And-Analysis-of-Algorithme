import java.util.Arrays;

public class Algorithme 
{
    
    static void heapSort(int arrA[])
    {
        buildMaxHeap(arrA);
        for (int i = arrA.length - 1; i >= 0; i--)
        {
            int exchange = arrA[0];
            arrA[0] = arrA[i];
            arrA[i] = exchange;
            maxHeapify(arrA, i, 0);
        }
    }
    
    static void buildMaxHeap(int arrA[])
    {
        int heap_size = arrA.length;
        for (int i = (arrA.length / 2) - 1; i >= 0; i--)
        {
            maxHeapify(arrA, heap_size, i);
        }  
    }
    
    static void maxHeapify(int arrA[], int heap_size, int i){

        int largest;
        int l  = 2*i; // left = 2i +1
        int r  = 2*i + 1; // right = 2i + 1

        if (l < heap_size && arrA[l] > arrA[i])
        {
            largest = l;
        }
        else
        {
            largest =i;
        }

        if (r < heap_size && arrA[r ] > arrA[largest])
        {
            largest = r;
        }

        if (largest != i)
        {
            int exchange = arrA[i];
            arrA[i] = arrA[largest];
            arrA[largest] = exchange;
            maxHeapify(arrA, heap_size, largest);
        }
    }

    public static void main(String args[]){
        int arrA[] = {8, 10, 4, 3, 2, 5, 7, 75, 42, 13, 9};

        System.out.println("Before HeapSort: " + Arrays.toString(arrA));

        heapSort(arrA);

        System.out.println("After HeapSort: " + Arrays.toString(arrA));
    }
}
