// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            HttpsURLConnectionBuilder, RetryableHttpURLConnection, RetryLogic, Tracer

class RetryableHttpsURLConnection extends HttpsURLConnection
{

    private static final String TAG = com/amazon/identity/auth/device/framework/RetryableHttpsURLConnection.getName();
    private final HttpsURLConnectionBuilder mHttpsUrlConnectionBuilder;
    private final RetryableHttpURLConnection mInnerHttpUrlConnection;
    private final RetryLogic mRetryLogic;
    private final Tracer mTracer;

    RetryableHttpsURLConnection(URL url, RetryLogic retrylogic, Tracer tracer, Context context)
        throws IOException
    {
        super(url);
        mHttpsUrlConnectionBuilder = new HttpsURLConnectionBuilder(url);
        mRetryLogic = retrylogic;
        mInnerHttpUrlConnection = new RetryableHttpURLConnection(mHttpsUrlConnectionBuilder, mRetryLogic, tracer, context);
        mTracer = tracer;
    }

    public void addRequestProperty(String s, String s1)
    {
        mInnerHttpUrlConnection.addRequestProperty(s, s1);
    }

    public void connect()
        throws IOException
    {
        mInnerHttpUrlConnection.connect();
    }

    public void disconnect()
    {
        mInnerHttpUrlConnection.disconnect();
    }

    public boolean getAllowUserInteraction()
    {
        return mInnerHttpUrlConnection.getAllowUserInteraction();
    }

    public String getCipherSuite()
    {
        return mHttpsUrlConnectionBuilder.getCipherSuite();
    }

    public int getConnectTimeout()
    {
        return mInnerHttpUrlConnection.getConnectTimeout();
    }

    public Object getContent()
        throws IOException
    {
        return mInnerHttpUrlConnection.getContent();
    }

    public Object getContent(Class aclass[])
        throws IOException
    {
        return mInnerHttpUrlConnection.getContent(aclass);
    }

    public String getContentEncoding()
    {
        return mInnerHttpUrlConnection.getContentEncoding();
    }

    public int getContentLength()
    {
        return mInnerHttpUrlConnection.getContentLength();
    }

    public String getContentType()
    {
        return mInnerHttpUrlConnection.getContentType();
    }

    public long getDate()
    {
        return mInnerHttpUrlConnection.getDate();
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

    public InputStream getErrorStream()
    {
        return mInnerHttpUrlConnection.getErrorStream();
    }

    public long getExpiration()
    {
        return mInnerHttpUrlConnection.getExpiration();
    }

    public String getHeaderField(int i)
    {
        return mInnerHttpUrlConnection.getHeaderField(i);
    }

    public String getHeaderField(String s)
    {
        return mInnerHttpUrlConnection.getHeaderField(s);
    }

    public long getHeaderFieldDate(String s, long l)
    {
        return mInnerHttpUrlConnection.getHeaderFieldDate(s, l);
    }

    public int getHeaderFieldInt(String s, int i)
    {
        return mInnerHttpUrlConnection.getHeaderFieldInt(s, i);
    }

    public String getHeaderFieldKey(int i)
    {
        return mInnerHttpUrlConnection.getHeaderFieldKey(i);
    }

    public Map getHeaderFields()
    {
        return mInnerHttpUrlConnection.getHeaderFields();
    }

    public HostnameVerifier getHostnameVerifier()
    {
        return mHttpsUrlConnectionBuilder.getHostnameVerifier();
    }

    public long getIfModifiedSince()
    {
        return mInnerHttpUrlConnection.getIfModifiedSince();
    }

    public InputStream getInputStream()
        throws IOException
    {
        return mInnerHttpUrlConnection.getInputStream();
    }

    public boolean getInstanceFollowRedirects()
    {
        return mInnerHttpUrlConnection.getInstanceFollowRedirects();
    }

    public long getLastModified()
    {
        return mInnerHttpUrlConnection.getLastModified();
    }

    public Certificate[] getLocalCertificates()
    {
        return mHttpsUrlConnectionBuilder.getLocalCertificates();
    }

    public Principal getLocalPrincipal()
    {
        return mHttpsUrlConnectionBuilder.getLocalPrincipal();
    }

    public OutputStream getOutputStream()
        throws IOException
    {
        return mInnerHttpUrlConnection.getOutputStream();
    }

    public Principal getPeerPrincipal()
        throws SSLPeerUnverifiedException
    {
        return mHttpsUrlConnectionBuilder.getPeerPrincipal();
    }

    public Permission getPermission()
        throws IOException
    {
        return mInnerHttpUrlConnection.getPermission();
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

    public int getResponseCode()
        throws IOException
    {
        return mInnerHttpUrlConnection.getResponseCode();
    }

    public String getResponseMessage()
        throws IOException
    {
        return mInnerHttpUrlConnection.getResponseMessage();
    }

    public SSLSocketFactory getSSLSocketFactory()
    {
        return mHttpsUrlConnectionBuilder.getSSLSocketFactory();
    }

    public Certificate[] getServerCertificates()
        throws SSLPeerUnverifiedException
    {
        return mHttpsUrlConnectionBuilder.getServerCertificates();
    }

    public URL getURL()
    {
        return mInnerHttpUrlConnection.getURL();
    }

    public boolean getUseCaches()
    {
        return mInnerHttpUrlConnection.getUseCaches();
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

    public void setHostnameVerifier(HostnameVerifier hostnameverifier)
    {
        mHttpsUrlConnectionBuilder.setHostnameVerifier(hostnameverifier);
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

    public void setSSLSocketFactory(SSLSocketFactory sslsocketfactory)
    {
        mHttpsUrlConnectionBuilder.setSSLSocketFactory(sslsocketfactory);
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
