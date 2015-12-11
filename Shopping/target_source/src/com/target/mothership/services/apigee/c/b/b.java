// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.b;

import com.target.mothership.util.o;
import java.util.List;

public class b
{

    private String mAddressId;
    private List mAddressLines;
    private String mBillingAddressId;
    private String mCity;
    private String mCountry;
    private String mFirstName;
    private String mLastName;
    private String mMiddleName;
    private String mPhone;
    private String mPostalCode;
    private String mState;
    private String mStateOrProvinceName;
    private String mZipCode;

    public b()
    {
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
        return mMiddleName;
    }

    public String d()
    {
        return mAddressId;
    }

    public String e()
    {
        return mBillingAddressId;
    }

    public List f()
    {
        return mAddressLines;
    }

    public String g()
    {
        return mCity;
    }

    public String h()
    {
        if (o.g(mState))
        {
            return mState;
        } else
        {
            return mStateOrProvinceName;
        }
    }

    public String i()
    {
        return mCountry;
    }

    public String j()
    {
        if (o.g(mPostalCode))
        {
            return mPostalCode;
        } else
        {
            return mZipCode;
        }
    }

    public String k()
    {
        return mPhone;
    }
}
