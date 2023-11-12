import java.util.Scanner;

public class getEveryIndex {
    public static void main(String[] args) {
        System.out.println("请输入一个三位数的整数");
        Scanner scan = new Scanner(System.in);

        // e.g. input = 123; output = 3, 2, 1

        int input = scan.nextInt();
        int num1 = input % 10; // 取得个位数
        int num2 = input /10 % 10; // 取得十位数
        int num3 = input /100 % 10; // 取得百位数
        System.out.println("个位是："+num1);
        System.out.println("十位是："+num2);
        System.out.println("百位是："+num3);

    }
}
