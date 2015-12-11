// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web.jnet;

import com.amazon.searchapp.retailsearch.client.web.CollectionMap;
import com.amazon.searchapp.retailsearch.client.web.WebResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public long getContentLength()
    {
        return (long)connection.getContentLength();
    }

    public String getContentType()
    {
        return connection.getContentType();
    }

    public CollectionMap getHeaders()
    {
        Object obj = null;
        Object obj1 = connection.getHeaderFields();
        if (obj1 != null)
        {
            CollectionMap collectionmap = new CollectionMap(((Map) (obj1)).size());
            obj1 = ((Map) (obj1)).entrySet().iterator();
            do
            {
                obj = collectionmap;
                if (!((Iterator) (obj1)).hasNext())
                {
                    break;
                }
                obj = (java.util.Map.Entry)((Iterator) (obj1)).next();
                Iterator iterator = ((List)((java.util.Map.Entry) (obj)).getValue()).iterator();
                while (iterator.hasNext()) 
                {
                    String s = (String)iterator.next();
                    collectionmap.add(((java.util.Map.Entry) (obj)).getKey(), s);
                }
            } while (true);
        }
        return ((CollectionMap) (obj));
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
