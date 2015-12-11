// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.conn.HttpRoutedConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.client.protocol:
//            RequestAuthenticationBase

public class RequestProxyAuthentication extends RequestAuthenticationBase
{

    public RequestProxyAuthentication()
    {
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        Args.notNull(httprequest, "HTTP request");
        Args.notNull(httpcontext, "HTTP context");
        if (!httprequest.containsHeader("Proxy-Authorization"))
        {
            HttpRoutedConnection httproutedconnection = (HttpRoutedConnection)httpcontext.getAttribute("http.connection");
            if (httproutedconnection == null)
            {
                log.debug("HTTP connection not set in the context");
                return;
            }
            if (!httproutedconnection.getRoute().isTunnelled())
            {
                AuthState authstate = (AuthState)httpcontext.getAttribute("http.auth.proxy-scope");
                if (authstate == null)
                {
                    log.debug("Proxy auth state not set in the context");
                    return;
                }
                if (log.isDebugEnabled())
                {
                    log.debug((new StringBuilder()).append("Proxy auth state: ").append(authstate.getState()).toString());
                }
                process(authstate, httprequest, httpcontext);
                return;
            }
        }
    }
}
