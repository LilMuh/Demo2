import java.util.Random;

public class practiceVerifyCode {
    public static void main(String[] args) {

        // 0-9 Number array
        int[] numArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        // Letters array containing all lower letters and UPPER LETTERS
        char[] letterTable = new char[52];
        for (int i = 0; i < letterTable.length; i++) {
            // Adding lower letters
            if (i<26 && i >=0){
                letterTable[i]=(char)(i+97);
            }
            // Adding UPPER letters
            else {
                letterTable[i]=(char)(i+65-26);
            }
        }

        System.out.println("The verify code is: "+getCode(5, numArr, letterTable));

        // Output1: The verify code is: 7962t
        // Output2: The verify code is: CIt9l
        // Output3: The verify code is: 1s104


        System.out.println("The verify code is: "+getCode(7, numArr, letterTable));

        // Output1: The verify code is: Q05620z
        // Output2: The verify code is: WUO5xw3
        // Output3: The verify code is: 59tZ409

    }

    public static String getCode(int codeLength, int[] numArr, char[] letterTable){

        // Initialize code
        String verifyCode = "";
        Random r = new Random();
        // Generating code
        for (int i = 0; i < codeLength; i++) {

            // Get either 0 or 1
            int numOrLetter = r.nextInt(2);
            int randomIndex = 0;

            // If 0, add random number; if 1, add random letters(lower/UPPER)
            if (numOrLetter ==0){
                randomIndex = r.nextInt(numArr.length);
                verifyCode+=numArr[randomIndex];
            }
            else{
                randomIndex = r.nextInt(letterTable.length);
                verifyCode+=letterTable[randomIndex];
            }
        }
        // Return Code
        return verifyCode;
    }
}
