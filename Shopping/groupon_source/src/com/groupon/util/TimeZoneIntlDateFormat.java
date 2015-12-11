// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.text.DateFormat;
import java.util.TimeZone;

// Referenced classes of package com.groupon.util:
//            IntlDateFormat

public class TimeZoneIntlDateFormat extends IntlDateFormat
{

    protected TimeZone timeZone;

    public TimeZoneIntlDateFormat()
    {
    }

    protected DateFormat getLocalInstance()
    {
        DateFormat dateformat = super.getLocalInstance();
        if (timeZone != null)
        {
            dateformat.setTimeZone(timeZone);
        }
        return dateformat;
    }

    public void setTimeZoneByIdentifier(String s)
    {
        timeZone = TimeZone.getTimeZone(s);
    }
}
