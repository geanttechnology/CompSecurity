// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.huc;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.StatusLine;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.util.Map;

// Referenced classes of package com.squareup.okhttp.internal.huc:
//            JavaApiConverter

private static final class request extends HttpURLConnection
{

    private final Request request;
    private final Response response;

    public void addRequestProperty(String s, String s1)
    {
        throw JavaApiConverter.access$000();
    }

    public void connect()
        throws IOException
    {
        throw JavaApiConverter.access$000();
    }

    public void disconnect()
    {
        throw JavaApiConverter.access$000();
    }

    public boolean getAllowUserInteraction()
    {
        return false;
    }

    public int getConnectTimeout()
    {
        return 0;
    }

    public Object getContent()
        throws IOException
    {
        throw JavaApiConverter.access$200();
    }

    public Object getContent(Class aclass[])
        throws IOException
    {
        throw JavaApiConverter.access$200();
    }

    public boolean getDefaultUseCaches()
    {
        return super.getDefaultUseCaches();
    }

    public boolean getDoInput()
    {
        return true;
    }

    public boolean getDoOutput()
    {
        return request.body() != null;
    }

    public InputStream getErrorStream()
    {
        return null;
    }

    public String getHeaderField(int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid header index: ").append(i).toString());
        }
        if (i == 0)
        {
            return StatusLine.get(response).toString();
        } else
        {
            return response.headers().value(i - 1);
        }
    }

    public String getHeaderField(String s)
    {
        if (s == null)
        {
            return StatusLine.get(response).toString();
        } else
        {
            return response.headers().get(s);
        }
    }

    public String getHeaderFieldKey(int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid header index: ").append(i).toString());
        }
        if (i == 0)
        {
            return null;
        } else
        {
            return response.headers().name(i - 1);
        }
    }

    public Map getHeaderFields()
    {
        return OkHeaders.toMultimap(response.headers(), StatusLine.get(response).toString());
    }

    public long getIfModifiedSince()
    {
        return 0L;
    }

    public InputStream getInputStream()
        throws IOException
    {
        throw JavaApiConverter.access$200();
    }

    public boolean getInstanceFollowRedirects()
    {
        return super.getInstanceFollowRedirects();
    }

    public OutputStream getOutputStream()
        throws IOException
    {
        throw JavaApiConverter.access$000();
    }

    public int getReadTimeout()
    {
        return 0;
    }

    public String getRequestMethod()
    {
        return request.method();
    }

    public Map getRequestProperties()
    {
        throw JavaApiConverter.access$100();
    }

    public String getRequestProperty(String s)
    {
        return request.header(s);
    }

    public int getResponseCode()
        throws IOException
    {
        return response.code();
    }

    public String getResponseMessage()
        throws IOException
    {
        return response.message();
    }

    public boolean getUseCaches()
    {
        return super.getUseCaches();
    }

    public void setAllowUserInteraction(boolean flag)
    {
        throw JavaApiConverter.access$000();
    }

    public void setChunkedStreamingMode(int i)
    {
        throw JavaApiConverter.access$000();
    }

    public void setConnectTimeout(int i)
    {
        throw JavaApiConverter.access$000();
    }

    public void setDefaultUseCaches(boolean flag)
    {
        super.setDefaultUseCaches(flag);
    }

    public void setDoInput(boolean flag)
    {
        throw JavaApiConverter.access$000();
    }

    public void setDoOutput(boolean flag)
    {
        throw JavaApiConverter.access$000();
    }

    public void setFixedLengthStreamingMode(int i)
    {
        throw JavaApiConverter.access$000();
    }

    public void setFixedLengthStreamingMode(long l)
    {
        throw JavaApiConverter.access$000();
    }

    public void setIfModifiedSince(long l)
    {
        throw JavaApiConverter.access$000();
    }

    public void setInstanceFollowRedirects(boolean flag)
    {
        throw JavaApiConverter.access$000();
    }

    public void setReadTimeout(int i)
    {
        throw JavaApiConverter.access$000();
    }

    public void setRequestMethod(String s)
        throws ProtocolException
    {
        throw JavaApiConverter.access$000();
    }

    public void setRequestProperty(String s, String s1)
    {
        throw JavaApiConverter.access$000();
    }

    public void setUseCaches(boolean flag)
    {
        throw JavaApiConverter.access$000();
    }

    public boolean usingProxy()
    {
        return false;
    }


    public (Response response1)
    {
        boolean flag = true;
        super(response1.request().url());
        request = response1.request();
        response = response1;
        connected = true;
        if (response1.body() != null)
        {
            flag = false;
        }
        doOutput = flag;
        method = request.method();
    }
}
