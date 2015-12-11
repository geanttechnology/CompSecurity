// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.kd;
import com.google.android.gms.internal.kf;

public final class h extends kf
{

    public static final h a[] = new h[0];
    public int b;
    public String c;
    public long d;
    public long e;
    private int g;

    public h()
    {
        b = 1;
        c = "";
        d = -1L;
        e = -1L;
        g = -1;
    }

    public final int a()
    {
        int i = b;
        int j = kd.a(1);
        String s;
        int k;
        if (i >= 0)
        {
            i = kd.c(i);
        } else
        {
            i = 10;
        }
        s = c;
        k = kd.a(2);
        i = i + j + 0 + (kd.a(s) + k) + kd.b(3, d) + kd.b(4, e);
        g = i;
        return i;
    }

    public final void a(kd kd1)
    {
        int i = b;
        kd1.a(1, 0);
        if (i >= 0)
        {
            kd1.b(i);
        } else
        {
            kd1.a(i);
        }
        kd1.a(2, c);
        kd1.a(3, d);
        kd1.a(4, e);
    }

}
