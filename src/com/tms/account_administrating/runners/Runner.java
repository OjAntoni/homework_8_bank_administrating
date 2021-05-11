package com.tms.account_administrating.runners;

import com.tms.account_administrating.model.banks.BankConstants;
import com.tms.account_administrating.model.banks.BankOfAmerica;
import com.tms.account_administrating.model.banks.ChinaBank;
import com.tms.account_administrating.model.banks.DeutscheBank;
import com.tms.account_administrating.model.bills.Bill;
import com.tms.account_administrating.model.users.User;

import java.util.Date;

/**
 * Класс, который служит для работы с банками, пользователями и  счетами пользователей
 */
public class Runner implements BankConstants {

    public static void go(){

        BankOfAmerica bankOfAmerica = new BankOfAmerica(14, "Hawaii");
        ChinaBank chinaBank = new ChinaBank("Hong-Hong");
        DeutscheBank deutscheBank = new DeutscheBank(23);

        User user1 = new User("Anton", "Z", "KB4324325", "male");
        User user2 = new User("Mary", "N", "PL353443", "female");
        User user3 = new User("Jane", "L", "SP4524678", "female");
        User user4 = new User("Mark", "C", "KL436003", "male");
        User user5 = new User("Jerald", "O", "PT00060F", "male");

        //Добавляем пользователей в соответствующие банки
        bankOfAmerica.addUser(user1);
        chinaBank.addUser(user1);
        deutscheBank.addUser(user1);

        bankOfAmerica.addUser(user2);
        chinaBank.addUser(user2);
        deutscheBank.addUser(user2);

        bankOfAmerica.addUser(user3);
        chinaBank.addUser(user3);
        deutscheBank.addUser(user3);

        bankOfAmerica.addUser(user4);
        deutscheBank.addUser(user4);

        chinaBank.addUser(user5);
        deutscheBank.addUser(user5);

        //проверка добавления того же пользователя
        chinaBank.addUser(user5);
        deutscheBank.addUser(user5);
        //Создаём счета для пользователей
        user1.createBill(new Bill("1234", 2300, new Date(20,9,2026)), bankOfAmerica);
        user1.createBill(new Bill("1234534", 2200, new Date(20,9,2026)), bankOfAmerica);
        user1.createBill(new Bill("1234fd34", 1300, new Date(20,9,2026)), chinaBank);
        user1.createBill(new Bill("1234-98", 5300, new Date(20,9,2026)), deutscheBank);

        user2.createBill(new Bill("1234gfd", 2300, new Date(20,9,2026)), deutscheBank);
        user2.createBill(new Bill("12-34534df", 2200, new Date(20,9,2026)), bankOfAmerica);
        user2.createBill(new Bill("1234sfd34", 1300, new Date(20,9,2026)), chinaBank);
        user2.createBill(new Bill("120034-98", 5300, new Date(20,9,2026)), deutscheBank);

        user3.createBill(new Bill("1004gfd", 2300, new Date(20,9,2026)), deutscheBank);
        user3.createBill(new Bill("009-34534df", 2200, new Date(20,9,2026)), bankOfAmerica);
        user3.createBill(new Bill("12309fd34", 900, new Date(20,9,2026)), chinaBank);
        user3.createBill(new Bill("120034-98", 300, new Date(20,9,2026)), deutscheBank);

        user4.createBill(new Bill("1-0034gfd", 2300, new Date(20,9,2026)), deutscheBank);
        user4.createBill(new Bill("12-3453-74df", 2200, new Date(20,9,2026)), bankOfAmerica);

        user5.createBill(new Bill("1114sfd34", 7300, new Date(20,9,2026)), chinaBank);
        user5.createBill(new Bill("12dfdf4-98", 52300, new Date(20,9,2026)), deutscheBank);

        //проверка добавления того же счета
        user4.createBill(new Bill("1-0034gfd", 2300, new Date(20,9,2026)), deutscheBank);
        user4.createBill(new Bill("12-3453-74df", 2200, new Date(20,9,2026)), bankOfAmerica);

        //Смотрим пользователей в банках
        bankOfAmerica.showUsers();
        chinaBank.showUsers();
        deutscheBank.showUsers();

        //Смотрим какие счета открыты у пользователейd
        System.out.println("User1 bills: ");
        user1.showBills();
        System.out.println("User2 bills: ");
        user2.showBills();
        System.out.println("User3 bills: ");
        user3.showBills();
        System.out.println("User4 bills: ");
        user4.showBills();
        System.out.println("User5 bills: ");
        user5.showBills();

        //Удаляем некoторые счета
        user1.deleteBill();
        user1.deleteBill();

        user1.showBills();
    }



}
