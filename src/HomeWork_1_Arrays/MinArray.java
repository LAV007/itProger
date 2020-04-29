package HomeWork_1_Arrays;

public class MinArray {
    public static void main(String[] args) {

        int length = 3;
        int[][] x = {
                {20, 34, 2},
                {9, 12, 18},
                {3, 4, 5}
        };

        int min = x[0][0];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (x[i][j] < min)
                    min = x[i][j];
            }
        }
        System.out.print("Минимальный: " + min);
    }
}
