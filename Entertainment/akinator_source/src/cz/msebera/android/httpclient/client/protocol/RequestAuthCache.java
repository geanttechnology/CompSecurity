// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.auth.AuthProtocolState;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.client.AuthCache;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.conn.routing.RouteInfo;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.client.protocol:
//            HttpClientContext

public class RequestAuthCache
    implements HttpRequestInterceptor
{

    public HttpClientAndroidLog log;

    public RequestAuthCache()
    {
        log = new HttpClientAndroidLog(getClass());
    }

    private void doPreemptiveAuth(HttpHost httphost, AuthScheme authscheme, AuthState authstate, CredentialsProvider credentialsprovider)
    {
        String s = authscheme.getSchemeName();
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Re-using cached '").append(s).append("' auth scheme for ").append(httphost).toString());
        }
        httphost = credentialsprovider.getCredentials(new AuthScope(httphost, AuthScope.ANY_REALM, s));
        if (httphost != null)
        {
            if ("BASIC".equalsIgnoreCase(authscheme.getSchemeName()))
            {
                authstate.setState(AuthProtocolState.CHALLENGED);
            } else
            {
                authstate.setState(AuthProtocolState.SUCCESS);
            }
            authstate.update(authscheme, httphost);
            return;
        } else
        {
            log.debug("No credentials for preemptive authentication");
            return;
        }
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        Args.notNull(httprequest, "HTTP request");
        Args.notNull(httpcontext, "HTTP context");
        HttpClientContext httpclientcontext = HttpClientContext.adapt(httpcontext);
        Object obj = httpclientcontext.getAuthCache();
        if (obj == null)
        {
            log.debug("Auth cache not set in the context");
        } else
        {
            CredentialsProvider credentialsprovider = httpclientcontext.getCredentialsProvider();
            if (credentialsprovider == null)
            {
                log.debug("Credentials provider not set in the context");
                return;
            }
            RouteInfo routeinfo = httpclientcontext.getHttpRoute();
            if (routeinfo == null)
            {
                log.debug("Route info not set in the context");
                return;
            }
            httpcontext = httpclientcontext.getTargetHost();
            if (httpcontext == null)
            {
                log.debug("Target host not set in the context");
                return;
            }
            httprequest = httpcontext;
            if (httpcontext.getPort() < 0)
            {
                httprequest = new HttpHost(httpcontext.getHostName(), routeinfo.getTargetHost().getPort(), httpcontext.getSchemeName());
            }
            httpcontext = httpclientcontext.getTargetAuthState();
            if (httpcontext != null && httpcontext.getState() == AuthProtocolState.UNCHALLENGED)
            {
                AuthScheme authscheme = ((AuthCache) (obj)).get(httprequest);
                if (authscheme != null)
                {
                    doPreemptiveAuth(httprequest, authscheme, httpcontext, credentialsprovider);
                }
            }
            httprequest = routeinfo.getProxyHost();
            httpcontext = httpclientcontext.getProxyAuthState();
            if (httprequest != null && httpcontext != null && httpcontext.getState() == AuthProtocolState.UNCHALLENGED)
            {
                obj = ((AuthCache) (obj)).get(httprequest);
                if (obj != null)
                {
                    doPreemptiveAuth(httprequest, ((AuthScheme) (obj)), httpcontext, credentialsprovider);
                    return;
                }
            }
        }
    }
}
