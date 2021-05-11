package com.tms.account_administrating.model.banks;

import java.util.Date;

/**
 * Класс который наследует абстрактный класс Bank
 * Имеет свои уникальные поля, которые следует подать в конструкторе класса
 * Все остальные поля можно заполнить с помощью геттеров и сеттеров, реализация которых
 * находится в абстрактом классе Bank
 */
public class BankOfAmerica extends Bank {

    private final int stateCode;
    private final String stateName;
    public final double minSum = BANK_OF_AMERICA_MIN_SUM;
    public final int bankCode = BANK_OF_AMERICA_CODE;

    public BankOfAmerica(int stateCode, String stateName){
        country = "America";
        code = BANK_OF_AMERICA_CODE;
        currency = "Dollar";
        licenseTill = new Date(2050,7,12);
        this.stateCode = stateCode;
        this.stateName = stateName;
    }

    public int getStateCode() {
        return stateCode;
    }

    public String getStateName() {
        return stateName;
    }

}
