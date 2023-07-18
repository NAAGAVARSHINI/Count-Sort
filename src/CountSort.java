import java.util.Scanner;

public class CountSort {
    static int[] count(int[] arr, int n){
        int max=arr[0];
        for(int i=0;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }

        int[] countArray = new int[max+1];
        int[] sortedArray = new int[n];
        for(int i=0;i<n;i++){
            ++countArray[arr[i]];
        }
        for(int i=1;i<=max;i++){
            countArray[i]=countArray[i]+countArray[i-1];
        }
        for(int i=n-1; i>=0;i--){
            sortedArray[--countArray[arr[i]]]= arr[i];
        }
        for (int i=0;i<n;i++){
            arr[i]=sortedArray[i];
        }
        return arr;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        arr = count(arr, n);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+ " ");
        }
    }
}
