// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api.models;


public class CoinbaseConfiguration
{

    private String mClientId;
    private String mEnvironment;
    private String mMerchantAccount;
    private String mScopes;

    public CoinbaseConfiguration()
    {
    }

    public String getBaseURLForEnvironment()
    {
        if (getEnvironment().equalsIgnoreCase("shared_sandbox"))
        {
            return "https://sandbox.coinbase.com/";
        } else
        {
            return "https://www.coinbase.com/";
        }
    }

    public String getClientId()
    {
        return mClientId;
    }

    public String getEnvironment()
    {
        return mEnvironment;
    }

    public String getMerchantAccount()
    {
        return mMerchantAccount;
    }

    public String getScopes()
    {
        return mScopes;
    }
}
