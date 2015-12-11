// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import com.target.mothership.model.guest.interfaces.Guest;
import java.util.Calendar;

public class j
{

    private static final long DAY_IN_MILLIS = 0x5265c00L;
    private static final int MIN_DIFF_IN_DAYS_FOR_REFRESH = 29;

    public static boolean a(Guest guest)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(guest.getExpirationDate());
        guest = Calendar.getInstance();
        return (int)((calendar.getTimeInMillis() - guest.getTimeInMillis()) / 0x5265c00L) < 29;
    }
}
