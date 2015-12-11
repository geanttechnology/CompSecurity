// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web.jnet;

import com.amazon.searchapp.retailsearch.client.web.WebResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class NetWebResponse
    implements WebResponse
{

    private final HttpURLConnection connection;

    NetWebResponse(HttpURLConnection httpurlconnection)
    {
        connection = httpurlconnection;
    }

    public InputStream getContent()
        throws IOException
    {
        BufferedInputStream bufferedinputstream;
        try
        {
            bufferedinputstream = new BufferedInputStream(connection.getInputStream());
        }
        catch (IOException ioexception)
        {
            InputStream inputstream = connection.getErrorStream();
            if (inputstream == null)
            {
                throw ioexception;
            } else
            {
                return new BufferedInputStream(inputstream);
            }
        }
        return bufferedinputstream;
    }

    public int getStatusCode()
        throws IOException
    {
        return connection.getResponseCode();
    }

    public String getStatusLine()
    {
        return connection.getHeaderField(0);
    }
}
