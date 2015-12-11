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

    public WebResponse getResponse()
        throws IOException
    {
        if (content != null) goto _L2; else goto _L1
_L1:
        connection.connect();
_L4:
        return new NetWebResponse(connection);
_L2:
        OutputStream outputstream = connection.getOutputStream();
        content.writeTo(outputstream);
        outputstream.close();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        outputstream.close();
        throw exception;
    }
}
