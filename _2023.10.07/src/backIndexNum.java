public class backIndexNum {
    public static void main(String[] args) {

        // 定义数字
        // 一开始给的数字
        int num = 1233456321;
        int initialNum = num;
        //


        // 输出结果
        int result = 0;
        // 最后一位数
        int finalDigit=0;
        // 获取位数
        int firstDigit = num%10;
        int secondDigit = num/10%10;
        int thirdDigit = num/10/10%10;
        while(num!=0){
            finalDigit = num%10;
            result=result*10+finalDigit;
            num= num/10;
        }
        // 拼接result
        // int result = firstDigit*100+secondDigit*10+thirdDigit;
        System.out.println("The given int is "+initialNum);
        System.out.println("The reversed int is "+result);
        System.out.println("The result is "+ (result==initialNum));


    }
}
