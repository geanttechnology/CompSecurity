// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;

public final class dm
{

    private static String a = "JPY, HUF, TWD";
    private static final Locale b;
    private static final Locale c;
    private static NumberFormat d = null;

    public static String a(double d1, Currency currency)
    {
        Object obj = new DecimalFormat("0.00");
        ((DecimalFormat) (obj)).setCurrency(currency);
        String s;
        boolean flag;
        if (((DecimalFormat) (obj)).format(1.5600000000000001D).indexOf(".") > 0)
        {
            obj = ".";
        } else
        {
            obj = ",";
        }
        if (((String) (obj)).equals(","))
        {
            obj = (DecimalFormat)NumberFormat.getInstance(c);
        } else
        {
            obj = (DecimalFormat)NumberFormat.getInstance(b);
        }
        s = "#######0";
        if (a.indexOf(currency.getCurrencyCode().toUpperCase(Locale.US)) == -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        currency = s;
        if (flag)
        {
            currency = "#####0.00";
        }
        ((DecimalFormat) (obj)).applyPattern(currency);
        return ((DecimalFormat) (obj)).format(d1);
    }

    public static String a(Locale locale, double d1, Currency currency)
    {
        return b(locale, d1, currency);
    }

    private static String b(Locale locale, double d1, Currency currency)
    {
        boolean flag1 = true;
        if (d == null)
        {
            d = NumberFormat.getCurrencyInstance(locale);
        }
        d.setCurrency(currency);
        String s;
        String s1;
        StringBuilder stringbuilder;
        boolean flag;
        if (d.format(1234.5599999999999D).indexOf("1") != 0)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (!flag)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        s = currency.getSymbol();
        s1 = currency.getCurrencyCode();
        try
        {
            stringbuilder = new StringBuilder();
        }
        // Misplaced declaration of an exception variable
        catch (Locale locale)
        {
            return "";
        }
        if (flag) goto _L2; else goto _L1
_L1:
        locale = (new StringBuilder()).append(s1).append(" ").toString();
_L4:
        stringbuilder = stringbuilder.append(locale);
        if (flag)
        {
            locale = s;
        } else
        {
            locale = "";
        }
        currency = stringbuilder.append(locale).append(a(d1, currency));
        if (flag)
        {
            break MISSING_BLOCK_LABEL_225;
        }
        locale = (new StringBuilder(" ")).append(s).toString();
_L5:
        currency = currency.append(locale);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        locale = (new StringBuilder(" ")).append(s1).toString();
_L3:
        return currency.append(locale).toString();
        locale = "";
          goto _L3
_L2:
        locale = "";
          goto _L4
        locale = "";
          goto _L5
    }

    static 
    {
        Arrays.asList(new String[] {
            "AUD", "BRL", "CAD", "CHF", "CZK", "DKK", "EUR", "GBP", "HKD", "HUF", 
            "ILS", "JPY", "MXN", "MYR", "NOK", "NZD", "PHP", "PLN", "RUB", "SEK", 
            "SGD", "THB", "TWD", "TRY", "USD"
        });
        b = Locale.US;
        c = Locale.GERMANY;
    }
}
