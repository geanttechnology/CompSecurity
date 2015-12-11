// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.interstitial;


public final class SPInterstitialAdCloseReason extends Enum
{

    private static final SPInterstitialAdCloseReason ENUM$VALUES[];
    public static final SPInterstitialAdCloseReason ReasonError;
    public static final SPInterstitialAdCloseReason ReasonUnknown;
    public static final SPInterstitialAdCloseReason ReasonUserClickedOnAd;
    public static final SPInterstitialAdCloseReason ReasonUserClosedAd;

    private SPInterstitialAdCloseReason(String s, int i)
    {
        super(s, i);
    }

    public static SPInterstitialAdCloseReason valueOf(String s)
    {
        return (SPInterstitialAdCloseReason)Enum.valueOf(com/sponsorpay/publisher/interstitial/SPInterstitialAdCloseReason, s);
    }

    public static SPInterstitialAdCloseReason[] values()
    {
        SPInterstitialAdCloseReason aspinterstitialadclosereason[] = ENUM$VALUES;
        int i = aspinterstitialadclosereason.length;
        SPInterstitialAdCloseReason aspinterstitialadclosereason1[] = new SPInterstitialAdCloseReason[i];
        System.arraycopy(aspinterstitialadclosereason, 0, aspinterstitialadclosereason1, 0, i);
        return aspinterstitialadclosereason1;
    }

    static 
    {
        ReasonUnknown = new SPInterstitialAdCloseReason("ReasonUnknown", 0);
        ReasonUserClickedOnAd = new SPInterstitialAdCloseReason("ReasonUserClickedOnAd", 1);
        ReasonUserClosedAd = new SPInterstitialAdCloseReason("ReasonUserClosedAd", 2);
        ReasonError = new SPInterstitialAdCloseReason("ReasonError", 3);
        ENUM$VALUES = (new SPInterstitialAdCloseReason[] {
            ReasonUnknown, ReasonUserClickedOnAd, ReasonUserClosedAd, ReasonError
        });
    }
}
