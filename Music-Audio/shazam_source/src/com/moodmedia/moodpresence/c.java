// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.moodmedia.moodpresence;


class c
{

    private int a;
    private int b;
    private short c[];

    c(int i)
    {
        b = i;
        c = new short[b];
    }

    int a(int i)
    {
        a = i;
        return a;
    }

    void a(short aword0[])
    {
        System.arraycopy(aword0, 0, c, 0, b);
    }

    short[] a()
    {
        return c;
    }

    int b()
    {
        return a;
    }
}
