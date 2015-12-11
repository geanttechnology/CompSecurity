// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.config;

import cz.msebera.android.httpclient.HttpHost;
import java.net.InetAddress;
import java.util.Collection;

// Referenced classes of package cz.msebera.android.httpclient.client.config:
//            RequestConfig

public static class socketTimeout
{

    private boolean authenticationEnabled;
    private boolean circularRedirectsAllowed;
    private int connectTimeout;
    private int connectionRequestTimeout;
    private String cookieSpec;
    private boolean expectContinueEnabled;
    private InetAddress localAddress;
    private int maxRedirects;
    private HttpHost proxy;
    private Collection proxyPreferredAuthSchemes;
    private boolean redirectsEnabled;
    private boolean relativeRedirectsAllowed;
    private int socketTimeout;
    private boolean staleConnectionCheckEnabled;
    private Collection targetPreferredAuthSchemes;

    public RequestConfig build()
    {
        return new RequestConfig(expectContinueEnabled, proxy, localAddress, staleConnectionCheckEnabled, cookieSpec, redirectsEnabled, relativeRedirectsAllowed, circularRedirectsAllowed, maxRedirects, authenticationEnabled, targetPreferredAuthSchemes, proxyPreferredAuthSchemes, connectionRequestTimeout, connectTimeout, socketTimeout);
    }

    public socketTimeout setAuthenticationEnabled(boolean flag)
    {
        authenticationEnabled = flag;
        return this;
    }

    public authenticationEnabled setCircularRedirectsAllowed(boolean flag)
    {
        circularRedirectsAllowed = flag;
        return this;
    }

    public circularRedirectsAllowed setConnectTimeout(int i)
    {
        connectTimeout = i;
        return this;
    }

    public connectTimeout setConnectionRequestTimeout(int i)
    {
        connectionRequestTimeout = i;
        return this;
    }

    public connectionRequestTimeout setCookieSpec(String s)
    {
        cookieSpec = s;
        return this;
    }

    public cookieSpec setExpectContinueEnabled(boolean flag)
    {
        expectContinueEnabled = flag;
        return this;
    }

    public expectContinueEnabled setLocalAddress(InetAddress inetaddress)
    {
        localAddress = inetaddress;
        return this;
    }

    public localAddress setMaxRedirects(int i)
    {
        maxRedirects = i;
        return this;
    }

    public maxRedirects setProxy(HttpHost httphost)
    {
        proxy = httphost;
        return this;
    }

    public proxy setProxyPreferredAuthSchemes(Collection collection)
    {
        proxyPreferredAuthSchemes = collection;
        return this;
    }

    public proxyPreferredAuthSchemes setRedirectsEnabled(boolean flag)
    {
        redirectsEnabled = flag;
        return this;
    }

    public redirectsEnabled setRelativeRedirectsAllowed(boolean flag)
    {
        relativeRedirectsAllowed = flag;
        return this;
    }

    public relativeRedirectsAllowed setSocketTimeout(int i)
    {
        socketTimeout = i;
        return this;
    }

    public socketTimeout setStaleConnectionCheckEnabled(boolean flag)
    {
        staleConnectionCheckEnabled = flag;
        return this;
    }

    public staleConnectionCheckEnabled setTargetPreferredAuthSchemes(Collection collection)
    {
        targetPreferredAuthSchemes = collection;
        return this;
    }

    ()
    {
        staleConnectionCheckEnabled = true;
        redirectsEnabled = true;
        maxRedirects = 50;
        relativeRedirectsAllowed = true;
        authenticationEnabled = true;
        connectionRequestTimeout = -1;
        connectTimeout = -1;
        socketTimeout = -1;
    }
}
