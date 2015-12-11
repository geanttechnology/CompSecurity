// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


final class lf
{

    final byte a[];
    int b;
    int c;
    boolean d;
    boolean e;
    lf f;
    lf g;

    lf()
    {
        a = new byte[2048];
        e = true;
        d = false;
    }

    lf(lf lf1)
    {
        this(lf1.a, lf1.b, lf1.c);
        lf1.d = true;
    }

    private lf(byte abyte0[], int i, int j)
    {
        a = abyte0;
        b = i;
        c = j;
        e = false;
        d = true;
    }

    public final lf a()
    {
        lf lf1;
        if (f != this)
        {
            lf1 = f;
        } else
        {
            lf1 = null;
        }
        g.f = f;
        f.g = g;
        f = null;
        g = null;
        return lf1;
    }

    public final lf a(lf lf1)
    {
        lf1.g = this;
        lf1.f = f;
        f.g = lf1;
        f = lf1;
        return lf1;
    }

    public final void a(lf lf1, int i)
    {
        if (!lf1.e)
        {
            throw new IllegalArgumentException();
        }
        if (lf1.c + i > 2048)
        {
            if (lf1.d)
            {
                throw new IllegalArgumentException();
            }
            if ((lf1.c + i) - lf1.b > 2048)
            {
                throw new IllegalArgumentException();
            }
            System.arraycopy(lf1.a, lf1.b, lf1.a, 0, lf1.c - lf1.b);
            lf1.c = lf1.c - lf1.b;
            lf1.b = 0;
        }
        System.arraycopy(a, b, lf1.a, lf1.c, i);
        lf1.c = lf1.c + i;
        b = b + i;
    }
}
