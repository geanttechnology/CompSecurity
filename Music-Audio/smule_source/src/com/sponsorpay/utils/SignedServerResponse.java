// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.utils;


public class SignedServerResponse
{

    private String mResponseBody;
    private String mResponseSignature;
    private int mStatusCode;

    public SignedServerResponse(int i, String s, String s1)
    {
        mStatusCode = i;
        mResponseBody = s;
        mResponseSignature = s1;
    }

    public String getResponseBody()
    {
        return mResponseBody;
    }

    public String getResponseSignature()
    {
        return mResponseSignature;
    }

    public int getStatusCode()
    {
        return mStatusCode;
    }
}
