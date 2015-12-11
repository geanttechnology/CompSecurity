// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.helpers;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;

public class AbsoluteTimeDateFormat extends DateFormat
{

    private static long previousTime;
    private static char previousTimeWithoutMillis[] = new char[9];

    public AbsoluteTimeDateFormat()
    {
        setCalendar(Calendar.getInstance());
    }

    public StringBuffer format(Date date, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        long l = date.getTime();
        int i = (int)(l % 1000L);
        if (l - (long)i != previousTime || previousTimeWithoutMillis[0] == 0)
        {
            super.calendar.setTime(date);
            int j = stringbuffer.length();
            int k = super.calendar.get(11);
            if (k < 10)
            {
                stringbuffer.append('0');
            }
            stringbuffer.append(k);
            stringbuffer.append(':');
            k = super.calendar.get(12);
            if (k < 10)
            {
                stringbuffer.append('0');
            }
            stringbuffer.append(k);
            stringbuffer.append(':');
            k = super.calendar.get(13);
            if (k < 10)
            {
                stringbuffer.append('0');
            }
            stringbuffer.append(k);
            stringbuffer.append(',');
            stringbuffer.getChars(j, stringbuffer.length(), previousTimeWithoutMillis, 0);
            previousTime = l - (long)i;
        } else
        {
            stringbuffer.append(previousTimeWithoutMillis);
        }
        if (i < 100)
        {
            stringbuffer.append('0');
        }
        if (i < 10)
        {
            stringbuffer.append('0');
        }
        stringbuffer.append(i);
        return stringbuffer;
    }

    public Date parse(String s, ParsePosition parseposition)
    {
        return null;
    }

}
