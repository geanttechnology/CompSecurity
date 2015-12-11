// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.c;


public class s
{

    private long a;
    private long b;
    private long c;

    public s()
    {
    }

    public void a()
    {
        if (a == 0L)
        {
            a = System.currentTimeMillis();
        }
    }

    public void b()
    {
        b = b + c();
        a = 0L;
    }

    public long c()
    {
        long l1 = b;
        long l = l1;
        if (a > 0L)
        {
            l = l1 + (System.currentTimeMillis() - a);
        }
        l1 = l;
        if (l < c)
        {
            l1 = c;
            b = c;
            a = System.currentTimeMillis();
        }
        c = l1;
        return l1;
    }

    public double d()
    {
        return (double)c() / 1000D;
    }
}
