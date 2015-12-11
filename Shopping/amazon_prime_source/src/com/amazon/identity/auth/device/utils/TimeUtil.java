// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            StringConversionHelpers

public final class TimeUtil
{

    public static Date deserialize(String s)
    {
        s = StringConversionHelpers.toLong(s);
        if (s == null)
        {
            return null;
        } else
        {
            return new Date(s.longValue());
        }
    }

    public static long fromHoursTo(long l, TimeUnit timeunit)
    {
        return fromMinutesTo(60L * l, timeunit);
    }

    public static long fromMinutesTo(long l, TimeUnit timeunit)
    {
        return timeunit.convert(l * 60L, TimeUnit.SECONDS);
    }

    public static String serialize(Date date)
    {
        if (date == null)
        {
            return null;
        } else
        {
            return Long.toString(date.getTime());
        }
    }
}
