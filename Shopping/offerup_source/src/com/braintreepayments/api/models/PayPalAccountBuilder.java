// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api.models;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.braintreepayments.api.models:
//            PayPalAccount, Metadata, PaymentMethodOptions, PaymentMethod

public class PayPalAccountBuilder
    implements PaymentMethod.Builder
{

    private String mAuthorizationCode;
    private String mCorrelationId;
    private String mEmail;
    private String mIntegration;
    private PaymentMethodOptions mPaymentMethodOptions;
    private String mSource;

    public PayPalAccountBuilder()
    {
        mIntegration = "custom";
    }

    public PayPalAccountBuilder authorizationCode(String s)
    {
        mAuthorizationCode = s;
        return this;
    }

    public PayPalAccount build()
    {
        PayPalAccount paypalaccount = new PayPalAccount();
        paypalaccount.setConsentCode(mAuthorizationCode);
        paypalaccount.setCorrelationId(mCorrelationId);
        paypalaccount.setOptions(mPaymentMethodOptions);
        paypalaccount.setSource(mSource);
        return paypalaccount;
    }

    public volatile PaymentMethod build()
    {
        return build();
    }

    public PayPalAccountBuilder correlationId(String s)
    {
        mCorrelationId = s;
        return this;
    }

    public PayPalAccountBuilder email(String s)
    {
        mEmail = s;
        return this;
    }

    public PayPalAccount fromJson(String s)
    {
        s = PayPalAccount.fromJson(s);
        s.setEmail(mEmail);
        return s;
    }

    public volatile PaymentMethod fromJson(String s)
    {
        return fromJson(s);
    }

    public String getApiPath()
    {
        return "paypal_accounts";
    }

    public String getApiResource()
    {
        return "paypalAccounts";
    }

    public PayPalAccountBuilder integration(String s)
    {
        mIntegration = s;
        return this;
    }

    public volatile PaymentMethod.Builder integration(String s)
    {
        return integration(s);
    }

    public PayPalAccountBuilder source(String s)
    {
        mSource = s;
        return this;
    }

    public volatile PaymentMethod.Builder source(String s)
    {
        return source(s);
    }

    public Map toJson()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("paypalAccount", build());
        hashmap.put("_meta", new Metadata(mIntegration, mSource));
        return hashmap;
    }

    public String toJsonString()
    {
        return (new Gson()).toJson(toJson());
    }

    public PayPalAccountBuilder validate(boolean flag)
    {
        mPaymentMethodOptions = new PaymentMethodOptions();
        mPaymentMethodOptions.setValidate(flag);
        return this;
    }

    public volatile PaymentMethod.Builder validate(boolean flag)
    {
        return validate(flag);
    }
}
