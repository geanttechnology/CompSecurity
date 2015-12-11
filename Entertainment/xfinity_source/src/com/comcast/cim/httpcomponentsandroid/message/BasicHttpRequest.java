// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.message;

import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.ProtocolVersion;
import com.comcast.cim.httpcomponentsandroid.RequestLine;
import com.comcast.cim.httpcomponentsandroid.params.HttpProtocolParams;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.message:
//            AbstractHttpMessage, BasicRequestLine

public class BasicHttpRequest extends AbstractHttpMessage
    implements HttpRequest
{

    private final String method;
    private RequestLine requestline;
    private final String uri;

    public BasicHttpRequest(RequestLine requestline1)
    {
        if (requestline1 == null)
        {
            throw new IllegalArgumentException("Request line may not be null");
        } else
        {
            requestline = requestline1;
            method = requestline1.getMethod();
            uri = requestline1.getUri();
            return;
        }
    }

    public BasicHttpRequest(String s, String s1, ProtocolVersion protocolversion)
    {
        this(((RequestLine) (new BasicRequestLine(s, s1, protocolversion))));
    }

    public ProtocolVersion getProtocolVersion()
    {
        return getRequestLine().getProtocolVersion();
    }

    public RequestLine getRequestLine()
    {
        if (requestline == null)
        {
            ProtocolVersion protocolversion = HttpProtocolParams.getVersion(getParams());
            requestline = new BasicRequestLine(method, uri, protocolversion);
        }
        return requestline;
    }

    public String toString()
    {
        return method + " " + uri + " " + headergroup;
    }
}
