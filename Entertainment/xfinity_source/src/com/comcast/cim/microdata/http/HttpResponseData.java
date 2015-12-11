// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.http;


public class HttpResponseData
{

    private final String baseUrl;
    private final String content;
    private final String contentType;
    private final int statusCode;

    public String getBaseUrl()
    {
        return baseUrl;
    }

    public String getContent()
    {
        return content;
    }

    public String getContentType()
    {
        return contentType;
    }

    public int getStatusCode()
    {
        return statusCode;
    }
}
