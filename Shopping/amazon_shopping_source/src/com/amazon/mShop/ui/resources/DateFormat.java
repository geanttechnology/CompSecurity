// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.ui.resources;

import com.amazon.rio.j2me.client.services.mShop.Date;
import java.util.Calendar;

public class DateFormat
{

    public DateFormat()
    {
    }

    public static Calendar getCalendarFromDate(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, date.getYear());
        calendar.set(2, (date.getMonth() - 1) + 0);
        calendar.set(5, date.getDay());
        return calendar;
    }
}
