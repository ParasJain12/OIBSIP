import java.util.Scanner;

class ATMWindow 
{

    String name;
    String userName; //Customer ID
    String password; //Customer PIN
    int accountNo;
    double balance = 50000.00;
    int transaction = 0;
    String transactionHistory = "";

    Scanner sc = new Scanner(System.in);

    // Customer Registration in ATM Interface Window
    public void registerUser() 
    {
        System.out.println("*****WELCOME TO HDFC BANK*****");
        System.out.println("Enter Customer(Your) Name: ");
        name = sc.next();
        System.out.println("Enter Customer(Your) Username: ");
        userName = sc.next();
        System.out.println("Enter your password: ");
        password = sc.next();
        System.out.println("Enter Customer(Your) Account Number: ");
        accountNo = sc.nextInt();
        System.out.println("Congratulations!! Registration Successfully Completed");
    }

    // Customer Login After Registration
    public boolean loginUser() 
    {
        boolean isLogin = false;
        while (!isLogin)
        {
            System.out.println("Enter Customer(Your) Username: ");
            String userId = sc.next();
            if (userId.equals(userName)) 
            {
                while (!isLogin) 
                {
                    System.out.println("Enter your password: ");
                    String Password = sc.next();
                    if (Password.equals(password))
                    {
                        System.out.println("Login Successfully!!!");
                        isLogin = true;
                    } 
                    else
                    {
                        System.out.println("Incorrect Password");
                    }
                }
            } 
            else
            {
                System.out.println("Username not correct!! Not Found");
            }
        }
        return isLogin;
    }

    //Deposit Method
    public void deposit() 
    {
        System.out.println("Enter a amount to be added as a deposit: ");
        double amount = sc.nextDouble();
        if (amount > 0 && amount <= balance)
        {
            transaction++;
            balance = balance + amount;
            System.out.println("Congratulations!!! Successfully Deposited!");
            String str = amount + " Rs Deposited\n";
            transactionHistory = transactionHistory.concat(str);
        } 
        else
        {
            System.out.println("Invalid Amount");
        }
    }

    //WithDraw Method
    public void withdraw() 
    {
        System.out.println("Enter a amount to be added as a withdraw: ");
        double amount = sc.nextDouble();
        if ((amount > 0) && (amount <= balance))
        {
            transaction++;
            balance = balance - amount;
            System.out.println("Congratulations!!! Successfully Withdraw!");
            String str = amount + " Rs WithDraw\n";
            transactionHistory = transactionHistory.concat(str);
        } 
        else
        {
            System.out.println("Invalid Amount");
        }
    }

    //Transfer Method
    public void transfer() 
    {
        System.out.println("Enter Reciever Name: ");
        String reciever = sc.next();
        System.out.println("Enter amount to be transfer: ");
        double amount = sc.nextDouble();
        if ((amount > 0) && (amount <= balance)) 
        {
            transaction++;
            balance = balance - amount;
            System.out.println("Congratulations!!! Successfully Tranferrred!");
            String str = amount + " Rs transferred to " + reciever + "\n";
            transactionHistory = transactionHistory.concat(str);
        }
    }

    //Check Balance Method
    public void checkBalance() 
    {
        System.out.println("In Your Account, Total Balance is : " + balance);
    }

    //Check Transaction History
    public void transactionsHistory() 
    {
        if (transaction == 0) 
        {
            System.out.println("Nothing!!!");
        } 
        else 
        {
            System.out.println(transactionHistory);
        }
    }
}

public class Task_Three 
{

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("*****WELCOME TO HDFC BANK*****");
        int choice1, choice2, choice3;
        System.out.println("*************HDFC ATM Interface Application***************");
        System.out.println("1. Register");
        System.out.println("2. Exit");
        System.out.println("Enter your choice(From 1 or 2): ");
        choice1 = sc.nextInt();

        if (choice1 == 1)   
        {
            ATMWindow a = new ATMWindow();
            a.registerUser();
            while (true) 
            {
                System.out.println("1. Login");
                System.out.println("2. Exit");
                System.out.println("Enter your choice(From 1 or 2): ");
                choice2 = sc.nextInt();
                if (choice2 == 1) 
                {
                    if (a.loginUser())
                    {
                        System.out.println("Welcome " + a.name + " !!!");
                        boolean isFinish = false;
                        while (!isFinish)
                        {
                            System.out.println("1. Deposit an amount");
                            System.out.println("2. Withdraw an amount");
                            System.out.println("3. Transfer an amount");
                            System.out.println("4. Check Transaction History");
                            System.out.println("5. Check Balance");
                            System.out.println("6. Exit");
                            System.out.println("Enter your choice(from 1 to 6)");
                            choice3 = sc.nextInt();
                            switch (choice3) 
                            {
                                case 1:
                                    a.deposit();
                                    break;
                                case 2:
                                    a.withdraw();
                                    break;
                                case 3:
                                    a.transfer();
                                    break;
                                case 4:
                                    a.transactionsHistory();
                                    break;
                                case 5:
                                    a.checkBalance();
                                    break;
                                case 6:
                                    isFinish = true;
                                    System.out.println("See you soon");
                                    break;
                            }
                        }
                    }
                }
                else
                {
                    System.exit(0);
                }
            }
        } 
        else
        {
            System.exit(0);
        }
    }
}