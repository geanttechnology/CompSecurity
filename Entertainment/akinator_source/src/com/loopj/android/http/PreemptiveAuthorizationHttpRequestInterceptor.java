// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.impl.auth.BasicScheme;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;

public class PreemptiveAuthorizationHttpRequestInterceptor
    implements HttpRequestInterceptor
{

    public PreemptiveAuthorizationHttpRequestInterceptor()
    {
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        httprequest = (AuthState)httpcontext.getAttribute("http.auth.target-scope");
        CredentialsProvider credentialsprovider = (CredentialsProvider)httpcontext.getAttribute("http.auth.credentials-provider");
        httpcontext = (HttpHost)httpcontext.getAttribute("http.target_host");
        if (httprequest.getAuthScheme() == null)
        {
            httpcontext = credentialsprovider.getCredentials(new AuthScope(httpcontext.getHostName(), httpcontext.getPort()));
            if (httpcontext != null)
            {
                httprequest.setAuthScheme(new BasicScheme());
                httprequest.setCredentials(httpcontext);
            }
        }
    }
}
