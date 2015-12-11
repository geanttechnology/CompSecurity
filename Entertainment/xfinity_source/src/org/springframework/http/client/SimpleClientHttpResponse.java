// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

// Referenced classes of package org.springframework.http.client:
//            AbstractClientHttpResponse

final class SimpleClientHttpResponse extends AbstractClientHttpResponse
{

    private final HttpURLConnection connection;
    private HttpHeaders headers;

    SimpleClientHttpResponse(HttpURLConnection httpurlconnection)
    {
        connection = httpurlconnection;
    }

    protected void closeInternal()
    {
        connection.disconnect();
    }

    protected InputStream getBodyInternal()
        throws IOException
    {
        InputStream inputstream = connection.getErrorStream();
        if (inputstream != null)
        {
            return inputstream;
        } else
        {
            return connection.getInputStream();
        }
    }

    public HttpHeaders getHeaders()
    {
        if (headers != null) goto _L2; else goto _L1
_L1:
        int i;
        headers = new HttpHeaders();
        String s = connection.getHeaderFieldKey(0);
        if (StringUtils.hasLength(s))
        {
            headers.add(s, connection.getHeaderField(0));
        }
        i = 1;
_L5:
        String s1 = connection.getHeaderFieldKey(i);
        if (StringUtils.hasLength(s1)) goto _L3; else goto _L2
_L2:
        return headers;
_L3:
        headers.add(s1, connection.getHeaderField(i));
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public int getRawStatusCode()
        throws IOException
    {
        return connection.getResponseCode();
    }

    public HttpStatus getStatusCode()
        throws IOException
    {
        HttpStatus httpstatus;
        try
        {
            httpstatus = HttpStatus.valueOf(getRawStatusCode());
        }
        catch (IOException ioexception)
        {
            if (ioexception.getLocalizedMessage().equals("Received authentication challenge is null"))
            {
                return HttpStatus.UNAUTHORIZED;
            } else
            {
                throw ioexception;
            }
        }
        return httpstatus;
    }

    public String getStatusText()
        throws IOException
    {
        String s;
        try
        {
            s = connection.getResponseMessage();
        }
        catch (IOException ioexception)
        {
            if (ioexception.getLocalizedMessage().equals("Received authentication challenge is null"))
            {
                return HttpStatus.UNAUTHORIZED.getReasonPhrase();
            } else
            {
                throw ioexception;
            }
        }
        return s;
    }
}
