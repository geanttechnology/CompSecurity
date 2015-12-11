// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import com.amazon.identity.kcpsdk.auth.AuthenticationChallenge;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AuthenticateAccountAction

public static class error
{

    public final String accessToken;
    public final AuthenticationChallenge challenge;
    public final String directedId;
    public final com.amazon.identity.auth.device.framework.e error;

    public boolean isError()
    {
        return error != null;
    }

    public (com.amazon.identity.auth.device.framework. )
    {
        this(null, null, null, );
    }

    public <init>(AuthenticationChallenge authenticationchallenge, com.amazon.identity.auth.device.framework. )
    {
        this(null, null, authenticationchallenge, );
    }

    public <init>(String s, String s1)
    {
        this(s, s1, null, null);
    }

    private <init>(String s, String s1, AuthenticationChallenge authenticationchallenge, com.amazon.identity.auth.device.framework. )
    {
        accessToken = s;
        directedId = s1;
        challenge = authenticationchallenge;
        error = ;
    }
}
