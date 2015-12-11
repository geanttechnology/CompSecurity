// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.interstitial;

import android.content.Intent;

public interface SPInterstitialRequestListener
{

    public abstract void onSPInterstitialAdAvailable(Intent intent);

    public abstract void onSPInterstitialAdError(String s);

    public abstract void onSPInterstitialAdNotAvailable();
}
