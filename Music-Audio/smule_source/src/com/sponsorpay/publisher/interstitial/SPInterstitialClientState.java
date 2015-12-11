// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.interstitial;


public final class SPInterstitialClientState extends Enum
{

    private static final SPInterstitialClientState ENUM$VALUES[];
    public static final SPInterstitialClientState READY_TO_CHECK_OFFERS;
    public static final SPInterstitialClientState READY_TO_SHOW_OFFERS;
    public static final SPInterstitialClientState REQUESTING_OFFERS;
    public static final SPInterstitialClientState SHOWING_OFFERS;
    public static final SPInterstitialClientState VALIDATING_OFFERS;
    private final boolean canChangeParameters;
    private final boolean canRequestAds;
    private final boolean canShowAdw;

    private SPInterstitialClientState(String s, int i, boolean flag, boolean flag1, boolean flag2)
    {
        super(s, i);
        canShowAdw = flag;
        canRequestAds = flag1;
        canChangeParameters = flag2;
    }

    public static SPInterstitialClientState valueOf(String s)
    {
        return (SPInterstitialClientState)Enum.valueOf(com/sponsorpay/publisher/interstitial/SPInterstitialClientState, s);
    }

    public static SPInterstitialClientState[] values()
    {
        SPInterstitialClientState aspinterstitialclientstate[] = ENUM$VALUES;
        int i = aspinterstitialclientstate.length;
        SPInterstitialClientState aspinterstitialclientstate1[] = new SPInterstitialClientState[i];
        System.arraycopy(aspinterstitialclientstate, 0, aspinterstitialclientstate1, 0, i);
        return aspinterstitialclientstate1;
    }

    boolean canChangeParameters()
    {
        return canChangeParameters;
    }

    boolean canRequestAds()
    {
        return canRequestAds;
    }

    boolean canShowAds()
    {
        return canShowAdw;
    }

    static 
    {
        READY_TO_CHECK_OFFERS = new SPInterstitialClientState("READY_TO_CHECK_OFFERS", 0, false, true, true);
        REQUESTING_OFFERS = new SPInterstitialClientState("REQUESTING_OFFERS", 1, false, false, false);
        VALIDATING_OFFERS = new SPInterstitialClientState("VALIDATING_OFFERS", 2, false, false, false);
        READY_TO_SHOW_OFFERS = new SPInterstitialClientState("READY_TO_SHOW_OFFERS", 3, true, true, true);
        SHOWING_OFFERS = new SPInterstitialClientState("SHOWING_OFFERS", 4, false, false, false);
        ENUM$VALUES = (new SPInterstitialClientState[] {
            READY_TO_CHECK_OFFERS, REQUESTING_OFFERS, VALIDATING_OFFERS, READY_TO_SHOW_OFFERS, SHOWING_OFFERS
        });
    }
}
