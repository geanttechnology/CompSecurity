// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.currency;


public class SPCurrencyServerSuccesfulResponse
    implements SPCurrencyServerRequester.SPCurrencyServerReponse
{

    private double mDeltaOfCoins;
    private String mLatestTransactionId;

    public SPCurrencyServerSuccesfulResponse(double d, String s)
    {
        mDeltaOfCoins = d;
        mLatestTransactionId = s;
    }

    public double getDeltaOfCoins()
    {
        return mDeltaOfCoins;
    }

    public String getLatestTransactionId()
    {
        return mLatestTransactionId;
    }
}
