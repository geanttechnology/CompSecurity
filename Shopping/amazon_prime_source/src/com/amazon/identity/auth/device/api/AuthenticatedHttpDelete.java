// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import java.net.URI;
import org.apache.http.client.methods.HttpDelete;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            AuthenticatedHttpRequest, AuthenticationMethod

public class AuthenticatedHttpDelete extends HttpDelete
    implements AuthenticatedHttpRequest
{

    private final AuthenticationMethod mAuthMethod;

    public AuthenticatedHttpDelete(AuthenticationMethod authenticationmethod)
    {
        mAuthMethod = authenticationmethod;
    }

    public AuthenticatedHttpDelete(String s, AuthenticationMethod authenticationmethod)
    {
        super(s);
        mAuthMethod = authenticationmethod;
    }

    public AuthenticatedHttpDelete(URI uri, AuthenticationMethod authenticationmethod)
    {
        super(uri);
        mAuthMethod = authenticationmethod;
    }

    public AuthenticationMethod getAuthenticationMethod()
    {
        return mAuthMethod;
    }
}
