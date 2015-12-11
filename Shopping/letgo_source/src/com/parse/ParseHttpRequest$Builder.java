// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseHttpRequest, ParseHttpBody

public static class _cls00
{

    protected ParseHttpBody body;
    protected Map headers;
    protected boolean isCancelled;
    protected url method;
    protected String url;

    public _cls00 addHeader(String s, String s1)
    {
        headers.put(s, s1);
        return this;
    }

    public ParseHttpRequest build()
    {
        return new ParseHttpRequest(this);
    }

    public headers setBody(ParseHttpBody parsehttpbody)
    {
        body = parsehttpbody;
        return this;
    }

    public body setHeaders(Map map)
    {
        headers = map;
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
        isCancelled = ParseHttpRequest.access$400(parsehttprequest);
    }
}
