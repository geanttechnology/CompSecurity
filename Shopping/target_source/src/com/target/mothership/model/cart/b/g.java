// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.b;


public class g
{

    private String mEmailId;
    private String mFirstName;
    private String mLastName;
    private String mMobileNumber;

    public g(String s, String s1, String s2, String s3)
    {
        mFirstName = s;
        mLastName = s1;
        mEmailId = s2;
        mMobileNumber = s3;
    }

    public String a()
    {
        return mFirstName;
    }

    public String b()
    {
        return mLastName;
    }

    public String c()
    {
        return mEmailId;
    }

    public String d()
    {
        return mMobileNumber;
    }
}
