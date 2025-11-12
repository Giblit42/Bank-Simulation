import java.time.LocalDate;
public class Bankfunctions implements Bank{

    public String usserName(){
        // the body of userName is here
        String usserName = "John Doe";
        return usserName;
    } 

    public int accountNumb(){
        // the body of accountNumb is here
        int accNumb = 12345;
        return accNumb;
        
    }

    public int accBallance(){
        //the ammount of money you currently have in your account
        int accBallance = 500; // starting ammount in account
        return accBallance;
    }

    public int ammount(int usserAmount){
        // the ammount of money you want to deposit or withdraw
        return usserAmount;
    }

    public void localDate(){
        // the body of local date is here
        LocalDate currTime = LocalDate.now();
        System.out.println("This transaction was completed on " + currTime);
    }

    public boolean validateAccount(String userName, int accountNumb){ //This mehtod is used to validate the accounts of users
        if(userName.equals("John Doe") && accountNumb == 12345){
            //System.out.println("name and account number match");
            return true;
        }
        return false;
    }

    public void depositMon(int moneyDeposit , String userName, int accountNumb){ //Deposits money into account
         // make a check that only allows the correct user to deposot money into thier own account
        if(validateAccount(userName, accountNumb) == true){
            System.out.println("Welcome John Doe how much would you like to deposit");
            // might need a screen reader to read the user input
            System.out.println( "The ammount you would like to deposit is $" + moneyDeposit);
            //take parameter and update ballance
            int newBal =  updateBalance(moneyDeposit);
            System.out.println("Your new ballance is $" + newBal);
            localDate();
        }  
    }

    private int updateBalance(int moneyDeposit) { //needs to update account ballance so all methods are updated with new account in
        // Updates the users total balance
        int ballanceTotal = accBallance();// accBallance is always 500 and never updates when test is done running
        ballanceTotal = ballanceTotal + moneyDeposit;
        return ballanceTotal;
    }

    public void withdrawMon(int moneyWithdraw, String userName, int accountNumb){ //Withdraws money from account
        // make a check to only allows the correct user to with draw money from their own account
        if(validateAccount(userName, accountNumb) == true){
            System.out.println("Welcome John Doe how much would you like to take out?");
            System.out.println("The ammount you wish to withdraw is $" + moneyWithdraw);
            // do overdraw check
            if(overdraw(moneyWithdraw) == false){
                //take parameter and update ballance
                int newBal =  updateBalanceWith(moneyWithdraw);
                System.out.println("Your new ballance is $" + newBal);
                localDate();
            }
            else{
                System.out.println("The ammount you wish to withdraw is greater than what you have in your account");
                System.out.println("Please enter in a smaller ammount that you would like to withdraw");
            }
        }
    }

    private int updateBalanceWith(int moneyWithdraw) {
        // update totalbalance by withdrawing money from account
        int ballanceTotal = accBallance();
        ballanceTotal = ballanceTotal - moneyWithdraw;
        return ballanceTotal;
    }

    private boolean overdraw(int moneyWithdraw) {
        // checks to see if the user is going to take more money out of thier accout then they have
        int ballanceTotal = accBallance();

        if(moneyWithdraw <= ballanceTotal){
            return false;
        }
        
        return true;
    }
}

class Main {
    public static void main (String[] args){
        Bankfunctions myBank = new Bankfunctions();
        //myBank.usserName();
        //myBank.accountNumb();
        //myBank.accBallance();
        //myBank.ammount(500);
        //myBank.localDate();
        myBank.validateAccount(myBank.usserName(), myBank.accountNumb());
        myBank.depositMon(myBank.ammount(500), myBank.usserName(), myBank.accountNumb());
        myBank.withdrawMon(myBank.ammount(250), myBank.usserName(), myBank.accountNumb());
    }
}
