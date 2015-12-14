// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import com.amazon.identity.auth.device.utils.MAPLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.HashMap;
import java.util.Map;

public abstract class WrappableHttpURLConnection extends HttpURLConnection
{

    private static final String TAG = com/amazon/identity/auth/device/framework/WrappableHttpURLConnection.getName();
    private boolean mConnected;
    private IOException mIOException;
    private HttpURLConnection mInnerHttpUrlConnection;

    protected WrappableHttpURLConnection(URL url)
    {
        super(url);
        mConnected = false;
        mIOException = null;
    }

    private void onConnectionRequested()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mConnected;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (mIOException != null)
        {
            MAPLog.i(TAG, "The first connection attempt ended in IOException so throwing the same");
            throw mIOException;
        }
        break MISSING_BLOCK_LABEL_39;
        Object obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        mInnerHttpUrlConnection = performOnConnectionRequested();
        if (mInnerHttpUrlConnection == null)
        {
            throw new IOException("Connection could not be established");
        }
        break MISSING_BLOCK_LABEL_72;
        obj;
        mIOException = ((IOException) (obj));
        throw obj;
        mConnected = true;
          goto _L1
    }

    public abstract void addRequestProperty(String s, String s1);

    public void connect()
        throws IOException
    {
        onConnectionRequested();
        mInnerHttpUrlConnection.connect();
    }

    public void disconnect()
    {
        this;
        JVM INSTR monitorenter ;
        if (mConnected)
        {
            mInnerHttpUrlConnection.disconnect();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public abstract boolean getAllowUserInteraction();

    public abstract int getConnectTimeout();

    public Object getContent()
        throws IOException
    {
        onConnectionRequested();
        return mInnerHttpUrlConnection.getContent();
    }

    public Object getContent(Class aclass[])
        throws IOException
    {
        onConnectionRequested();
        return mInnerHttpUrlConnection.getContent(aclass);
    }

    public String getContentEncoding()
    {
        String s;
        try
        {
            onConnectionRequested();
            s = mInnerHttpUrlConnection.getContentEncoding();
        }
        catch (IOException ioexception)
        {
            MAPLog.e(TAG, "Could not get Content Encoding", ioexception);
            return null;
        }
        return s;
    }

    public int getContentLength()
    {
        int i;
        try
        {
            onConnectionRequested();
            i = mInnerHttpUrlConnection.getContentLength();
        }
        catch (IOException ioexception)
        {
            MAPLog.e(TAG, "Could not get Content Length", ioexception);
            return 0;
        }
        return i;
    }

    public String getContentType()
    {
        String s;
        try
        {
            onConnectionRequested();
            s = mInnerHttpUrlConnection.getContentType();
        }
        catch (IOException ioexception)
        {
            MAPLog.e(TAG, "Could not get Content Type", ioexception);
            return null;
        }
        return s;
    }

    public long getDate()
    {
        long l;
        try
        {
            onConnectionRequested();
            l = mInnerHttpUrlConnection.getDate();
        }
        catch (IOException ioexception)
        {
            MAPLog.e(TAG, "Could not get Date", ioexception);
            return 0L;
        }
        return l;
    }

    public abstract boolean getDefaultUseCaches();

    public abstract boolean getDoInput();

    public abstract boolean getDoOutput();

    public InputStream getErrorStream()
    {
        if (mInnerHttpUrlConnection != null)
        {
            return mInnerHttpUrlConnection.getErrorStream();
        } else
        {
            return null;
        }
    }

    public long getExpiration()
    {
        long l;
        try
        {
            onConnectionRequested();
            l = mInnerHttpUrlConnection.getExpiration();
        }
        catch (IOException ioexception)
        {
            MAPLog.e(TAG, "Could not get expiration", ioexception);
            return 0L;
        }
        return l;
    }

    public String getHeaderField(int i)
    {
        String s;
        try
        {
            onConnectionRequested();
            s = mInnerHttpUrlConnection.getHeaderField(i);
        }
        catch (IOException ioexception)
        {
            MAPLog.e(TAG, "Could not get header field", ioexception);
            return null;
        }
        return s;
    }

    public String getHeaderField(String s)
    {
        try
        {
            onConnectionRequested();
            s = mInnerHttpUrlConnection.getHeaderField(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "Could not get header field", s);
            return null;
        }
        return s;
    }

    public long getHeaderFieldDate(String s, long l)
    {
        long l1;
        try
        {
            onConnectionRequested();
            l1 = mInnerHttpUrlConnection.getHeaderFieldDate(s, l);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "Could not get header field date", s);
            return l;
        }
        return l1;
    }

    public int getHeaderFieldInt(String s, int i)
    {
        int j;
        try
        {
            onConnectionRequested();
            j = mInnerHttpUrlConnection.getHeaderFieldInt(s, i);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "Could not get header field int", s);
            return i;
        }
        return j;
    }

    public String getHeaderFieldKey(int i)
    {
        String s;
        try
        {
            onConnectionRequested();
            s = mInnerHttpUrlConnection.getHeaderFieldKey(i);
        }
        catch (IOException ioexception)
        {
            MAPLog.e(TAG, "Could not get header field key", ioexception);
            return null;
        }
        return s;
    }

    public Map getHeaderFields()
    {
        Map map;
        try
        {
            onConnectionRequested();
            map = mInnerHttpUrlConnection.getHeaderFields();
        }
        catch (IOException ioexception)
        {
            MAPLog.e(TAG, "Could not get header fields", ioexception);
            return new HashMap();
        }
        return map;
    }

    public abstract long getIfModifiedSince();

    public InputStream getInputStream()
        throws IOException
    {
        onConnectionRequested();
        return mInnerHttpUrlConnection.getInputStream();
    }

    public abstract boolean getInstanceFollowRedirects();

    public long getLastModified()
    {
        long l;
        try
        {
            onConnectionRequested();
            l = mInnerHttpUrlConnection.getLastModified();
        }
        catch (IOException ioexception)
        {
            MAPLog.e(TAG, "Could not get last modified date", ioexception);
            return 0L;
        }
        return l;
    }

    public abstract OutputStream getOutputStream()
        throws IOException;

    public Permission getPermission()
        throws IOException
    {
        onConnectionRequested();
        return mInnerHttpUrlConnection.getPermission();
    }

    public abstract int getReadTimeout();

    public abstract String getRequestMethod();

    public abstract Map getRequestProperties();

    public abstract String getRequestProperty(String s);

    public int getResponseCode()
        throws IOException
    {
        onConnectionRequested();
        return mInnerHttpUrlConnection.getResponseCode();
    }

    public String getResponseMessage()
        throws IOException
    {
        onConnectionRequested();
        return mInnerHttpUrlConnection.getResponseMessage();
    }

    public abstract URL getURL();

    public abstract boolean getUseCaches();

    protected abstract HttpURLConnection performOnConnectionRequested()
        throws IOException;

    public abstract void setAllowUserInteraction(boolean flag);

    public abstract void setChunkedStreamingMode(int i);

    public abstract void setConnectTimeout(int i);

    public abstract void setDefaultUseCaches(boolean flag);

    public abstract void setDoInput(boolean flag);

    public abstract void setDoOutput(boolean flag);

    public abstract void setFixedLengthStreamingMode(int i);

    public abstract void setFixedLengthStreamingMode(long l);

    public abstract void setIfModifiedSince(long l);

    public abstract void setInstanceFollowRedirects(boolean flag);

    public abstract void setReadTimeout(int i);

    public abstract void setRequestMethod(String s)
        throws ProtocolException;

    public abstract void setRequestProperty(String s, String s1);

    public abstract void setUseCaches(boolean flag);

    public abstract String toString();

    public abstract boolean usingProxy();

}
