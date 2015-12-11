// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.http;

import java.util.Map;

public class Response
{

    private long lastModified;
    private String responseBody;
    private Map responseHeaders;
    private String responseMessage;
    private int status;

    private Response()
    {
    }

    Response(_cls1 _pcls1)
    {
        this();
    }

    public long getLastModifiedTime()
    {
        return lastModified;
    }

    public String getResponseBody()
    {
        return responseBody;
    }

    public Map getResponseHeaders()
    {
        return responseHeaders;
    }

    public int getStatus()
    {
        return status;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Response: ");
        stringbuilder.append("ResponseBody: ");
        if (responseBody != null)
        {
            stringbuilder.append(responseBody);
        }
        stringbuilder.append(" ResponseHeaders: ");
        if (responseHeaders != null)
        {
            stringbuilder.append(responseHeaders);
        }
        stringbuilder.append(" ResponseMessage: ");
        if (responseMessage != null)
        {
            stringbuilder.append(responseMessage);
        }
        stringbuilder.append(" Status: ").append(Integer.toString(status));
        return stringbuilder.toString();
    }


/*
    static int access$102(Response response, int i)
    {
        response.status = i;
        return i;
    }

*/


/*
    static String access$202(Response response, String s)
    {
        response.responseBody = s;
        return s;
    }

*/


/*
    static Map access$302(Response response, Map map)
    {
        response.responseHeaders = map;
        return map;
    }

*/


/*
    static String access$402(Response response, String s)
    {
        response.responseMessage = s;
        return s;
    }

*/


/*
    static long access$502(Response response, long l)
    {
        response.lastModified = l;
        return l;
    }

*/
}
