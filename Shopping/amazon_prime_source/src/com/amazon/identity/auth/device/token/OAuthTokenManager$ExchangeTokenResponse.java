// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;


// Referenced classes of package com.amazon.identity.auth.device.token:
//            OAuthTokenManager

public static class mRefreshToken
{

    final String mAccessToken;
    final int mExpiresIn;
    final String mRefreshToken;

    public (String s, int i)
    {
        this(s, i, null);
    }

    public <init>(String s, int i, String s1)
    {
        mAccessToken = s;
        mExpiresIn = i;
        mRefreshToken = s1;
    }
}
