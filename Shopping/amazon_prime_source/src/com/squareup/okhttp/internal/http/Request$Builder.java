// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import java.net.URL;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            Request, Headers

public static class <init>
{

    private url body;
    private url headers;
    private String method;
    private Object tag;
    private URL url;

    public <init> addHeader(String s, String s1)
    {
        headers.add(s, s1);
        return this;
    }

    public Request build()
    {
        if (url == null)
        {
            throw new IllegalStateException("url == null");
        } else
        {
            return new Request(this, null);
        }
    }

    public url header(String s, String s1)
    {
        headers.set(s, s1);
        return this;
    }

    public set method(String s, set set)
    {
        if (s == null || s.length() == 0)
        {
            throw new IllegalArgumentException("method == null || method.length() == 0");
        } else
        {
            method = s;
            body = set;
            return this;
        }
    }

    public body setUserAgent(String s)
    {
        return header("User-Agent", s);
    }

    public header url(URL url1)
    {
        if (url1 == null)
        {
            throw new IllegalArgumentException("url == null");
        } else
        {
            url = url1;
            return this;
        }
    }






    public ()
    {
        method = "GET";
        headers = new <init>();
    }

    private <init>(Request request)
    {
        url = Request.access$800(request);
        method = Request.access$900(request);
        body = Request.access$1000(request);
        tag = Request.access$1100(request);
        headers = Request.access$1200(request).newBuilder();
    }

    er(Request request, er er)
    {
        this(request);
    }
}
