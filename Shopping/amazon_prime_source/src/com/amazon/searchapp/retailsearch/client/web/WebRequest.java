// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web;

import java.io.IOException;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.web:
//            WebConnection, WebClient, RequestContent, CollectionMap, 
//            WebResponse

public class WebRequest
{

    private static String NO_CONNECTION_ERROR = "No connection created";
    private final WebClient client;
    private WebConnection connection;
    private RequestContent content;
    private CollectionMap headers;
    private String method;
    private String url;

    WebRequest(WebClient webclient)
    {
        client = webclient;
    }

    void abort()
    {
        if (connection == null)
        {
            throw new IllegalStateException(NO_CONNECTION_ERROR);
        } else
        {
            connection.abort();
            return;
        }
    }

    void disconnect()
    {
        if (connection == null)
        {
            throw new IllegalStateException(NO_CONNECTION_ERROR);
        } else
        {
            connection.disconnect();
            return;
        }
    }

    public RequestContent getContent()
    {
        return content;
    }

    public CollectionMap getHeaders()
    {
        return headers;
    }

    public String getMethod()
    {
        return method;
    }

    public WebResponse getResponse()
        throws IOException
    {
        connection = client.createConnection(method, url, headers, content);
        return connection.getResponse();
    }

    public String getUrl()
    {
        return url;
    }

    public void setContent(RequestContent requestcontent)
    {
        content = requestcontent;
    }

    public void setHeaders(CollectionMap collectionmap)
    {
        headers = collectionmap;
    }

    public void setMethod(String s)
    {
        method = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }

}
