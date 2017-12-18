public class QuickSort {

  private static int partition(int arr[], int start, int end) {

    int pivot = arr[end]; // we always pick our rightmost element to be the pivot
    int pIndex = 0;

    // put all values that are lesser than pivot to the leftmost positions
    for (int i = 0; i < end; i++) {
      if (arr[i] < pivot) {
        // swap values
        int temp = arr[i];
        arr[i] = arr[pIndex];
        arr[pIndex] = temp;
        pIndex++;
      }
    }
    // once all values have been pushed to the leftmost positions
    // swap the pivot value with the value at the pIndex
    int temp = arr[pIndex];
    arr[pIndex] = arr[end];
    arr[end] = temp;

    // this index will be the new "splitting" point for our recursive calls
    return pIndex;
  }

  public static void quicksort(int arr[], int start, int end) {

    if (start < end) { // Recurse until
      int pIndex = partition(arr, start, end); // partition the array
      quicksort(arr, start, pIndex - 1); // Recursively partition the left subarray
      quicksort(arr, pIndex + 1, end); // Recursively partition the right subarray
    }
  }

  public static void main(String[] args) {
    int arr[] = {7, 6, 4, 5, 3, 1, 2, 0};

    QuickSort.quicksort(arr, 0, arr.length - 1);

    for (int i : arr) {
       System.out.print(i + " ");
    }
    System.out.println();
  }

}
