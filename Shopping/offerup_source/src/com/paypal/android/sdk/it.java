// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


final class it
{

    private final it a[];
    private final int b;
    private final int c;

    it()
    {
        a = new it[256];
        b = 0;
        c = 0;
    }

    it(int i, int j)
    {
        a = null;
        b = i;
        j &= 7;
        i = j;
        if (j == 0)
        {
            i = 8;
        }
        c = i;
    }

    static it[] a(it it1)
    {
        return it1.a;
    }

    static int b(it it1)
    {
        return it1.b;
    }

    static int c(it it1)
    {
        return it1.c;
    }
}
