// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.snds.api;

import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public final class TimeUtil
{

    private static final TimeZone STANDARD_TIME_ZONE = TimeZone.getTimeZone("GMT");
    private static final String TAG = com/amazon/identity/snds/api/TimeUtil.getName();

    private TimeUtil()
    {
    }

    public static long fromMinutesTo(long l, TimeUnit timeunit)
    {
        return timeunit.convert(l * 60L, TimeUnit.SECONDS);
    }

}
