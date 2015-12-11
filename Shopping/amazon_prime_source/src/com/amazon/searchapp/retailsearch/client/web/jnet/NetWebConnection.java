// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web.jnet;

import com.amazon.searchapp.retailsearch.client.web.RequestContent;
import com.amazon.searchapp.retailsearch.client.web.WebConnection;
import com.amazon.searchapp.retailsearch.client.web.WebResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.web.jnet:
//            NetWebResponse

public class NetWebConnection
    implements WebConnection
{

    private final HttpURLConnection connection;
    private final RequestContent content;

    NetWebConnection(HttpURLConnection httpurlconnection, RequestContent requestcontent)
    {
        connection = httpurlconnection;
        content = requestcontent;
    }

    public void abort()
    {
        connection.disconnect();
    }

    public void disconnect()
    {
        connection.disconnect();
    }

    public WebResponse getResponse()
        throws IOException
    {
        OutputStream outputstream;
        if (content == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        outputstream = connection.getOutputStream();
        content.writeTo(outputstream);
        outputstream.close();
        connection.connect();
        return new NetWebResponse(connection);
        Exception exception;
        exception;
        outputstream.close();
        throw exception;
    }
}
