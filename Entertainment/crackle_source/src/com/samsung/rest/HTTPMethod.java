// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.samsung.rest;


public final class HTTPMethod extends Enum
{

    public static final HTTPMethod DELETE;
    private static final HTTPMethod ENUM$VALUES[];
    public static final HTTPMethod GET;
    public static final HTTPMethod HEAD;
    public static final HTTPMethod OPTIONS;
    public static final HTTPMethod POST;
    public static final HTTPMethod PUT;
    public static final HTTPMethod TRACE;

    private HTTPMethod(String s, int i)
    {
        super(s, i);
    }

    public static HTTPMethod get(String s)
    {
        if ("GET".equals(s))
        {
            return GET;
        }
        if ("POST".equals(s))
        {
            return POST;
        }
        if ("PUT".equals(s))
        {
            return PUT;
        }
        if ("DELETE".equals(s))
        {
            return DELETE;
        }
        if ("HEAD".equals(s))
        {
            return HEAD;
        }
        if ("OPTIONS".equals(s))
        {
            return OPTIONS;
        }
        if ("TRACE".equals(s))
        {
            return TRACE;
        } else
        {
            return GET;
        }
    }

    public static HTTPMethod valueOf(String s)
    {
        return (HTTPMethod)Enum.valueOf(com/samsung/rest/HTTPMethod, s);
    }

    public static HTTPMethod[] values()
    {
        HTTPMethod ahttpmethod[] = ENUM$VALUES;
        int i = ahttpmethod.length;
        HTTPMethod ahttpmethod1[] = new HTTPMethod[i];
        System.arraycopy(ahttpmethod, 0, ahttpmethod1, 0, i);
        return ahttpmethod1;
    }

    static 
    {
        GET = new HTTPMethod("GET", 0);
        POST = new HTTPMethod("POST", 1);
        PUT = new HTTPMethod("PUT", 2);
        DELETE = new HTTPMethod("DELETE", 3);
        HEAD = new HTTPMethod("HEAD", 4);
        OPTIONS = new HTTPMethod("OPTIONS", 5);
        TRACE = new HTTPMethod("TRACE", 6);
        ENUM$VALUES = (new HTTPMethod[] {
            GET, POST, PUT, DELETE, HEAD, OPTIONS, TRACE
        });
    }
}
