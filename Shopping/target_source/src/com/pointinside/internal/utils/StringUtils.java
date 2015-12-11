// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.internal.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class StringUtils
{

    public static String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public StringUtils()
    {
    }

    public static StringBuilder appendIfNotNull(StringBuilder stringbuilder, String s, Object obj)
    {
        if (obj != null)
        {
            stringbuilder.append(s).append(" -- ").append(obj);
            stringbuilder.append(System.getProperty("line.separator"));
        }
        return stringbuilder;
    }

    public static int compare(String s, String s1)
    {
        if (s != null && s1 != null)
        {
            return s.compareTo(s1);
        }
        if (s == null && s1 == null)
        {
            return 0;
        }
        return s != null ? 1 : -1;
    }

    public static String encodeHexString(byte abyte0[])
    {
        int j = abyte0.length;
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append(String.format("%02x", new Object[] {
                Byte.valueOf(abyte0[i])
            }));
        }

        return stringbuilder.toString();
    }

    public static String getDatetimeInString(long l)
    {
        if (l > 0L)
        {
            return (new SimpleDateFormat(DATE_FORMAT, Locale.US)).format(new Date(l));
        } else
        {
            return "";
        }
    }

    public static boolean isNullOrEmpty(String s)
    {
        return s == null || s.length() == 0;
    }

}
