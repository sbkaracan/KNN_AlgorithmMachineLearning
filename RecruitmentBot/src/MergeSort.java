class MergeSort //merge sort's method
{ 
    
    void merge(double arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; //(middle index - first index) + 1
        int n2 = r - m;//last index - middle index
  
        //Create temp arrays
        double A[] = new double [n1]; 
        double B[] = new double [n2]; 
  
        //in the code below. Array has divided to 2 parts and filled the first part to A array, second part to B array.
        for (int i=0; i<n1; ++i) 
            A[i] = arr[l + i]; //i'th index of A temp array equals to (l+i)th index of given array. 
        for (int j=0; j<n2; ++j) 
            B[j] = arr[m + 1+ j]; //j'th index of B temp array equals to (m+1+j)th index of given array.
  
  
        
        int i = 0, j = 0; 
  
        
        
        //sorting part
        
        // logic: If i'th part of A smaller than j'th part of B. Put i'th part of A to the arr's k'th element. After that add 1 to i. Because we added A[i] and it was smaller. Now 
        //we need to compare (i+1)'th part of A and j'th part of B.
        int k = l; 
        while (i < n1 && j < n2) //while i<n1 and j<n2: i will get the index of A temp array and j will get the index of B temp array.
        { 
            if (A[i] <= B[j]) //i'th index of A smaller than or equal j'th index of B.
            { 
                arr[k] = A[i]; //add i'th index of A to arr's k'th element. Because A[i] is smaller than B[j]
                i++; //increase i 1 time for comparing with the next index.
            } 
            else//if B[j] is smaller than A[i]:
            { 
                arr[k] = B[j]; //k'th index of arr is j'th index of B.
                j++; ////increase j 1 time for comparing with the next index.
            } 
            k++; //increase 1 time. Because for every loop we will fill one index of Arr. If we don't increase, arr will have 1 element only.
        } 
        
        
        
  
        /* Copy remaining elements of A[] if any */
        while (i < n1) // at the while loop above, if j reaches to n2 before. We need to add remaining elements of A to the arr.
        { 
            arr[k] = A[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) // if i reaches to n1 before j. We need to add remaining elements of b to the arr.
        { 
            arr[k] = B[j]; 
            j++; 
            k++; 
        }
        
        
    }
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void sort(double arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point for dividing the array.
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m); //first half
            sort(arr , m+1, r); //second half
  
            // Merge the sorted halves 
            merge(arr, l, m, r); //call merge method
        } 
    } 
  
    
   
}