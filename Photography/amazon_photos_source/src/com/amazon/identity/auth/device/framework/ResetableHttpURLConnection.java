// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.StreamUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.Map;

public class ResetableHttpURLConnection extends HttpURLConnection
{

    private static final String TAG = com/amazon/identity/auth/device/framework/ResetableHttpURLConnection.getName();
    private byte mErrorStreamBytes[];
    private byte mInputStreamBytes[];
    private IOException mInputStreamException;
    private final Object mLock[] = new Object[0];
    private final HttpURLConnection mUrlConn;

    public ResetableHttpURLConnection(HttpURLConnection httpurlconnection)
    {
        super(httpurlconnection.getURL());
        mUrlConn = httpurlconnection;
    }

    public void addRequestProperty(String s, String s1)
    {
        mUrlConn.addRequestProperty(s, s1);
    }

    public void connect()
        throws IOException
    {
        mUrlConn.connect();
    }

    public void disconnect()
    {
        mUrlConn.disconnect();
    }

    public boolean getAllowUserInteraction()
    {
        return mUrlConn.getAllowUserInteraction();
    }

    public int getConnectTimeout()
    {
        return mUrlConn.getConnectTimeout();
    }

    public Object getContent()
        throws IOException
    {
        return mUrlConn.getContent();
    }

    public Object getContent(Class aclass[])
        throws IOException
    {
        return mUrlConn.getContent(aclass);
    }

    public String getContentEncoding()
    {
        return mUrlConn.getContentEncoding();
    }

    public int getContentLength()
    {
        return mUrlConn.getContentLength();
    }

    public String getContentType()
    {
        return mUrlConn.getContentType();
    }

    public long getDate()
    {
        return mUrlConn.getDate();
    }

    public boolean getDefaultUseCaches()
    {
        return mUrlConn.getDefaultUseCaches();
    }

    public boolean getDoInput()
    {
        return mUrlConn.getDoInput();
    }

    public boolean getDoOutput()
    {
        return mUrlConn.getDoOutput();
    }

    public InputStream getErrorStream()
    {
        Object aobj[] = mLock;
        aobj;
        JVM INSTR monitorenter ;
        byte abyte0[] = mErrorStreamBytes;
        if (abyte0 != null) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        obj1 = null;
        obj = null;
        InputStream inputstream = mUrlConn.getErrorStream();
        if (inputstream == null) goto _L4; else goto _L3
_L3:
        obj = inputstream;
        obj1 = inputstream;
        mErrorStreamBytes = StreamUtils.readInputStream(inputstream);
_L5:
        StreamUtils.closeStream(inputstream);
_L2:
        obj = new ByteArrayInputStream(mErrorStreamBytes);
        aobj;
        JVM INSTR monitorexit ;
        return ((InputStream) (obj));
_L4:
        obj = inputstream;
        obj1 = inputstream;
        MAPLog.i(TAG, "No Error Stream found");
        obj = inputstream;
        obj1 = inputstream;
        mErrorStreamBytes = new byte[0];
          goto _L5
        obj1;
        obj1 = obj;
        mErrorStreamBytes = new byte[0];
        StreamUtils.closeStream(((java.io.Closeable) (obj)));
          goto _L2
        Exception exception;
        exception;
        throw exception;
        exception;
        StreamUtils.closeStream(((java.io.Closeable) (obj1)));
        throw exception;
          goto _L5
    }

    public long getExpiration()
    {
        return mUrlConn.getExpiration();
    }

    public String getHeaderField(int i)
    {
        return mUrlConn.getHeaderField(i);
    }

    public String getHeaderField(String s)
    {
        return mUrlConn.getHeaderField(s);
    }

    public long getHeaderFieldDate(String s, long l)
    {
        return mUrlConn.getHeaderFieldDate(s, l);
    }

    public int getHeaderFieldInt(String s, int i)
    {
        return mUrlConn.getHeaderFieldInt(s, i);
    }

    public String getHeaderFieldKey(int i)
    {
        return mUrlConn.getHeaderFieldKey(i);
    }

    public Map getHeaderFields()
    {
        return mUrlConn.getHeaderFields();
    }

    public long getIfModifiedSince()
    {
        return mUrlConn.getIfModifiedSince();
    }

    public InputStream getInputStream()
        throws IOException
    {
        Object aobj[] = mLock;
        aobj;
        JVM INSTR monitorenter ;
        Object obj;
        if (mInputStreamBytes != null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        obj = mInputStreamException;
        Object obj1;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        obj1 = null;
        obj = null;
        InputStream inputstream = mUrlConn.getInputStream();
        obj = inputstream;
        obj1 = inputstream;
        mInputStreamBytes = StreamUtils.readInputStream(inputstream);
        StreamUtils.closeStream(inputstream);
        if (mInputStreamException != null)
        {
            throw mInputStreamException;
        }
        break MISSING_BLOCK_LABEL_102;
        obj;
        aobj;
        JVM INSTR monitorexit ;
        throw obj;
        IOException ioexception;
        ioexception;
        obj1 = obj;
        mInputStreamBytes = new byte[0];
        obj1 = obj;
        mInputStreamException = ioexception;
        obj1 = obj;
        throw mInputStreamException;
        Exception exception;
        exception;
        StreamUtils.closeStream(((java.io.Closeable) (obj1)));
        throw exception;
        exception = new ByteArrayInputStream(mInputStreamBytes);
        aobj;
        JVM INSTR monitorexit ;
        return exception;
    }

    public boolean getInstanceFollowRedirects()
    {
        return mUrlConn.getInstanceFollowRedirects();
    }

    public long getLastModified()
    {
        return mUrlConn.getLastModified();
    }

    public OutputStream getOutputStream()
        throws IOException
    {
        return mUrlConn.getOutputStream();
    }

    public Permission getPermission()
        throws IOException
    {
        return mUrlConn.getPermission();
    }

    public int getReadTimeout()
    {
        return mUrlConn.getReadTimeout();
    }

    public String getRequestMethod()
    {
        return mUrlConn.getRequestMethod();
    }

    public Map getRequestProperties()
    {
        return mUrlConn.getRequestProperties();
    }

    public String getRequestProperty(String s)
    {
        return mUrlConn.getRequestProperty(s);
    }

    public int getResponseCode()
        throws IOException
    {
        return mUrlConn.getResponseCode();
    }

    public String getResponseMessage()
        throws IOException
    {
        return mUrlConn.getRequestMethod();
    }

    public URL getURL()
    {
        return mUrlConn.getURL();
    }

    public boolean getUseCaches()
    {
        return mUrlConn.getUseCaches();
    }

    public void setAllowUserInteraction(boolean flag)
    {
        mUrlConn.setAllowUserInteraction(flag);
    }

    public void setChunkedStreamingMode(int i)
    {
        mUrlConn.setChunkedStreamingMode(i);
    }

    public void setConnectTimeout(int i)
    {
        mUrlConn.setConnectTimeout(i);
    }

    public void setDefaultUseCaches(boolean flag)
    {
        mUrlConn.setDefaultUseCaches(flag);
    }

    public void setDoInput(boolean flag)
    {
        mUrlConn.setDoInput(flag);
    }

    public void setDoOutput(boolean flag)
    {
        mUrlConn.setDoInput(flag);
    }

    public void setFixedLengthStreamingMode(int i)
    {
        mUrlConn.setFixedLengthStreamingMode(i);
    }

    public void setIfModifiedSince(long l)
    {
        mUrlConn.setIfModifiedSince(l);
    }

    public void setInstanceFollowRedirects(boolean flag)
    {
        mUrlConn.setInstanceFollowRedirects(flag);
    }

    public void setReadTimeout(int i)
    {
        mUrlConn.setReadTimeout(i);
    }

    public void setRequestMethod(String s)
        throws ProtocolException
    {
        mUrlConn.setRequestMethod(s);
    }

    public void setRequestProperty(String s, String s1)
    {
        mUrlConn.setRequestProperty(s, s1);
    }

    public void setUseCaches(boolean flag)
    {
        mUrlConn.setUseCaches(flag);
    }

    public String toString()
    {
        return mUrlConn.toString();
    }

    public boolean usingProxy()
    {
        return mUrlConn.usingProxy();
    }

}
