// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.a;

import com.target.mothership.services.k;

public class z extends k
{

    private static final String NO = "N";
    private String mEmailId;
    private String mFirstName;
    private String mIsSelfAddress;
    private String mLastName;
    private String mMobileNumber;

    public z(String s, String s1)
    {
        mIsSelfAddress = "N";
        mFirstName = s;
        mLastName = s1;
    }

    public void a(String s)
    {
        mEmailId = s;
    }

    public void b(String s)
    {
        mMobileNumber = s;
    }
}
