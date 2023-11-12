import java.util.Scanner;

public class sqRoot {
    public static void main(String[] args) {
        // 1*1 ； 2*2 ； 3*3 ； 和given数作比较
        // 如果大于就返回前一个整数

        // 用户输入
        System.out.println("请输入要检测的数字哦");
        Scanner num = new Scanner(System.in);
        int input = num.nextInt();


        for(int i = 0;i<input;i++){
            if(i*i>input) {
                System.out.println(input+"的平方根是"+(i-1));
                break;
            } else if (i*i==input) {
                System.out.println(input+"的平方根是"+i);
            }
        }
    }
}
