// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyUtil
{

    private static final Pattern CURRENCY_REGEX_PATTERN = Pattern.compile("^\\$\\s(([0-9]{1})|([1-9]{1}[0-9]+)|([1-9][0-9]{0,2}(,[0-9]{3})*))(\\.\\d{2}){1}$");
    private static final String US_CURRENCY_REGEX = "^\\$\\s(([0-9]{1})|([1-9]{1}[0-9]+)|([1-9][0-9]{0,2}(,[0-9]{3})*))(\\.\\d{2}){1}$";

    private CurrencyUtil()
    {
    }

    public boolean isCorrectCurrencyFormat(String s)
    {
        return CURRENCY_REGEX_PATTERN.matcher(s).matches();
    }

}
