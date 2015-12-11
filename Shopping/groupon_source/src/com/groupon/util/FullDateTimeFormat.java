// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FullDateTimeFormat extends SimpleDateFormat
{

    public FullDateTimeFormat()
    {
        super("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
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
