// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WeekDateFormat extends SimpleDateFormat
{

    public static final String WEEK_DATE = "weekDate";
    private static final String WEEK_DATE_FORMAT = "EEEE, MMM d, yyyy";

    public WeekDateFormat()
    {
        super("EEEE, MMM d, yyyy");
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
