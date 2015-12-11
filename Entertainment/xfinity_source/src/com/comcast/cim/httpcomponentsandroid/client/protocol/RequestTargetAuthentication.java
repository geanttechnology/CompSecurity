// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.client.protocol;

import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.HttpRequestInterceptor;
import com.comcast.cim.httpcomponentsandroid.RequestLine;
import com.comcast.cim.httpcomponentsandroid.auth.AuthScheme;
import com.comcast.cim.httpcomponentsandroid.auth.AuthState;
import com.comcast.cim.httpcomponentsandroid.auth.AuthenticationException;
import com.comcast.cim.httpcomponentsandroid.auth.ContextAwareAuthScheme;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RequestTargetAuthentication
    implements HttpRequestInterceptor
{

    private final Log log = LogFactory.getLog(getClass());

    public RequestTargetAuthentication()
    {
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        if (httprequest == null)
        {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        if (httpcontext == null)
        {
            throw new IllegalArgumentException("HTTP context may not be null");
        }
        break MISSING_BLOCK_LABEL_28;
_L2:
        AuthState authstate;
        AuthScheme authscheme;
        com.comcast.cim.httpcomponentsandroid.auth.Credentials credentials;
        do
        {
            do
            {
                do
                {
                    return;
                } while (httprequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") || httprequest.containsHeader("Authorization"));
                authstate = (AuthState)httpcontext.getAttribute("http.auth.target-scope");
                if (authstate == null)
                {
                    log.debug("Target auth state not set in the context");
                    return;
                }
                authscheme = authstate.getAuthScheme();
            } while (authscheme == null);
            credentials = authstate.getCredentials();
            if (credentials == null)
            {
                log.debug("User credentials not available");
                return;
            }
        } while (authstate.getAuthScope() == null && authscheme.isConnectionBased());
        if (!(authscheme instanceof ContextAwareAuthScheme))
        {
            break MISSING_BLOCK_LABEL_214;
        }
        httpcontext = ((ContextAwareAuthScheme)authscheme).authenticate(credentials, httprequest, httpcontext);
_L3:
        httprequest.addHeader(httpcontext);
        return;
        httprequest;
        if (!log.isErrorEnabled()) goto _L2; else goto _L1
_L1:
        log.error((new StringBuilder()).append("Authentication error: ").append(httprequest.getMessage()).toString());
        return;
        httpcontext = authscheme.authenticate(credentials, httprequest);
          goto _L3
    }
}
