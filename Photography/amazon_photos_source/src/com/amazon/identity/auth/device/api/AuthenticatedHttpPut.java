// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import java.net.URI;
import org.apache.http.client.methods.HttpPut;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            AuthenticatedHttpRequest, AuthenticationMethod

public class AuthenticatedHttpPut extends HttpPut
    implements AuthenticatedHttpRequest
{

    private final AuthenticationMethod mAuthMethod;

    public AuthenticatedHttpPut(AuthenticationMethod authenticationmethod)
    {
        mAuthMethod = authenticationmethod;
    }

    public AuthenticatedHttpPut(String s, AuthenticationMethod authenticationmethod)
    {
        super(s);
        mAuthMethod = authenticationmethod;
    }

    public AuthenticatedHttpPut(URI uri, AuthenticationMethod authenticationmethod)
    {
        super(uri);
        mAuthMethod = authenticationmethod;
    }

    public AuthenticationMethod getAuthenticationMethod()
    {
        return mAuthMethod;
    }
}
