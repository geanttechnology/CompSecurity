// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.b;


public class m
{

    private String a;
    private String b;
    private String c;
    private int d;
    private long e;

    public m(String s)
    {
        d = 1;
        e = -1L;
        a = s;
    }

    public void a(String s)
    {
        c = s;
    }

    public void a(String s, String s1)
    {
        b = s;
        e = 0L;
        if (s1 != null)
        {
            e = System.currentTimeMillis() + Long.parseLong(s1) * 1000L;
        }
    }

    public boolean a()
    {
        return b != null && System.currentTimeMillis() < e;
    }

    public String b()
    {
        return a;
    }

    public String c()
    {
        return b;
    }

    public String d()
    {
        return c;
    }
}
