// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.f.b;

import java.util.List;

public class i
{

    private String mAddressId;
    private List mAddressLines;
    private String mAddressType;
    private String mCity;
    private String mFirstName;
    private String mLastName;
    private String mMarkForDeleteString;
    private String mMiddleName;
    private String mNickName;
    private String mPhone1;
    private String mPhone1Type;
    private String mPrimary;
    private String mState;
    private String mZipCode;

    public i()
    {
    }

    public String a()
    {
        return mAddressId;
    }

    public List b()
    {
        return mAddressLines;
    }

    public String c()
    {
        return mAddressType;
    }

    public String d()
    {
        return mCity;
    }

    public String e()
    {
        return mState;
    }

    public String f()
    {
        return mZipCode;
    }

    public String g()
    {
        return mFirstName;
    }

    public String h()
    {
        return mLastName;
    }

    public String i()
    {
        return mMiddleName;
    }

    public String j()
    {
        return mPhone1;
    }

    public String k()
    {
        return mPhone1Type;
    }

    public Boolean l()
    {
        if (mPrimary != null)
        {
            return Boolean.valueOf(mPrimary.equals("true"));
        } else
        {
            return null;
        }
    }
}
