import java.util.Scanner;

public class practiceFlightTickets {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("请输入机票原价");
        long rawPrice = input.nextLong();
//        long rawPrice=3054;

        System.out.println("请输入机票月份");
        int month = input.nextInt();
//        int month = 12;

        System.out.println("请输入机舱。0:头等舱，1:经济舱");
        int ticketClass = input.nextInt();
//        String ticketClass = 0;
        long finalPrice = getPrice(rawPrice, month, ticketClass);
        System.out.println("您的机票预估价为"+finalPrice+"元。");

    }

    // long的重载getPrice
    public static long getPrice(long rawPrice, int month, int ticketClass) {
        boolean business = (ticketClass==0);
        if(month>=5 && month<=10){
            if(business){
                return (long) (rawPrice*0.9);
            }
            else {
                return (long) (rawPrice*0.85);
            }
        } else if (month>=11 || month<=4) {
            if(business){
                return (long) (rawPrice*0.7);
            }
            else {
                return (long) (rawPrice*0.65);
            }
        }else{
            System.out.println("Something went wrong!");
            return 0;
        }

    }

    // int的重载getPrice
}
