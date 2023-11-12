import java.util.Random;
import java.util.Scanner;

public class bicolorBallLottery {
    public static void main(String[] args) {
        /* RULES:
        There are two colors of balls (Red and Blue) with unique number in the pool. And the customer needs to enter
        a series of number to take a bet of the number that the system draw. The numbers that system draws out are the
        lottery numbers. By comparing the lottery numbers and customers' input, output the prize that customers win.

        * STRUCTURE:
            Each bet: 7 guesses (6 for red ball numbers, 1 for blue ball number)
            Customers can take their own guesses or let the admin generate a bet with random guesses for them.

        * NUMBERS:
            Red ball number: 1-33
            Blue ball number: 1-16

        * PROCESS:
            The number that system draws will be an array with 7 numbers (6 for red balls and 1 for blue).
            (E.g. 30 2 4 14 10 7 2)
            (E.g. 33 9 6 8 19 1 5)

            * In each bet, customers should take 6 guesses about the red ball numbers and 1 for the blue ball number.
            The numbers for red balls should not be the same in each bet, but the number for blue ball can be the
            same with red ball numbers.
            Valid: (17 30 16 9 7 1 1) - First 6 numbers are for red balls and the last one is for blue ball
            Invalid: (17 30 11 9 17 1 6) - 17 is repeated in the red ball guess

            * Every bet costs $10

            Then comparing the guess numbers and the drawn numbers. When the customer successfully guessed a correct
            number, it calls a Win. The number of balls that the customers correctly guessed is related to the level
            of prize.

        * PRIZE:
            - First place: $10,000,000  (Win: 6 red balls + 1 blue ball)
            - Second place: $5,000,000  (Win: 6 red balls + 0 blue ball)
            - Third place: $3,000       (Win: 5 red balls + 1 blue ball)
            - Fourth place: $200        (Win: 5 red balls + 0 blue ball)
                                        (Win: 4 red balls + 1 blue ball)
            - Fifth place: $10          (Win: 4 red balls + 0 blue ball)
                                        (Win: 3 red balls + 1 blue ball)
            - Sixth place: $5           (Win: 2 red balls + 1 blue ball)
                                        (Win: 1 red balls + 1 blue ball)
                                        (Win: 0 red balls + 1 blue ball)
         */


        // =======================================================================================
        // Stage 1: Draw the win numbers
        int[] lotteryNum = drawNumber();

        // This is to preview the lottery number.
        // Comment the next line out to try it as a customer.
        //viewLottery(lotteryNum);

        // =======================================================================================
        // Stage 2: Let the customers input/generate their bet
        int[] betNum = inputNumber();
        // Show lottory number
        viewLottery(lotteryNum);
        // Show customer's bet
        System.out.println("Your bet:");
        printArray(betNum);

        // =======================================================================================
        // Stage 3: Determine the Prize
        int redCount = 0;
        int blueCount = 0;
        // Determining the wins for red ball
        for (int i = 0; i < lotteryNum.length-1; i++) {
            for (int j = 0; j < betNum.length-1; j++) {
                if(betNum[j]==lotteryNum[i]){
                    redCount++;
                    break;
                }
            }
        }
        // Determining the win for blue ball
        if(betNum[betNum.length-1]==lotteryNum[lotteryNum.length-1]){
            blueCount++;
        }
        // Print out the wins you have
        System.out.println();
        System.out.println("Correct red ball number: "+redCount);
        System.out.println("Correct blue ball number: "+blueCount);
        System.out.println("-----------------------------------");
        // Print out the prize you won
        checkPrize(redCount,blueCount);
        // =======================================================================================
    }

    // Draw the win/random number
    public static int[] drawNumber(){
        // lottery numbers (6 red balls and 1 blue ball)
        int[] lottery= new int[7];

        Random r = new Random();
        // Draw and push the red ball numbers
        for (int i = 0; i < 6;) {
            // Draw a number for red ball. Range: [1, 33]
            int redNum = r.nextInt(33)+1;
            // Check if the number is already in the array
            if(!contains(lottery, redNum)){
                // If not, add the number for red ball
                lottery[i]=redNum;
                i++;
            }
        }

        // Draw and push the blue ball number
        // Draw a number for blue ball. Range: [1, 16]
        int blueNum = r.nextInt(16)+1;
        lottery[lottery.length-1]=blueNum;

        return lottery;
    }

    // Check whether an int is in the array
    public static boolean contains(int[] arr, int num){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==num){
                return true;
            }
        }
        return false;
    }

    // Let the customer input their bet or generate a random guess
    public static int[] inputNumber(){
        // Choose to take own bet or generate random bet
        System.out.println("Do you want to take your own bet or generate a random bet? 0: Own bet; 1: Random bet");
        Scanner input = new Scanner(System.in);
        int inputType = input.nextInt();

        if(inputType==1 || inputType==1){
            // Generate a random bet
            return drawNumber();
        }
        else if (inputType==0 || inputType==0) {
            // Generate your own bet
            int[] ownBet = new int[7];

            // Input 6 numbers for red ball
            for (int i = 0; i < ownBet.length-1;) {
                if(i==0){
                    System.out.println("-----------------------------------");
                    System.out.println("Please enter the " + (i+1) +"st number for red ball");
                } else if (i==1) {
                    System.out.println("-----------------------------------");
                    System.out.println("Please enter the " + (i+1) +"nd number for red ball");
                } else if (i==2) {
                    System.out.println("-----------------------------------");
                    System.out.println("Please enter the " + (i+1) +"rd number for red ball");
                }else {
                    System.out.println("-----------------------------------");
                    System.out.println("Please enter the " + (i+1) +"st number for red ball");
                }

                int redNum = input.nextInt();
                // Determine whether redNum is valid (not repeated and in the range of 1-33)
                if(redNum<=33 && redNum>=1){
                    if(!contains(ownBet,redNum)){
                        ownBet[i]=redNum;
                        i++;
                    }
                    else {
                        // Input is as same as one of previous guess in this bet
                        System.out.println("-----------------------------------");
                        System.out.println("The number is already existed, please try again.");
                    }

                }
                else{
                    // Input is larger than 33 or smaller than 0
                    System.out.println("-----------------------------------");
                    System.out.println("Your guess for red ball number is out of the range (1-33)");
                }

            }

            // Input 1 number for blue ball
            System.out.println("-----------------------------------");
            System.out.println("Please enter the number for blue ball");
            int blueNum = input.nextInt();
            if(blueNum>=1 && blueNum<=16){
                ownBet[ownBet.length-1]=blueNum;
            }
            else{
                System.out.println("-----------------------------------");
                System.out.println("Your guess for blue ball number is out of the range (1-16)");
            }

            return ownBet;
        }
        else{
            // Input is invalid
            System.out.println("-----------------------------------");
            System.out.println("Please enter a valid letter. 0: Own bet; 1: Random bet");
            System.out.println("-----------------------------------");
            // Fail to input, recurse
            return inputNumber();
        }
    }

    // Print out array
    public static void printArray(int[] arr){
        // Print out array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    // Print out the lottery numbers
    public static void viewLottery(int[] lotteryNum){
        System.out.println("====================LOTTERY NUMBER====================");
        printArray(lotteryNum);
        System.out.println();
        System.out.println("======================================================");
    }

    // Print out the result for prize
    public static void checkPrize(int redNum, int blueNum){
        /*PRIZE:
            - First place: $10,000,000  (Win: 6 red balls + 1 blue ball)
            - Second place: $5,000,000  (Win: 6 red balls + 0 blue ball)
            - Third place: $3,000       (Win: 5 red balls + 1 blue ball)
            - Fourth place: $200        (Win: 5 red balls + 0 blue ball)
                                        (Win: 4 red balls + 1 blue ball)
            - Fifth place: $10          (Win: 4 red balls + 0 blue ball)
                                        (Win: 3 red balls + 1 blue ball)
            - Sixth place: $5           (Win: 2 red balls + 1 blue ball)
                                        (Win: 1 red balls + 1 blue ball)
                                        (Win: 0 red balls + 1 blue ball)
         */
        if((redNum == 0 && blueNum==1)||(redNum == 1 && blueNum==1)||(redNum == 2 && blueNum==1)){
            // Sixth place: $5
            System.out.println("Congratulations! ");
            System.out.println("You have won $5, please contact customer service representative to redeem your prize.");
        }
        else if((redNum == 4 && blueNum==0)||(redNum == 3 && blueNum==1)){
            // Fifth place: $10
            System.out.println("Congratulations! ");
            System.out.println("You have won $10, please contact customer service representative to redeem your prize.");
        }
        else if((redNum == 4 && blueNum==1)||(redNum == 5 && blueNum==0)){
            // Fourth place: $200
            System.out.println("Congratulations! ");
            System.out.println("You have won $200, please contact customer service representative to redeem your prize.");
        }
        else if((redNum == 5 && blueNum==1)){
            // Third place: $3,000
            System.out.println("Congratulations! ");
            System.out.println("You have won $3,000, please contact customer service representative to redeem your prize.");
        }
        else if((redNum == 6 && blueNum==0)){
            // Second place: $5,000,000
            System.out.println("Congratulations! ");
            System.out.println("You have won $5,000,000, please contact customer service representative to redeem your prize.");
        }
        else if((redNum == 6 && blueNum==1)){
            // First place: $10,000,000
            System.out.println("Congratulations! ");
            System.out.println("You have won $10,000,000, please contact customer service representative to redeem your prize.");
        }
        else {
            // The wins are not enough for prize
            System.out.println("Unfortunately, you did not win a prize. Thank you for playing!");
        }
    }

}

