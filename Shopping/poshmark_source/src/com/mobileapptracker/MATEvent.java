// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;

import java.util.Date;
import java.util.List;

public class MATEvent
{

    private String a;
    private int b;
    private double c;
    private String d;
    private String e;
    private List f;
    private String g;
    private String h;
    private String i;
    private String j;
    private int k;
    private int l;
    private String m;
    private double n;
    private Date o;
    private Date p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;

    public MATEvent(int i1)
    {
        b = i1;
    }

    public MATEvent(String s1)
    {
        a = s1;
    }

    public String getAttribute1()
    {
        return q;
    }

    public String getAttribute2()
    {
        return r;
    }

    public String getAttribute3()
    {
        return s;
    }

    public String getAttribute4()
    {
        return t;
    }

    public String getAttribute5()
    {
        return u;
    }

    public String getContentId()
    {
        return j;
    }

    public String getContentType()
    {
        return i;
    }

    public String getCurrencyCode()
    {
        return d;
    }

    public Date getDate1()
    {
        return o;
    }

    public Date getDate2()
    {
        return p;
    }

    public int getEventId()
    {
        return b;
    }

    public List getEventItems()
    {
        return f;
    }

    public String getEventName()
    {
        return a;
    }

    public int getLevel()
    {
        return k;
    }

    public int getQuantity()
    {
        return l;
    }

    public double getRating()
    {
        return n;
    }

    public String getReceiptData()
    {
        return g;
    }

    public String getReceiptSignature()
    {
        return h;
    }

    public String getRefId()
    {
        return e;
    }

    public double getRevenue()
    {
        return c;
    }

    public String getSearchString()
    {
        return m;
    }

    public MATEvent withAdvertiserRefId(String s1)
    {
        e = s1;
        return this;
    }

    public MATEvent withAttribute1(String s1)
    {
        q = s1;
        return this;
    }

    public MATEvent withAttribute2(String s1)
    {
        r = s1;
        return this;
    }

    public MATEvent withAttribute3(String s1)
    {
        s = s1;
        return this;
    }

    public MATEvent withAttribute4(String s1)
    {
        t = s1;
        return this;
    }

    public MATEvent withAttribute5(String s1)
    {
        u = s1;
        return this;
    }

    public MATEvent withContentId(String s1)
    {
        j = s1;
        return this;
    }

    public MATEvent withContentType(String s1)
    {
        i = s1;
        return this;
    }

    public MATEvent withCurrencyCode(String s1)
    {
        d = s1;
        return this;
    }

    public MATEvent withDate1(Date date)
    {
        o = date;
        return this;
    }

    public MATEvent withDate2(Date date)
    {
        p = date;
        return this;
    }

    public MATEvent withEventItems(List list)
    {
        f = list;
        return this;
    }

    public MATEvent withLevel(int i1)
    {
        k = i1;
        return this;
    }

    public MATEvent withQuantity(int i1)
    {
        l = i1;
        return this;
    }

    public MATEvent withRating(double d1)
    {
        n = d1;
        return this;
    }

    public MATEvent withReceipt(String s1, String s2)
    {
        g = s1;
        h = s2;
        return this;
    }

    public MATEvent withRevenue(double d1)
    {
        c = d1;
        return this;
    }

    public MATEvent withSearchString(String s1)
    {
        m = s1;
        return this;
    }
}
