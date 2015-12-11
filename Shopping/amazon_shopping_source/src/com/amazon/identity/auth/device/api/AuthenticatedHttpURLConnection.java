// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import com.amazon.identity.auth.device.framework.WrappableHttpURLConnection;
import com.amazon.identity.auth.request.AuthenticatedUrlConnectionAdapter;
import com.amazon.identity.auth.request.HttpOutputStreamWrapper;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            AuthenticationMethod

class AuthenticatedHttpURLConnection extends WrappableHttpURLConnection
{

    private static final String TAG = com/amazon/identity/auth/device/api/AuthenticatedHttpURLConnection.getName();
    private final AuthenticationMethod mAuthMethod;
    private final HttpURLConnection mInnerHttpUrlConnection;
    private final Object mLock[];
    private HttpOutputStreamWrapper mWrappedOutputStream;

    AuthenticatedHttpURLConnection(HttpURLConnection httpurlconnection, AuthenticationMethod authenticationmethod)
    {
        this(httpurlconnection.getURL(), httpurlconnection, authenticationmethod);
    }

    AuthenticatedHttpURLConnection(URL url, HttpURLConnection httpurlconnection, AuthenticationMethod authenticationmethod)
    {
        super(url);
        mLock = new Object[0];
        mAuthMethod = authenticationmethod;
        mInnerHttpUrlConnection = httpurlconnection;
    }

    public void addRequestProperty(String s, String s1)
    {
        mInnerHttpUrlConnection.addRequestProperty(s, s1);
    }

    public boolean getAllowUserInteraction()
    {
        return mInnerHttpUrlConnection.getAllowUserInteraction();
    }

    public int getConnectTimeout()
    {
        return mInnerHttpUrlConnection.getConnectTimeout();
    }

    byte[] getCurrentBody()
    {
        byte abyte0[];
        synchronized (mLock)
        {
            if (mWrappedOutputStream == null)
            {
                return new byte[0];
            }
            abyte0 = mWrappedOutputStream.getCurrentBytes();
        }
        return abyte0;
    }

    public boolean getDefaultUseCaches()
    {
        return mInnerHttpUrlConnection.getDefaultUseCaches();
    }

    public boolean getDoInput()
    {
        return mInnerHttpUrlConnection.getDoInput();
    }

    public boolean getDoOutput()
    {
        return mInnerHttpUrlConnection.getDoOutput();
    }

    public long getIfModifiedSince()
    {
        return mInnerHttpUrlConnection.getIfModifiedSince();
    }

    public boolean getInstanceFollowRedirects()
    {
        return mInnerHttpUrlConnection.getInstanceFollowRedirects();
    }

    public OutputStream getOutputStream()
        throws IOException
    {
        HttpOutputStreamWrapper httpoutputstreamwrapper;
        synchronized (mLock)
        {
            if (mWrappedOutputStream == null)
            {
                mWrappedOutputStream = new HttpOutputStreamWrapper(mInnerHttpUrlConnection);
            }
            httpoutputstreamwrapper = mWrappedOutputStream;
        }
        return httpoutputstreamwrapper;
    }

    public int getReadTimeout()
    {
        return mInnerHttpUrlConnection.getReadTimeout();
    }

    public String getRequestMethod()
    {
        return mInnerHttpUrlConnection.getRequestMethod();
    }

    public Map getRequestProperties()
    {
        return mInnerHttpUrlConnection.getRequestProperties();
    }

    public String getRequestProperty(String s)
    {
        return mInnerHttpUrlConnection.getRequestProperty(s);
    }

    public URL getURL()
    {
        return mInnerHttpUrlConnection.getURL();
    }

    public boolean getUseCaches()
    {
        return mInnerHttpUrlConnection.getUseCaches();
    }

    protected HttpURLConnection performOnConnectionRequested()
        throws IOException
    {
        AuthenticatedUrlConnectionAdapter authenticatedurlconnectionadapter = new AuthenticatedUrlConnectionAdapter(this) {

            final AuthenticatedHttpURLConnection this$0;

            public byte[] getBody()
            {
                return ((AuthenticatedHttpURLConnection)getUrlConnection()).getCurrentBody();
            }

            
            {
                this$0 = AuthenticatedHttpURLConnection.this;
                super(authenticatedhttpurlconnection1);
            }
        };
        mAuthMethod.authenticateConnection(authenticatedurlconnectionadapter);
        Object aobj[] = mLock;
        aobj;
        JVM INSTR monitorenter ;
        if (mWrappedOutputStream != null) goto _L2; else goto _L1
_L1:
        return mInnerHttpUrlConnection;
_L2:
        mWrappedOutputStream.flushToUnderlyingStream();
        aobj;
        JVM INSTR monitorexit ;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void setAllowUserInteraction(boolean flag)
    {
        mInnerHttpUrlConnection.setAllowUserInteraction(flag);
    }

    public void setChunkedStreamingMode(int i)
    {
        mInnerHttpUrlConnection.setChunkedStreamingMode(i);
    }

    public void setConnectTimeout(int i)
    {
        mInnerHttpUrlConnection.setConnectTimeout(i);
    }

    public void setDefaultUseCaches(boolean flag)
    {
        mInnerHttpUrlConnection.setDefaultUseCaches(flag);
    }

    public void setDoInput(boolean flag)
    {
        mInnerHttpUrlConnection.setDoInput(flag);
    }

    public void setDoOutput(boolean flag)
    {
        mInnerHttpUrlConnection.setDoOutput(flag);
    }

    public void setFixedLengthStreamingMode(int i)
    {
        mInnerHttpUrlConnection.setFixedLengthStreamingMode(i);
    }

    public void setFixedLengthStreamingMode(long l)
    {
        mInnerHttpUrlConnection.setFixedLengthStreamingMode(l);
    }

    public void setIfModifiedSince(long l)
    {
        mInnerHttpUrlConnection.setIfModifiedSince(l);
    }

    public void setInstanceFollowRedirects(boolean flag)
    {
        mInnerHttpUrlConnection.setInstanceFollowRedirects(flag);
    }

    public void setReadTimeout(int i)
    {
        mInnerHttpUrlConnection.setReadTimeout(i);
    }

    public void setRequestMethod(String s)
        throws ProtocolException
    {
        mInnerHttpUrlConnection.setRequestMethod(s);
    }

    public void setRequestProperty(String s, String s1)
    {
        mInnerHttpUrlConnection.setRequestProperty(s, s1);
    }

    public void setUseCaches(boolean flag)
    {
        mInnerHttpUrlConnection.setUseCaches(flag);
    }

    public String toString()
    {
        return mInnerHttpUrlConnection.toString();
    }

    public boolean usingProxy()
    {
        return mInnerHttpUrlConnection.usingProxy();
    }

}
