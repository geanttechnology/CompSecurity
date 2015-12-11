// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.interstitial;


// Referenced classes of package com.sponsorpay.publisher.interstitial:
//            SPInterstitialAdCloseReason

public interface SPInterstitialAdListener
{

    public abstract void onSPInterstitialAdClosed(SPInterstitialAdCloseReason spinterstitialadclosereason);

    public abstract void onSPInterstitialAdError(String s);

    public abstract void onSPInterstitialAdShown();
}
