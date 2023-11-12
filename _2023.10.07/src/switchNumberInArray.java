import java.util.Random;

public class switchNumberInArray {
    public static void main(String[] args) {
        // 1. 交换两个数字
        /*
        int a = 20;
        int b = 50;

        int temp = a;
        a=b;
        b=temp;
        System.out.println(a);
        System.out.println(b);*/

        // 2. 交换首位数字

        /* int[] arr = {1, 5, 6, 4, 10, 7};
        int temp = arr[0];
        arr[0]=arr[arr.length-1];
        arr[arr.length-1]=temp;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        */

        // 3. 交换array里的所有数字

//        int[] arr = {1, 5, 6, 4, 10, 7};
//        for (int i = 0, j=arr.length-1; i < j; i++, j--) {
//            int temp = arr[i];
//            arr[i]=arr[j];
//            arr[j]=temp;
//        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]+" ");
//        }

        // 4. 打乱arr里的数据
        int[] arr = {1, 2, 3, 4, 5};
        Random r = new Random();
        // 随机索引index

        for (int i = 0; i < arr.length; i++) {
            int randomIndex = r.nextInt(arr.length);
            int temp = arr[randomIndex];
            arr[randomIndex] = arr[i];
            arr[i] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
