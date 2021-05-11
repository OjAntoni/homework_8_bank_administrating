package com.tms.account_administrating.model.banks;

import com.tms.account_administrating.model.users.User;
import java.util.Date;

/**
 * Этот класс является абстрактным для всех банков, которые его будут наследовать.
 * Имеет поля, связанные с местоположением и локацией банка а также массив пользователей.
 */
public abstract class Bank implements BankConstants {

    protected String country;
    protected int code;
    protected String currency;
    protected Date licenseTill;
    protected User[] users = new User[10];
    protected int lastUserIndex;

    public void addUser(User user){
        for(int i = 0; i < lastUserIndex; i++){
            if(users[i].equals(user)){
                System.out.println("There is already the same user!");
                return;
            }
        }
        users[lastUserIndex] = user;
        lastUserIndex++;
    }

    public void showUsers(){
        System.out.println("--------------------------------------");
        String str = this.getClass().getName();
        String[] words = str.split("\\.");
        System.out.println(words[words.length-1]+ " users:");
        for (int i = 0; i < lastUserIndex; i++){
            System.out.println(users[i]);
        }
        System.out.println("--------------------------------------");
    }

    private User[] doubleSize(){
        User[] newUsers = new User[2*lastUserIndex];
        System.arraycopy(users,0,newUsers,0,lastUserIndex);
        return newUsers;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getLicenseTill() {
        return licenseTill;
    }

    public void setLicenseTill(Date licenseTill) {
        this.licenseTill = licenseTill;
    }
}
