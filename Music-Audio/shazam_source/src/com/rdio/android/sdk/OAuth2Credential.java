// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk;

import com.google.api.a.a.a.i;

public class OAuth2Credential
{

    public final String accessToken;
    public final Long expirationTimeMSec;
    public final String refreshToken;

    public OAuth2Credential(i j)
    {
        this(j.a(), j.b(), j.d());
    }

    public OAuth2Credential(String s, String s1, Long long1)
    {
        accessToken = s;
        refreshToken = s1;
        expirationTimeMSec = long1;
    }
}
