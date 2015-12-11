// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.b.a;


public class f
{

    private final int a;
    private final int b;

    public f(int i, int j)
    {
        a = i;
        b = j;
    }

    public f(int i, int j, int k)
    {
        if (k % 180 == 0)
        {
            a = i;
            b = j;
            return;
        } else
        {
            a = j;
            b = i;
            return;
        }
    }

    public int a()
    {
        return a;
    }

    public f a(float f1)
    {
        return new f((int)((float)a * f1), (int)((float)b * f1));
    }

    public f a(int i)
    {
        return new f(a / i, b / i);
    }

    public int b()
    {
        return b;
    }

    public String toString()
    {
        return (new StringBuilder(9)).append(a).append("x").append(b).toString();
    }
}
