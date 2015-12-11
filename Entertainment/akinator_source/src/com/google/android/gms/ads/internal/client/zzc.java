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

    public void onAdClosed()
    {
        zzsz.onAdClosed();
    }

    public void onAdFailedToLoad(int i)
    {
        zzsz.onAdFailedToLoad(i);
    }

    public void onAdLeftApplication()
    {
        zzsz.onAdLeftApplication();
    }

    public void onAdLoaded()
    {
        zzsz.onAdLoaded();
    }

    public void onAdOpened()
    {
        zzsz.onAdOpened();
    }
}
