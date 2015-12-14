// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;

public final class zzc extends zzo.zza
{

    private final AdListener zzsz;

    public zzc(AdListener adlistener)
    {
        zzsz = adlistener;
    }

    public final void onAdClosed()
    {
        zzsz.onAdClosed();
    }

    public final void onAdFailedToLoad(int i)
    {
        zzsz.onAdFailedToLoad(i);
    }

    public final void onAdLeftApplication()
    {
        zzsz.onAdLeftApplication();
    }

    public final void onAdLoaded()
    {
        zzsz.onAdLoaded();
    }

    public final void onAdOpened()
    {
        zzsz.onAdOpened();
    }
}
