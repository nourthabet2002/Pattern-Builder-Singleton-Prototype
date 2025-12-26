package ma.enset;

import ma.enset.model.AccountStatus;
import ma.enset.model.AccountType;
import ma.enset.model.BankAccount;
import ma.enset.model.Customer;

public class Test2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        BankAccount account1 = new BankAccount();
        account1.setAccountId(1L);
        account1.setCurrency("MAD");
        account1.setBalance(1000);
        account1.setType(AccountType.CURRENT_ACCOUNT);
        account1.setStatus(AccountStatus.ACTIVATED);
        account1.setCustomer(new Customer(1L,"Mohamed"));





        BankAccount account3=account1.clone();


        System.out.println(account1);

        System.out.println(account3);
        System.out.println("==================");
        account1.getCustomer().setName("Hassan");
        account1.setAccountId(2L);

        System.out.println(account1);
        System.out.println(account3);

    }
}
