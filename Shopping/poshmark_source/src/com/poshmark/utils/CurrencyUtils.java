// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class CurrencyUtils
{

    public CurrencyUtils()
    {
    }

    public static String getCurrencyCode()
    {
        return "USD";
    }

    public static String getCurrencySymbol()
    {
        return "$";
    }

    public static String getPriceAsFormattedString(BigDecimal bigdecimal)
    {
        DecimalFormat decimalformat = new DecimalFormat();
        decimalformat.setMaximumFractionDigits(2);
        decimalformat.setMinimumFractionDigits(2);
        decimalformat.setGroupingUsed(true);
        return decimalformat.format(bigdecimal);
    }

    public static String getPriceAsWholeNumber(BigDecimal bigdecimal)
    {
        DecimalFormat decimalformat = new DecimalFormat();
        decimalformat.setMaximumFractionDigits(0);
        decimalformat.setMinimumFractionDigits(0);
        decimalformat.setGroupingUsed(true);
        return decimalformat.format(bigdecimal);
    }
}
