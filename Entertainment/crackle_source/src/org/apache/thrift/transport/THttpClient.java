// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package org.apache.thrift.transport:
//            TTransport, TTransportException

public class THttpClient extends TTransport
{

    private URL a;
    private final ByteArrayOutputStream b = new ByteArrayOutputStream();
    private InputStream c;
    private int d;
    private int e;
    private Map f;

    public THttpClient(String s)
        throws TTransportException
    {
        a = null;
        c = null;
        d = 0;
        e = 0;
        f = null;
        try
        {
            a = new URL(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new TTransportException(s);
        }
    }

    public void close()
    {
        if (c != null)
        {
            try
            {
                c.close();
            }
            catch (IOException ioexception) { }
            c = null;
        }
    }

    public void flush()
        throws TTransportException
    {
        Object obj;
        HttpURLConnection httpurlconnection;
        obj = b.toByteArray();
        b.reset();
        try
        {
            httpurlconnection = (HttpURLConnection)a.openConnection();
            if (d > 0)
            {
                httpurlconnection.setConnectTimeout(d);
            }
            if (e > 0)
            {
                httpurlconnection.setReadTimeout(e);
            }
            httpurlconnection.setRequestMethod("POST");
            httpurlconnection.setRequestProperty("Content-Type", "application/x-thrift");
            httpurlconnection.setRequestProperty("Accept", "application/x-thrift");
            httpurlconnection.setRequestProperty("User-Agent", "Java/THttpClient");
            if (f != null)
            {
                java.util.Map.Entry entry;
                for (Iterator iterator = f.entrySet().iterator(); iterator.hasNext(); httpurlconnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue()))
                {
                    entry = (java.util.Map.Entry)iterator.next();
                }

            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new TTransportException(((Throwable) (obj)));
        }
        int i;
        httpurlconnection.setDoOutput(true);
        httpurlconnection.connect();
        httpurlconnection.getOutputStream().write(((byte []) (obj)));
        i = httpurlconnection.getResponseCode();
        if (i == 200)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        throw new TTransportException((new StringBuilder()).append("HTTP Response code: ").append(i).toString());
        c = httpurlconnection.getInputStream();
        return;
    }

    public boolean isOpen()
    {
        return true;
    }

    public void open()
    {
    }

    public int read(byte abyte0[], int i, int j)
        throws TTransportException
    {
        if (c == null)
        {
            throw new TTransportException("Response buffer is empty, no request.");
        }
        try
        {
            i = c.read(abyte0, i, j);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new TTransportException(abyte0);
        }
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        throw new TTransportException("No more data available.");
        return i;
    }

    public void setConnectTimeout(int i)
    {
        d = i;
    }

    public void setCustomHeader(String s, String s1)
    {
        if (f == null)
        {
            f = new HashMap();
        }
        f.put(s, s1);
    }

    public void setCustomHeaders(Map map)
    {
        f = map;
    }

    public void setReadTimeout(int i)
    {
        e = i;
    }

    public void write(byte abyte0[], int i, int j)
    {
        b.write(abyte0, i, j);
    }
}
