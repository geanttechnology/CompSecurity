// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.store;

import java.io.Serializable;

public class DetailedHours
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String close;
    private String date;
    private String day;
    private String open;

    public DetailedHours()
    {
    }

    public String getClose()
    {
        return close;
    }

    public String getDate()
    {
        return date;
    }

    public String getDay()
    {
        return day;
    }

    public String getOpen()
    {
        return open;
    }

    public void setClose(String s)
    {
        close = s;
    }

    public void setDate(String s)
    {
        date = s;
    }

    public void setDay(String s)
    {
        day = s;
    }

    public void setOpen(String s)
    {
        open = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ClassPojo [open = ").append(open).append(", day = ").append(day).append(", date = ").append(date).append(", close = ").append(close).append("]").toString();
    }
}
