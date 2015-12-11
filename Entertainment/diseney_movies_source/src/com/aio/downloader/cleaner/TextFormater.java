// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import java.text.DecimalFormat;

public class TextFormater
{

    public TextFormater()
    {
    }

    public static String dataSizeFormat(long l)
    {
        DecimalFormat decimalformat = new DecimalFormat("####.00");
        if (l < 1024L)
        {
            return (new StringBuilder(String.valueOf(l))).append("byte").toString();
        }
        if (l < 0x100000L)
        {
            return (new StringBuilder(String.valueOf(decimalformat.format((float)(l >> 10))))).append("KB").toString();
        }
        if (l < 0x40000000L)
        {
            return (new StringBuilder(String.valueOf(decimalformat.format((float)(l >> 20))))).append("MB").toString();
        }
        if (l < 256L)
        {
            return (new StringBuilder(String.valueOf(decimalformat.format((float)(l >> 30))))).append("GB").toString();
        } else
        {
            return "size : error";
        }
    }

    public static String getSizeFromKB(long l)
    {
        return dataSizeFormat(l << 10);
    }
}
