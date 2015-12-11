// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.google.tagmanager:
//            NetworkClient

class HttpUrlConnectionNetworkClient
    implements NetworkClient
{

    private HttpURLConnection mConnection;

    HttpUrlConnectionNetworkClient()
    {
    }

    private void closeURLConnection(HttpURLConnection httpurlconnection)
    {
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
    }

    private InputStream handleServerResponse(HttpURLConnection httpurlconnection)
        throws IOException
    {
        int i = httpurlconnection.getResponseCode();
        if (i == 200)
        {
            return httpurlconnection.getInputStream();
        }
        httpurlconnection = (new StringBuilder()).append("Bad response: ").append(i).toString();
        if (i == 404)
        {
            throw new FileNotFoundException(httpurlconnection);
        } else
        {
            throw new IOException(httpurlconnection);
        }
    }

    public void close()
    {
        closeURLConnection(mConnection);
    }

    public InputStream getInputStream(String s)
        throws IOException
    {
        mConnection = getUrlConnection(s);
        return handleServerResponse(mConnection);
    }

    HttpURLConnection getUrlConnection(String s)
        throws IOException
    {
        s = (HttpURLConnection)HttpInstrumentation.openConnection((new URL(s)).openConnection());
        s.setReadTimeout(20000);
        s.setConnectTimeout(20000);
        return s;
    }

    public void sendPostRequest(String s, byte abyte0[])
        throws IOException
    {
        s = getUrlConnection(s);
        OutputStream outputstream;
        s.setRequestProperty("Content-Length", Integer.toString(abyte0.length));
        s.setRequestMethod("POST");
        s.setDoOutput(true);
        s.connect();
        outputstream = s.getOutputStream();
        outputstream.write(abyte0);
        outputstream.flush();
        outputstream.close();
        handleServerResponse(s);
        closeURLConnection(s);
        return;
        abyte0;
        outputstream.close();
        throw abyte0;
        abyte0;
        closeURLConnection(s);
        throw abyte0;
    }
}
