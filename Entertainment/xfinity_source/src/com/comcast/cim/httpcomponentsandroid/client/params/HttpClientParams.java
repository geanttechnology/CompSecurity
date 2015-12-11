// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.client.params;

import com.comcast.cim.httpcomponentsandroid.params.HttpParams;

public class HttpClientParams
{

    private HttpClientParams()
    {
    }

    public static String getCookiePolicy(HttpParams httpparams)
    {
        if (httpparams == null)
        {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        String s = (String)httpparams.getParameter("http.protocol.cookie-policy");
        httpparams = s;
        if (s == null)
        {
            httpparams = "best-match";
        }
        return httpparams;
    }

    public static boolean isAuthenticating(HttpParams httpparams)
    {
        if (httpparams == null)
        {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        } else
        {
            return httpparams.getBooleanParameter("http.protocol.handle-authentication", true);
        }
    }

    public static boolean isRedirecting(HttpParams httpparams)
    {
        if (httpparams == null)
        {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        } else
        {
            return httpparams.getBooleanParameter("http.protocol.handle-redirects", true);
        }
    }
}
