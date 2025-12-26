package ma.enset;


import ma.enset.model.AccountStatus;
import ma.enset.model.AccountType;
import ma.enset.model.BankAccount;
import ma.enset.repository.AccountRepositoryImpl;
import ma.enset.util.JsonSerializer;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(Thread.currentThread().getName());
        JsonSerializer<BankAccount> bankAccountJsonSerializer=new JsonSerializer<>();
        AccountRepositoryImpl accountRepository =AccountRepositoryImpl.getInstance();
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
            accountRepository.populateData();
            }).start();
        }
        System.out.print("Tape a character :");
        System.in.read();

        List<BankAccount> bankAccounts = accountRepository.findAll();
        bankAccounts.stream()
                .map(bankAccountJsonSerializer::toJson)
                .forEach(System.out::println);



    }
}