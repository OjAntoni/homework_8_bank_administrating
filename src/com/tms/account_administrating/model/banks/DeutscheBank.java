package com.tms.account_administrating.model.banks;

import java.util.Date;
/**
 * Класс который наследует абстрактный класс Bank
 * Имеет свои уникальные поля, которые следует подать в конструкторе класса
 * Все остальные поля можно заполнить с помощью геттеров и сеттеров, реализация которых
 * находится в абстрактом классе Bank
 */
public class DeutscheBank extends Bank {

    private final int federativeTerritoryCode;
    public final double minSum = DEUTSCHE_BANK_MIN_SUM;
    public final int bankCode = DEUTSCHE_BANK_CODE;

    public DeutscheBank(int federativeTerritoryCode){
        country = "Germany";
        code = DEUTSCHE_BANK_CODE;
        currency = "Euro";
        licenseTill = new Date(2095,10,20);
        this.federativeTerritoryCode = federativeTerritoryCode;
    }

    public int getFederativeTerritoryCode() {
        return federativeTerritoryCode;
    }


}
