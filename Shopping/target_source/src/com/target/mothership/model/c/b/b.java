// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.c.b;

import com.google.a.a.e;
import com.target.mothership.model.c.c.a;

public class b
    implements a
{

    public String mCity;
    public String mCountry;
    private Double mLatitude;
    private Double mLongitude;
    public String mState;

    b()
    {
    }

    public e a()
    {
        return com.google.a.a.e.c(mState);
    }

    public void a(Double double1)
    {
        mLatitude = double1;
    }

    public void a(String s)
    {
        mCity = s;
    }

    public e b()
    {
        return com.google.a.a.e.c(mCity);
    }

    public void b(Double double1)
    {
        mLongitude = double1;
    }

    public void b(String s)
    {
        mState = s;
    }

    public e c()
    {
        return com.google.a.a.e.c(mCountry);
    }

    public void c(String s)
    {
        mCountry = s;
    }

    public e d()
    {
        return com.google.a.a.e.c(mLatitude);
    }

    public e e()
    {
        return com.google.a.a.e.c(mLongitude);
    }
}
