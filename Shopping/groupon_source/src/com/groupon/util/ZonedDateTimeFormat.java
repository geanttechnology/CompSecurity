// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.text.FieldPosition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ZonedDateTimeFormat extends SimpleDateFormat
{

    public ZonedDateTimeFormat()
    {
        super("HH:mm:ssZ");
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

    public Date parse(String s)
        throws ParseException
    {
        try
        {
            s = (new StringBuilder()).append(s.substring(0, 22)).append(s.substring(23)).toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new ParseException("Invalid length", 0);
        }
        return super.parse(s);
    }
}
