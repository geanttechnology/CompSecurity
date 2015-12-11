// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.a;


public class k
{

    private String mAddressId;
    private String mCity;
    private String mEmailId;
    private String mFromName;
    private String mOrderItemId;
    private String mPhone;
    private String mShipModeId;
    private String mState;
    private String mToName;
    private String mZipCode;

    public k(String s)
    {
        mOrderItemId = s;
    }

    public void a(String s)
    {
        mShipModeId = s;
    }

    public void b(String s)
    {
        mAddressId = s;
    }

    public void c(String s)
    {
        mFromName = s;
    }

    public void d(String s)
    {
        mToName = s;
    }

    public void e(String s)
    {
        mPhone = s;
    }

    public void f(String s)
    {
        mEmailId = s;
    }

    public void g(String s)
    {
        mZipCode = s;
    }

    public void h(String s)
    {
        mCity = s;
    }

    public void i(String s)
    {
        mState = s;
    }
}
