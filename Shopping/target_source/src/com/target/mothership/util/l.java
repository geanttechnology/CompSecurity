// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import java.math.BigDecimal;
import java.util.Currency;

// Referenced classes of package com.target.mothership.util:
//            o, c

public class l
{

    private static final int CARD_LAST_DIGITS_LENGTH = 4;

    public static transient String a(String as[])
    {
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            if (o.g(s))
            {
                return s;
            }
        }

        return null;
    }

    public static BigDecimal a(String s)
    {
        if (o.g(s))
        {
            return new BigDecimal(s);
        } else
        {
            return c.ZERO;
        }
    }

    public static Currency b(String s)
    {
        if (o.g(s))
        {
            return Currency.getInstance(s);
        } else
        {
            return c.USD;
        }
    }

    public static String c(String s)
    {
        String s2 = "";
        String s1 = s2;
        if (o.g(s))
        {
            int i = s.length();
            s1 = s2;
            if (i >= 4)
            {
                s1 = s.substring(i - 4);
            }
        }
        return s1;
    }
}
