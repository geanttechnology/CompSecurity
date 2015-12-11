// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.util.Log;
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
    private static final class ConnectionState extends Enum
    {

        private static final ConnectionState $VALUES[];
        public static final ConnectionState Connected;
        public static final ConnectionState Connecting;
        public static final ConnectionState Initial;

        public static ConnectionState valueOf(String s)
        {
            return (ConnectionState)Enum.valueOf(com/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState, s);
        }

        public static ConnectionState[] values()
        {
            return (ConnectionState[])$VALUES.clone();
        }

        static 
        {
            Initial = new ConnectionState("Initial", 0);
            Connecting = new ConnectionState("Connecting", 1);
            Connected = new ConnectionState("Connected", 2);
            $VALUES = (new ConnectionState[] {
                Initial, Connecting, Connected
            });
        }

        private ConnectionState(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/framework/WrappableHttpURLConnection.getName();
    private Throwable mConnectionInitiator;
    private HttpURLConnection mInnerHttpUrlConnection;
    private final Object mLock[] = new Object[0];
    private ConnectionState mState;

    protected WrappableHttpURLConnection(URL url)
    {
        super(url);
        mState = ConnectionState.Initial;
        mConnectionInitiator = null;
    }

    private void onConnectionRequested()
        throws IOException
    {
        Object aobj[] = mLock;
        aobj;
        JVM INSTR monitorenter ;
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$identity$auth$device$framework$WrappableHttpURLConnection$ConnectionState[];

            static 
            {
                $SwitchMap$com$amazon$identity$auth$device$framework$WrappableHttpURLConnection$ConnectionState = new int[ConnectionState.values().length];
                try
                {
                    $SwitchMap$com$amazon$identity$auth$device$framework$WrappableHttpURLConnection$ConnectionState[ConnectionState.Initial.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$identity$auth$device$framework$WrappableHttpURLConnection$ConnectionState[ConnectionState.Connecting.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$identity$auth$device$framework$WrappableHttpURLConnection$ConnectionState[ConnectionState.Connected.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.amazon.identity.auth.device.framework.WrappableHttpURLConnection.ConnectionState[mState.ordinal()];
        JVM INSTR tableswitch 1 3: default 179
    //                   1 79
    //                   2 124
    //                   3 154;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new IllegalStateException((new StringBuilder("Connection is in unknown state:")).append(mState.name()).toString());
        Exception exception;
        exception;
        aobj;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        mConnectionInitiator = new Throwable();
        mState = ConnectionState.Connecting;
        aobj;
        JVM INSTR monitorexit ;
          goto _L5
_L3:
        throw new IllegalStateException((new StringBuilder("Connection is being established. Connection initiated from:")).append(Log.getStackTraceString(mConnectionInitiator)).toString());
_L4:
        aobj;
        JVM INSTR monitorexit ;
        return;
_L5:
        mInnerHttpUrlConnection = performOnConnectionRequested();
        if (mInnerHttpUrlConnection == null)
        {
            throw new IOException("Connection could not be established");
        }
        synchronized (mLock)
        {
            mState = ConnectionState.Connected;
        }
        return;
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
        if (mState == ConnectionState.Connected)
        {
            mInnerHttpUrlConnection.disconnect();
        }
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
