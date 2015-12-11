// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

final class StringUtil
{

    private StringUtil()
    {
    }

    public static String dateToString(Long long1)
    {
        String s = null;
        if (long1 != null)
        {
            s = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date(long1.longValue()));
        }
        return s;
    }

    public static boolean isBlank(String s)
    {
        return s == null || s.trim().length() == 0;
    }

    public static boolean isEmpty(String s)
    {
        return s == null || s.length() == 0;
    }

    public static String join(String as[], String s)
    {
        Object obj = null;
        if (as != null)
        {
            boolean flag;
            if (!isEmpty(s))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = new StringBuilder();
            for (int i = 0; i < as.length; i++)
            {
                ((StringBuilder) (obj)).append(as[i]);
                if (flag && i < as.length - 1)
                {
                    ((StringBuilder) (obj)).append(s);
                }
            }

            obj = ((StringBuilder) (obj)).toString();
        }
        return ((String) (obj));
    }

    public static String[] split(String s, String s1)
    {
        Object obj = null;
        String as[] = obj;
        if (s != null)
        {
            as = obj;
            if (s1 != null)
            {
                s1 = new StringTokenizer(s, s1);
                s = new String[s1.countTokens()];
                int i = 0;
                do
                {
                    as = s;
                    if (!s1.hasMoreTokens())
                    {
                        break;
                    }
                    s[i] = s1.nextToken();
                    i++;
                } while (true);
            }
        }
        return as;
    }
}
