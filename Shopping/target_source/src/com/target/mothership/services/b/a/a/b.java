// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.b.a.a;


public class b
{

    private String mAccessKey;
    private String mFirstName;
    private String mLastName;
    private String mPeriod;
    private String mTimeZone;
    private String mZipCode;

    public b(String s, String s1, String s2, String s3, String s4, String s5)
    {
        mAccessKey = s;
        mFirstName = s1;
        mLastName = s2;
        mZipCode = s3;
        mTimeZone = s4;
        mPeriod = s5;
    }

    public String a()
    {
        return mAccessKey;
    }

    public String b()
    {
        return mFirstName;
    }

    public String c()
    {
        return mLastName;
    }

    public String d()
    {
        return mZipCode;
    }

    public String e()
    {
        return mTimeZone;
    }

    public String f()
    {
        return mPeriod;
    }
}
