// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.interstitial;


public final class SPInterstitialEvent extends Enum
{

    private static final SPInterstitialEvent ENUM$VALUES[];
    public static final SPInterstitialEvent NotIntegrated;
    public static final SPInterstitialEvent ShowClick;
    public static final SPInterstitialEvent ShowClose;
    public static final SPInterstitialEvent ShowError;
    public static final SPInterstitialEvent ShowImpression;
    public static final SPInterstitialEvent ValidationError;
    public static final SPInterstitialEvent ValidationFill;
    public static final SPInterstitialEvent ValidationNoFill;
    public static final SPInterstitialEvent ValidationRequest;
    private final String text;

    private SPInterstitialEvent(String s, int i, String s1)
    {
        super(s, i);
        text = s1;
    }

    public static SPInterstitialEvent valueOf(String s)
    {
        return (SPInterstitialEvent)Enum.valueOf(com/sponsorpay/publisher/interstitial/SPInterstitialEvent, s);
    }

    public static SPInterstitialEvent[] values()
    {
        SPInterstitialEvent aspinterstitialevent[] = ENUM$VALUES;
        int i = aspinterstitialevent.length;
        SPInterstitialEvent aspinterstitialevent1[] = new SPInterstitialEvent[i];
        System.arraycopy(aspinterstitialevent, 0, aspinterstitialevent1, 0, i);
        return aspinterstitialevent1;
    }

    public String toString()
    {
        return text;
    }

    static 
    {
        ValidationRequest = new SPInterstitialEvent("ValidationRequest", 0, "request");
        ValidationFill = new SPInterstitialEvent("ValidationFill", 1, "fill");
        ValidationNoFill = new SPInterstitialEvent("ValidationNoFill", 2, "no_fill");
        ValidationError = new SPInterstitialEvent("ValidationError", 3, "error");
        ShowImpression = new SPInterstitialEvent("ShowImpression", 4, "impression");
        ShowClick = new SPInterstitialEvent("ShowClick", 5, "click");
        ShowClose = new SPInterstitialEvent("ShowClose", 6, "close");
        ShowError = new SPInterstitialEvent("ShowError", 7, "error");
        NotIntegrated = new SPInterstitialEvent("NotIntegrated", 8, "no_sdk");
        ENUM$VALUES = (new SPInterstitialEvent[] {
            ValidationRequest, ValidationFill, ValidationNoFill, ValidationError, ShowImpression, ShowClick, ShowClose, ShowError, NotIntegrated
        });
    }
}
