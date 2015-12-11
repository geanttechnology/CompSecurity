// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.http;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.parse.http:
//            ParseHttpRequest, ParseHttpBody

public static final class _cls00
{

    private ParseHttpBody body;
    private Map headers;
    private url method;
    private String url;

    public _cls00 addHeader(String s, String s1)
    {
        headers.put(s, s1);
        return this;
    }

    public headers addHeaders(Map map)
    {
        headers.putAll(map);
        return this;
    }

    public ParseHttpRequest build()
    {
        return new ParseHttpRequest(this, null);
    }

    public headers setBody(ParseHttpBody parsehttpbody)
    {
        body = parsehttpbody;
        return this;
    }

    public body setHeaders(Map map)
    {
        headers = new HashMap(map);
        return this;
    }

    public headers setMethod(headers headers1)
    {
        method = headers1;
        return this;
    }

    public method setUrl(String s)
    {
        url = s;
        return this;
    }





    public ()
    {
        headers = new HashMap();
    }

    public headers(ParseHttpRequest parsehttprequest)
    {
        url = ParseHttpRequest.access$000(parsehttprequest);
        method = ParseHttpRequest.access$100(parsehttprequest);
        headers = new HashMap(ParseHttpRequest.access$200(parsehttprequest));
        body = ParseHttpRequest.access$300(parsehttprequest);
    }
}
