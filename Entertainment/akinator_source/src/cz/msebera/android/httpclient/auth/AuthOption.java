// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.util.Args;

// Referenced classes of package cz.msebera.android.httpclient.auth:
//            AuthScheme, Credentials

public final class AuthOption
{

    private final AuthScheme authScheme;
    private final Credentials creds;

    public AuthOption(AuthScheme authscheme, Credentials credentials)
    {
        Args.notNull(authscheme, "Auth scheme");
        Args.notNull(credentials, "User credentials");
        authScheme = authscheme;
        creds = credentials;
    }

    public AuthScheme getAuthScheme()
    {
        return authScheme;
    }

    public Credentials getCredentials()
    {
        return creds;
    }

    public String toString()
    {
        return authScheme.toString();
    }
}
