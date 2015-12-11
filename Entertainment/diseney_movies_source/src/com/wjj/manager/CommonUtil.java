// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wjj.manager;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil
{

    public CommonUtil()
    {
    }

    public static String formatSize(long l)
    {
        DecimalFormat decimalformat = new DecimalFormat("#.00");
        StringBuffer stringbuffer = new StringBuffer();
        if (l < 1024L)
        {
            stringbuffer.append(l);
        } else
        if (l < 0x100000L)
        {
            stringbuffer.append(decimalformat.format((double)l / 1024D));
        } else
        if (l < 0x40000000L)
        {
            stringbuffer.append(decimalformat.format((double)(l / 1024L) / 1024D));
        } else
        {
            stringbuffer.append(decimalformat.format((double)(l / 1024L / 1024L) / 1024D));
        }
        return stringbuffer.toString();
    }

    public static String formatSizeDanwei(long l)
    {
        DecimalFormat decimalformat = new DecimalFormat("#.00");
        StringBuffer stringbuffer = new StringBuffer();
        if (l < 1024L)
        {
            stringbuffer.append(l);
            stringbuffer.append("B");
        } else
        if (l < 0x100000L)
        {
            stringbuffer.append(decimalformat.format((double)l / 1024D));
            stringbuffer.append("K");
        } else
        if (l < 0x40000000L)
        {
            stringbuffer.append(decimalformat.format((double)(l / 1024L) / 1024D));
            stringbuffer.append("M");
        } else
        {
            stringbuffer.append(decimalformat.format((double)(l / 1024L / 1024L) / 1024D));
            stringbuffer.append("G");
        }
        return stringbuffer.toString();
    }

    public static String formatSizeDanweiTwo(long l)
    {
        StringBuffer stringbuffer = new StringBuffer();
        if (l < 1024L)
        {
            stringbuffer.append("B");
        } else
        if (l < 0x100000L)
        {
            stringbuffer.append("KB");
        } else
        if (l < 0x40000000L)
        {
            stringbuffer.append("MB");
        } else
        {
            stringbuffer.append("GB");
        }
        return stringbuffer.toString();
    }

    public static String getCurTime()
    {
        Date date = new Date();
        return (new SimpleDateFormat("yyyyMMddHHmmss")).format(date);
    }

    public static String getCurTime(long l)
    {
        Date date = new Date(l);
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date);
    }
}
