import java.util.Scanner;

public class Akcija {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //get input
        int books = sc.nextInt();
        int prices[] = new int[books];
        for (int i = 0; i < books; i++){
            prices[i] = sc.nextInt();
        }
        //gives the number of books in the only group with size smaller than 3, if 0 no such group exists
        int groupsOf3 = books/3;
        int remainder = books % 3;
        int totalPrice = 0;
        //sort array of books
//        for(int i = 0; i < books; i++){
//            for (int j = i; j < books -1; j++){
//                if (prices[j] > prices[j+1]){
//                    int temp = prices[j+1];
//                    prices[j+1] = prices[j];
//                    prices[j] = temp;
//                }
//            }
//        }
        Akcija ob = new Akcija();
        ob.sort(prices, 0, prices.length - 1);

        //sort into groups
        if (remainder > 0){
            //put the cheapest books in the remainder group, so we can just add them to our total price
            for(int i = 0; i < remainder; i++){
                totalPrice += prices[i];
            }
        }
        //now we do the rest of them, we can use % to know when we are at the third book
        for (int i = remainder; i < books; i++){
            //if we are not on the first in a group of 3
            if (!(((i - remainder) % 3) == 0)){
                totalPrice += prices[i];
            }
        }
        //print
        System.out.println(totalPrice);
    }
    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }


        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}

