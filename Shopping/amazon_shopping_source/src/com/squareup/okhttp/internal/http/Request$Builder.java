// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import java.net.MalformedURLException;
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

    public url get()
    {
        return method("GET", null);
    }

    public method head()
    {
        return method("HEAD", null);
    }

    public method header(String s, String s1)
    {
        headers.set(s, s1);
        return this;
    }

    public set headers(Headers headers1)
    {
        headers = headers1.newBuilder();
        return this;
    }

    public er method(String s, er er)
    {
        if (s == null || s.length() == 0)
        {
            throw new IllegalArgumentException("method == null || method.length() == 0");
        } else
        {
            method = s;
            body = er;
            return this;
        }
    }

    public body post(body body1)
    {
        return method("POST", body1);
    }

    public method put(method method1)
    {
        return method("PUT", method1);
    }

    public method removeHeader(String s)
    {
        headers.removeAll(s);
        return this;
    }

    public removeAll setUserAgent(String s)
    {
        return header("User-Agent", s);
    }

    public header tag(Object obj)
    {
        tag = obj;
        return this;
    }

    public tag url(String s)
    {
        tag tag1;
        try
        {
            tag1 = url(new URL(s));
        }
        catch (MalformedURLException malformedurlexception)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Malformed URL: ").append(s).toString());
        }
        return tag1;
    }

    public url url(URL url1)
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
