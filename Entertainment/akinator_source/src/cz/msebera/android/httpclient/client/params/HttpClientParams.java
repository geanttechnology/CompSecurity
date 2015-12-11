// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.params;

import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;

public class HttpClientParams
{

    private HttpClientParams()
    {
    }

    public static long getConnectionManagerTimeout(HttpParams httpparams)
    {
        Args.notNull(httpparams, "HTTP parameters");
        Long long1 = (Long)httpparams.getParameter("http.conn-manager.timeout");
        if (long1 != null)
        {
            return long1.longValue();
        } else
        {
            return (long)HttpConnectionParams.getConnectionTimeout(httpparams);
        }
    }

    public static String getCookiePolicy(HttpParams httpparams)
    {
        Args.notNull(httpparams, "HTTP parameters");
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
        Args.notNull(httpparams, "HTTP parameters");
        return httpparams.getBooleanParameter("http.protocol.handle-authentication", true);
    }

    public static boolean isRedirecting(HttpParams httpparams)
    {
        Args.notNull(httpparams, "HTTP parameters");
        return httpparams.getBooleanParameter("http.protocol.handle-redirects", true);
    }

    public static void setAuthenticating(HttpParams httpparams, boolean flag)
    {
        Args.notNull(httpparams, "HTTP parameters");
        httpparams.setBooleanParameter("http.protocol.handle-authentication", flag);
    }

    public static void setConnectionManagerTimeout(HttpParams httpparams, long l)
    {
        Args.notNull(httpparams, "HTTP parameters");
        httpparams.setLongParameter("http.conn-manager.timeout", l);
    }

    public static void setCookiePolicy(HttpParams httpparams, String s)
    {
        Args.notNull(httpparams, "HTTP parameters");
        httpparams.setParameter("http.protocol.cookie-policy", s);
    }

    public static void setRedirecting(HttpParams httpparams, boolean flag)
    {
        Args.notNull(httpparams, "HTTP parameters");
        httpparams.setBooleanParameter("http.protocol.handle-redirects", flag);
    }
}
