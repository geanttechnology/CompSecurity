// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import java.net.URI;
import org.apache.http.client.methods.HttpHead;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            AuthenticatedHttpRequest, AuthenticationMethod

public class AuthenticatedHttpHead extends HttpHead
    implements AuthenticatedHttpRequest
{

    private final AuthenticationMethod mAuthMethod;

    public AuthenticatedHttpHead(AuthenticationMethod authenticationmethod)
    {
        mAuthMethod = authenticationmethod;
    }

    public AuthenticatedHttpHead(String s, AuthenticationMethod authenticationmethod)
    {
        super(s);
        mAuthMethod = authenticationmethod;
    }

    public AuthenticatedHttpHead(URI uri, AuthenticationMethod authenticationmethod)
    {
        super(uri);
        mAuthMethod = authenticationmethod;
    }

    public AuthenticationMethod getAuthenticationMethod()
    {
        return mAuthMethod;
    }
}
