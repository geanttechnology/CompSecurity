// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpConnection;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.client.UserTokenHandler;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.security.Principal;
import javax.net.ssl.SSLSession;

public class DefaultUserTokenHandler
    implements UserTokenHandler
{

    public static final DefaultUserTokenHandler INSTANCE = new DefaultUserTokenHandler();

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
        Object obj1 = HttpClientContext.adapt(httpcontext);
        httpcontext = null;
        Object obj = ((HttpClientContext) (obj1)).getTargetAuthState();
        if (obj != null)
        {
            obj = getAuthPrincipal(((AuthState) (obj)));
            httpcontext = ((HttpContext) (obj));
            if (obj == null)
            {
                httpcontext = getAuthPrincipal(((HttpClientContext) (obj1)).getProxyAuthState());
            }
        }
        obj = httpcontext;
        if (httpcontext == null)
        {
            obj1 = ((HttpClientContext) (obj1)).getConnection();
            obj = httpcontext;
            if (((HttpConnection) (obj1)).isOpen())
            {
                obj = httpcontext;
                if (obj1 instanceof ManagedHttpClientConnection)
                {
                    obj1 = ((ManagedHttpClientConnection)obj1).getSSLSession();
                    obj = httpcontext;
                    if (obj1 != null)
                    {
                        obj = ((SSLSession) (obj1)).getLocalPrincipal();
                    }
                }
            }
        }
        return obj;
    }

}
