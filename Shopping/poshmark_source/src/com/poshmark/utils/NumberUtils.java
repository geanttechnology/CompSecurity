// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumberUtils
{

    public NumberUtils()
    {
    }

    public static String getBigDecimalAsGroupedString(BigDecimal bigdecimal, int i, int j)
    {
        DecimalFormat decimalformat = new DecimalFormat();
        decimalformat.setMaximumFractionDigits(j);
        decimalformat.setMinimumFractionDigits(i);
        decimalformat.setGroupingUsed(true);
        return decimalformat.format(bigdecimal);
    }

    public static String getIntegerAsGroupedString(int i)
    {
        DecimalFormat decimalformat = new DecimalFormat();
        decimalformat.setMaximumFractionDigits(0);
        decimalformat.setMinimumFractionDigits(0);
        decimalformat.setGroupingUsed(true);
        return decimalformat.format(i);
    }
}
