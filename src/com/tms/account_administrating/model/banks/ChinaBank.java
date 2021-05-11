package com.tms.account_administrating.model.banks;

import java.util.Date;
/**
 * Класс который наследует абстрактный класс Bank
 * Имеет свои уникальные поля, которые следует подать в конструкторе класса
 * Все остальные поля можно заполнить с помощью геттеров и сеттеров, реализация которых
 * находится в абстрактом классе Bank
 */
public class ChinaBank extends Bank {

    private final String province;
    public final double minSum = CHINA_BANK_MIN_SUM;
    public final int bankCode = CHINA_BANK_CODE;

    public ChinaBank(String province){
        country = "China";
        code = CHINA_BANK_CODE;
        currency = "Juan";
        licenseTill = new Date(2078,2,1);
        this.province = province;
    }

    public String getProvince() {
        return province;
    }
}
