// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.samsung.rest;

import java.util.HashMap;

public class Response
{

    public static final int ACTION_IMAGE_UPLOAD = 101;
    public static final int ACTION_JSON_MESSAGE = 102;
    private int _actionType;
    private String _body;
    private long _executionTime;
    private HashMap _headers;
    private int _statusCode;
    private String _statusLine;

    public Response()
    {
        _actionType = 102;
        _headers = new HashMap();
    }

    public void addHeader(String s, String s1)
    {
        _headers.put(s, s1);
    }

    public int getActionType()
    {
        return _actionType;
    }

    public String getBody()
    {
        return _body;
    }

    public long getExecutionTime()
    {
        return _executionTime;
    }

    public HashMap getHeaders()
    {
        return _headers;
    }

    public int getStatusCode()
    {
        return _statusCode;
    }

    public String getStatusLine()
    {
        return _statusLine;
    }

    public void setActionType(int i)
    {
        _actionType = i;
    }

    public void setBody(String s)
    {
        _body = s;
    }

    public void setExecutionTime(long l)
    {
        _executionTime = l;
    }

    public void setHeaders(HashMap hashmap)
    {
        _headers = hashmap;
    }

    public void setStatusCode(int i)
    {
        _statusCode = i;
    }

    public void setStatusLine(String s)
    {
        _statusLine = s;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("@Response[");
        stringbuilder.append(_statusLine);
        stringbuilder.append("]");
        return stringbuilder.toString();
    }
}
