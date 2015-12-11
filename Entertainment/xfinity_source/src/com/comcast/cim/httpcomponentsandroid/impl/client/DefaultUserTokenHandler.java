// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client;

import com.comcast.cim.httpcomponentsandroid.auth.AuthScheme;
import com.comcast.cim.httpcomponentsandroid.auth.AuthState;
import com.comcast.cim.httpcomponentsandroid.auth.Credentials;
import com.comcast.cim.httpcomponentsandroid.client.UserTokenHandler;
import com.comcast.cim.httpcomponentsandroid.conn.HttpRoutedConnection;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import java.security.Principal;
import javax.net.ssl.SSLSession;

public class DefaultUserTokenHandler
    implements UserTokenHandler
{

    public DefaultUserTokenHandler()
    {
    }

    private static Principal getAuthPrincipal(AuthState authstate)
    {
        AuthScheme authscheme = authstate.getAuthScheme();
        if (authscheme != null && authscheme.isComplete() && authscheme.isConnectionBased())
        {
            authstate = authstate.getCredentials();
            if (authstate != null)
            {
                return authstate.getUserPrincipal();
            }
        }
        return null;
    }

    public Object getUserToken(HttpContext httpcontext)
    {
        Principal principal = null;
        Object obj = (AuthState)httpcontext.getAttribute("http.auth.target-scope");
        if (obj != null)
        {
            obj = getAuthPrincipal(((AuthState) (obj)));
            principal = ((Principal) (obj));
            if (obj == null)
            {
                principal = getAuthPrincipal((AuthState)httpcontext.getAttribute("http.auth.proxy-scope"));
            }
        }
        obj = principal;
        if (principal == null)
        {
            httpcontext = (HttpRoutedConnection)httpcontext.getAttribute("http.connection");
            obj = principal;
            if (httpcontext.isOpen())
            {
                httpcontext = httpcontext.getSSLSession();
                obj = principal;
                if (httpcontext != null)
                {
                    obj = httpcontext.getLocalPrincipal();
                }
            }
        }
        return obj;
    }
}
