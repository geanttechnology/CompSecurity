// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.util.Collection;
import java.util.Map;
import java.util.Queue;

// Referenced classes of package cz.msebera.android.httpclient.impl.client:
//            AuthenticationStrategyImpl

public class ProxyAuthenticationStrategy extends AuthenticationStrategyImpl
{

    public static final ProxyAuthenticationStrategy INSTANCE = new ProxyAuthenticationStrategy();

    public ProxyAuthenticationStrategy()
    {
        super(407, "Proxy-Authenticate");
    }

    public volatile void authFailed(HttpHost httphost, AuthScheme authscheme, HttpContext httpcontext)
    {
        super.authFailed(httphost, authscheme, httpcontext);
    }

    public volatile void authSucceeded(HttpHost httphost, AuthScheme authscheme, HttpContext httpcontext)
    {
        super.authSucceeded(httphost, authscheme, httpcontext);
    }

    public volatile Map getChallenges(HttpHost httphost, HttpResponse httpresponse, HttpContext httpcontext)
        throws MalformedChallengeException
    {
        return super.getChallenges(httphost, httpresponse, httpcontext);
    }

    Collection getPreferredAuthSchemes(RequestConfig requestconfig)
    {
        return requestconfig.getProxyPreferredAuthSchemes();
    }

    public volatile boolean isAuthenticationRequested(HttpHost httphost, HttpResponse httpresponse, HttpContext httpcontext)
    {
        return super.isAuthenticationRequested(httphost, httpresponse, httpcontext);
    }

    public volatile Queue select(Map map, HttpHost httphost, HttpResponse httpresponse, HttpContext httpcontext)
        throws MalformedChallengeException
    {
        return super.select(map, httphost, httpresponse, httpcontext);
    }

}
