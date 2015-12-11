// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import java.io.Serializable;
import java.util.Calendar;

public class BookingMetaData
    implements Serializable
{

    private static final long serialVersionUID = 0x309adf5ce14bc598L;
    private Calendar endDate;
    private int minNights;
    private Calendar startDate;

    public BookingMetaData()
    {
    }

    public Calendar getEndDate()
    {
        return endDate;
    }

    public int getMinNights()
    {
        return minNights;
    }

    public Calendar getStartDate()
    {
        return startDate;
    }

    public void setEndDate(Calendar calendar)
    {
        endDate = calendar;
    }

    public void setMinNights(int i)
    {
        minNights = i;
    }

    public void setStartDate(Calendar calendar)
    {
        startDate = calendar;
    }
}
