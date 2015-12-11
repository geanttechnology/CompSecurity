// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http;


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
        return (HttpMethod)Enum.valueOf(org/springframework/http/HttpMethod, s);
    }

    public static HttpMethod[] values()
    {
        return (HttpMethod[])$VALUES.clone();
    }

    static 
    {
        GET = new HttpMethod("GET", 0);
        POST = new HttpMethod("POST", 1);
        HEAD = new HttpMethod("HEAD", 2);
        OPTIONS = new HttpMethod("OPTIONS", 3);
        PUT = new HttpMethod("PUT", 4);
        DELETE = new HttpMethod("DELETE", 5);
        TRACE = new HttpMethod("TRACE", 6);
        $VALUES = (new HttpMethod[] {
            GET, POST, HEAD, OPTIONS, PUT, DELETE, TRACE
        });
    }
}
