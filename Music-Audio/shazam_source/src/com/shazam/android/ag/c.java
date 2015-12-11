// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ag;

import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.location.SimpleLocation;

public final class c
{
    public static final class a
    {

        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public long f;
        public SimpleLocation g;
        public Double h;
        public Double i;
        public Double j;
        public String k;
        public String l;
        public String m;
        public ScreenOrigin n;

        public final c a()
        {
            return new c(this, (byte)0);
        }

        public a()
        {
        }
    }


    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final ScreenOrigin h;
    private final String i;
    private final long j;
    private final SimpleLocation k;
    private final Double l;
    private final Double m;
    private final Double n;

    private c(a a1)
    {
        a = a1.a;
        b = a1.b;
        c = a1.c;
        f = a1.d;
        i = a1.e;
        j = a1.f;
        k = a1.g;
        l = a1.h;
        m = a1.i;
        n = a1.j;
        g = a1.k;
        d = a1.l;
        e = a1.m;
        h = a1.n;
    }

    c(a a1, byte byte0)
    {
        this(a1);
    }
}
