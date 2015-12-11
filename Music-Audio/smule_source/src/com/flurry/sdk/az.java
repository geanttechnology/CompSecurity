// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import com.flurry.android.impl.ads.protocol.v13.FrequencyCapResponseInfo;
import com.flurry.android.impl.ads.protocol.v13.FrequencyCapType;

public class az
{

    private FrequencyCapType a;
    private String b;
    private long c;
    private long d;
    private long e;
    private int f;
    private int g;
    private int h;
    private int i;
    private long j;

    private az()
    {
    }

    public az(FrequencyCapResponseInfo frequencycapresponseinfo)
    {
        a = frequencycapresponseinfo.capType;
        b = frequencycapresponseinfo.id;
        c = frequencycapresponseinfo.serveTime;
        d = frequencycapresponseinfo.expirationTime;
        e = frequencycapresponseinfo.streamCapDurationMillis;
        f = frequencycapresponseinfo.capRemaining;
        g = frequencycapresponseinfo.totalCap;
        h = frequencycapresponseinfo.capDurationType;
        i = 0;
        j = 0L;
    }


    static int a(az az1, int l)
    {
        az1.i = l;
        return l;
    }

    static long a(az az1, long l)
    {
        az1.e = l;
        return l;
    }

    static FrequencyCapType a(az az1)
    {
        return az1.a;
    }

    static FrequencyCapType a(az az1, FrequencyCapType frequencycaptype)
    {
        az1.a = frequencycaptype;
        return frequencycaptype;
    }

    static String a(az az1, String s)
    {
        az1.b = s;
        return s;
    }

    static int b(az az1, int l)
    {
        az1.f = l;
        return l;
    }

    static long b(az az1, long l)
    {
        az1.j = l;
        return l;
    }

    static String b(az az1)
    {
        return az1.b;
    }

    static int c(az az1, int l)
    {
        az1.g = l;
        return l;
    }

    static long c(az az1)
    {
        return az1.c;
    }

    static long c(az az1, long l)
    {
        az1.c = l;
        return l;
    }

    static int d(az az1, int l)
    {
        az1.h = l;
        return l;
    }

    static long d(az az1)
    {
        return az1.d;
    }

    static long d(az az1, long l)
    {
        az1.d = l;
        return l;
    }

    static long e(az az1)
    {
        return az1.e;
    }

    static int f(az az1)
    {
        return az1.f;
    }

    static int g(az az1)
    {
        return az1.g;
    }

    static int h(az az1)
    {
        return az1.h;
    }

    static int i(az az1)
    {
        return az1.i;
    }

    static long j(az az1)
    {
        return az1.j;
    }

    public void a()
    {
        i = i + 1;
        j = System.currentTimeMillis();
    }

    public FrequencyCapType b()
    {
        return a;
    }

    public String c()
    {
        return b;
    }

    public long d()
    {
        return c;
    }

    public long e()
    {
        return d;
    }

    public long f()
    {
        return e;
    }

    public int g()
    {
        return f;
    }

    public int h()
    {
        return g;
    }

    public int i()
    {
        return h;
    }

    public int j()
    {
        return i;
    }

    public long k()
    {
        return j;
    }
}
