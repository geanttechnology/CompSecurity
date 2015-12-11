// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.http;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.parse.http:
//            ParseHttpResponse

public static final class nPhrase
{

    private InputStream content;
    private String contentType;
    private Map headers;
    private String reasonPhrase;
    private int statusCode;
    private long totalSize;

    public nPhrase addHeader(String s, String s1)
    {
        headers.put(s, s1);
        return this;
    }

    public headers addHeaders(Map map)
    {
        headers.putAll(map);
        return this;
    }

    public ParseHttpResponse build()
    {
        return new ParseHttpResponse(this, null);
    }

    public headers setContent(InputStream inputstream)
    {
        content = inputstream;
        return this;
    }

    public content setContentType(String s)
    {
        contentType = s;
        return this;
    }

    public contentType setHeaders(Map map)
    {
        headers = new HashMap(map);
        return this;
    }

    public headers setReasonPhrase(String s)
    {
        reasonPhrase = s;
        return this;
    }

    public reasonPhrase setStatusCode(int i)
    {
        statusCode = i;
        return this;
    }

    public statusCode setTotalSize(long l)
    {
        totalSize = l;
        return this;
    }







    public ()
    {
        totalSize = -1L;
        headers = new HashMap();
    }

    public headers(ParseHttpResponse parsehttpresponse)
    {
        setStatusCode(parsehttpresponse.getStatusCode());
        setContent(parsehttpresponse.getContent());
        setTotalSize(parsehttpresponse.getTotalSize());
        setContentType(parsehttpresponse.getContentType());
        setHeaders(parsehttpresponse.getAllHeaders());
        setReasonPhrase(parsehttpresponse.getReasonPhrase());
    }
}
