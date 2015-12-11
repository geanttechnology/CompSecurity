// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;


public class PaymentToken
{

    public final String appNonce;
    public final String deviceNonce;
    public final String deviceReferenceToken;
    public final boolean expressCheckoutAvailable;
    public final boolean expressCheckoutEnabled;
    public final String expressCheckoutUser;

    public PaymentToken(String s, String s1, String s2, String s3, boolean flag, boolean flag1)
    {
        appNonce = s;
        deviceNonce = s1;
        deviceReferenceToken = s2;
        expressCheckoutUser = s3;
        expressCheckoutAvailable = flag;
        expressCheckoutEnabled = flag1;
    }
}
