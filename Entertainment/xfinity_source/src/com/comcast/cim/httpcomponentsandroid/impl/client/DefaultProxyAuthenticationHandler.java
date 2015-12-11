// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client;

import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.StatusLine;
import com.comcast.cim.httpcomponentsandroid.auth.MalformedChallengeException;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.client:
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
        if (httpresponse == null)
        {
            throw new IllegalArgumentException("HTTP response may not be null");
        } else
        {
            return parseChallenges(httpresponse.getHeaders("Proxy-Authenticate"));
        }
    }

    public boolean isAuthenticationRequested(HttpResponse httpresponse, HttpContext httpcontext)
    {
        if (httpresponse == null)
        {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
        return httpresponse.getStatusLine().getStatusCode() == 407;
    }
}
