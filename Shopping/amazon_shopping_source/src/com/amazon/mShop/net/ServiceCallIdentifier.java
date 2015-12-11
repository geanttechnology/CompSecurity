// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;


public class ServiceCallIdentifier
{

    private final String mMethodName;
    private final String mServiceName;

    public ServiceCallIdentifier(String s, String s1)
    {
        mServiceName = s;
        mMethodName = s1;
    }

    public String getMethodName()
    {
        return mMethodName;
    }

    public String getServiceName()
    {
        return mServiceName;
    }
}
