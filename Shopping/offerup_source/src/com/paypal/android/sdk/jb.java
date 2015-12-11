// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.Arrays;

public final class jb
{

    private int a;
    private int b;
    private int c;
    private final int d[] = new int[10];

    public jb()
    {
    }

    final jb a(int i, int j, int k)
    {
        if (i >= 10)
        {
            return this;
        }
        int l = 1 << i;
        a = a | l;
        if ((j & 1) != 0)
        {
            b = b | l;
        } else
        {
            b = b & ~l;
        }
        if ((j & 2) != 0)
        {
            c = l | c;
        } else
        {
            c = ~l & c;
        }
        d[i] = k;
        return this;
    }

    final void a()
    {
        c = 0;
        b = 0;
        a = 0;
        Arrays.fill(d, 0);
    }

    final boolean a(int i)
    {
        return (1 << i & a) != 0;
    }

    final int b()
    {
        return Integer.bitCount(a);
    }

    final int b(int i)
    {
        return d[i];
    }

    final int c()
    {
        if ((a & 2) != 0)
        {
            return d[1];
        } else
        {
            return -1;
        }
    }

    final int c(int i)
    {
        boolean flag = false;
        byte byte0;
        if ((1 << i & c) != 0)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        if (byte0 != 0)
        {
            byte0 = 2;
        } else
        {
            byte0 = 0;
        }
        if ((1 << i & b) != 0)
        {
            flag = true;
        }
        i = byte0;
        if (flag)
        {
            i = byte0 | 1;
        }
        return i;
    }

    final int d()
    {
        if ((a & 0x80) != 0)
        {
            return d[7];
        } else
        {
            return 0x10000;
        }
    }

    final int d(int i)
    {
        if ((a & 0x20) != 0)
        {
            i = d[5];
        }
        return i;
    }
}
