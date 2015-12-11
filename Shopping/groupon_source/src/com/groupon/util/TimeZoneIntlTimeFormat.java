// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

// Referenced classes of package com.groupon.util:
//            LocalTimeDateFormat

public class TimeZoneIntlTimeFormat extends LocalTimeDateFormat
{

    private static final String INTL_DATE_FORMAT = "hh:mm aa";
    private TimeZone timeZone;

    public TimeZoneIntlTimeFormat()
    {
    }

    private DateFormat getTimeFormatter()
    {
        return new SimpleDateFormat("hh:mm aa");
    }

    public StringBuffer format(Date date, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        return getLocalInstance().format(date, stringbuffer, fieldposition);
    }

    protected DateFormat getLocalInstance()
    {
        DateFormat dateformat = getTimeFormatter();
        if (timeZone != null)
        {
            dateformat.setTimeZone(timeZone);
        }
        return dateformat;
    }

    public Date parse(String s)
        throws ParseException
    {
        return getLocalInstance().parse(s);
    }

    public Date parse(String s, ParsePosition parseposition)
    {
        return getLocalInstance().parse(s, parseposition);
    }

    public void setTimeZoneByIdentifier(String s)
    {
        timeZone = TimeZone.getTimeZone(s);
    }
}
