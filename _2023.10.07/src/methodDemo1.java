import java.sql.Array;

public class methodDemo1 {
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 9, 10, 5, 6, 8, 1, 6};
//        printArr(arr);
//        System.out.println(getMax(arr));
//        System.out.println(existIn(15, arr));
        printArr(getNewArray(arr,2, 9));
    }



    // 打印array
    public static void printArr(int[] arr){
        System.out.print("["+arr[0]);
        for (int i = 1; i < arr.length; i++) {
            System.out.print(", "+arr[i]);
        }
        System.out.print("]");
    }

    // 拿到arr的最大值
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

    // 判断是否存在数据
    public static boolean existIn(int target, int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(target == arr[i]){
                return true;
            }
        }
        return false;
    }

    // return 一个新array contain 从from 到to(不包含to)
    public static int[] getNewArray(int[] arr, int from, int to){
        int[] newArr= new int[to - from];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i==to){
                return newArr;
            }
            else if(i>=from){
                newArr[index] = arr[i];
                index++;
            }
        }
        return newArr;
    }

    // 打印array
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
