// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.a;

import com.target.mothership.services.k;

public class aa extends k
{

    private static final String YES = "Y";
    private String mEmailId;
    private String mFirstName;
    private String mIsSelfAddress;
    private String mLastName;
    private String mMobile;

    public aa(String s, String s1, String s2)
    {
        mIsSelfAddress = "Y";
        mFirstName = s;
        mLastName = s1;
        mEmailId = s2;
    }

    public void a(String s)
    {
        mMobile = s;
    }
}
