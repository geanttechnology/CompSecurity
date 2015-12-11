// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.auth.params;

import com.comcast.cim.httpcomponentsandroid.params.HttpParams;

public final class AuthParams
{

    private AuthParams()
    {
    }

    public static String getCredentialCharset(HttpParams httpparams)
    {
        if (httpparams == null)
        {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        String s = (String)httpparams.getParameter("http.auth.credential-charset");
        httpparams = s;
        if (s == null)
        {
            httpparams = "US-ASCII";
        }
        return httpparams;
    }

    public static void setCredentialCharset(HttpParams httpparams, String s)
    {
        if (httpparams == null)
        {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        } else
        {
            httpparams.setParameter("http.auth.credential-charset", s);
            return;
        }
    }
}
