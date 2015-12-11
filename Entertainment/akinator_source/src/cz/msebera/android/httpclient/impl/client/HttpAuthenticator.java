// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;

public class HttpAuthenticator extends cz.msebera.android.httpclient.impl.auth.HttpAuthenticator
{

    public HttpAuthenticator()
    {
    }

    public HttpAuthenticator(HttpClientAndroidLog httpclientandroidlog)
    {
        super(httpclientandroidlog);
    }

    public boolean authenticate(HttpHost httphost, HttpResponse httpresponse, AuthenticationStrategy authenticationstrategy, AuthState authstate, HttpContext httpcontext)
    {
        return handleAuthChallenge(httphost, httpresponse, authenticationstrategy, authstate, httpcontext);
    }
}
