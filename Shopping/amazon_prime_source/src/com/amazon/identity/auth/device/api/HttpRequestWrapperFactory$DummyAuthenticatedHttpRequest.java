// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;


// Referenced classes of package com.amazon.identity.auth.device.api:
//            AuthenticatedHttpRequest, HttpRequestWrapperFactory, AuthenticationMethod

private static class mAuthMethod
    implements AuthenticatedHttpRequest
{

    private final AuthenticationMethod mAuthMethod;

    public AuthenticationMethod getAuthenticationMethod()
    {
        return mAuthMethod;
    }

    public a(AuthenticationMethod authenticationmethod)
    {
        mAuthMethod = authenticationmethod;
    }
}
