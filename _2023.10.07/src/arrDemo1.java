public class arrDemo1 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 8, 1, 3, 4, 9, 7, 15, 34, 15, 76, 95, 14};
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%3 == 0) {
                count++;
            }
        }
        System.out.println("能被3整除的数字 有"+count+"个");
    }
}
