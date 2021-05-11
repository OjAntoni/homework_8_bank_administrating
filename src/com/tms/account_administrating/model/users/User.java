package com.tms.account_administrating.model.users;

import com.tms.account_administrating.model.banks.*;
import com.tms.account_administrating.model.bills.Bill;

import java.util.Date;
import java.util.Objects;

/**
 * Класс пользователя, содержит основную информацию о нём.
 * В конструкторе следует указать имя, фамилию, номер пасспорта и пол.
 */
public class User implements BankConstants {

    private String name;
    private String surname;
    private Date dateOfBirth;
    private String passport;
    private String sex;
    private Bill lastBill;
    private Bill[] bills = new Bill[10];
    private int lastBillIndex;

    public User(String name, String surname, String passport, String sex) {
        this.name = name;
        this.surname = surname;
        this.passport = passport;
        setSex(sex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(dateOfBirth, user.dateOfBirth) && Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, dateOfBirth, passport);
    }

    public String toString(){
        return this.name + " " +this.surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassport() {
        return passport;
    }

    public String getSex() {
        return sex;
    }

    public void createBill(Bill bill, Bank bank) {

        if(lastBillIndex != 0) {
            for (int i = 0; i < lastBillIndex; i++) {
                if (bills[i].equals(bill)) {
                    System.out.println("There is already the same bill!");
                    return;
                }
            }
        }

        if(bank.getClass().equals(BankOfAmerica.class)){
            if(bill.getCurrentSum()<BANK_OF_AMERICA_MIN_SUM){
                System.out.println("You can't create bill on the sum " + bill.getCurrentSum() + "in Bank Of America");
                return;
            }

        }
        else if (bank.getClass().equals(ChinaBank.class)){
            if(bill.getCurrentSum()<CHINA_BANK_MIN_SUM) {
                System.out.println("You can't create bill on the sum " + bill.getCurrentSum() + "in China Bank");
                return;
            }
        }
        else if (bank.getClass().equals(DeutscheBank.class)){
            if(bill.getCurrentSum()<DEUTSCHE_BANK_MIN_SUM) {
                System.out.println("You can't create bill on the sum " + bill.getCurrentSum() + "in Deutsche Bank");
                return;
            }
        }
        else return;

        if(lastBillIndex == bills.length){
            bills = doubleSize(lastBillIndex);
        }

        this.lastBill = bill;
        bills[lastBillIndex] = bill;
        lastBillIndex++;
    }

    public void deleteBill(){
        if(lastBillIndex>0) {
            bills[lastBillIndex] = null;
            lastBillIndex--;
            lastBill = bills[lastBillIndex];
        }
    }

    public void changeBill(double newSum){
        if(newSum<0) return;
        if(newSum==0) {
            deleteBill();
            return;
        }
        bills[lastBillIndex].setCurrentSum(newSum);
        lastBill = bills[lastBillIndex];
    }

    public void showBills(){
        System.out.println("------------------------------------------------------------");
        for(int i = 0; i < lastBillIndex; i++){
            System.out.println("Bill " + i + ": id = " + bills[i].getId() +
                    "; current sum = " + bills[i].getCurrentSum() +
                    "; ending date: " + bills[i].getEndingDate());
        }
        System.out.println("------------------------------------------------------------");
    }

    private Bill[] doubleSize(int l){
        Bill[] newBills = new Bill[2*l];
        System.arraycopy(bills, 0, newBills, 0, lastBillIndex);
        return newBills;
    }

    private void setSex(String sex) {
        if(sex.equals("male") || sex.equals("female"))
            this.sex = sex;
    }
}
