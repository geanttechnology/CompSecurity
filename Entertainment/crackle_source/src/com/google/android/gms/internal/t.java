// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;

public final class t extends ab.a
{

    private final AdListener ev;

    public t(AdListener adlistener)
    {
        ev = adlistener;
    }

    public void onAdClosed()
    {
        ev.onAdClosed();
    }

    public void onAdFailedToLoad(int i)
    {
        ev.onAdFailedToLoad(i);
    }

    public void onAdLeftApplication()
    {
        ev.onAdLeftApplication();
    }

    public void onAdLoaded()
    {
        ev.onAdLoaded();
    }

    public void onAdOpened()
    {
        ev.onAdOpened();
    }
}
