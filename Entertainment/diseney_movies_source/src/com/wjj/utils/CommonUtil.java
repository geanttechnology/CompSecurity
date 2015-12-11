// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wjj.utils;

import java.text.DecimalFormat;

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
}
