// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.auth.AuthProtocolState;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.client.AuthCache;
import cz.msebera.android.httpclient.conn.scheme.Scheme;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.client.BasicAuthCache;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

public class ResponseAuthCache
    implements HttpResponseInterceptor
{

    public HttpClientAndroidLog log;

    public ResponseAuthCache()
    {
        log = new HttpClientAndroidLog(getClass());
    }

    private void cache(AuthCache authcache, HttpHost httphost, AuthScheme authscheme)
    {
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Caching '").append(authscheme.getSchemeName()).append("' auth scheme for ").append(httphost).toString());
        }
        authcache.put(httphost, authscheme);
    }

    private boolean isCachable(AuthState authstate)
    {
        authstate = authstate.getAuthScheme();
        if (authstate != null && authstate.isComplete())
        {
            if ((authstate = authstate.getSchemeName()).equalsIgnoreCase("Basic") || authstate.equalsIgnoreCase("Digest"))
            {
                return true;
            }
        }
        return false;
    }

    private void uncache(AuthCache authcache, HttpHost httphost, AuthScheme authscheme)
    {
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Removing from cache '").append(authscheme.getSchemeName()).append("' auth scheme for ").append(httphost).toString());
        }
        authcache.remove(httphost);
    }

    public void process(HttpResponse httpresponse, HttpContext httpcontext)
        throws HttpException, IOException
    {
        Object obj;
        Object obj1;
        AuthState authstate;
        Args.notNull(httpresponse, "HTTP request");
        Args.notNull(httpcontext, "HTTP context");
        obj = (AuthCache)httpcontext.getAttribute("http.auth.auth-cache");
        obj1 = (HttpHost)httpcontext.getAttribute("http.target_host");
        authstate = (AuthState)httpcontext.getAttribute("http.auth.target-scope");
        httpresponse = ((HttpResponse) (obj));
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        httpresponse = ((HttpResponse) (obj));
        if (authstate == null) goto _L2; else goto _L3
_L3:
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Target auth state: ").append(authstate.getState()).toString());
        }
        httpresponse = ((HttpResponse) (obj));
        if (!isCachable(authstate)) goto _L2; else goto _L4
_L4:
        HttpHost httphost;
        httpresponse = (SchemeRegistry)httpcontext.getAttribute("http.scheme-registry");
        httphost = ((HttpHost) (obj1));
        if (((HttpHost) (obj1)).getPort() < 0)
        {
            httpresponse = httpresponse.getScheme(((HttpHost) (obj1)));
            httphost = new HttpHost(((HttpHost) (obj1)).getHostName(), httpresponse.resolvePort(((HttpHost) (obj1)).getPort()), ((HttpHost) (obj1)).getSchemeName());
        }
        httpresponse = ((HttpResponse) (obj));
        if (obj == null)
        {
            httpresponse = new BasicAuthCache();
            httpcontext.setAttribute("http.auth.auth-cache", httpresponse);
        }
        static class _cls1
        {

            static final int $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[];

            static 
            {
                $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState = new int[AuthProtocolState.values().length];
                try
                {
                    $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.CHALLENGED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[AuthProtocolState.FAILURE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.cz.msebera.android.httpclient.auth.AuthProtocolState[authstate.getState().ordinal()];
        JVM INSTR tableswitch 1 2: default 232
    //                   1 377
    //                   2 392;
           goto _L2 _L5 _L6
_L2:
        httphost = (HttpHost)httpcontext.getAttribute("http.proxy_host");
        obj1 = (AuthState)httpcontext.getAttribute("http.auth.proxy-scope");
        if (httphost == null || obj1 == null) goto _L8; else goto _L7
_L7:
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Proxy auth state: ").append(((AuthState) (obj1)).getState()).toString());
        }
        if (!isCachable(((AuthState) (obj1)))) goto _L8; else goto _L9
_L9:
        obj = httpresponse;
        if (httpresponse == null)
        {
            obj = new BasicAuthCache();
            httpcontext.setAttribute("http.auth.auth-cache", obj);
        }
        _cls1..SwitchMap.cz.msebera.android.httpclient.auth.AuthProtocolState[((AuthState) (obj1)).getState().ordinal()];
        JVM INSTR tableswitch 1 2: default 376
    //                   1 407
    //                   2 420;
           goto _L8 _L10 _L11
_L8:
        return;
_L5:
        cache(httpresponse, httphost, authstate.getAuthScheme());
          goto _L2
_L6:
        uncache(httpresponse, httphost, authstate.getAuthScheme());
          goto _L2
_L10:
        cache(((AuthCache) (obj)), httphost, ((AuthState) (obj1)).getAuthScheme());
        return;
_L11:
        uncache(((AuthCache) (obj)), httphost, ((AuthState) (obj1)).getAuthScheme());
        return;
    }
}
