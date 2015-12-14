// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.network;

import com.mopub.common.util.ResponseHeader;
import com.mopub.volley.AuthFailureError;
import com.mopub.volley.Request;
import com.mopub.volley.toolbox.HurlStack;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpResponse;

public class RequestQueueHttpStack extends HurlStack
{

    private final String mUserAgent;

    public RequestQueueHttpStack(String s)
    {
        this(s, null);
    }

    public RequestQueueHttpStack(String s, com.mopub.volley.toolbox.HurlStack.UrlRewriter urlrewriter)
    {
        this(s, urlrewriter, null);
    }

    public RequestQueueHttpStack(String s, com.mopub.volley.toolbox.HurlStack.UrlRewriter urlrewriter, SSLSocketFactory sslsocketfactory)
    {
        super(urlrewriter, sslsocketfactory);
        mUserAgent = s;
    }

    public HttpResponse performRequest(Request request, Map map)
        throws IOException, AuthFailureError
    {
        Object obj = map;
        if (map == null)
        {
            obj = new TreeMap();
        }
        ((Map) (obj)).put(ResponseHeader.USER_AGENT.getKey(), mUserAgent);
        return super.performRequest(request, ((Map) (obj)));
    }
}
