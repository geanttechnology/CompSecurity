// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.text.FieldPosition;
import java.util.Date;

// Referenced classes of package com.groupon.util:
//            HumanReadableCountdownFormat, TimeUtil

public class HumanReadableCountdownHourFormat extends HumanReadableCountdownFormat
{

    private static final String COUNTDOWN_FORMAT = "%02d:%02d:%02d";
    private static final int HOURS_IN_DAY = 24;
    TimeUtil timeUtil;

    public HumanReadableCountdownHourFormat()
    {
    }

    protected void doFormat(StringBuffer stringbuffer, int i, int j, int k, int l)
    {
        stringbuffer.append(String.format("%02d:%02d:%02d", new Object[] {
            Integer.valueOf(i * 24 + j), Integer.valueOf(k), Integer.valueOf(l)
        }));
    }

    public StringBuffer format(Date date, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        if (date == null)
        {
            return new StringBuffer(0);
        } else
        {
            int i = timeUtil.diffDays(relativeTo, date);
            int j = timeUtil.diffHours(relativeTo, date);
            int k = timeUtil.diffMinutes(relativeTo, date);
            int l = timeUtil.diffSeconds(relativeTo, date);
            date = new StringBuffer();
            doFormat(date, i, j, k, l);
            return date;
        }
    }
}
