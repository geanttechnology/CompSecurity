// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.params;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.params.HttpParams;
import java.net.InetAddress;
import java.util.Collection;

public final class HttpClientParamConfig
{

    private HttpClientParamConfig()
    {
    }

    public static RequestConfig getRequestConfig(HttpParams httpparams)
    {
        cz.msebera.android.httpclient.client.config.RequestConfig.Builder builder = RequestConfig.custom().setSocketTimeout(httpparams.getIntParameter("http.socket.timeout", 0)).setStaleConnectionCheckEnabled(httpparams.getBooleanParameter("http.connection.stalecheck", true)).setConnectTimeout(httpparams.getIntParameter("http.connection.timeout", 0)).setExpectContinueEnabled(httpparams.getBooleanParameter("http.protocol.expect-continue", false)).setProxy((HttpHost)httpparams.getParameter("http.route.default-proxy")).setLocalAddress((InetAddress)httpparams.getParameter("http.route.local-address")).setProxyPreferredAuthSchemes((Collection)httpparams.getParameter("http.auth.proxy-scheme-pref")).setTargetPreferredAuthSchemes((Collection)httpparams.getParameter("http.auth.target-scheme-pref")).setAuthenticationEnabled(httpparams.getBooleanParameter("http.protocol.handle-authentication", true)).setCircularRedirectsAllowed(httpparams.getBooleanParameter("http.protocol.allow-circular-redirects", false)).setConnectionRequestTimeout((int)httpparams.getLongParameter("http.conn-manager.timeout", 0L)).setCookieSpec((String)httpparams.getParameter("http.protocol.cookie-policy")).setMaxRedirects(httpparams.getIntParameter("http.protocol.max-redirects", 50)).setRedirectsEnabled(httpparams.getBooleanParameter("http.protocol.handle-redirects", true));
        boolean flag;
        if (!httpparams.getBooleanParameter("http.protocol.reject-relative-redirect", false))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return builder.setRelativeRedirectsAllowed(flag).build();
    }
}
