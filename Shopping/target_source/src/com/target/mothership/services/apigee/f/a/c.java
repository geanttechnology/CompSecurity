// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.f.a;

import com.target.mothership.services.k;

public class c extends k
{

    private String mGrantType;
    private String mRefreshToken;

    public c(String s)
    {
        mGrantType = "refresh_token";
        mRefreshToken = s;
    }
}
