// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api.models;

import android.text.TextUtils;
import com.google.gson.Gson;

// Referenced classes of package com.braintreepayments.api.models:
//            AndroidPayConfiguration, AnalyticsConfiguration, CoinbaseConfiguration, PayPalConfiguration

public class Configuration
{

    private AnalyticsConfiguration mAnalyticsConfiguration;
    private AndroidPayConfiguration mAndroidPayConfiguration;
    private String mChallenges[];
    private String mClientApiUrl;
    private CoinbaseConfiguration mCoinbaseConfiguration;
    private boolean mCoinbaseEnabled;
    private String mMerchantAccountId;
    private String mMerchantId;
    private PayPalConfiguration mPayPalConfiguration;
    private boolean mPaypalEnabled;
    private boolean mThreeDSecureEnabled;
    private String mVenmo;

    public Configuration()
    {
    }

    public static Configuration fromJson(String s)
    {
        return (Configuration)(new Gson()).fromJson(s, com/braintreepayments/api/models/Configuration);
    }

    private boolean isChallengePresent(String s)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (mChallenges == null) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (mChallenges.length <= 0) goto _L2; else goto _L3
_L3:
        String as[];
        int i;
        int j;
        as = mChallenges;
        j = as.length;
        i = 0;
_L8:
        flag = flag1;
        if (i >= j) goto _L2; else goto _L4
_L4:
        if (!as[i].equals(s)) goto _L6; else goto _L5
_L5:
        flag = true;
_L2:
        return flag;
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public AnalyticsConfiguration getAnalytics()
    {
        return mAnalyticsConfiguration;
    }

    public AndroidPayConfiguration getAndroidPay()
    {
        if (mAndroidPayConfiguration == null)
        {
            return new AndroidPayConfiguration();
        } else
        {
            return mAndroidPayConfiguration;
        }
    }

    public String getClientApiUrl()
    {
        return mClientApiUrl;
    }

    public CoinbaseConfiguration getCoinbase()
    {
        return mCoinbaseConfiguration;
    }

    public String getMerchantAccountId()
    {
        return mMerchantAccountId;
    }

    public String getMerchantId()
    {
        return mMerchantId;
    }

    public PayPalConfiguration getPayPal()
    {
        return mPayPalConfiguration;
    }

    public String getVenmoState()
    {
        if (mVenmo == null)
        {
            return "off";
        } else
        {
            return mVenmo;
        }
    }

    public boolean isAnalyticsEnabled()
    {
        return mAnalyticsConfiguration != null && !TextUtils.isEmpty(mAnalyticsConfiguration.getUrl());
    }

    public boolean isCoinbaseEnabled()
    {
        return mCoinbaseEnabled && mCoinbaseConfiguration != null;
    }

    public boolean isCvvChallengePresent()
    {
        return isChallengePresent("cvv");
    }

    public boolean isPayPalEnabled()
    {
        return mPaypalEnabled && mPayPalConfiguration != null;
    }

    public boolean isPostalCodeChallengePresent()
    {
        return isChallengePresent("postal_code");
    }

    public boolean isThreeDSecureEnabled()
    {
        return mThreeDSecureEnabled;
    }
}
