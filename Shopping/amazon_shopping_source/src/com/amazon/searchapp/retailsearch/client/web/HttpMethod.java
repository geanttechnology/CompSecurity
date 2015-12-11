// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web;


public final class HttpMethod extends Enum
{

    private static final HttpMethod $VALUES[];
    public static final HttpMethod DELETE;
    public static final HttpMethod GET;
    public static final HttpMethod HEAD;
    public static final HttpMethod OPTIONS;
    public static final HttpMethod POST;
    public static final HttpMethod PUT;
    public static final HttpMethod TRACE;

    private HttpMethod(String s, int i)
    {
        super(s, i);
    }

    public static HttpMethod valueOf(String s)
    {
        return (HttpMethod)Enum.valueOf(com/amazon/searchapp/retailsearch/client/web/HttpMethod, s);
    }

    public static HttpMethod[] values()
    {
        return (HttpMethod[])$VALUES.clone();
    }

    public String getName()
    {
        return name();
    }

    static 
    {
        DELETE = new HttpMethod("DELETE", 0);
        GET = new HttpMethod("GET", 1);
        HEAD = new HttpMethod("HEAD", 2);
        OPTIONS = new HttpMethod("OPTIONS", 3);
        POST = new HttpMethod("POST", 4);
        PUT = new HttpMethod("PUT", 5);
        TRACE = new HttpMethod("TRACE", 6);
        $VALUES = (new HttpMethod[] {
            DELETE, GET, HEAD, OPTIONS, POST, PUT, TRACE
        });
    }
}
