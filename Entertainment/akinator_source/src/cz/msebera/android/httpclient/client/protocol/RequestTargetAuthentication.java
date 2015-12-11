// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.client.protocol:
//            RequestAuthenticationBase

public class RequestTargetAuthentication extends RequestAuthenticationBase
{

    public RequestTargetAuthentication()
    {
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        Args.notNull(httprequest, "HTTP request");
        Args.notNull(httpcontext, "HTTP context");
        while (httprequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") || httprequest.containsHeader("Authorization")) 
        {
            return;
        }
        AuthState authstate = (AuthState)httpcontext.getAttribute("http.auth.target-scope");
        if (authstate == null)
        {
            log.debug("Target auth state not set in the context");
            return;
        }
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Target auth state: ").append(authstate.getState()).toString());
        }
        process(authstate, httprequest, httpcontext);
    }
}
