// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


public class BrainTreePayment
{

    String cardholder_name;
    String cc_bin;
    String cc_token;
    String cc_type;
    int expiration_month;
    int expiration_year;
    String expiry_date;
    String last_4;
    String processor_authorization_code;
    String processor_response_text;
    String transaction_id;
    String transaction_type;

    public BrainTreePayment()
    {
    }

    public String getCCToken()
    {
        return cc_token;
    }

    public String getCCType()
    {
        return cc_type;
    }

    public int getExpirationMonth()
    {
        return expiration_month;
    }

    public int getExpirationYear()
    {
        return expiration_year;
    }

    public String getExpiryDate()
    {
        return expiry_date;
    }

    public String getLast4Digits()
    {
        return last_4;
    }

    public String getProcessorResponseText()
    {
        return processor_response_text;
    }
}
