public class fengQiGuo {
    public static void main(String[] args) {
        /* 缝7过，从1开始喊数，每当下一个数包含7或
        是7的倍数，下一个人要喊“过”。这个demo数到100
        */

        // 起始数
        int temp = 1;

        while(temp<=100){
            // 如果十位是7 /或/ 个位是7 /或/ 能被7整除；都喊过
            if(temp/10%10 == 7 || temp%10 == 7 ||temp%7 == 0){
                System.out.println("过");
            }
            else{
                // 不是的话就喊出数字
                System.out.println(temp);
            }
            // 到下一位数
            temp++;
        }

    }
}
