// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.helpers;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;

// Referenced classes of package org.apache.log4j.helpers:
//            AbsoluteTimeDateFormat

public class DateTimeDateFormat extends AbsoluteTimeDateFormat
{

    String shortMonths[];

    public DateTimeDateFormat()
    {
        shortMonths = (new DateFormatSymbols()).getShortMonths();
    }

    public StringBuffer format(Date date, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        super.calendar.setTime(date);
        int i = super.calendar.get(5);
        if (i < 10)
        {
            stringbuffer.append('0');
        }
        stringbuffer.append(i);
        stringbuffer.append(' ');
        stringbuffer.append(shortMonths[super.calendar.get(2)]);
        stringbuffer.append(' ');
        stringbuffer.append(super.calendar.get(1));
        stringbuffer.append(' ');
        return super.format(date, stringbuffer, fieldposition);
    }

    public Date parse(String s, ParsePosition parseposition)
    {
        return null;
    }
}
