// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.FileCopyUtils;

// Referenced classes of package org.springframework.http.client:
//            AbstractBufferingClientHttpRequest, SimpleClientHttpResponse, ClientHttpResponse

final class SimpleBufferingClientHttpRequest extends AbstractBufferingClientHttpRequest
{

    private final HttpURLConnection connection;

    SimpleBufferingClientHttpRequest(HttpURLConnection httpurlconnection)
    {
        connection = httpurlconnection;
    }

    protected ClientHttpResponse executeInternal(HttpHeaders httpheaders, byte abyte0[])
        throws IOException
    {
        for (httpheaders = httpheaders.entrySet().iterator(); httpheaders.hasNext();)
        {
            Object obj = (java.util.Map.Entry)httpheaders.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            obj = ((List)((java.util.Map.Entry) (obj)).getValue()).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                String s1 = (String)((Iterator) (obj)).next();
                connection.addRequestProperty(s, s1);
            }
        }

        if (connection.getDoOutput())
        {
            connection.setFixedLengthStreamingMode(abyte0.length);
        }
        connection.connect();
        if (connection.getDoOutput())
        {
            FileCopyUtils.copy(abyte0, connection.getOutputStream());
        }
        return new SimpleClientHttpResponse(connection);
    }

    public HttpMethod getMethod()
    {
        return HttpMethod.valueOf(connection.getRequestMethod());
    }

    public URI getURI()
    {
        URI uri;
        try
        {
            uri = connection.getURL().toURI();
        }
        catch (URISyntaxException urisyntaxexception)
        {
            throw new IllegalStateException((new StringBuilder()).append("Could not get HttpURLConnection URI: ").append(urisyntaxexception.getMessage()).toString(), urisyntaxexception);
        }
        return uri;
    }
}
