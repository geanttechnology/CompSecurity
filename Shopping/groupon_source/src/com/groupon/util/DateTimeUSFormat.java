// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUSFormat extends SimpleDateFormat
{

    private static final String US_DATE_TIME_FORMAT = "MMM d, yyyy h:mma";

    public DateTimeUSFormat()
    {
        super("MMM d, yyyy h:mma");
    }

    public StringBuffer format(Date date, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        if (date == null)
        {
            return new StringBuffer();
        } else
        {
            return new StringBuffer(super.format(date, stringbuffer, fieldposition).toString());
        }
    }
}
