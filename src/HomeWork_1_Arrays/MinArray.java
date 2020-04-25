package HomeWork_1_Arrays;

public class MinArray {
    public static void main(String[] args) {
        int[][] x = { {20, 34, 2}, {9, 12, 18}, {3, 4, 5} };
        int res = search(x);
        System.out.println(res);
    }
    static int search(int arr[][]){
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                res += arr[i][j];
            }
        }
    return res;
    }
}
