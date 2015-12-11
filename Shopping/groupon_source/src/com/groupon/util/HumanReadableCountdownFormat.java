// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;

public abstract class HumanReadableCountdownFormat extends DateFormat
{

    protected Context context;
    private String expiredMessage;
    protected Date relativeTo;

    public HumanReadableCountdownFormat()
    {
        relativeTo = null;
        expiredMessage = "";
    }

    protected abstract void doFormat(StringBuffer stringbuffer, int i, int j, int k, int l);

    public StringBuffer format(Date date, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        if (date == null)
        {
            return new StringBuffer(0);
        }
        long l1 = date.getTime();
        if (relativeTo != null)
        {
            date = relativeTo;
        } else
        {
            date = new Date();
        }
        l1 = (l1 - date.getTime()) / 1000L;
        if (l1 <= 0L)
        {
            return new StringBuffer(expiredMessage);
        } else
        {
            int i = (int)(l1 / 0x15180L);
            int j = (int)(l1 % 0x15180L) / 3600;
            int k = (int)(l1 % 3600L) / 60;
            int l = (int)(l1 % 60L);
            date = new StringBuffer();
            doFormat(date, i, j, k, l);
            return date;
        }
    }

    public Date parse(String s, ParsePosition parseposition)
    {
        throw new UnsupportedOperationException();
    }

    public void setRelativeTo(Date date)
    {
        relativeTo = date;
    }
}
