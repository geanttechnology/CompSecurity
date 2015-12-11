// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.a;

public final class f extends p.a
{

    private final a a;

    public f(a a1)
    {
        a = a1;
    }

    public final void a()
    {
        a.onAdClosed();
    }

    public final void a(int i)
    {
        a.onAdFailedToLoad(i);
    }

    public final void b()
    {
        a.onAdLeftApplication();
    }

    public final void c()
    {
        a.onAdLoaded();
    }

    public final void d()
    {
        a.onAdOpened();
    }
}
