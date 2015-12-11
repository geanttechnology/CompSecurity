// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.signpost.basic;

import com.parse.signpost.http.HttpResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class HttpURLConnectionResponseAdapter
    implements HttpResponse
{

    private HttpURLConnection connection;

    public HttpURLConnectionResponseAdapter(HttpURLConnection httpurlconnection)
    {
        connection = httpurlconnection;
    }

    public InputStream getContent()
        throws IOException
    {
        return connection.getInputStream();
    }

    public String getReasonPhrase()
        throws Exception
    {
        return connection.getResponseMessage();
    }

    public int getStatusCode()
        throws IOException
    {
        return connection.getResponseCode();
    }

    public Object unwrap()
    {
        return connection;
    }
}
