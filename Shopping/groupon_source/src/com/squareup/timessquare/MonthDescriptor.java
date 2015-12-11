// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.timessquare;

import java.util.Date;

class MonthDescriptor
{

    private final Date date;
    private String label;
    private final int month;
    private final int year;

    public MonthDescriptor(int i, int j, Date date1, String s)
    {
        month = i;
        year = j;
        date = date1;
        label = s;
    }

    public Date getDate()
    {
        return date;
    }

    public String getLabel()
    {
        return label;
    }

    public int getMonth()
    {
        return month;
    }

    public int getYear()
    {
        return year;
    }

    void setLabel(String s)
    {
        label = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("MonthDescriptor{label='").append(label).append('\'').append(", month=").append(month).append(", year=").append(year).append('}').toString();
    }
}
