// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.util.List;
import java.util.Map;

// Referenced classes of package cz.msebera.android.httpclient.impl.client:
//            AbstractAuthenticationHandler

public class DefaultProxyAuthenticationHandler extends AbstractAuthenticationHandler
{

    public DefaultProxyAuthenticationHandler()
    {
    }

    protected List getAuthPreferences(HttpResponse httpresponse, HttpContext httpcontext)
    {
        List list = (List)httpresponse.getParams().getParameter("http.auth.proxy-scheme-pref");
        if (list != null)
        {
            return list;
        } else
        {
            return super.getAuthPreferences(httpresponse, httpcontext);
        }
    }

    public Map getChallenges(HttpResponse httpresponse, HttpContext httpcontext)
        throws MalformedChallengeException
    {
        Args.notNull(httpresponse, "HTTP response");
        return parseChallenges(httpresponse.getHeaders("Proxy-Authenticate"));
    }

    public boolean isAuthenticationRequested(HttpResponse httpresponse, HttpContext httpcontext)
    {
        Args.notNull(httpresponse, "HTTP response");
        return httpresponse.getStatusLine().getStatusCode() == 407;
    }
}
