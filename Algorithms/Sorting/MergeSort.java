public class MergeSort {


  private void merge(int arr[], int left[], int right[]) {
    int i = 0; // points to index of next uninserted element in left sub array
    int j = 0; // points to index of next uninserted element in right sub array
    int k = 0; // points to next unempty space in arr

    // Rebuild the new array in sorted order, maintaining the ptrs to the subarrays
    while(i < left.length && j < right.length) {
      if (left[i] <= right[j]) {
        arr[k] = left[i];
        i++;
      }
      else {
        arr[k] = right[j];
        j++;
      }
      k++;
    }
    // if there are leftovers in left subarray, add them to the new array
    while (i < left.length) {
      arr[k] = left[i];
      i++;
      k++;
    }
    // if there are leftovers in right subarray, add them to the new array
    while (j < right.length) {
      arr[k] = right[j];
      j++;
      k++;
    }
  }

  // Recursively call mergeSort creating subarrays, half the size of
  // their predecessors. Once the size of the subarrays are 1, merge the
  // arrays back in sorted order.
  public void mergeSort(int arr[]) {

    int size = arr.length;
    if (size == 1) {return;}
    int mid = size / 2;

    int left[] = new int[mid];
    int right[] = new int[size - mid];

    for (int i = 0; i < mid; i++) {left[i] = arr[i];}
    for (int i = mid; i < size; i++) {right[i - mid] = arr[i];}

    mergeSort(left);
    mergeSort(right);
    merge(arr, left, right);
  }

  public static void main(String[] args) {
    MergeSort ms = new MergeSort();
    int arr[] = {12, 11, 13, 5, 6, 7, 4, 2, 1, 3, 100};

    System.out.println("---Unsorted Array---");
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();

    ms.mergeSort(arr);
    System.out.println("---Sorted Array---");
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();

  }
}
