// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field.types;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class dateFormatStr
{

    final String dateFormatStr;
    private final ThreadLocal threadLocal = new ThreadLocal();

    public DateFormat getDateFormat()
    {
        DateFormat dateformat = (DateFormat)threadLocal.get();
        Object obj = dateformat;
        if (dateformat == null)
        {
            obj = new SimpleDateFormat(dateFormatStr);
            threadLocal.set(obj);
        }
        return ((DateFormat) (obj));
    }

    public String toString()
    {
        return dateFormatStr;
    }

    public (String s)
    {
        dateFormatStr = s;
    }
}
