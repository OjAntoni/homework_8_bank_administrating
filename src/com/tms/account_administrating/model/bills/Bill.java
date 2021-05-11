package com.tms.account_administrating.model.bills;

import com.tms.account_administrating.model.banks.BankConstants;

import java.util.Date;
import java.util.Objects;

/**
 * Класс, которые представляет счёт пользователя банка
 * При мощдании экземпляра класса следует указать все атрибуты
 */
public class Bill implements BankConstants {

    private final String id;
    private double currentSum;
    private Date endingDate;

    //Дoделать, чтобы принимало только латинские буквы и цифры id!!!
    public Bill(String id, double currentSum, Date endingDate){
        this.id = id;
        this.currentSum = currentSum;
        this.endingDate = endingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Objects.equals(id, bill.id) && Objects.equals(endingDate, bill.endingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, endingDate);
    }

    public String getId() {
        return id;
    }

    public double getCurrentSum() {
        return currentSum;
    }

    public void setCurrentSum(double currentSum) {
        this.currentSum = currentSum;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }
}
