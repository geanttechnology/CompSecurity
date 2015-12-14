// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals.a;


public class a
{

    private int a;
    private int b;
    private int c;
    private int d;

    public a()
    {
        a = -1;
        b = -1;
        c = -1;
        d = -1;
    }

    public String a()
    {
        if (a == -1 && b == -1)
        {
            return null;
        } else
        {
            return (new StringBuilder()).append(a).append("_").append(b).toString();
        }
    }

    public void a(int i)
    {
        a = i;
    }

    public String b()
    {
        if (c == -1 && d == -1)
        {
            return null;
        } else
        {
            return (new StringBuilder()).append(c).append("_").append(d).toString();
        }
    }

    public void b(int i)
    {
        b = i;
    }

    public void c(int i)
    {
        c = i;
    }

    public void d(int i)
    {
        d = i;
    }
}
