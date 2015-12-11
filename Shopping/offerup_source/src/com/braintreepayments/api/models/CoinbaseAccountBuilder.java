// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api.models;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.braintreepayments.api.models:
//            CoinbaseAccount, CoinbasePaymentMethodOptions, Metadata, PaymentMethod

public class CoinbaseAccountBuilder
    implements PaymentMethod.Builder
{

    private String mCode;
    private String mIntegration;
    private CoinbasePaymentMethodOptions mOptions;
    private String mRedirectUri;
    private String mSource;

    public CoinbaseAccountBuilder()
    {
        mIntegration = "custom";
    }

    public CoinbaseAccount build()
    {
        CoinbaseAccount coinbaseaccount = new CoinbaseAccount();
        coinbaseaccount.setAccessCode(mCode);
        coinbaseaccount.setOptions(mOptions);
        coinbaseaccount.setSource(mSource);
        coinbaseaccount.setRedirectUri(mRedirectUri);
        return coinbaseaccount;
    }

    public volatile PaymentMethod build()
    {
        return build();
    }

    public CoinbaseAccountBuilder code(String s)
    {
        mCode = s;
        return this;
    }

    public CoinbaseAccount fromJson(String s)
    {
        return CoinbaseAccount.fromJson(s);
    }

    public volatile PaymentMethod fromJson(String s)
    {
        return fromJson(s);
    }

    public String getApiPath()
    {
        return "coinbase_accounts";
    }

    public String getApiResource()
    {
        return "coinbaseAccounts";
    }

    public CoinbaseAccountBuilder integration(String s)
    {
        mIntegration = s;
        return this;
    }

    public volatile PaymentMethod.Builder integration(String s)
    {
        return integration(s);
    }

    public CoinbaseAccountBuilder redirectUri(String s)
    {
        mRedirectUri = s;
        return this;
    }

    public CoinbaseAccountBuilder source(String s)
    {
        mSource = s;
        return this;
    }

    public volatile PaymentMethod.Builder source(String s)
    {
        return source(s);
    }

    public CoinbaseAccountBuilder storeInVault(boolean flag)
    {
        if (mOptions == null)
        {
            mOptions = new CoinbasePaymentMethodOptions();
        }
        mOptions.setStoreInVault(flag);
        return this;
    }

    public Map toJson()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("coinbaseAccount", build());
        hashmap.put("_meta", new Metadata(mIntegration, mSource));
        return hashmap;
    }

    public String toJsonString()
    {
        return (new Gson()).toJson(toJson());
    }

    public CoinbaseAccountBuilder validate(boolean flag)
    {
        if (mOptions == null)
        {
            mOptions = new CoinbasePaymentMethodOptions();
        }
        mOptions.setValidate(flag);
        return this;
    }

    public volatile PaymentMethod.Builder validate(boolean flag)
    {
        return validate(flag);
    }
}
