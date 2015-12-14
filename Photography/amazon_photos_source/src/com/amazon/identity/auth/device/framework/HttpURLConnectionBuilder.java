// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import com.amazon.identity.auth.device.framework.security.EnhancedURLConnectionFactory;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.StreamUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class HttpURLConnectionBuilder
{

    private static final String TAG = com/amazon/identity/auth/device/framework/HttpURLConnectionBuilder.getName();
    private Integer mChunkLength;
    private Long mContentLength;
    private final HttpURLConnection mInnerConnectionStore;
    private final ByteArrayOutputStream mOutputStream = new ByteArrayOutputStream();
    private final Map mProperties = new HashMap();

    public HttpURLConnectionBuilder(URL url)
        throws IOException
    {
        mChunkLength = null;
        mContentLength = null;
        if (url == null)
        {
            throw new IllegalArgumentException("url cannot be null");
        }
        url = EnhancedURLConnectionFactory.createURLConnection(url);
        if (!(url instanceof HttpURLConnection))
        {
            throw new IllegalArgumentException("url must be atleast http");
        } else
        {
            mInnerConnectionStore = (HttpURLConnection)url;
            return;
        }
    }

    private HttpURLConnection getConnection()
    {
        HttpURLConnection httpurlconnection;
        try
        {
            httpurlconnection = (HttpURLConnection)EnhancedURLConnectionFactory.createURLConnection(mInnerConnectionStore.getURL());
        }
        catch (IOException ioexception)
        {
            MAPLog.e(TAG, "IOException while cloning connection. Should not happen", ioexception);
            return null;
        }
        return httpurlconnection;
    }

    private void putRequestProperty(String s, String s1, boolean flag)
    {
        List list = (List)mProperties.get(s);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            mProperties.put(s, obj);
        }
        if (flag)
        {
            ((List) (obj)).clear();
        }
        ((List) (obj)).add(s1);
    }

    public void addRequestProperty(String s, String s1)
    {
        putRequestProperty(s, s1, false);
    }

    public final HttpURLConnection createConnection()
        throws IOException
    {
        Object obj1 = getConnection();
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((HttpURLConnection) (obj));
_L2:
        Object obj2;
        populateConnectionAttributes(((HttpURLConnection) (obj1)));
        obj2 = ((HttpURLConnection) (obj1)).getRequestMethod();
        if ("POST".equalsIgnoreCase(((String) (obj2))))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        if (!"PUT".equalsIgnoreCase(((String) (obj2)))) goto _L4; else goto _L3
_L3:
        obj = ((HttpURLConnection) (obj1)).getOutputStream();
        ((OutputStream) (obj)).write(mOutputStream.toByteArray());
        StreamUtils.closeStream(((java.io.Closeable) (obj)));
        return ((HttpURLConnection) (obj1));
        obj;
        obj2 = null;
        obj1 = obj;
_L6:
        StreamUtils.closeStream(((java.io.Closeable) (obj2)));
        throw obj1;
        obj1;
        obj2 = obj;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean getAllowUserInteraction()
    {
        return mInnerConnectionStore.getAllowUserInteraction();
    }

    public int getConnectTimeout()
    {
        return mInnerConnectionStore.getConnectTimeout();
    }

    public boolean getDefaultUseCaches()
    {
        return mInnerConnectionStore.getDefaultUseCaches();
    }

    public boolean getDoInput()
    {
        return mInnerConnectionStore.getDoInput();
    }

    public boolean getDoOutput()
    {
        return mInnerConnectionStore.getDoOutput();
    }

    public long getIfModifiedSince()
    {
        return mInnerConnectionStore.getIfModifiedSince();
    }

    protected HttpURLConnection getInnerStore()
    {
        return mInnerConnectionStore;
    }

    public boolean getInstanceFollowRedirects()
    {
        return mInnerConnectionStore.getInstanceFollowRedirects();
    }

    public OutputStream getOutputStream()
    {
        return mOutputStream;
    }

    public int getReadTimeout()
    {
        return mInnerConnectionStore.getReadTimeout();
    }

    public String getRequestMethod()
    {
        return mInnerConnectionStore.getRequestMethod();
    }

    public Map getRequestProperties()
    {
        return Collections.unmodifiableMap(mProperties);
    }

    public String getRequestProperty(String s)
    {
        s = (List)mProperties.get(s);
        if (s == null || s.size() == 0)
        {
            return null;
        } else
        {
            return (String)s.get(0);
        }
    }

    public URL getURL()
    {
        return mInnerConnectionStore.getURL();
    }

    public boolean getUseCaches()
    {
        return mInnerConnectionStore.getUseCaches();
    }

    protected void populateConnectionAttributes(HttpURLConnection httpurlconnection)
    {
        try
        {
            httpurlconnection.setRequestMethod(mInnerConnectionStore.getRequestMethod());
        }
        // Misplaced declaration of an exception variable
        catch (HttpURLConnection httpurlconnection)
        {
            throw new IllegalStateException("Connection has been already executed");
        }
        if (mChunkLength != null)
        {
            httpurlconnection.setChunkedStreamingMode(mChunkLength.intValue());
        }
        if (mContentLength != null)
        {
            if (android.os.Build.VERSION.SDK_INT >= 19)
            {
                httpurlconnection.setFixedLengthStreamingMode(mContentLength.longValue());
            } else
            {
                httpurlconnection.setFixedLengthStreamingMode(mContentLength.intValue());
            }
        }
        httpurlconnection.setInstanceFollowRedirects(mInnerConnectionStore.getInstanceFollowRedirects());
        httpurlconnection.setAllowUserInteraction(mInnerConnectionStore.getAllowUserInteraction());
        httpurlconnection.setConnectTimeout(mInnerConnectionStore.getConnectTimeout());
        httpurlconnection.setDefaultUseCaches(mInnerConnectionStore.getDefaultUseCaches());
        httpurlconnection.setDoInput(mInnerConnectionStore.getDoInput());
        httpurlconnection.setDoOutput(mInnerConnectionStore.getDoOutput());
        httpurlconnection.setIfModifiedSince(mInnerConnectionStore.getIfModifiedSince());
        httpurlconnection.setReadTimeout(mInnerConnectionStore.getReadTimeout());
        httpurlconnection.setUseCaches(mInnerConnectionStore.getUseCaches());
        for (Iterator iterator = mProperties.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            Iterator iterator1 = ((List)entry.getValue()).iterator();
            while (iterator1.hasNext()) 
            {
                String s = (String)iterator1.next();
                httpurlconnection.addRequestProperty((String)entry.getKey(), s);
            }
        }

    }

    public void setAllowUserInteraction(boolean flag)
    {
        mInnerConnectionStore.setAllowUserInteraction(flag);
    }

    public void setChunkedStreamingMode(int i)
    {
        mChunkLength = Integer.valueOf(i);
    }

    public void setConnectTimeout(int i)
    {
        mInnerConnectionStore.setConnectTimeout(i);
    }

    public void setDefaultUseCaches(boolean flag)
    {
        mInnerConnectionStore.setDefaultUseCaches(flag);
    }

    public void setDoInput(boolean flag)
    {
        mInnerConnectionStore.setDoInput(flag);
    }

    public void setDoOutput(boolean flag)
    {
        mInnerConnectionStore.setDoOutput(flag);
    }

    public void setFixedLengthStreamingMode(long l)
    {
        mContentLength = Long.valueOf(l);
    }

    public void setIfModifiedSince(long l)
    {
        mInnerConnectionStore.setIfModifiedSince(l);
    }

    public void setInstanceFollowRedirects(boolean flag)
    {
        mInnerConnectionStore.setInstanceFollowRedirects(flag);
    }

    public void setReadTimeout(int i)
    {
        mInnerConnectionStore.setReadTimeout(i);
    }

    public void setRequestMethod(String s)
        throws ProtocolException
    {
        mInnerConnectionStore.setRequestMethod(s);
    }

    public void setRequestProperty(String s, String s1)
    {
        putRequestProperty(s, s1, true);
    }

    public void setUseCaches(boolean flag)
    {
        mInnerConnectionStore.setUseCaches(flag);
    }

    public String toString()
    {
        return mInnerConnectionStore.toString();
    }

    public boolean usingProxy()
    {
        return mInnerConnectionStore.usingProxy();
    }

}
