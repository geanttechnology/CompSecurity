// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// Referenced classes of package com.groupon.util:
//            TimeZoneIntlDateFormat

public class TimeZoneUSRedeemedAtFormat extends TimeZoneIntlDateFormat
{

    private static final String REDEEMED_AT_US_DATE_FORMAT = "MMM d, yyyy h:mma";

    public TimeZoneUSRedeemedAtFormat()
    {
    }

    public StringBuffer format(Date date, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        return new StringBuffer((new String(super.format(date, stringbuffer, fieldposition))).toUpperCase());
    }

    protected DateFormat getLocalInstance()
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("MMM d, yyyy h:mma", Locale.US);
        if (timeZone != null)
        {
            simpledateformat.setTimeZone(timeZone);
        }
        return simpledateformat;
    }
}
