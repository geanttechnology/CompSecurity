// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;


public final class Currency extends Enum
{

    private static final Currency $VALUES[];
    public static final Currency ARGENTINA;
    public static final Currency AUSTRALIA;
    public static final Currency BRAZIL;
    public static final Currency CANADA;
    public static final Currency CHILE;
    public static final Currency COLOMBIA;
    public static final Currency DENMARK;
    public static final Currency EURO;
    public static final Currency HONG_KONG;
    public static final Currency INDIA;
    public static final Currency ISRAEL;
    public static final Currency JAPAN;
    public static final Currency MALAYSIA;
    public static final Currency MEXICO;
    public static final Currency NEW_ZEALAND;
    public static final Currency NORWAY;
    public static final Currency PERU;
    public static final Currency POLAND;
    public static final Currency ROMANIA;
    public static final Currency RUSSIA;
    public static final Currency SINGAPORE;
    public static final Currency SOUTH_AFRICA;
    public static final Currency SWEDEN;
    public static final Currency SWITZERLAND;
    public static final Currency UKRAINE;
    public static final Currency UNITED_ARAB_EMIRATES;
    public static final Currency UNITED_KINGDOM;
    public static final Currency UNITED_STATES;
    public static final Currency URUGUAY;
    public final String currencyCode;
    public final String symbol;

    private Currency(String s, int i, String s1, String s2)
    {
        super(s, i);
        currencyCode = s1;
        symbol = s2;
    }

    public static Currency findCurrencyBy(String s)
    {
        Currency acurrency[] = values();
        int j = acurrency.length;
        for (int i = 0; i < j; i++)
        {
            Currency currency = acurrency[i];
            if (currency.currencyCode.equals(s))
            {
                return currency;
            }
        }

        return null;
    }

    public static Currency valueOf(String s)
    {
        return (Currency)Enum.valueOf(com/groupon/util/Currency, s);
    }

    public static Currency[] values()
    {
        return (Currency[])$VALUES.clone();
    }

    static 
    {
        JAPAN = new Currency("JAPAN", 0, "JPY", "\u5186");
        UNITED_ARAB_EMIRATES = new Currency("UNITED_ARAB_EMIRATES", 1, "AED", "AED");
        ARGENTINA = new Currency("ARGENTINA", 2, "ARS", "$");
        AUSTRALIA = new Currency("AUSTRALIA", 3, "AUD", "$");
        BRAZIL = new Currency("BRAZIL", 4, "BRL", "R$");
        CANADA = new Currency("CANADA", 5, "CAD", "C$");
        SWITZERLAND = new Currency("SWITZERLAND", 6, "CHF", "CHF");
        COLOMBIA = new Currency("COLOMBIA", 7, "COP", "$");
        CHILE = new Currency("CHILE", 8, "CLP", "$");
        DENMARK = new Currency("DENMARK", 9, "DKK", "kr.");
        EURO = new Currency("EURO", 10, "EUR", "\u20AC");
        UNITED_KINGDOM = new Currency("UNITED_KINGDOM", 11, "GBP", "\243");
        HONG_KONG = new Currency("HONG_KONG", 12, "HKD", "HK$");
        ISRAEL = new Currency("ISRAEL", 13, "ILS", "\u20AA");
        INDIA = new Currency("INDIA", 14, "INR", "\u20B9");
        MEXICO = new Currency("MEXICO", 15, "MXN", "$");
        MALAYSIA = new Currency("MALAYSIA", 16, "MYR", "RM");
        NORWAY = new Currency("NORWAY", 17, "NOK", "kr");
        NEW_ZEALAND = new Currency("NEW_ZEALAND", 18, "NZD", "$");
        PERU = new Currency("PERU", 19, "PEN", "S/.");
        POLAND = new Currency("POLAND", 20, "PLN", "z\u0142");
        ROMANIA = new Currency("ROMANIA", 21, "RON", "RON");
        RUSSIA = new Currency("RUSSIA", 22, "RUR", "\u0440\u0443\u0431.");
        SWEDEN = new Currency("SWEDEN", 23, "SEK", "kr");
        SINGAPORE = new Currency("SINGAPORE", 24, "SGD", "S$");
        UKRAINE = new Currency("UKRAINE", 25, "UAH", "\u0433\u0440\u043D.");
        UNITED_STATES = new Currency("UNITED_STATES", 26, "USD", "$");
        URUGUAY = new Currency("URUGUAY", 27, "UYU", "$");
        SOUTH_AFRICA = new Currency("SOUTH_AFRICA", 28, "ZAR", "R");
        $VALUES = (new Currency[] {
            JAPAN, UNITED_ARAB_EMIRATES, ARGENTINA, AUSTRALIA, BRAZIL, CANADA, SWITZERLAND, COLOMBIA, CHILE, DENMARK, 
            EURO, UNITED_KINGDOM, HONG_KONG, ISRAEL, INDIA, MEXICO, MALAYSIA, NORWAY, NEW_ZEALAND, PERU, 
            POLAND, ROMANIA, RUSSIA, SWEDEN, SINGAPORE, UKRAINE, UNITED_STATES, URUGUAY, SOUTH_AFRICA
        });
    }
}
