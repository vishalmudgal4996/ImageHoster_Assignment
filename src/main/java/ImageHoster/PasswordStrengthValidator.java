package ImageHoster;

public class PasswordStrengthValidator {
    //This function checks Password Strength
    public boolean passStrengthCheck(String password) {
        String pass=password;
        int asciiValue;
        boolean digit=false,letter=false,specialChar=false;

        for(int i=0;i<pass.length();i++){
            asciiValue=pass.charAt(i);
            System.out.print(asciiValue + " ");

            if(specialCharCheck(asciiValue)) {
                specialChar = true;
            }
            if(asciiValue>=48 && asciiValue<=57) {
                digit = true;
            }
            if(asciiValue>=65 && asciiValue<=90 || asciiValue>=97 && asciiValue<=122) {
                letter = true;
            }
        }

        if(digit && letter && specialChar) {
            return true;
        }

        return false;
    }

    //this method checks special character validity
    public boolean specialCharCheck(int asciiValue) {
        /* special character allowed-->" !#$%&'()*+-./:<=>?@[]^_`{|}~" */
        String specialChar=" !#$%&'()*+-./:<=>?@[]^_`{|}~";
        boolean check=false;
        int length=specialChar.length();
        int[] asciiValueArray=new int[length];
        for(int i=0;i<length;i++){
            asciiValueArray[i]=specialChar.charAt(i);
        }

        for(int i=0;i<length;i++){
            if(asciiValueArray[i]==asciiValue){
                check=true;
                break;
            }
        }

        if(check){
            return check;
        }
        return check;
    }

}
