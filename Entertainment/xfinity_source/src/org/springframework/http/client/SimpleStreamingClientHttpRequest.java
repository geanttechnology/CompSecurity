// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

// Referenced classes of package org.springframework.http.client:
//            AbstractClientHttpRequest, SimpleClientHttpResponse, ClientHttpResponse

final class SimpleStreamingClientHttpRequest extends AbstractClientHttpRequest
{
    private static class NonClosingOutputStream extends FilterOutputStream
    {

        public void close()
            throws IOException
        {
        }

        private NonClosingOutputStream(OutputStream outputstream)
        {
            super(outputstream);
        }

    }


    private static final Boolean olderThanFroyo;
    private OutputStream body;
    private final int chunkSize;
    private final HttpURLConnection connection;

    SimpleStreamingClientHttpRequest(HttpURLConnection httpurlconnection, int i)
    {
        connection = httpurlconnection;
        chunkSize = i;
        if (olderThanFroyo.booleanValue())
        {
            System.setProperty("http.keepAlive", "false");
        }
    }

    private boolean shouldAllowConnectionReuse(String s, String s1)
    {
        return !olderThanFroyo.booleanValue() || !s.equals("Connection") || !s1.equals("Keep-Alive");
    }

    private void writeHeaders(HttpHeaders httpheaders)
    {
        for (httpheaders = httpheaders.entrySet().iterator(); httpheaders.hasNext();)
        {
            Object obj = (java.util.Map.Entry)httpheaders.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            obj = ((List)((java.util.Map.Entry) (obj)).getValue()).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                String s1 = (String)((Iterator) (obj)).next();
                if (shouldAllowConnectionReuse(s, s1))
                {
                    connection.addRequestProperty(s, s1);
                }
            }
        }

    }

    protected ClientHttpResponse executeInternal(HttpHeaders httpheaders)
        throws IOException
    {
        if (body == null) goto _L2; else goto _L1
_L1:
        body.close();
_L4:
        return new SimpleClientHttpResponse(connection);
_L2:
        try
        {
            writeHeaders(httpheaders);
            connection.connect();
        }
        // Misplaced declaration of an exception variable
        catch (HttpHeaders httpheaders) { }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected OutputStream getBodyInternal(HttpHeaders httpheaders)
        throws IOException
    {
        if (body == null)
        {
            int i = (int)httpheaders.getContentLength();
            if (i >= 0 && !olderThanFroyo.booleanValue())
            {
                connection.setFixedLengthStreamingMode(i);
            } else
            {
                connection.setChunkedStreamingMode(chunkSize);
            }
            writeHeaders(httpheaders);
            connection.connect();
            body = connection.getOutputStream();
        }
        return new NonClosingOutputStream(body);
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

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT < 8)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        olderThanFroyo = Boolean.valueOf(flag);
    }
}
