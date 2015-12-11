// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert.i;

import com.facebook.ads.a;
import com.facebook.ads.b;
import com.facebook.ads.c;

public final class d
    implements c
{

    private final c a[];

    public transient d(c ac[])
    {
        a = ac;
    }

    public final void a(a a1)
    {
        c ac[] = a;
        int j = ac.length;
        for (int i = 0; i < j; i++)
        {
            ac[i].a(a1);
        }

    }

    public final void a(a a1, b b1)
    {
        c ac[] = a;
        int j = ac.length;
        for (int i = 0; i < j; i++)
        {
            ac[i].a(a1, b1);
        }

    }

    public final void b(a a1)
    {
        c ac[] = a;
        int j = ac.length;
        for (int i = 0; i < j; i++)
        {
            ac[i].b(a1);
        }

    }
}
